/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.OrdenDeCompraCantidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victo
 */
@Local
public interface OrdenDeCompraCantidadFacadeLocal {

    void create(OrdenDeCompraCantidad ordenDeCompraCantidad);

    void edit(OrdenDeCompraCantidad ordenDeCompraCantidad);

    void remove(OrdenDeCompraCantidad ordenDeCompraCantidad);

    OrdenDeCompraCantidad find(Object id);

    List<OrdenDeCompraCantidad> findAll();

    List<OrdenDeCompraCantidad> findRange(int[] range);

    int count();
    
}
