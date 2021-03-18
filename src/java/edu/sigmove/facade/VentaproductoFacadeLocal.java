/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.facade;

import edu.sigmove.entity.Ventaproducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author victo
 */
@Local
public interface VentaproductoFacadeLocal {

    void create(Ventaproducto ventaproducto);

    void edit(Ventaproducto ventaproducto);

    void remove(Ventaproducto ventaproducto);

    Ventaproducto find(Object id);

    List<Ventaproducto> findAll();

    List<Ventaproducto> findRange(int[] range);

    int count();
    
    public boolean ingresarVentaProducto(int cantidad, int producto_ID_Producto, int ventas_ID_Venta);
    
}
