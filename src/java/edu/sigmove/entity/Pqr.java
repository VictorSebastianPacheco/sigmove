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
@Table(name = "pqr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pqr.findAll", query = "SELECT p FROM Pqr p")})
public class Pqr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PQR")
    private Integer idPqr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Radicaci\u00f3n")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRadicación;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Tipo_Documento")
    private String tipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Numero_Documento")
    private int numeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 25)
    @Column(name = "Telefono")
    private String telefono;
    @Size(max = 65)
    @Column(name = "Correo")
    private String correo;
    @ManyToMany(mappedBy = "pqrCollection", fetch = FetchType.LAZY)
    private Collection<ClienteFidelizado> clienteFidelizadoCollection;

    public Pqr() {
    }

    public Pqr(Integer idPqr) {
        this.idPqr = idPqr;
    }

    public Pqr(Integer idPqr, Date fechaRadicación, String tipo, String nombre, String apellido, String tipoDocumento, int numeroDocumento, String descripcion) {
        this.idPqr = idPqr;
        this.fechaRadicación = fechaRadicación;
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.descripcion = descripcion;
    }

    public Integer getIdPqr() {
        return idPqr;
    }

    public void setIdPqr(Integer idPqr) {
        this.idPqr = idPqr;
    }

    public Date getFechaRadicación() {
        return fechaRadicación;
    }

    public void setFechaRadicación(Date fechaRadicación) {
        this.fechaRadicación = fechaRadicación;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
        hash += (idPqr != null ? idPqr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pqr)) {
            return false;
        }
        Pqr other = (Pqr) object;
        if ((this.idPqr == null && other.idPqr != null) || (this.idPqr != null && !this.idPqr.equals(other.idPqr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.Pqr[ idPqr=" + idPqr + " ]";
    }
    
}
