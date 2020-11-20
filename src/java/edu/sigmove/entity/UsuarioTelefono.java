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
@Table(name = "usuario_telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioTelefono.findAll", query = "SELECT u FROM UsuarioTelefono u")})
public class UsuarioTelefono implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "Usuario_ID_Usuario")
    private Integer usuarioIDUsuario;
    @JoinColumn(name = "Usuario_ID_Usuario", referencedColumnName = "ID_Usuario", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;

    public UsuarioTelefono() {
    }

    public UsuarioTelefono(Integer usuarioIDUsuario) {
        this.usuarioIDUsuario = usuarioIDUsuario;
    }

    public UsuarioTelefono(Integer usuarioIDUsuario, String telefono, String telefono2) {
        this.usuarioIDUsuario = usuarioIDUsuario;
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

    public Integer getUsuarioIDUsuario() {
        return usuarioIDUsuario;
    }

    public void setUsuarioIDUsuario(Integer usuarioIDUsuario) {
        this.usuarioIDUsuario = usuarioIDUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioIDUsuario != null ? usuarioIDUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioTelefono)) {
            return false;
        }
        UsuarioTelefono other = (UsuarioTelefono) object;
        if ((this.usuarioIDUsuario == null && other.usuarioIDUsuario != null) || (this.usuarioIDUsuario != null && !this.usuarioIDUsuario.equals(other.usuarioIDUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.UsuarioTelefono[ usuarioIDUsuario=" + usuarioIDUsuario + " ]";
    }
    
}
