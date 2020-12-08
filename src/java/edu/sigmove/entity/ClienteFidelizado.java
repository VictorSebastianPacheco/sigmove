/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "cliente_fidelizado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteFidelizado.findAll", query = "SELECT c FROM ClienteFidelizado c")})
public class ClienteFidelizado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Cliente")
    private Integer iDCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo")
    private String correo;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinTable(name = "cliente_has_pqr", joinColumns = {
        @JoinColumn(name = "Cliente_ID_Cliente", referencedColumnName = "ID_Cliente")}, inverseJoinColumns = {
        @JoinColumn(name = "PQR_ID_PQR", referencedColumnName = "ID_PQR")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Pqr> pqrCollection;
    @ManyToMany(mappedBy = "clienteFidelizadoCollection", fetch = FetchType.LAZY)
    private Collection<Beneficio> beneficioCollection;
    @JoinColumn(name = "usuario_ID_Usuario", referencedColumnName = "ID_Usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuarioIDUsuario;
    @OneToMany(mappedBy = "clienteIDCliente", fetch = FetchType.LAZY)
    private Collection<VentasHasCliente> ventasHasClienteCollection;

    public ClienteFidelizado() {
    }

    public ClienteFidelizado(Integer iDCliente) {
        this.iDCliente = iDCliente;
    }

    public ClienteFidelizado(Integer iDCliente, String nombre, String correo) {
        this.iDCliente = iDCliente;
        this.nombre = nombre;
        this.correo = correo;
    }

    public Integer getIDCliente() {
        return iDCliente;
    }

    public void setIDCliente(Integer iDCliente) {
        this.iDCliente = iDCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<Pqr> getPqrCollection() {
        return pqrCollection;
    }

    public void setPqrCollection(Collection<Pqr> pqrCollection) {
        this.pqrCollection = pqrCollection;
    }

    @XmlTransient
    public Collection<Beneficio> getBeneficioCollection() {
        return beneficioCollection;
    }

    public void setBeneficioCollection(Collection<Beneficio> beneficioCollection) {
        this.beneficioCollection = beneficioCollection;
    }

    public Usuario getUsuarioIDUsuario() {
        return usuarioIDUsuario;
    }

    public void setUsuarioIDUsuario(Usuario usuarioIDUsuario) {
        this.usuarioIDUsuario = usuarioIDUsuario;
    }

    @XmlTransient
    public Collection<VentasHasCliente> getVentasHasClienteCollection() {
        return ventasHasClienteCollection;
    }

    public void setVentasHasClienteCollection(Collection<VentasHasCliente> ventasHasClienteCollection) {
        this.ventasHasClienteCollection = ventasHasClienteCollection;
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
        if (!(object instanceof ClienteFidelizado)) {
            return false;
        }
        ClienteFidelizado other = (ClienteFidelizado) object;
        if ((this.iDCliente == null && other.iDCliente != null) || (this.iDCliente != null && !this.iDCliente.equals(other.iDCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.ClienteFidelizado[ iDCliente=" + iDCliente + " ]";
    }
    
}
