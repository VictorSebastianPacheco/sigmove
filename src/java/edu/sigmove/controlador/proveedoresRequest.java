/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.controlador;

import edu.sigmove.entity.Proveedores;
import edu.sigmove.facade.ProveedoresFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
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
    ProveedoresFacadeLocal ProveedoresFacadeLocal;

    private Proveedores provReg = new Proveedores();
    private Proveedores editPro = new Proveedores();
    private ArrayList<Proveedores> listaProveed = new ArrayList<>();

    @PostConstruct
    public void proveeRequestPos() {
        listaProveed.addAll(ProveedoresFacadeLocal.findAll());
    }

    
    public void registrarProveedor(){
        String mensajeRequest="";
        
        try {
            ProveedoresFacadeLocal.create(provReg);
            listaProveed.add(provReg);
            mensajeRequest = "swal('Registro', 'Exitoso !!!!', 'success');";
        } catch (Exception e) {
            System.out.println("Error RegistroRequest:registrarUsuario " +e.getMessage());
            mensajeRequest = "swal('Verifique sus datos', 'Intente de nuevo', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeRequest);
        provReg = new Proveedores();
    }

    public void removerProveedor(Proveedores remProve) {
        String mensajeAlerta = "";

        try {
            ProveedoresFacadeLocal.remove(remProve);
            listaProveed.remove(remProve);
            mensajeAlerta = "swal('Removido el Proveedor', '" + remProve.getNombre() + ' ' + remProve.getNumeroDocumento()+ "', 'success');";
        } catch (Exception e) {
            System.out.println("Error RegistroRequest:removerProveedor " + e.getMessage());
            mensajeAlerta = "swal('Problemas eliminando a ', '" + remProve.getNombre() + ' ' +  remProve.getNumeroDocumento() + "', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeAlerta);
    }
    
    public void UsuarioSelecionado(Proveedores proSelect) {
        editPro = proSelect;
    }
    
    public void actualizarProveedor() {
        String mensajeAlerta = "";
        try { 
            ProveedoresFacadeLocal.edit(editPro);
            listaProveed.clear();
            listaProveed.addAll(ProveedoresFacadeLocal.findAll());

            mensajeAlerta = "swal('Actualizado el usuario', '" + editPro.getNombre() + ' ' + editPro.getNumeroDocumento() + "', 'success');";
        } catch (Exception e) {
            mensajeAlerta = "swal('Problemas Actualizando a ', '" + editPro.getNombre() + ' ' + editPro.getNumeroDocumento() + "', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeAlerta);

    }

    public proveedoresRequest() {
    }

    public Proveedores getProvReg() {
        return provReg;
    }

    public void setProvReg(Proveedores provReg) {
        this.provReg = provReg;
    }

    public ArrayList<Proveedores> getListaProveed() {
        return listaProveed;
    }

    public void setListaProveed(ArrayList<Proveedores> listaProveed) {
        this.listaProveed = listaProveed;
    }

    public Proveedores getEditPro() {
        return editPro;
    }

    public void setEditPro(Proveedores editPro) {
        this.editPro = editPro;
    }


}
