/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Cliente")
    private Integer iDCliente;
    @JoinTable(name = "cliente_has_pqr", joinColumns = {
        @JoinColumn(name = "Cliente_ID_Cliente", referencedColumnName = "ID_Cliente")}, inverseJoinColumns = {
        @JoinColumn(name = "PQR_ID_PQR", referencedColumnName = "ID_PQR")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Pqr> pqrCollection;
    @JoinTable(name = "ventas_has_cliente", joinColumns = {
        @JoinColumn(name = "Cliente_ID_Cliente", referencedColumnName = "ID_Cliente")}, inverseJoinColumns = {
        @JoinColumn(name = "Ventas_ID_Venta", referencedColumnName = "ID_Venta")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Ventas> ventasCollection;
    @JoinColumn(name = "Usuario_ID_Usuario", referencedColumnName = "ID_Usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioIDUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteIDCliente", fetch = FetchType.LAZY)
    private Collection<Beneficio> beneficioCollection;

    public Cliente() {
    }

    public Cliente(Integer iDCliente) {
        this.iDCliente = iDCliente;
    }

    public Integer getIDCliente() {
        return iDCliente;
    }

    public void setIDCliente(Integer iDCliente) {
        this.iDCliente = iDCliente;
    }

    @XmlTransient
    public Collection<Pqr> getPqrCollection() {
        return pqrCollection;
    }

    public void setPqrCollection(Collection<Pqr> pqrCollection) {
        this.pqrCollection = pqrCollection;
    }

    @XmlTransient
    public Collection<Ventas> getVentasCollection() {
        return ventasCollection;
    }

    public void setVentasCollection(Collection<Ventas> ventasCollection) {
        this.ventasCollection = ventasCollection;
    }

    public Usuario getUsuarioIDUsuario() {
        return usuarioIDUsuario;
    }

    public void setUsuarioIDUsuario(Usuario usuarioIDUsuario) {
        this.usuarioIDUsuario = usuarioIDUsuario;
    }

    @XmlTransient
    public Collection<Beneficio> getBeneficioCollection() {
        return beneficioCollection;
    }

    public void setBeneficioCollection(Collection<Beneficio> beneficioCollection) {
        this.beneficioCollection = beneficioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDCliente != null ? iDCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.iDCliente == null && other.iDCliente != null) || (this.iDCliente != null && !this.iDCliente.equals(other.iDCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.Cliente[ iDCliente=" + iDCliente + " ]";
    }
    
}
