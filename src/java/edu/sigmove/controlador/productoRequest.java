/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.controlador;

import edu.sigmove.entity.Producto;
import edu.sigmove.facade.ProductoFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author victo
 */
@Named(value = "productoRequest")
@RequestScoped
public class productoRequest implements Serializable{

    @EJB
    ProductoFacadeLocal productoFacadeLocal;

    private Producto prodReg = new Producto();
    
    public productoRequest() {
    }
    public void registrarProducto() {
        String mensajeRequest="";
        try {
            productoFacadeLocal.create(prodReg);
            mensajeRequest = "swal('Registro', 'Exitoso !!!!', 'success');";
        } catch (Exception e) {
            System.out.println("Error RegistroRequest:registrarUsuario " +e.getMessage());
            mensajeRequest = "swal('Verifique sus datos', 'Intente de nuevo', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeRequest);
        prodReg = new Producto();
    }

    public Producto getProdReg() {
        return prodReg;
    }

    public void setProdReg(Producto prodReg) {
        this.prodReg = prodReg;
    }
    
    
}
