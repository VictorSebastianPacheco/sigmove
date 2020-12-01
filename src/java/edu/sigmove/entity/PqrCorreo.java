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
@Table(name = "pqr_correo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PqrCorreo.findAll", query = "SELECT p FROM PqrCorreo p")})
public class PqrCorreo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Correo2")
    private String correo2;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PQR_ID_PQR")
    private Integer pqrIdPqr;
    @JoinColumn(name = "PQR_ID_PQR", referencedColumnName = "ID_PQR", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pqr pqr;

    public PqrCorreo() {
    }

    public PqrCorreo(Integer pqrIdPqr) {
        this.pqrIdPqr = pqrIdPqr;
    }

    public PqrCorreo(Integer pqrIdPqr, String correo, String correo2) {
        this.pqrIdPqr = pqrIdPqr;
        this.correo = correo;
        this.correo2 = correo2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo2() {
        return correo2;
    }

    public void setCorreo2(String correo2) {
        this.correo2 = correo2;
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
        if (!(object instanceof PqrCorreo)) {
            return false;
        }
        PqrCorreo other = (PqrCorreo) object;
        if ((this.pqrIdPqr == null && other.pqrIdPqr != null) || (this.pqrIdPqr != null && !this.pqrIdPqr.equals(other.pqrIdPqr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sigmove.entity.PqrCorreo[ pqrIdPqr=" + pqrIdPqr + " ]";
    }
    
}
