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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "proveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Proveedor")
    private Integer iDProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nombre")
    private String nombre;
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
    @Size(min = 1, max = 40)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 20)
    @Column(name = "Ciudad")
    private String ciudad;
    @ManyToMany(mappedBy = "proveedoresCollection", fetch = FetchType.LAZY)
    private Collection<OrdenDeCompra> ordenDeCompraCollection;
    @ManyToMany(mappedBy = "proveedoresCollection", fetch = FetchType.LAZY)
    private Collection<Producto> productoCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "proveedores", fetch = FetchType.LAZY)
    private ProveedorTelefono proveedorTelefono;
    @JoinColumn(name = "Administrador_ID_Administrador", referencedColumnName = "ID_Administrador")
    @ManyToOne(fetch = FetchType.LAZY)
    private Administrador administradorIDAdministrador;

    public Proveedores() {
    }

    public Proveedores(Integer iDProveedor) {
        this.iDProveedor = iDProveedor;
    }

    public Proveedores(Integer iDProveedor, String nombre, String tipoDocumento, int numeroDocumento, String direccion) {
        this.iDProveedor = iDProveedor;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
    }

    public Integer getIDProveedor() {
        return iDProveedor;
    }

    public void setIDProveedor(Integer iDProveedor) {
        this.iDProveedor = iDProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public Collection<OrdenDeCompra> getOrdenDeCompraCollection() {
        return ordenDeCompraCollection;
    }

    public void setOrdenDeCompraCollection(Collection<OrdenDeCompra> ordenDeCompraCollection) {
        this.ordenDeCompraCollection = ordenDeCompraCollection;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    public ProveedorTelefono getProveedorTelefono() {
        return proveedorTelefono;
    }

    public void setProveedorTelefono(ProveedorTelefono proveedorTelefono) {
        this.proveedorTelefono = proveedorTelefono;
    }

    public Administrador getAdministradorIDAdministrador() {
        return administradorIDAdministrador;
    }

    public void setAdministradorIDAdministrador(Administrador administradorIDAdministrador) {
        this.administradorIDAdministrador = administradorIDAdministrador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDProveedor != null ? iDProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.iDProveedor == null && other.iDProveedor != null) || (this.iDProveedor != null && !this.iDProveedor.equals(other.iDProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.Proveedores[ iDProveedor=" + iDProveedor + " ]";
    }
    
}
