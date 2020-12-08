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
import javax.persistence.FetchType;
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
@Table(name = "asistente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistente.findAll", query = "SELECT a FROM Asistente a")})
public class Asistente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ID_Asistente")
    private String iDAsistente;
    @JoinColumn(name = "Usuario_ID_Usuario", referencedColumnName = "ID_Usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioIDUsuario;
    @OneToMany(mappedBy = "asistenteIDAsistente", fetch = FetchType.LAZY)
    private Collection<RegistroDeEntrada> registroDeEntradaCollection;
    @OneToMany(mappedBy = "asistenteIDAsistente", fetch = FetchType.LAZY)
    private Collection<OrdenDeCompra> ordenDeCompraCollection;
    @OneToMany(mappedBy = "asistenteIDAsistente", fetch = FetchType.LAZY)
    private Collection<Ventas> ventasCollection;

    public Asistente() {
    }

    public Asistente(String iDAsistente) {
        this.iDAsistente = iDAsistente;
    }

    public String getIDAsistente() {
        return iDAsistente;
    }

    public void setIDAsistente(String iDAsistente) {
        this.iDAsistente = iDAsistente;
    }

    public Usuario getUsuarioIDUsuario() {
        return usuarioIDUsuario;
    }

    public void setUsuarioIDUsuario(Usuario usuarioIDUsuario) {
        this.usuarioIDUsuario = usuarioIDUsuario;
    }

    @XmlTransient
    public Collection<RegistroDeEntrada> getRegistroDeEntradaCollection() {
        return registroDeEntradaCollection;
    }

    public void setRegistroDeEntradaCollection(Collection<RegistroDeEntrada> registroDeEntradaCollection) {
        this.registroDeEntradaCollection = registroDeEntradaCollection;
    }

    @XmlTransient
    public Collection<OrdenDeCompra> getOrdenDeCompraCollection() {
        return ordenDeCompraCollection;
    }

    public void setOrdenDeCompraCollection(Collection<OrdenDeCompra> ordenDeCompraCollection) {
        this.ordenDeCompraCollection = ordenDeCompraCollection;
    }

    @XmlTransient
    public Collection<Ventas> getVentasCollection() {
        return ventasCollection;
    }

    public void setVentasCollection(Collection<Ventas> ventasCollection) {
        this.ventasCollection = ventasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDAsistente != null ? iDAsistente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistente)) {
            return false;
        }
        Asistente other = (Asistente) object;
        if ((this.iDAsistente == null && other.iDAsistente != null) || (this.iDAsistente != null && !this.iDAsistente.equals(other.iDAsistente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.Asistente[ iDAsistente=" + iDAsistente + " ]";
    }
    
}
