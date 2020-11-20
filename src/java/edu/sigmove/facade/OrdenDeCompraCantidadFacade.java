/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.OrdenDeCompraCantidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author victo
 */
@Stateless
public class OrdenDeCompraCantidadFacade extends AbstractFacade<OrdenDeCompraCantidad> implements OrdenDeCompraCantidadFacadeLocal {

    @PersistenceContext(unitName = "sigmovefase4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenDeCompraCantidadFacade() {
        super(OrdenDeCompraCantidad.class);
    }
    
}
