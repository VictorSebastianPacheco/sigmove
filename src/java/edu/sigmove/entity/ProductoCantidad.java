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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "producto_cantidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoCantidad.findAll", query = "SELECT p FROM ProductoCantidad p")})
public class ProductoCantidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Unidad_de_medida")
    private String unidaddemedida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private int cantidad;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Producto_ID_Producto")
    private Integer productoIDProducto;
    @JoinColumn(name = "Producto_ID_Producto", referencedColumnName = "ID_Producto", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;

    public ProductoCantidad() {
    }

    public ProductoCantidad(Integer productoIDProducto) {
        this.productoIDProducto = productoIDProducto;
    }

    public ProductoCantidad(Integer productoIDProducto, String unidaddemedida, int cantidad) {
        this.productoIDProducto = productoIDProducto;
        this.unidaddemedida = unidaddemedida;
        this.cantidad = cantidad;
    }

    public String getUnidaddemedida() {
        return unidaddemedida;
    }

    public void setUnidaddemedida(String unidaddemedida) {
        this.unidaddemedida = unidaddemedida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getProductoIDProducto() {
        return productoIDProducto;
    }

    public void setProductoIDProducto(Integer productoIDProducto) {
        this.productoIDProducto = productoIDProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoIDProducto != null ? productoIDProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoCantidad)) {
            return false;
        }
        ProductoCantidad other = (ProductoCantidad) object;
        if ((this.productoIDProducto == null && other.productoIDProducto != null) || (this.productoIDProducto != null && !this.productoIDProducto.equals(other.productoIDProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.ProductoCantidad[ productoIDProducto=" + productoIDProducto + " ]";
    }
    
}
