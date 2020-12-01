/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.controlador;

import edu.sigmove.entity.Usuario;
import edu.sigmove.facade.UsuarioFacadeLocal;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.primefaces.PrimeFaces;

/**
 *
 * @author victo
 */
@Named(value = "usuarioView")
@ViewScoped
public class UsuarioView implements Serializable{

    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;
    private ArrayList<Usuario> listaUsuario = new ArrayList<>();
    private Usuario usuarioSelect = new Usuario();
    private Usuario usuReg = new Usuario();
    
    @Inject
    private UsuarioSesion usuarioSesion;
    
    
    @PostConstruct
    public void cargaUsuario() {
        listaUsuario.addAll(usuarioFacadeLocal.findAll());
    }
    public void removerUsuario(Usuario usuRemov) {
        String mensajeAlerta = "";
        try {
            usuarioFacadeLocal.remove(usuRemov);
            listaUsuario.remove(usuRemov);
            mensajeAlerta = "swal('Removido el usuario', '" + usuRemov.getNombre() + ' ' + usuRemov.getApellido()+ "', 'success');";
        } catch (Exception e) {
            mensajeAlerta = "swal('Problemas eliminando a ', '" + usuRemov.getNombre() + ' ' +  usuRemov.getApellido() + "', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeAlerta);

    }

    public void UsuarioSelecionado(Usuario usuSelect) {
        usuarioSelect = usuSelect;
    }

    public void actualizarUsuario() {
        String mensajeAlerta = "";
        try { 
            usuarioFacadeLocal.edit(usuarioSelect);
            listaUsuario.clear();
            listaUsuario.addAll(usuarioFacadeLocal.findAll());

            mensajeAlerta = "swal('Actualizado el usuario', '" + usuarioSelect.getNombre() + ' ' + usuarioSelect.getApellido() + "', 'success');";
        } catch (Exception e) {
            mensajeAlerta = "swal('Problemas Actualizando a ', '" + usuarioSelect.getNombre() + ' ' + usuarioSelect.getApellido() + "', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeAlerta);

    }

    public void registrarNuevoUsuario() {
        String mensajeRequest = "";
        try {
            usuReg.setFechaRegistro(new Date());
            usuarioFacadeLocal.create(usuReg);
            listaUsuario.clear();
            listaUsuario.addAll(usuarioFacadeLocal.findAll());
            mensajeRequest = "swal('Registro', 'Exitoso !!!!', 'success');";
        } catch (Exception e) {
            System.out.println("Error RegistroRequest:registrarUsuario " + e.getMessage());
            mensajeRequest = "swal('Verifique sus datos', 'Intente de nuevo', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeRequest);
        usuReg = new Usuario();
    }
    public void descargaListado() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext context = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getResponse();
        response.setContentType("application/pdf");

        try {
            Map parametro = new HashMap();
            parametro.put("UsuarioReporte", usuarioSesion.getUsuLogin().getNombre() + " " +usuarioSesion.getUsuLogin().getApellido());
            parametro.put("RutaImagen", context.getRealPath("/resources/img.lum/blackfriday.png"));
            parametro.put("RutaImagen2", context.getRealPath("/resources/img.lum/SIGMOVE.png"));
            Connection conec = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bdsigmovenew", "root", "");
           //C:\LIBRERIA\WebApp1966781B2\src\java\edu\webapp1966781b\reportes\ListaUsuarios.jrxml
            File jasper = new File(context.getRealPath("/WEB-INF/classes/edu/sigmove/reportes/ListaBeneficios.jasper"));

            JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), parametro, conec);

            HttpServletResponse hsr = (HttpServletResponse) context.getResponse();
            hsr.addHeader("Content-disposition", "attachment; filename=Certificado.pdf");
            OutputStream os = hsr.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jp, os);
            os.flush();
            os.close();
            facesContext.responseComplete();

        } catch (JRException e) {
            System.out.println("edu.sigmove.controlador.BeneficioView.descargaListado() " + e.getMessage());
        } catch (IOException i) {
            System.out.println("edu.sigmove.controlador.BeneficioView.descargaListado()  " + i.getMessage());
        } catch (SQLException q) {
            System.out.println("edu.sigmove.controlador.BeneficioView.descargaListado()  " + q.getMessage());
        }

    }
    
    public UsuarioView() {
    }

    public ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public Usuario getUsuarioSelect() {
        return usuarioSelect;
    }

    public void setUsuarioSelect(Usuario usuarioSelect) {
        this.usuarioSelect = usuarioSelect;
    }

    public Usuario getUsuReg() {
        return usuReg;
    }

    public void setUsuReg(Usuario usuReg) {
        this.usuReg = usuReg;
    }

    public UsuarioSesion getUsuarioSesion() {
        return usuarioSesion;
    }

    public void setUsuarioSesion(UsuarioSesion usuarioSesion) {
        this.usuarioSesion = usuarioSesion;
    }
    
}
