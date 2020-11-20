/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.PqrCorreo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victo
 */
@Local
public interface PqrCorreoFacadeLocal {

    void create(PqrCorreo pqrCorreo);

    void edit(PqrCorreo pqrCorreo);

    void remove(PqrCorreo pqrCorreo);

    PqrCorreo find(Object id);

    List<PqrCorreo> findAll();

    List<PqrCorreo> findRange(int[] range);

    int count();
    
}
