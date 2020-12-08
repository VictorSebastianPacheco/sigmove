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
@Table(name = "orden_de_compra_cantidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenDeCompraCantidad.findAll", query = "SELECT o FROM OrdenDeCompraCantidad o")})
public class OrdenDeCompraCantidad implements Serializable {

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
    @Column(name = "Orden_de_compra_ID_Orden")
    private Integer ordendecompraIDOrden;
    @JoinColumn(name = "Orden_de_compra_ID_Orden", referencedColumnName = "ID_Orden", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private OrdenDeCompra ordenDeCompra;

    public OrdenDeCompraCantidad() {
    }

    public OrdenDeCompraCantidad(Integer ordendecompraIDOrden) {
        this.ordendecompraIDOrden = ordendecompraIDOrden;
    }

    public OrdenDeCompraCantidad(Integer ordendecompraIDOrden, String unidaddemedida, int cantidad) {
        this.ordendecompraIDOrden = ordendecompraIDOrden;
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

    public Integer getOrdendecompraIDOrden() {
        return ordendecompraIDOrden;
    }

    public void setOrdendecompraIDOrden(Integer ordendecompraIDOrden) {
        this.ordendecompraIDOrden = ordendecompraIDOrden;
    }

    public OrdenDeCompra getOrdenDeCompra() {
        return ordenDeCompra;
    }

    public void setOrdenDeCompra(OrdenDeCompra ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordendecompraIDOrden != null ? ordendecompraIDOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenDeCompraCantidad)) {
            return false;
        }
        OrdenDeCompraCantidad other = (OrdenDeCompraCantidad) object;
        if ((this.ordendecompraIDOrden == null && other.ordendecompraIDOrden != null) || (this.ordendecompraIDOrden != null && !this.ordendecompraIDOrden.equals(other.ordendecompraIDOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.OrdenDeCompraCantidad[ ordendecompraIDOrden=" + ordendecompraIDOrden + " ]";
    }
    
}
