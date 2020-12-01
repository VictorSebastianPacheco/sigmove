/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ID_Administrador")
    private String iDAdministrador;
    @JoinColumn(name = "Usuario_ID_Usuario", referencedColumnName = "ID_Usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioIDUsuario;
    @OneToMany(mappedBy = "administradorIDAdministrador")
    private Collection<Proveedores> proveedoresCollection;

    public Administrador() {
    }

    public Administrador(String iDAdministrador) {
        this.iDAdministrador = iDAdministrador;
    }

    public String getIDAdministrador() {
        return iDAdministrador;
    }

    public void setIDAdministrador(String iDAdministrador) {
        this.iDAdministrador = iDAdministrador;
    }

    public Usuario getUsuarioIDUsuario() {
        return usuarioIDUsuario;
    }

    public void setUsuarioIDUsuario(Usuario usuarioIDUsuario) {
        this.usuarioIDUsuario = usuarioIDUsuario;
    }

    @XmlTransient
    public Collection<Proveedores> getProveedoresCollection() {
        return proveedoresCollection;
    }

    public void setProveedoresCollection(Collection<Proveedores> proveedoresCollection) {
        this.proveedoresCollection = proveedoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDAdministrador != null ? iDAdministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.iDAdministrador == null && other.iDAdministrador != null) || (this.iDAdministrador != null && !this.iDAdministrador.equals(other.iDAdministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.Administrador[ iDAdministrador=" + iDAdministrador + " ]";
    }
    
}
