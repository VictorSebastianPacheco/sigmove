/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.ProveedorTelefono;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victo
 */
@Local
public interface ProveedorTelefonoFacadeLocal {

    void create(ProveedorTelefono proveedorTelefono);

    void edit(ProveedorTelefono proveedorTelefono);

    void remove(ProveedorTelefono proveedorTelefono);

    ProveedorTelefono find(Object id);

    List<ProveedorTelefono> findAll();

    List<ProveedorTelefono> findRange(int[] range);

    int count();
    
}
