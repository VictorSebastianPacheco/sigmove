/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.ClienteFidelizado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victo
 */
@Local
public interface ClienteFidelizadoFacadeLocal {

    void create(ClienteFidelizado clienteFidelizado);

    void edit(ClienteFidelizado clienteFidelizado);

    void remove(ClienteFidelizado clienteFidelizado);

    ClienteFidelizado find(Object id);

    List<ClienteFidelizado> findAll();

    List<ClienteFidelizado> findRange(int[] range);

    int count();
    
}
