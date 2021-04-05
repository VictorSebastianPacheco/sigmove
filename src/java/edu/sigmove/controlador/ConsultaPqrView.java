/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.controlador;


import edu.sigmove.entity.Pqr;
import edu.sigmove.facade.PqrFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

import org.primefaces.PrimeFaces;

/**
 *
 * @author victo
 */
@Named(value = "consultaPqrView")
@ViewScoped
public class ConsultaPqrView implements Serializable{

    
    @EJB
    PqrFacadeLocal pqrFacadeLocal;
    private ArrayList<Pqr> listaPqr = new ArrayList<>();
    private Pqr pqrSelect = new Pqr();
    private Pqr pqrReg = new Pqr();
    
    @PostConstruct
    public void cargaPqr() {
        listaPqr.addAll(pqrFacadeLocal.findAll());
    }
    
    public void PqrSelecionado(Pqr pqrResSelect) {
        pqrSelect = pqrResSelect;
    }

    public void actualizarPqr() {
        String mensajeAlerta = "";
        try { 
            pqrFacadeLocal.edit(pqrSelect);
            listaPqr.clear();
            listaPqr.addAll( pqrFacadeLocal.findAll());

            mensajeAlerta = "swal('Actualizado el usuario', '" + pqrSelect.getIdPqr() + ' ' + pqrSelect.getCorreo() + "', 'success');";
        } catch (Exception e) {
            mensajeAlerta = "swal('Problemas Actualizando a ', '" + pqrSelect.getIdPqr() + ' ' + pqrSelect.getCorreo() + "', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeAlerta);

    }
    public void removerPqr(Pqr pqrRemov) {
        String mensajeAlerta = "";
        try {
            pqrFacadeLocal.remove(pqrRemov);
            listaPqr.remove(pqrRemov);
            mensajeAlerta = "swal('Removido el Beneficio', '" + pqrRemov.getIdPqr() + ' ' + pqrRemov.getTipo() + "', 'success');";
        } catch (Exception e) {
            mensajeAlerta = "swal('Problemas eliminando a ', '" + pqrRemov.getIdPqr() + ' ' + pqrRemov.getTipo() + "', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeAlerta);

    }
    
    
    public ConsultaPqrView() {
    }

    public ArrayList<Pqr> getListaPqr() {
        return listaPqr;
    }

    public void setListaPqr(ArrayList<Pqr> listaPqr) {
        this.listaPqr = listaPqr;
    }

    public Pqr getPqrSelect() {
        return pqrSelect;
    }

    public void setPqrSelect(Pqr pqrSelect) {
        this.pqrSelect = pqrSelect;
    }

    public Pqr getPqrReg() {
        return pqrReg;
    }

    public void setPqrReg(Pqr pqrReg) {
        this.pqrReg = pqrReg;
    }
    
}
