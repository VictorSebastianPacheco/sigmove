/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.controlador;

import edu.sigmove.entity.Ventaproducto;
import edu.sigmove.facade.VentaproductoFacadeLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author victo
 */
@Named(value = "ventasProductoRequest")
@RequestScoped
public class VentasProductoRequest {

    @EJB
    VentaproductoFacadeLocal ventaproductoFacadeLocal;

    private Ventaproducto VenProReg = new Ventaproducto();

    public VentasProductoRequest() {
    }
    
    public void registrarVentaproducto() {
        String mensajeRequest="";
        try {
            ventaproductoFacadeLocal.ingresarVentaProducto(0,0,0);
            mensajeRequest = "swal('Registro', 'Exitoso !!!!', 'success');";
        } catch (Exception e) {
            System.out.println("Error RegistroRequest:registrarVenta producto " +e.getMessage());
            mensajeRequest = "swal('Verifique sus datos', 'Intente de nuevo', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeRequest);
        VenProReg = new Ventaproducto();
    }
    
    

    public Ventaproducto getVenProReg() {
        return VenProReg;
    }

    public void setVenProReg(Ventaproducto VenProReg) {
        this.VenProReg = VenProReg;
    }
    
    
    
    
}
