/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.controlador;

import edu.sigmove.entity.ClienteFidelizado;
import edu.sigmove.facade.ClienteFidelizadoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author victo
 */
@Named(value = "clienteFidelizadoView")
@ViewScoped
public class ClienteFidelizadoView implements Serializable{

    @EJB
    ClienteFidelizadoFacadeLocal clienteFidelizadoFacadeLocal;
    private ArrayList<ClienteFidelizado> listaCliente = new ArrayList<>();
    
    @PostConstruct
    public void cargaClienteFidelizado() {
        listaCliente.addAll(clienteFidelizadoFacadeLocal.findAll());
    }
    
    
    public ClienteFidelizadoView() {
    }

    public ArrayList<ClienteFidelizado> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList<ClienteFidelizado> listaCliente) {
        this.listaCliente = listaCliente;
    }
    
}
