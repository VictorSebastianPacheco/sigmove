/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.entity;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "ventas_has_cliente")
@NamedQueries({
    @NamedQuery(name = "VentasHasCliente.findAll", query = "SELECT v FROM VentasHasCliente v")
    , @NamedQuery(name = "VentasHasCliente.findByVentasIDVenta", query = "SELECT v FROM VentasHasCliente v WHERE v.ventasIDVenta = :ventasIDVenta")})
public class VentasHasCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ventas_ID_Venta")
    private Integer ventasIDVenta;
    @JoinColumn(name = "Cliente_ID_Cliente", referencedColumnName = "ID_Cliente")
    @ManyToOne(fetch = FetchType.LAZY)
    private ClienteFidelizado clienteIDCliente;
    @JoinColumn(name = "Ventas_ID_Venta", referencedColumnName = "ID_Venta", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Ventas ventas;

    public VentasHasCliente() {
    }

    public VentasHasCliente(Integer ventasIDVenta) {
        this.ventasIDVenta = ventasIDVenta;
    }

    public Integer getVentasIDVenta() {
        return ventasIDVenta;
    }

    public void setVentasIDVenta(Integer ventasIDVenta) {
        this.ventasIDVenta = ventasIDVenta;
    }

    public ClienteFidelizado getClienteIDCliente() {
        return clienteIDCliente;
    }

    public void setClienteIDCliente(ClienteFidelizado clienteIDCliente) {
        this.clienteIDCliente = clienteIDCliente;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventasIDVenta != null ? ventasIDVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasHasCliente)) {
            return false;
        }
        VentasHasCliente other = (VentasHasCliente) object;
        if ((this.ventasIDVenta == null && other.ventasIDVenta != null) || (this.ventasIDVenta != null && !this.ventasIDVenta.equals(other.ventasIDVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.VentasHasCliente[ ventasIDVenta=" + ventasIDVenta + " ]";
    }
    
}
