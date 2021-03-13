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
//import javax.persistence.Query;

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
/*
    public boolean ingresarVentaProducto(int cantidad, int producto_ID_Producto, int ventas_ID_Venta) {

        try {
            /*Query qt = em.createQuery("INSERT INTO `bdsigmovenew`.`ventaproducto`");

            qt.setParameter("cantidad", cantidad);
            qt.setParameter("producto_ID_Producto", producto_ID_Producto);

            qt.setParameter("ventas_ID_Venta", ventas_ID_Venta);

            Query nativeQuery = em.createNativeQuery("INSERT INTO cantidad, producto_ID_Producto, ventas_ID_Venta FROM `bdsigmovenew`.`ventaproducto`");
            nativeQuery.setParameter(1, cantidad);
            nativeQuery.setParameter(2, producto_ID_Producto);
            nativeQuery.setParameter(3, ventas_ID_Venta);
            nativeQuery.executeUpdate();
            
            //INSERT INTO `bdsigmovenew`.`ventaproducto` (`cantidad`, `producto_ID_Producto`, `ventas_ID_Venta`) VALUES ('1', '212', '1212');
            
            return nativeQuery.getResultList() ;
            
        } catch (Exception e) {

            return false;
        }
        

    }*/
}
