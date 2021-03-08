
package edu.sigmove.controlador;

import edu.sigmove.entity.OrdenDeCompra;
import edu.sigmove.facade.OrdenDeCompraFacadeLocal;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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
 * @author Freddy
 */
@Named(value = "compraRequest")
@RequestScoped
public class CompraRequest {

    @EJB
    OrdenDeCompraFacadeLocal OrdenDeCompraFacadeLocal;

    private OrdenDeCompra ordcom = new OrdenDeCompra();
    private ArrayList<OrdenDeCompra> listaOrdenes = new ArrayList<>();

    @PostConstruct
    public void compraRequestPos() {
        listaOrdenes.addAll(OrdenDeCompraFacadeLocal.findAll());
    }
    
    @Inject
    UsuarioSesion usuarioSesion;

    public CompraRequest() {
    }

    public void registrarOrden() {
        String mensajeRequest = "";
        try {
            ordcom.setFecha(new Date());
            OrdenDeCompraFacadeLocal.create(ordcom);
            listaOrdenes.add(ordcom);
            mensajeRequest = "swal('Registro', 'Exitoso !!!!', 'success');";
        } catch (Exception e) {
            System.out.println("Error RegistroRequest:registrarUsuario " + e.getMessage());
            mensajeRequest = "swal('Verifique sus datos', 'Intente de nuevo', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeRequest);
        ordcom = new OrdenDeCompra();
    }

    public void descargaOrdenes() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext context = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        response.setContentType("application/pdf");

        try {
            Map parametro = new HashMap();
            parametro.put("UsuarioOrden", usuarioSesion.getUsuLogin().getNombre() + " " + usuarioSesion.getUsuLogin().getApellido());
            parametro.put("RutaImagen", context.getRealPath("/resources/img.lum/blackfriday.png"));
            parametro.put("RutaImagen2", context.getRealPath("/resources/img.lum/Mars.png"));
            //"C:\\LIBRERIA\\sigmovefase4\\web\\imagenes\\Mars.png"
            Connection conec = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bdsigmovenew", "root", "password123");
            //C:\LIBRERIA\WebApp1966781B2\src\java\edu\webapp1966781b\reportes\ListaUsuarios.jrxml
            File jasper = new File(context.getRealPath("/WEB-INF/classes/edu/sigmove/reportes/ListaCompras.jasper"));

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

    public OrdenDeCompra getOrdcom() {
        return ordcom;
    }

    public void setOrdcom(OrdenDeCompra ordcom) {
        this.ordcom = ordcom;
    }

    public ArrayList<OrdenDeCompra> getListaOrdenes() {
        return listaOrdenes;
    }

    public void setListaOrdenes(ArrayList<OrdenDeCompra> listaOrdenes) {
        this.listaOrdenes = listaOrdenes;
    }

    

}