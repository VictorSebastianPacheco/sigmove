/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.Asistente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victo
 */
@Local
public interface AsistenteFacadeLocal {

    void create(Asistente asistente);

    void edit(Asistente asistente);

    void remove(Asistente asistente);

    Asistente find(Object id);

    List<Asistente> findAll();

    List<Asistente> findRange(int[] range);

    int count();
    
}
