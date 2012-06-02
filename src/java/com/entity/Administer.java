/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "administer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administer.findAll", query = "SELECT a FROM Administer a"),
    @NamedQuery(name = "Administer.findByAdmId", query = "SELECT a FROM Administer a WHERE a.admId = :admId"),
    @NamedQuery(name = "Administer.findByPassword", query = "SELECT a FROM Administer a WHERE a.password = :password")})
public class Administer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "adm_id")
    private String admId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "password")
    private String password;

    public Administer() {
    }

    public Administer(String admId) {
        this.admId = admId;
    }

    public Administer(String admId, String password) {
        this.admId = admId;
        this.password = password;
    }

    public String getAdmId() {
        return admId;
    }

    public void setAdmId(String admId) {
        this.admId = admId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (admId != null ? admId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administer)) {
            return false;
        }
        Administer other = (Administer) object;
        if ((this.admId == null && other.admId != null) || (this.admId != null && !this.admId.equals(other.admId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Administer[ admId=" + admId + " ]";
    }
    
}
