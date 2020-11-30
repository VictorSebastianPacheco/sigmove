/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.controlador;

import edu.sigmove.entity.Proveedores;
import edu.sigmove.facade.ProveedoresFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author victo
 */
@Named(value = "proveedoresRequest")
@RequestScoped
public class proveedoresRequest implements Serializable{

    /**
     * Creates a new instance of proveedoresRequest
     */
    
    @EJB
    ProveedoresFacadeLocal proveedoresFacadeLocal;

    private Proveedores provReg = new Proveedores();
    
    
    public void registrarProveedor(){
        String mensajeRequest="";
        
        try {
            proveedoresFacadeLocal.create(provReg);
            mensajeRequest = "swal('Registro', 'Exitoso !!!!', 'success');";
        } catch (Exception e) {
            System.out.println("Error RegistroRequest:registrarUsuario " +e.getMessage());
            mensajeRequest = "swal('Verifique sus datos', 'Intente de nuevo', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeRequest);
        provReg = new Proveedores();
    }
    public proveedoresRequest() {
    }

    public Proveedores getProvReg() {
        return provReg;
    }

    public void setProvReg(Proveedores provReg) {
        this.provReg = provReg;
    }
    
}
