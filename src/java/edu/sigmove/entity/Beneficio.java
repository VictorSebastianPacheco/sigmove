/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Beneficio")
    private Integer iDBeneficio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Inicio_Vigencia")
    @Temporal(TemporalType.DATE)
    private Date inicioVigencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fin_Vigencia")
    @Temporal(TemporalType.DATE)
    private Date finVigencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Tipo")
    private String tipo;
    @JoinColumn(name = "Cliente_ID_Cliente", referencedColumnName = "ID_Cliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente clienteIDCliente;
    @JoinColumn(name = "Producto_ID_Producto", referencedColumnName = "ID_Producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto productoIDProducto;

    public Beneficio() {
    }

    public Beneficio(Integer iDBeneficio) {
        this.iDBeneficio = iDBeneficio;
    }

    public Beneficio(Integer iDBeneficio, String nombre, Date fecha, Date inicioVigencia, Date finVigencia, String tipo) {
        this.iDBeneficio = iDBeneficio;
        this.nombre = nombre;
        this.fecha = fecha;
        this.inicioVigencia = inicioVigencia;
        this.finVigencia = finVigencia;
        this.tipo = tipo;
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

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Date getFinVigencia() {
        return finVigencia;
    }

    public void setFinVigencia(Date finVigencia) {
        this.finVigencia = finVigencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getClienteIDCliente() {
        return clienteIDCliente;
    }

    public void setClienteIDCliente(Cliente clienteIDCliente) {
        this.clienteIDCliente = clienteIDCliente;
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
