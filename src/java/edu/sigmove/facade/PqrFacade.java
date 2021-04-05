/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.Pqr;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author victo
 */
@Stateless
public class PqrFacade extends AbstractFacade<Pqr> implements PqrFacadeLocal {

    @PersistenceContext(unitName = "sigmovefase4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PqrFacade() {
        super(Pqr.class);
    }

    @Override
    public boolean ingresarNuevaPqr(int cantidad, int producto_ID_Producto, int ventas_ID_Venta) {
        try {
            //INSERT INTO `ventaproducto` (`codigo`, `cantidad`, `producto_ID_Producto`, `ventas_ID_Venta`) VALUES (NULL, '3', '1154', '9109');
            Query q = em.createNativeQuery("INSERT INTO bdsigmovenew.ventaproducto (`cantidad`, `producto_ID_Producto`, `ventas_ID_Venta`)");
            q.setParameter(1, cantidad);
            q.setParameter(2, producto_ID_Producto);
            q.setParameter(3, ventas_ID_Venta);
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
}
