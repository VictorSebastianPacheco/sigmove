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
import javax.persistence.OneToOne;
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
@Table(name = "orden_de_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenDeCompra.findAll", query = "SELECT o FROM OrdenDeCompra o")})
public class OrdenDeCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Orden")
    private Integer iDOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nombre_Comprador")
    private String nombreComprador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nombre_Vendedor")
    private String nombreVendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Lugar_Emision")
    private String lugarEmision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Precio_Unitario")
    private double precioUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Precio_Total")
    private double precioTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Pago_Total")
    private double pagoTotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Metodo_Pago")
    private String metodoPago;
    @JoinTable(name = "proveedores_has_orden_de_compra", joinColumns = {
        @JoinColumn(name = "Orden_de_compra_ID_Orden", referencedColumnName = "ID_Orden")}, inverseJoinColumns = {
        @JoinColumn(name = "Proveedores_ID_Proveedor", referencedColumnName = "ID_Proveedor")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Proveedores> proveedoresCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ordenDeCompra", fetch = FetchType.LAZY)
    private OrdenDeCompraCantidad ordenDeCompraCantidad;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ordenDeCompra", fetch = FetchType.LAZY)
    private OrdenDeCompraTelefono ordenDeCompraTelefono;
    @JoinColumn(name = "Asistente_ID_Asistente", referencedColumnName = "ID_Asistente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Asistente asistenteIDAsistente;

    public OrdenDeCompra() {
    }

    public OrdenDeCompra(Integer iDOrden) {
        this.iDOrden = iDOrden;
    }

    public OrdenDeCompra(Integer iDOrden, Date fecha, String nombreComprador, String nombreVendedor, String lugarEmision, String descripcion, double precioUnitario, double precioTotal, double pagoTotal, String metodoPago) {
        this.iDOrden = iDOrden;
        this.fecha = fecha;
        this.nombreComprador = nombreComprador;
        this.nombreVendedor = nombreVendedor;
        this.lugarEmision = lugarEmision;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
        this.pagoTotal = pagoTotal;
        this.metodoPago = metodoPago;
    }

    public Integer getIDOrden() {
        return iDOrden;
    }

    public void setIDOrden(Integer iDOrden) {
        this.iDOrden = iDOrden;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getLugarEmision() {
        return lugarEmision;
    }

    public void setLugarEmision(String lugarEmision) {
        this.lugarEmision = lugarEmision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(double pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @XmlTransient
    public Collection<Proveedores> getProveedoresCollection() {
        return proveedoresCollection;
    }

    public void setProveedoresCollection(Collection<Proveedores> proveedoresCollection) {
        this.proveedoresCollection = proveedoresCollection;
    }

    public OrdenDeCompraCantidad getOrdenDeCompraCantidad() {
        return ordenDeCompraCantidad;
    }

    public void setOrdenDeCompraCantidad(OrdenDeCompraCantidad ordenDeCompraCantidad) {
        this.ordenDeCompraCantidad = ordenDeCompraCantidad;
    }

    public OrdenDeCompraTelefono getOrdenDeCompraTelefono() {
        return ordenDeCompraTelefono;
    }

    public void setOrdenDeCompraTelefono(OrdenDeCompraTelefono ordenDeCompraTelefono) {
        this.ordenDeCompraTelefono = ordenDeCompraTelefono;
    }

    public Asistente getAsistenteIDAsistente() {
        return asistenteIDAsistente;
    }

    public void setAsistenteIDAsistente(Asistente asistenteIDAsistente) {
        this.asistenteIDAsistente = asistenteIDAsistente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDOrden != null ? iDOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenDeCompra)) {
            return false;
        }
        OrdenDeCompra other = (OrdenDeCompra) object;
        if ((this.iDOrden == null && other.iDOrden != null) || (this.iDOrden != null && !this.iDOrden.equals(other.iDOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.OrdenDeCompra[ iDOrden=" + iDOrden + " ]";
    }
    
}
