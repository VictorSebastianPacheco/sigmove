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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIDProducto", query = "SELECT p FROM Producto p WHERE p.iDProducto = :iDProducto")
    , @NamedQuery(name = "Producto.findBySerial", query = "SELECT p FROM Producto p WHERE p.serial = :serial")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Producto.findByImagenruta", query = "SELECT p FROM Producto p WHERE p.imagenruta = :imagenruta")
    , @NamedQuery(name = "Producto.findByCantidad", query = "SELECT p FROM Producto p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Producto.findByUnidadMedida", query = "SELECT p FROM Producto p WHERE p.unidadMedida = :unidadMedida")
    , @NamedQuery(name = "Producto.findByPrecioUnitario", query = "SELECT p FROM Producto p WHERE p.precioUnitario = :precioUnitario")
    , @NamedQuery(name = "Producto.findByPrecioventa", query = "SELECT p FROM Producto p WHERE p.precioventa = :precioventa")
    , @NamedQuery(name = "Producto.findByGenero", query = "SELECT p FROM Producto p WHERE p.genero = :genero")
    , @NamedQuery(name = "Producto.findByMarca", query = "SELECT p FROM Producto p WHERE p.marca = :marca")
    , @NamedQuery(name = "Producto.findByTipo", query = "SELECT p FROM Producto p WHERE p.tipo = :tipo")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Producto")
    private Integer iDProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Serial")
    private String serial;
    @Size(max = 20)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "Imagen_ruta")
    private String imagenruta;
    @Size(max = 45)
    @Column(name = "cantidad")
    private String cantidad;
    @Size(max = 45)
    @Column(name = "unidad_medida")
    private String unidadMedida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Precio_Unitario")
    private Double precioUnitario;
    @Column(name = "Precio_venta")
    private Double precioventa;
    @Size(max = 30)
    @Column(name = "Genero")
    private String genero;
    @Size(max = 30)
    @Column(name = "Marca")
    private String marca;
    @Size(max = 30)
    @Column(name = "Tipo")
    private String tipo;
    @JoinTable(name = "producto_has_ventas", joinColumns = {
        @JoinColumn(name = "Producto_ID_Producto", referencedColumnName = "ID_Producto")}, inverseJoinColumns = {
        @JoinColumn(name = "Ventas_ID_Venta", referencedColumnName = "ID_Venta")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Ventas> ventasCollection;
    @JoinTable(name = "producto_has_proveedores", joinColumns = {
        @JoinColumn(name = "Producto_ID_Producto", referencedColumnName = "ID_Producto")}, inverseJoinColumns = {
        @JoinColumn(name = "Proveedores_ID_Proveedor", referencedColumnName = "ID_Proveedor")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Proveedores> proveedoresCollection;
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria idcategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoIDProducto", fetch = FetchType.LAZY)
    private Collection<RegistroDeEntrada> registroDeEntradaCollection;

    public Producto() {
    }

    public Producto(Integer iDProducto) {
        this.iDProducto = iDProducto;
    }

    public Producto(Integer iDProducto, String serial) {
        this.iDProducto = iDProducto;
        this.serial = serial;
    }

    public Integer getIDProducto() {
        return iDProducto;
    }

    public void setIDProducto(Integer iDProducto) {
        this.iDProducto = iDProducto;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagenruta() {
        return imagenruta;
    }

    public void setImagenruta(String imagenruta) {
        this.imagenruta = imagenruta;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(Double precioventa) {
        this.precioventa = precioventa;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Collection<Ventas> getVentasCollection() {
        return ventasCollection;
    }

    public void setVentasCollection(Collection<Ventas> ventasCollection) {
        this.ventasCollection = ventasCollection;
    }

    public Collection<Proveedores> getProveedoresCollection() {
        return proveedoresCollection;
    }

    public void setProveedoresCollection(Collection<Proveedores> proveedoresCollection) {
        this.proveedoresCollection = proveedoresCollection;
    }

    public Categoria getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Categoria idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Collection<RegistroDeEntrada> getRegistroDeEntradaCollection() {
        return registroDeEntradaCollection;
    }

    public void setRegistroDeEntradaCollection(Collection<RegistroDeEntrada> registroDeEntradaCollection) {
        this.registroDeEntradaCollection = registroDeEntradaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDProducto != null ? iDProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.iDProducto == null && other.iDProducto != null) || (this.iDProducto != null && !this.iDProducto.equals(other.iDProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.Producto[ iDProducto=" + iDProducto + " ]";
    }
    
}
