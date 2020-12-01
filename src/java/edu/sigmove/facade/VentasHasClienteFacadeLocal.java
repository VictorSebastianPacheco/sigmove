/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.VentasHasCliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victo
 */
@Local
public interface VentasHasClienteFacadeLocal {

    void create(VentasHasCliente ventasHasCliente);

    void edit(VentasHasCliente ventasHasCliente);

    void remove(VentasHasCliente ventasHasCliente);

    VentasHasCliente find(Object id);

    List<VentasHasCliente> findAll();

    List<VentasHasCliente> findRange(int[] range);

    int count();
    
}
