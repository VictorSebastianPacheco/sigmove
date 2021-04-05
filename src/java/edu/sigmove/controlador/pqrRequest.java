/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.controlador;


import edu.sigmove.entity.Pqr;

import edu.sigmove.facade.PqrFacadeLocal;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Freddy
 */
@Named(value = "pqrRequest")
@RequestScoped
public class pqrRequest implements Serializable{

    @EJB
    PqrFacadeLocal PqrFacadeLocal;
    
    @Inject
    UsuarioSesion usuarioSesion;
    
    private Pqr newpqr = new Pqr();
    
    
    public pqrRequest() {
    }
    
    public void registrarPqr(){
        String mensajeRequest="";
        try{
            newpqr.setFechaRadicación(new Date());
            newpqr.setUsuarioIDUsuario(usuarioSesion.getUsuLogin());
            PqrFacadeLocal.create(newpqr);
            
            mensajeRequest = "swal('Registro', 'Exitoso !!!!', 'success');";
        } catch (Exception e) {
            System.out.println("Error RegistroRequest:registrarUsuario " +e.getMessage());
            mensajeRequest = "swal('Verifique sus datos', 'Intente de nuevo', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeRequest);
        newpqr = new Pqr();
    }
    public void removerPqr(Pqr pqrRemov) {
        String mensajeAlerta = "";
        try {
            PqrFacadeLocal.remove(pqrRemov);
            mensajeAlerta = "swal('La PQR ha sido eliminada', '" + pqrRemov.getTipo() + ' ' + pqrRemov.getIdPqr()+ "', 'success');";
        } catch (Exception e) {
            mensajeAlerta = "swal('Problemas al eliminar la PQR  ', '" + pqrRemov.getTipo() + ' ' +pqrRemov.getIdPqr() + "', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeAlerta);

    }

    public Pqr getNewpqr() {
        return newpqr;
    }

    public void setNewpqr(Pqr newpqr) {
        this.newpqr = newpqr;
    }
    
    
}
