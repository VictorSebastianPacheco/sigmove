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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "registro_de_entrada_cantidad")
@NamedQueries({
    @NamedQuery(name = "RegistroDeEntradaCantidad.findAll", query = "SELECT r FROM RegistroDeEntradaCantidad r")
    , @NamedQuery(name = "RegistroDeEntradaCantidad.findByUnidaddemedida", query = "SELECT r FROM RegistroDeEntradaCantidad r WHERE r.unidaddemedida = :unidaddemedida")
    , @NamedQuery(name = "RegistroDeEntradaCantidad.findByCantidad", query = "SELECT r FROM RegistroDeEntradaCantidad r WHERE r.cantidad = :cantidad")
    , @NamedQuery(name = "RegistroDeEntradaCantidad.findByRegistrodeentradaIDRegistro", query = "SELECT r FROM RegistroDeEntradaCantidad r WHERE r.registrodeentradaIDRegistro = :registrodeentradaIDRegistro")})
public class RegistroDeEntradaCantidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Unidad_de_medida")
    private String unidaddemedida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cantidad")
    private int cantidad;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Registro_de_entrada_ID_Registro")
    private Integer registrodeentradaIDRegistro;
    @JoinColumn(name = "Registro_de_entrada_ID_Registro", referencedColumnName = "ID_Registro", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private RegistroDeEntrada registroDeEntrada;

    public RegistroDeEntradaCantidad() {
    }

    public RegistroDeEntradaCantidad(Integer registrodeentradaIDRegistro) {
        this.registrodeentradaIDRegistro = registrodeentradaIDRegistro;
    }

    public RegistroDeEntradaCantidad(Integer registrodeentradaIDRegistro, String unidaddemedida, int cantidad) {
        this.registrodeentradaIDRegistro = registrodeentradaIDRegistro;
        this.unidaddemedida = unidaddemedida;
        this.cantidad = cantidad;
    }

    public String getUnidaddemedida() {
        return unidaddemedida;
    }

    public void setUnidaddemedida(String unidaddemedida) {
        this.unidaddemedida = unidaddemedida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getRegistrodeentradaIDRegistro() {
        return registrodeentradaIDRegistro;
    }

    public void setRegistrodeentradaIDRegistro(Integer registrodeentradaIDRegistro) {
        this.registrodeentradaIDRegistro = registrodeentradaIDRegistro;
    }

    public RegistroDeEntrada getRegistroDeEntrada() {
        return registroDeEntrada;
    }

    public void setRegistroDeEntrada(RegistroDeEntrada registroDeEntrada) {
        this.registroDeEntrada = registroDeEntrada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registrodeentradaIDRegistro != null ? registrodeentradaIDRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroDeEntradaCantidad)) {
            return false;
        }
        RegistroDeEntradaCantidad other = (RegistroDeEntradaCantidad) object;
        if ((this.registrodeentradaIDRegistro == null && other.registrodeentradaIDRegistro != null) || (this.registrodeentradaIDRegistro != null && !this.registrodeentradaIDRegistro.equals(other.registrodeentradaIDRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.RegistroDeEntradaCantidad[ registrodeentradaIDRegistro=" + registrodeentradaIDRegistro + " ]";
    }
    
}
