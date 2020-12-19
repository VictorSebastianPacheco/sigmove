/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.controlador;

import edu.sigmove.entity.Producto;
import edu.sigmove.facade.ProductoFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import org.primefaces.PrimeFaces;

/**
 *
 * @author victo
 */
@Named(value = "productoSession")
@SessionScoped
public class ProductoSession implements Serializable {

    @EJB
    ProductoFacadeLocal productoFacadeLocal;

    
    private Producto prodLogin = new Producto();
    
    
    public ProductoSession() {
    }
    public void actualizarMisDatos(){
         String mensajeAlerta = "";
        try {
           productoFacadeLocal.edit(prodLogin);
             mensajeAlerta = "swal('Datos actualizados', 'Exitosamente !!!', 'success');";
        } catch (Exception e) {
             mensajeAlerta = "swal('Problemas actualizando', 'sus datos', 'error');";
        }
          PrimeFaces.current().executeScript(mensajeAlerta);
    }

    public Producto getProdLogin() {
        return prodLogin;
    }

    public void setProdLogin(Producto prodLogin) {
        this.prodLogin = prodLogin;
    }
    
    /*@Override
    public List<Producto> listaProdutosporcategoria(int fk_categoria){
        try {
            Query qt = em.createQuery("SELECT p FROM Producto p WHERE p.idcategoria.idcategoria = :fk_categoria");
            qt.setParameter("fk_categoria", fk_categoria);
            return   qt.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }*/
    
    /*
    public List<Producto> listaProdutosporcategoria(int fk_categoria);
    */
    
}
