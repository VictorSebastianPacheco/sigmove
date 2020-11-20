/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.Pqr;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victo
 */
@Local
public interface PqrFacadeLocal {

    void create(Pqr pqr);

    void edit(Pqr pqr);

    void remove(Pqr pqr);

    Pqr find(Object id);

    List<Pqr> findAll();

    List<Pqr> findRange(int[] range);

    int count();
    
}
