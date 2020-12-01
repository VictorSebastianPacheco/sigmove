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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "beneficio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Beneficio.findAll", query = "SELECT b FROM Beneficio b")})
public class Beneficio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Beneficio")
    private Integer iDBeneficio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "producto")
    private String producto;
    @JoinTable(name = "beneficio_has_cliente", joinColumns = {
        @JoinColumn(name = "beneficio_ID_Beneficio", referencedColumnName = "ID_Beneficio")}, inverseJoinColumns = {
        @JoinColumn(name = "cliente_ID_Cliente", referencedColumnName = "ID_Cliente")})
    @ManyToMany
    private Collection<ClienteFidelizado> clienteFidelizadoCollection;

    public Beneficio() {
    }

    public Beneficio(Integer iDBeneficio) {
        this.iDBeneficio = iDBeneficio;
    }

    public Beneficio(Integer iDBeneficio, String nombre, String tipo, String producto) {
        this.iDBeneficio = iDBeneficio;
        this.nombre = nombre;
        this.tipo = tipo;
        this.producto = producto;
    }

    public Integer getIDBeneficio() {
        return iDBeneficio;
    }

    public void setIDBeneficio(Integer iDBeneficio) {
        this.iDBeneficio = iDBeneficio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @XmlTransient
    public Collection<ClienteFidelizado> getClienteFidelizadoCollection() {
        return clienteFidelizadoCollection;
    }

    public void setClienteFidelizadoCollection(Collection<ClienteFidelizado> clienteFidelizadoCollection) {
        this.clienteFidelizadoCollection = clienteFidelizadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDBeneficio != null ? iDBeneficio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beneficio)) {
            return false;
        }
        Beneficio other = (Beneficio) object;
        if ((this.iDBeneficio == null && other.iDBeneficio != null) || (this.iDBeneficio != null && !this.iDBeneficio.equals(other.iDBeneficio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.Beneficio[ iDBeneficio=" + iDBeneficio + " ]";
    }
    
}
