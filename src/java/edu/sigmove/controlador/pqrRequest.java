/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.controlador;

import edu.sigmove.entity.Pqr;
import edu.sigmove.facade.PqrFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Freddy
 */
@Named(value = "pqrRequest")
@RequestScoped
public class pqrRequest {

    @EJB
    PqrFacadeLocal PqrFacadeLocal;
    
    private Pqr newpqr = new Pqr();
    
    
    public pqrRequest() {
    }
    
    public void registrarPqr(){
        String mensajeRequest="";
        try{
            newpqr.setFechaRadicación(new Date());
            PqrFacadeLocal.create(newpqr);
            mensajeRequest = "swal('Registro', 'Exitoso !!!!', 'success');";
        } catch (Exception e) {
            System.out.println("Error RegistroRequest:registrarUsuario " +e.getMessage());
            mensajeRequest = "swal('Verifique sus datos', 'Intente de nuevo', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeRequest);
        newpqr = new Pqr();
    }

    public Pqr getNewpqr() {
        return newpqr;
    }

    public void setNewpqr(Pqr newpqr) {
        this.newpqr = newpqr;
    }
    
    
}
