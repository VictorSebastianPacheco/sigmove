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
    public boolean ingresarVentaProducto(int cantidad, int producto_ID_Producto, int ventas_ID_Venta) {
        try {
            //INSERT INTO `bdsigmovenew`.`ventaproducto` (`cantidad`, `producto_ID_Producto`, `ventas_ID_Venta`) VALUES ('1', '1136', '9102');
            //INSERT INTO `ventaproducto` (`codigo`, `cantidad`, `producto_ID_Producto`, `ventas_ID_Venta`) VALUES (NULL, '3', '1154', '9109');
            Query nativeQuery = em.createNativeQuery("INSERT INTO ventaproducto (cantidad, producto_ID_Producto, ventas_ID_Venta) ");
            nativeQuery.setParameter("cantidad", cantidad);
            nativeQuery.setParameter("producto_ID_Producto", producto_ID_Producto);
            nativeQuery.setParameter("ventas_ID_Venta", ventas_ID_Venta);
            nativeQuery.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
    @Override
    public boolean ingresarVentaProducto2(int cantidad, int producto_ID_Producto, int ventas_ID_Venta) {
        try {
           Query nativeQuery = em.createNativeQuery("INSERT INTO ventaproducto (cantidad, producto_ID_Producto, ventas_ID_Venta) VALUES(?,?,?)");
            nativeQuery.setParameter(1, cantidad);
            nativeQuery.setParameter(2, producto_ID_Producto);
            nativeQuery.setParameter(3, ventas_ID_Venta);
            nativeQuery.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
     */
    @Override
    public void insert(int cantidad, int producto_ID_Producto, int ventas_ID_Venta) {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("INSERT INTO ventaproducto (cantidad, producto_ID_Producto, ventas_ID_Venta) ");
        query.setParameter("cantidad", cantidad);
        query.setParameter("producto_ID_Producto", producto_ID_Producto);
        query.setParameter("ventas_ID_Venta", ventas_ID_Venta);
        query.executeUpdate();
        em.getTransaction().commit();
    }
}