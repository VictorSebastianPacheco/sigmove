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
@Table(name = "orden_de_compra_telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenDeCompraTelefono.findAll", query = "SELECT o FROM OrdenDeCompraTelefono o")})
public class OrdenDeCompraTelefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "Telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "Telefono2")
    private String telefono2;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Orden_de_compra_ID_Orden")
    private Integer ordendecompraIDOrden;
    @JoinColumn(name = "Orden_de_compra_ID_Orden", referencedColumnName = "ID_Orden", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private OrdenDeCompra ordenDeCompra;

    public OrdenDeCompraTelefono() {
    }

    public OrdenDeCompraTelefono(Integer ordendecompraIDOrden) {
        this.ordendecompraIDOrden = ordendecompraIDOrden;
    }

    public OrdenDeCompraTelefono(Integer ordendecompraIDOrden, String telefono, String telefono2) {
        this.ordendecompraIDOrden = ordendecompraIDOrden;
        this.telefono = telefono;
        this.telefono2 = telefono2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
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
        if (!(object instanceof OrdenDeCompraTelefono)) {
            return false;
        }
        OrdenDeCompraTelefono other = (OrdenDeCompraTelefono) object;
        if ((this.ordendecompraIDOrden == null && other.ordendecompraIDOrden != null) || (this.ordendecompraIDOrden != null && !this.ordendecompraIDOrden.equals(other.ordendecompraIDOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.OrdenDeCompraTelefono[ ordendecompraIDOrden=" + ordendecompraIDOrden + " ]";
    }
    
}
