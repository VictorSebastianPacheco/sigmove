/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "ventaproducto")
@NamedQueries({
    @NamedQuery(name = "Ventaproducto.findAll", query = "SELECT v FROM Ventaproducto v")
    , @NamedQuery(name = "Ventaproducto.findByCodigo", query = "SELECT v FROM Ventaproducto v WHERE v.codigo = :codigo")
    , @NamedQuery(name = "Ventaproducto.findByCantidad", query = "SELECT v FROM Ventaproducto v WHERE v.cantidad = :cantidad")})
public class Ventaproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "producto_ID_Producto", referencedColumnName = "ID_Producto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto productoIDProducto;
    @JoinColumn(name = "ventas_ID_Venta", referencedColumnName = "ID_Venta")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ventas ventasIDVenta;

    public Ventaproducto() {
    }

    public Ventaproducto(Integer codigo) {
        this.codigo = codigo;
    }

    public Ventaproducto(Integer codigo, int cantidad) {
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProductoIDProducto() {
        return productoIDProducto;
    }

    public void setProductoIDProducto(Producto productoIDProducto) {
        this.productoIDProducto = productoIDProducto;
    }

    public Ventas getVentasIDVenta() {
        return ventasIDVenta;
    }

    public void setVentasIDVenta(Ventas ventasIDVenta) {
        this.ventasIDVenta = ventasIDVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventaproducto)) {
            return false;
        }
        Ventaproducto other = (Ventaproducto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.Ventaproducto[ codigo=" + codigo + " ]";
    }
    
}
