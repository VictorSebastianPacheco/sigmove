/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.controlador;

import edu.sigmove.entity.Producto;
import edu.sigmove.facade.ProductoFacadeLocal;
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
@Named(value = "productoView")
@ViewScoped
public class ProductoView implements Serializable{

    @EJB
    ProductoFacadeLocal productoFacadeLocal;
    private ArrayList<Producto> listaProducto = new ArrayList<>(5);
    
    private Producto productoSelect = new Producto();
    
    public ProductoView() {
    }
    @PostConstruct
    public void cargaUsuarios() {
        listaProducto.addAll(productoFacadeLocal.findAll());
    }
    
    public void removerProducto(Producto prodRemov) {
        String mensajeAlerta = "";
        try {
            productoFacadeLocal.remove(prodRemov);
            listaProducto.remove(prodRemov);
            mensajeAlerta = "swal('Removido el usuario', '" + prodRemov.getNombre() + ' ' + prodRemov.getTipo() + "', 'success');";
        } catch (Exception e) {
            mensajeAlerta = "swal('Problemas eliminando a ', '" + prodRemov.getNombre() + ' ' + prodRemov.getTipo() + "', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeAlerta);

    }
    public void ProductoSelecionado(Producto prodSelect) {
        productoSelect = prodSelect;
    }

    public void acutalizarProducto() {
        String mensajeAlerta = "";
        try {
            productoFacadeLocal.edit(productoSelect);
            listaProducto.clear();
            listaProducto.addAll(productoFacadeLocal.findAll());

            mensajeAlerta = "swal('Actualizado el usuario', '" + productoSelect.getNombre() + ' ' + productoSelect.getIDProducto() + "', 'success');";
        } catch (Exception e) {
            mensajeAlerta = "swal('Problemas Actualizando a ', '" + productoSelect.getNombre() + ' ' + productoSelect.getIDProducto() + "', 'error');";
        }
        PrimeFaces.current().executeScript(mensajeAlerta);

    }
    
    

    public ArrayList<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(ArrayList<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public Producto getProductoSelect() {
        return productoSelect;
    }

    public void setProductoSelect(Producto productoSelect) {
        this.productoSelect = productoSelect;
    }
    
}
