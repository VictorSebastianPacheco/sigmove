/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.ProductoCantidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victo
 */
@Local
public interface ProductoCantidadFacadeLocal {

    void create(ProductoCantidad productoCantidad);

    void edit(ProductoCantidad productoCantidad);

    void remove(ProductoCantidad productoCantidad);

    ProductoCantidad find(Object id);

    List<ProductoCantidad> findAll();

    List<ProductoCantidad> findRange(int[] range);

    int count();
    
}
