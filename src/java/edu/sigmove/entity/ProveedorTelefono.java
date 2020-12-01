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
@Table(name = "proveedor_telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProveedorTelefono.findAll", query = "SELECT p FROM ProveedorTelefono p")})
public class ProveedorTelefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 12)
    @Column(name = "Telefono")
    private String telefono;
    @Size(max = 12)
    @Column(name = "Telefono2")
    private String telefono2;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Proveedores_ID_Proveedor")
    private Integer proveedoresIDProveedor;
    @JoinColumn(name = "Proveedores_ID_Proveedor", referencedColumnName = "ID_Proveedor", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Proveedores proveedores;

    public ProveedorTelefono() {
    }

    public ProveedorTelefono(Integer proveedoresIDProveedor) {
        this.proveedoresIDProveedor = proveedoresIDProveedor;
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

    public Integer getProveedoresIDProveedor() {
        return proveedoresIDProveedor;
    }

    public void setProveedoresIDProveedor(Integer proveedoresIDProveedor) {
        this.proveedoresIDProveedor = proveedoresIDProveedor;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proveedoresIDProveedor != null ? proveedoresIDProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProveedorTelefono)) {
            return false;
        }
        ProveedorTelefono other = (ProveedorTelefono) object;
        if ((this.proveedoresIDProveedor == null && other.proveedoresIDProveedor != null) || (this.proveedoresIDProveedor != null && !this.proveedoresIDProveedor.equals(other.proveedoresIDProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.ProveedorTelefono[ proveedoresIDProveedor=" + proveedoresIDProveedor + " ]";
    }
    
}
