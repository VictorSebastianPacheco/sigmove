/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.controlador;

import edu.sigmove.entity.Ventas;
import edu.sigmove.facade.VentasFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Freddy
 */
@Named(value = "ventaRequest")
@RequestScoped
public class VentaRequest {

    @EJB
    VentasFacadeLocal VentasFacadeLocal;
    
    private Ventas newVen = new Ventas();
    
    
    public VentaRequest() {
    }
    
    public void registrarVenta(){
        String mensajeRequest="";
        try{
            newVen.setFecha(new Date());
            VentasFacadeLocal.create(newVen);
            mensajeRequest = "swal('Registro', 'Exitoso !!!!', 'success');";
        } catch (Exception e) {
            System.out.println("Error RegistroRequest:registrarUsuario " +e.getMessage());
            mensajeRequest = "swal('Verifique sus datos', 'Intente de nuevo', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeRequest);
        newVen = new Ventas();
    }

    public Ventas getNewVen() {
        return newVen;
    }

    public void setNewVen(Ventas newVen) {
        this.newVen = newVen;
    }
    
    
}
