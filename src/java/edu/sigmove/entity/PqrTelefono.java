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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "pqr_telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PqrTelefono.findAll", query = "SELECT p FROM PqrTelefono p")})
public class PqrTelefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "Telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "Telefono2")
    private String telefono2;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PQR_ID_PQR")
    private Integer pqrIdPqr;
    @JoinColumn(name = "PQR_ID_PQR", referencedColumnName = "ID_PQR", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pqr pqr;

    public PqrTelefono() {
    }

    public PqrTelefono(Integer pqrIdPqr) {
        this.pqrIdPqr = pqrIdPqr;
    }

    public PqrTelefono(Integer pqrIdPqr, String telefono, String telefono2) {
        this.pqrIdPqr = pqrIdPqr;
        this.telefono = telefono;
        this.telefono2 = telefono2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public Integer getPqrIdPqr() {
        return pqrIdPqr;
    }

    public void setPqrIdPqr(Integer pqrIdPqr) {
        this.pqrIdPqr = pqrIdPqr;
    }

    public Pqr getPqr() {
        return pqr;
    }

    public void setPqr(Pqr pqr) {
        this.pqr = pqr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pqrIdPqr != null ? pqrIdPqr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PqrTelefono)) {
            return false;
        }
        PqrTelefono other = (PqrTelefono) object;
        if ((this.pqrIdPqr == null && other.pqrIdPqr != null) || (this.pqrIdPqr != null && !this.pqrIdPqr.equals(other.pqrIdPqr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.PqrTelefono[ pqrIdPqr=" + pqrIdPqr + " ]";
    }
    
}
