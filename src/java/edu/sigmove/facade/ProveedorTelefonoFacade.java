/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.ProveedorTelefono;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author victo
 */
@Stateless
public class ProveedorTelefonoFacade extends AbstractFacade<ProveedorTelefono> implements ProveedorTelefonoFacadeLocal {

    @PersistenceContext(unitName = "sigmovefase4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedorTelefonoFacade() {
        super(ProveedorTelefono.class);
    }
    
}
