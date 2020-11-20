/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.OrdenDeCompraTelefono;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victo
 */
@Local
public interface OrdenDeCompraTelefonoFacadeLocal {

    void create(OrdenDeCompraTelefono ordenDeCompraTelefono);

    void edit(OrdenDeCompraTelefono ordenDeCompraTelefono);

    void remove(OrdenDeCompraTelefono ordenDeCompraTelefono);

    OrdenDeCompraTelefono find(Object id);

    List<OrdenDeCompraTelefono> findAll();

    List<OrdenDeCompraTelefono> findRange(int[] range);

    int count();
    
}
