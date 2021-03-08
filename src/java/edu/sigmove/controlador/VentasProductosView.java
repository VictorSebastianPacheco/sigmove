/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.controlador;

import edu.sigmove.entity.Ventaproducto;
import edu.sigmove.facade.VentaproductoFacadeLocal;
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
@Named(value = "ventasProductosView")
@ViewScoped
public class VentasProductosView implements Serializable{

    @EJB
    VentaproductoFacadeLocal ventaproductoFacadeLocal;
    private ArrayList<Ventaproducto> listaVentaproducto = new ArrayList<>();
    
    private Ventaproducto venProSelect = new Ventaproducto();

    //private Ventaproducto VenProReg = new Ventaproducto();
    
    @PostConstruct
    public void cargaVentasProductos() {
        listaVentaproducto.addAll(ventaproductoFacadeLocal.findAll());
    }
    
    public void VentasProductosSelecionado(Ventaproducto ventasProSelect) {
        venProSelect = ventasProSelect;
    }
    public void actualizarVentasProductos() {
        String mensajeAlerta = "";
        try { 
            ventaproductoFacadeLocal.edit(venProSelect);
            listaVentaproducto.clear();
            listaVentaproducto.addAll( ventaproductoFacadeLocal.findAll());

            mensajeAlerta = "swal('Actualizado el usuario', '" + venProSelect.getProductoIDProducto() + ' ' +venProSelect.getVentasIDVenta() + "', 'success');";
        } catch (Exception e) {
            mensajeAlerta = "swal('Problemas Actualizando a ', '" + venProSelect.getProductoIDProducto() + ' ' + venProSelect.getVentasIDVenta() + "', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeAlerta);

    }
    
   /* public void registrarVentaproducto() {
        String mensajeRequest="";
        
        try {
            ventaproductoFacadeLocal.create(VenProReg);
            
            
                    
            mensajeRequest = "swal('Registro', 'Exitoso !!!!', 'success');";
        } catch (Exception e) {
            System.out.println("Error RegistroRequest:registrarVenta producto " +e.getMessage());
            mensajeRequest = "swal('Verifique sus datos', 'Intente de nuevo', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeRequest);
        VenProReg = new Ventaproducto();
    }*/
    
    public VentasProductosView() {
    }

    public ArrayList<Ventaproducto> getListaVentaproducto() {
        return listaVentaproducto;
    }

    public void setListaVentaproducto(ArrayList<Ventaproducto> listaVentaproducto) {
        this.listaVentaproducto = listaVentaproducto;
    }

    public Ventaproducto getVenProSelect() {
        return venProSelect;
    }

    public void setVenProSelect(Ventaproducto venProSelect) {
        this.venProSelect = venProSelect;
    }

    /*public Ventaproducto getVenProReg() {
        return VenProReg;
    }

    public void setVenProReg(Ventaproducto VenProReg) {
        this.VenProReg = VenProReg;
    }*/
    
}
