/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.controlador;

import edu.sigmove.entity.Producto;
import edu.sigmove.entity.Ventaproducto;
import edu.sigmove.entity.Ventas;
import edu.sigmove.facade.ProductoFacade;
import edu.sigmove.facade.ProductoFacadeLocal;
import edu.sigmove.facade.VentaproductoFacadeLocal;
import edu.sigmove.facade.VentasFacade;
import edu.sigmove.facade.VentasFacadeLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
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
    
    @Inject
    VentasFacadeLocal ventasFacadeLocal;
    
    @Inject
    ProductoFacadeLocal productoFacadeLocal;
    
    @ManagedProperty(value = "Ventaproducto")
    private Ventaproducto VenProReg = new Ventaproducto();

    
    public VentasProductoRequest() {
    }
    
    public void registrarVentaproducto() {
        String mensajeRequest="";
        try {
            //VenProReg.setProductoIDProducto(new Producto());
            //VenProReg.setVentasIDVenta(new Ventas());
            ventaproductoFacadeLocal.ingresarVentaProducto(0, 0, 0);
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
