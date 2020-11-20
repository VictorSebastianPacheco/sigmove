/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.PqrTelefono;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victo
 */
@Local
public interface PqrTelefonoFacadeLocal {

    void create(PqrTelefono pqrTelefono);

    void edit(PqrTelefono pqrTelefono);

    void remove(PqrTelefono pqrTelefono);

    PqrTelefono find(Object id);

    List<PqrTelefono> findAll();

    List<PqrTelefono> findRange(int[] range);

    int count();
    
}
