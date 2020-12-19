
package edu.sigmove.controlador;

import edu.sigmove.entity.OrdenDeCompra;
import edu.sigmove.facade.OrdenDeCompraFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
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
    
        
    public CompraRequest() {
    }
    
    public void registrarOrden(){
        String mensajeRequest="";
        try{
            ordcom.setFecha(new Date());
            OrdenDeCompraFacadeLocal.create(ordcom);
            mensajeRequest = "swal('Registro', 'Exitoso !!!!', 'success');";
        } catch (Exception e) {
            System.out.println("Error RegistroRequest:registrarUsuario " +e.getMessage());
            mensajeRequest = "swal('Verifique sus datos', 'Intente de nuevo', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeRequest);
        ordcom = new OrdenDeCompra();
    }


    public OrdenDeCompra getOrdcom() {
        return ordcom;
    }

    public void setOrdcom(OrdenDeCompra ordcom) {
        this.ordcom = ordcom;
    }


    
}
