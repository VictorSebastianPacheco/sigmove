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
    
    @PostConstruct
    public void cargaPqr() {
        listaPqr.addAll(pqrFacadeLocal.findAll());
    }
    
    public ConsultaPqrView() {
    }

    public ArrayList<Pqr> getListaPqr() {
        return listaPqr;
    }

    public void setListaPqr(ArrayList<Pqr> listaPqr) {
        this.listaPqr = listaPqr;
    }

   
    
    
}
