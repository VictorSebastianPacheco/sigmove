/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.controlador;

import edu.sigmove.entity.Beneficio;
import edu.sigmove.facade.BeneficioFacadeLocal;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
import org.primefaces.PrimeFaces;

/**
 *
 * @author victo
 */
@Named(value = "beneficioView")
@ViewScoped
public class BeneficioView implements Serializable{

    @EJB
    BeneficioFacadeLocal beneficioFacadeLocal;
    private ArrayList<Beneficio> listaBeneficio = new ArrayList<>();
    private Beneficio beneficioSelect = new Beneficio();
    private Beneficio benReg = new Beneficio();
    
    @Inject
    private UsuarioSesion usuarioSesion;
    
    
    @PostConstruct
    public void cargaBeneficio() {
        listaBeneficio.addAll(beneficioFacadeLocal.findAll());
    }
    public void removerBeneficio(Beneficio benRemov) {
        String mensajeAlerta = "";
        try {
            beneficioFacadeLocal.remove(benRemov);
            listaBeneficio.remove(benRemov);
            mensajeAlerta = "swal('Removido el Beneficio', '" + benRemov.getNombre() + ' ' + benRemov.getProducto() + "', 'success');";
        } catch (Exception e) {
            mensajeAlerta = "swal('Problemas eliminando a ', '" + benRemov.getNombre() + ' ' + benRemov.getProducto() + "', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeAlerta);

    }

    public void beneficioSelecionado(Beneficio benSelect) {
        beneficioSelect = benSelect;
    }

    public void acutalizarBeneficio() {
        String mensajeAlerta = "";
        try { 
            beneficioFacadeLocal.edit(beneficioSelect);
            listaBeneficio.clear();
            listaBeneficio.addAll(beneficioFacadeLocal.findAll());

            mensajeAlerta = "swal('Actualizado el usuario', '" + beneficioSelect.getNombre() + ' ' + beneficioSelect.getProducto() + "', 'success');";
        } catch (Exception e) {
            mensajeAlerta = "swal('Problemas Actualizando a ', '" + beneficioSelect.getNombre() + ' ' + beneficioSelect.getProducto() + "', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeAlerta);

    }

    public void registrarNuevoBeneficio() {
        String mensajeRequest = "";
        try {
            benReg.setFecha(new Date());
            beneficioFacadeLocal.create(benReg);
            listaBeneficio.clear();
            listaBeneficio.addAll(beneficioFacadeLocal.findAll());
            mensajeRequest = "swal('Registro', 'Exitoso !!!!', 'success');";
        } catch (Exception e) {
            System.out.println("Error RegistroRequest:registrarUsuario " + e.getMessage());
            mensajeRequest = "swal('Verifique sus datos', 'Intente de nuevo', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeRequest);
        benReg = new Beneficio();
    }

    public void descargaListado() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext context = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        response.setContentType("application/pdf");

        try {
            Map parametro = new HashMap();
            parametro.put("UsuarioReporte", usuarioSesion.getUsuLogin().getNombre() + " " +usuarioSesion.getUsuLogin().getApellido());
            parametro.put("RutaImagen", context.getRealPath("/resources/img.lum/blackfriday.png"));
            parametro.put("RutaImagen2", context.getRealPath("/resources/img.lum/Mars.png"));
            //"C:\\LIBRERIA\\sigmovefase4\\web\\imagenes\\Mars.png"
            Connection conec = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bdsigmovenew", "root", "");
           //C:\LIBRERIA\WebApp1966781B2\src\java\edu\webapp1966781b\reportes\ListaUsuarios.jrxml
            File jasper = new File(context.getRealPath("/WEB-INF/classes/edu/sigmove/reportes/ListaBeneficios.jasper"));

            JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), parametro, conec);

            HttpServletResponse hsr = (HttpServletResponse) context.getResponse();
            hsr.addHeader("Content-disposition", "attachment; filename=Certificado.pdf");
            OutputStream os = hsr.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jp, os);
            os.flush();
            os.close();
            facesContext.responseComplete();

        } catch (JRException e) {
            System.out.println("edu.sigmove.controlador.BeneficioView.descargaListado() " + e.getMessage());
        } catch (IOException i) {
            System.out.println("edu.sigmove.controlador.BeneficioView.descargaListado()  " + i.getMessage());
        } catch (SQLException q) {
            System.out.println("edu.sigmove.controlador.BeneficioView.descargaListado()  " + q.getMessage());
        }

    }
    public BeneficioView() {
    }

    public UsuarioSesion getUsuarioSesion() {
        return usuarioSesion;
    }

    public void setUsuarioSesion(UsuarioSesion usuarioSesion) {
        this.usuarioSesion = usuarioSesion;
    }

    public ArrayList<Beneficio> getListaBeneficio() {
        return listaBeneficio;
    }

    public void setListaBeneficio(ArrayList<Beneficio> listaBeneficio) {
        this.listaBeneficio = listaBeneficio;
    }

    public Beneficio getBeneficioSelect() {
        return beneficioSelect;
    }

    public void setBeneficioSelect(Beneficio beneficioSelect) {
        this.beneficioSelect = beneficioSelect;
    }

    public Beneficio getBenReg() {
        return benReg;
    }

    public void setBenReg(Beneficio benReg) {
        this.benReg = benReg;
    }
    
}
