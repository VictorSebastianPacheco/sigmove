/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "registro_de_entrada")
@NamedQueries({
    @NamedQuery(name = "RegistroDeEntrada.findAll", query = "SELECT r FROM RegistroDeEntrada r")
    , @NamedQuery(name = "RegistroDeEntrada.findByIDRegistro", query = "SELECT r FROM RegistroDeEntrada r WHERE r.iDRegistro = :iDRegistro")
    , @NamedQuery(name = "RegistroDeEntrada.findByNombre", query = "SELECT r FROM RegistroDeEntrada r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "RegistroDeEntrada.findByFecha", query = "SELECT r FROM RegistroDeEntrada r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "RegistroDeEntrada.findByDescripcion", query = "SELECT r FROM RegistroDeEntrada r WHERE r.descripcion = :descripcion")})
public class RegistroDeEntrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Registro")
    private Integer iDRegistro;
    @Size(max = 30)
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 200)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "registroDeEntrada", fetch = FetchType.LAZY)
    private RegistroDeEntradaCantidad registroDeEntradaCantidad;
    @JoinColumn(name = "Asistente_ID_Asistente", referencedColumnName = "ID_Asistente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Asistente asistenteIDAsistente;
    @JoinColumn(name = "producto_ID_Producto", referencedColumnName = "ID_Producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto productoIDProducto;

    public RegistroDeEntrada() {
    }

    public RegistroDeEntrada(Integer iDRegistro) {
        this.iDRegistro = iDRegistro;
    }

    public Integer getIDRegistro() {
        return iDRegistro;
    }

    public void setIDRegistro(Integer iDRegistro) {
        this.iDRegistro = iDRegistro;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public RegistroDeEntradaCantidad getRegistroDeEntradaCantidad() {
        return registroDeEntradaCantidad;
    }

    public void setRegistroDeEntradaCantidad(RegistroDeEntradaCantidad registroDeEntradaCantidad) {
        this.registroDeEntradaCantidad = registroDeEntradaCantidad;
    }

    public Asistente getAsistenteIDAsistente() {
        return asistenteIDAsistente;
    }

    public void setAsistenteIDAsistente(Asistente asistenteIDAsistente) {
        this.asistenteIDAsistente = asistenteIDAsistente;
    }

    public Producto getProductoIDProducto() {
        return productoIDProducto;
    }

    public void setProductoIDProducto(Producto productoIDProducto) {
        this.productoIDProducto = productoIDProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDRegistro != null ? iDRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroDeEntrada)) {
            return false;
        }
        RegistroDeEntrada other = (RegistroDeEntrada) object;
        if ((this.iDRegistro == null && other.iDRegistro != null) || (this.iDRegistro != null && !this.iDRegistro.equals(other.iDRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.RegistroDeEntrada[ iDRegistro=" + iDRegistro + " ]";
    }
    
}
