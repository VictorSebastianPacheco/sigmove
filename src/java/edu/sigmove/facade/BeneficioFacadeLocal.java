/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.Beneficio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victo
 */
@Local
public interface BeneficioFacadeLocal {

    void create(Beneficio beneficio);

    void edit(Beneficio beneficio);

    void remove(Beneficio beneficio);

    Beneficio find(Object id);

    List<Beneficio> findAll();

    List<Beneficio> findRange(int[] range);

    int count();
    
}
