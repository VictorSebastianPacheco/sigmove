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
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Venta")
    private Integer iDVenta;
    @Size(max = 30)
    @Column(name = "Nombre_Vendedor")
    private String nombreVendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nombre_Comprador")
    private String nombreComprador;
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 20)
    @Column(name = "Descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Precio_Total")
    private Double precioTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Pago_Total")
    private double pagoTotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Metodo_Pago")
    private String metodoPago;
    @ManyToMany(mappedBy = "ventasCollection", fetch = FetchType.LAZY)
    private Collection<Producto> productoCollection;
    @JoinColumn(name = "Asistente_ID_Asistente", referencedColumnName = "ID_Asistente")
    @ManyToOne(fetch = FetchType.LAZY)
    private Asistente asistenteIDAsistente;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ventas", fetch = FetchType.LAZY)
    private VentasHasCliente ventasHasCliente;

    public Ventas() {
    }

    public Ventas(Integer iDVenta) {
        this.iDVenta = iDVenta;
    }

    public Ventas(Integer iDVenta, String nombreComprador, String direccion, double pagoTotal, String metodoPago) {
        this.iDVenta = iDVenta;
        this.nombreComprador = nombreComprador;
        this.direccion = direccion;
        this.pagoTotal = pagoTotal;
        this.metodoPago = metodoPago;
    }

    public Integer getIDVenta() {
        return iDVenta;
    }

    public void setIDVenta(Integer iDVenta) {
        this.iDVenta = iDVenta;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
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
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    public Asistente getAsistenteIDAsistente() {
        return asistenteIDAsistente;
    }

    public void setAsistenteIDAsistente(Asistente asistenteIDAsistente) {
        this.asistenteIDAsistente = asistenteIDAsistente;
    }

    public VentasHasCliente getVentasHasCliente() {
        return ventasHasCliente;
    }

    public void setVentasHasCliente(VentasHasCliente ventasHasCliente) {
        this.ventasHasCliente = ventasHasCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDVenta != null ? iDVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.iDVenta == null && other.iDVenta != null) || (this.iDVenta != null && !this.iDVenta.equals(other.iDVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.Ventas[ iDVenta=" + iDVenta + " ]";
    }
    
}
