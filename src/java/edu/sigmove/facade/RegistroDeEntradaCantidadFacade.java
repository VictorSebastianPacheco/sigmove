/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.RegistroDeEntradaCantidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author victo
 */
@Stateless
public class RegistroDeEntradaCantidadFacade extends AbstractFacade<RegistroDeEntradaCantidad> implements RegistroDeEntradaCantidadFacadeLocal {

    @PersistenceContext(unitName = "sigmovefase4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroDeEntradaCantidadFacade() {
        super(RegistroDeEntradaCantidad.class);
    }
    
}
