/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.controlador;

import edu.sigmove.entity.Usuario;
import edu.sigmove.facade.UsuarioFacadeLocal;
import edu.sigmove.utilidades.Email;
import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

@Named(value = "usuarioRequest")
@RequestScoped
public class UsuarioRequest implements Serializable {

    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;

    private Usuario usuReg = new Usuario();
    private String usuarioIn = "";
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public UsuarioRequest() {
    }

    public void registrarUsuario() {
        String mensajeRequest = "";
        try {
            usuarioFacadeLocal.create(usuReg);
            mensajeRequest = "swal('Registro', 'Exitoso !!!!', 'success');";
        } catch (Exception e) {
            System.out.println("Error RegistroRequest:registrarUsuario " + e.getMessage());
            mensajeRequest = "swal('Verifique sus datos', 'Intente de nuevo', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeRequest);
        usuReg = new Usuario();
    }

    /*public void recuperarClave() {
        String mensajeRequest = "";
        Usuario usuRec = new Usuario();
        try {
            usuRec = usuarioFacadeLocal.recuperarContraseña(correoIn);
            int claveNew = (int) (Math.random() * 100000);
            usuRec.setContraseña("RC-" + claveNew);
            usuarioFacadeLocal.edit(usuRec);
            mensajeRequest = "swal('Su clave', 'Se envio al correo registrado !!!!', 'success');";
            Email.sendClaves(usuRec.getUsuario(),
                    usuRec.getNombre() + " " + usuRec.getApellido(),
                    correoIn, "RC-" + claveNew);
        } catch (Exception e) {
            System.out.println("Error RegistroRequest:recuperarClave " + e.getMessage());
            mensajeRequest = "swal('Correo NO', 'registrado', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeRequest);
        correoIn = "";
    }*/
    public void correoMasivo() {
        /*String mensaje = "los Usuarios con el correo" + listaUsuarios;
        Usuario usuarioResultado = new Usuario();
        

        if (usuarioResultado.getUsuario() == null) {
            mensaje += "no esta registrado";

        } else {*/
            try {
                for (Usuario IUsuario : listaUsuarios) {
                    Email.sendBienvenido(IUsuario.getUsuario(),
                            "Señor " + IUsuario.getNombre() + " " + IUsuario.getApellido(),
                            IUsuario.getUsuario(),
                            IUsuario.getContraseña()
                    );
                }
            } catch (Exception e) {
                System.out.println("Error RegistroRequest:recuperarClave " + e.getMessage());
            }
            //mensaje += " su clave se envio al correo registrado";
        /*}
        FacesMessage ms = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, ms);*/
    }
    

    
    public void recuperarClave() {
        String mensaje = "Usuario con el correo" + usuarioIn;
        Usuario usuarioResultado = new Usuario();
        usuarioResultado = usuarioFacadeLocal.recuperarContraseña(usuarioIn);

        if (usuarioResultado.getNombre() == null) {
            mensaje += "no esta registrado";

        } else {
            try {
                Email.sendClaves(usuarioResultado.getUsuario(),
                        "Señor " + usuarioResultado.getNombre() + " " + usuarioResultado.getApellido(),
                        usuarioResultado.getUsuario(),
                        usuarioResultado.getContraseña()
                );

            } catch (Exception e) {
                System.out.println("Error RegistroRequest:recuperarClave " + e.getMessage());

            }
            mensaje += " su clave se envio al correo registrado";
        }
        FacesMessage ms = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, ms);
    }

    /*public void inicioSession() {
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
    }*/
    public Usuario getUsuReg() {
        return usuReg;
    }

    public void setUsuReg(Usuario usuReg) {
        this.usuReg = usuReg;
    }

    public String getUsuarioIn() {
        return usuarioIn;
    }

    public void setUsuarioIn(String usuarioIn) {
        this.usuarioIn = usuarioIn;
    }

    /*usuarioFacade
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
    public boolean removerUsuario(int id) {
        boolean retorno = false;
        try {
            Query qt = em.createQuery("DELETE FROM Usuario u WHERE u.id = :id");
            qt.setParameter("id", id);
            int salida = qt.executeUpdate();
            return true;
        } catch (Exception e) {
            return retorno;
        }
    }
   

     */
 /*UsuarioFacadeLocal
    
    public Usuario loginUsuario(String usuarioIn, String contraseña);

    public Usuario recuperarContraseña(String usuarioIn);
    
    public boolean removerUsuario(int id);
     */

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
}

