/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.RegistroDeEntradaCantidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victo
 */
@Local
public interface RegistroDeEntradaCantidadFacadeLocal {

    void create(RegistroDeEntradaCantidad registroDeEntradaCantidad);

    void edit(RegistroDeEntradaCantidad registroDeEntradaCantidad);

    void remove(RegistroDeEntradaCantidad registroDeEntradaCantidad);

    RegistroDeEntradaCantidad find(Object id);

    List<RegistroDeEntradaCantidad> findAll();

    List<RegistroDeEntradaCantidad> findRange(int[] range);

    int count();
    
}
