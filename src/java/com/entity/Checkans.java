/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "checkans")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checkans.findAll", query = "SELECT c FROM Checkans c"),
    @NamedQuery(name = "Checkans.findByUsrId", query = "SELECT c FROM Checkans c WHERE c.checkansPK.usrId = :usrId"),
    @NamedQuery(name = "Checkans.findByAnsId", query = "SELECT c FROM Checkans c WHERE c.checkansPK.ansId = :ansId")})
public class Checkans implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CheckansPK checkansPK;

    public Checkans() {
    }

    public Checkans(CheckansPK checkansPK) {
        this.checkansPK = checkansPK;
    }

    public Checkans(int usrId, int ansId) {
        this.checkansPK = new CheckansPK(usrId, ansId);
    }

    public CheckansPK getCheckansPK() {
        return checkansPK;
    }

    public void setCheckansPK(CheckansPK checkansPK) {
        this.checkansPK = checkansPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checkansPK != null ? checkansPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Checkans)) {
            return false;
        }
        Checkans other = (Checkans) object;
        if ((this.checkansPK == null && other.checkansPK != null) || (this.checkansPK != null && !this.checkansPK.equals(other.checkansPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Checkans[ checkansPK=" + checkansPK + " ]";
    }
    
}
