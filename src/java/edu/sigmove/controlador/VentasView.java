/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.controlador;

import edu.sigmove.entity.Ventas;
import edu.sigmove.facade.VentasFacadeLocal;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


/**
 *
 * @author victo
 */
@Named(value = "ventasView")
@ViewScoped
public class VentasView implements Serializable{

    @EJB
    VentasFacadeLocal ventasFacadeLocal;
    private ArrayList<Ventas> listaVentas = new ArrayList<>();
    @Inject
    UsuarioSesion usuarioSesion;
    public VentasView() {
        
    }
    
    @PostConstruct
    public void cargaVentas() {
        listaVentas.addAll(ventasFacadeLocal.findAll());
    }
    
    public void descargaFactura( String idVenta) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext context = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        response.setContentType("application/pdf");

        try {
            Map parametro = new HashMap();
            parametro.put("idVenta",idVenta);
            Connection conec = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bdsigmovenew", "root", "");
           
            File jasper = new File(context.getRealPath("/WEB-INF/classes/edu/sigmove/reportes/Factura.jasper"));

            JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), parametro, conec);

            HttpServletResponse hsr = (HttpServletResponse) context.getResponse();
            hsr.addHeader("Content-disposition", "attachment; filename=facturaIndividual.pdf");
            OutputStream os = hsr.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jp, os);
            os.flush();
            os.close();
            facesContext.responseComplete();

        } catch (JRException e) {
            System.out.println("edu.sigmove.controlador.VentasView.descargaFactura() " + e.getMessage());
        } catch (IOException i) {
            System.out.println("edu.sigmove.controlador.VentasView.descargaFactura() " + i.getMessage());
        } catch (SQLException q) {
            System.out.println("edu.sigmove.controlador.VentasView.descargaFactura() " + q.getMessage());
        }

    }

    

    public ArrayList<Ventas> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ArrayList<Ventas> listaVentas) {
        this.listaVentas = listaVentas;
    }

    

    
}
