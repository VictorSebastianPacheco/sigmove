/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.Ventaproducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author victo
 */
@Stateless
public class VentaproductoFacade extends AbstractFacade<Ventaproducto> implements VentaproductoFacadeLocal {

    @PersistenceContext(unitName = "sigmovefase4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaproductoFacade() {
        super(Ventaproducto.class);
    }
    
    @Override
    public  Ventaproducto ingresarVentaProducto(int cantidad, int producto_ID_Producto, int ventas_ID_Venta) {
        try {
            Query q = em.createNativeQuery("INSERT INTO cantidad, producto_ID_Producto, ventas_ID_Venta FROM bdsigmovenew.ventaproducto");
            q.setParameter(1, cantidad);
            q.setParameter(2, producto_ID_Producto);
            q.setParameter(3, ventas_ID_Venta);
            return (Ventaproducto) q.getSingleResult();
        } catch (Exception e) {
            return null ;
        }
    }
 
}
