/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.RegistroDeEntrada;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victo
 */
@Local
public interface RegistroDeEntradaFacadeLocal {

    void create(RegistroDeEntrada registroDeEntrada);

    void edit(RegistroDeEntrada registroDeEntrada);

    void remove(RegistroDeEntrada registroDeEntrada);

    RegistroDeEntrada find(Object id);

    List<RegistroDeEntrada> findAll();

    List<RegistroDeEntrada> findRange(int[] range);

    int count();
    
}
