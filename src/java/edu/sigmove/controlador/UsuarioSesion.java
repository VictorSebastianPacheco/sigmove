package edu.sigmove.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.sigmove.entity.Usuario;
import edu.sigmove.facade.UsuarioFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import org.primefaces.PrimeFaces;


/**
 *
 * @author victo
 */
@Named(value = "usuarioSesion")
@SessionScoped
public class UsuarioSesion implements Serializable {
    
    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;

    private String usuarioIn;
    private String contraseña;
    private Usuario usuLogin = new Usuario();
    
    @Inject
    UsuarioSesion usuarioSesion;
    public UsuarioSesion() {
    }
    
    public void inicioSession() {
        String mensajeAlerta = "";
        try {
            usuLogin = usuarioFacadeLocal.loginUsuario(usuarioIn, contraseña);
            if (usuLogin.getUsuario()== null) {
                mensajeAlerta = "swal('Verifique sus datos', 'Intente de nuevo', 'error');";
            } else {
                FacesContext facesContext = FacesContext.getCurrentInstance();
                facesContext.getExternalContext().redirect("../usuario/index.xhtml?faces-redirect=true");
            }

        } catch (Exception e) {
            System.out.println("Error UsuarioSesion:inicioSession " + e.getMessage());
            mensajeAlerta = "swal('Verifique sus datos', 'Intente de nuevo', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeAlerta);
    }
    public void cerraSesion() {
        usuLogin = null;
        ExternalContext ext = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ext.getRequestContextPath();

        try {
            ((HttpSession) ext.getSession(false)).invalidate();
            ext.redirect(ctxPath + "/landingpage/login.xhtml");
        } catch (IOException e) {
            System.out.println("Error UsuarioSesion:cerraSesion " + e.getMessage());
        }

    }
    
    public void actualizarMisDatos(){
         String mensajeAlerta = "";
        try {
           usuarioFacadeLocal.edit(usuLogin);
             mensajeAlerta = "swal('Datos actualizados', 'Exitosamente !!!', 'success');";
        } catch (Exception e) {
             mensajeAlerta = "swal('Problemas actualizando', 'sus datos', 'error');";
        }
          PrimeFaces.current().executeScript(mensajeAlerta);
    }

    public String getUsuarioIn() {
        return usuarioIn;
    }

    public void setUsuarioIn(String usuarioIn) {
        this.usuarioIn = usuarioIn;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Usuario getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(Usuario usuLogin) {
        this.usuLogin = usuLogin;
    }
    
    /*
    @Override
    public Usuario recuperarContraseña(String usuarioIn) {
        try {
            Query qt = em.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :usuarioIn ");
            qt.setParameter("usuarioIn", usuarioIn);
            return (Usuario) qt.getSingleResult();
        } catch (Exception e) {
            return new Usuario();
        }

    }
     @Override
    public Usuario loginUsuario(String usuarioIn , String contraseñaIn){
        try {
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :usuarioIn AND u.contraseña = :contraseñaIn");
            q.setParameter("usuarioIn",usuarioIn );
            q.setParameter("contraseñaIn",contraseñaIn );
            return (Usuario) q.getSingleResult();            
        } catch (Exception e) {
        return  new Usuario();
        }
    }
    */
    
       /* public Usuario recuperarContraseña(String usuarioIn);
    
        public Usuario loginUsuario(String usuarioIn, String contraseña);*/
    
    
    
}
