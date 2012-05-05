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
@Table(name = "checkque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checkque.findAll", query = "SELECT c FROM Checkque c"),
    @NamedQuery(name = "Checkque.findByUsrId", query = "SELECT c FROM Checkque c WHERE c.checkquePK.usrId = :usrId"),
    @NamedQuery(name = "Checkque.findByQueId", query = "SELECT c FROM Checkque c WHERE c.checkquePK.queId = :queId")})
public class Checkque implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CheckquePK checkquePK;

    public Checkque() {
    }

    public Checkque(CheckquePK checkquePK) {
        this.checkquePK = checkquePK;
    }

    public Checkque(int usrId, int queId) {
        this.checkquePK = new CheckquePK(usrId, queId);
    }

    public CheckquePK getCheckquePK() {
        return checkquePK;
    }

    public void setCheckquePK(CheckquePK checkquePK) {
        this.checkquePK = checkquePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checkquePK != null ? checkquePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Checkque)) {
            return false;
        }
        Checkque other = (Checkque) object;
        if ((this.checkquePK == null && other.checkquePK != null) || (this.checkquePK != null && !this.checkquePK.equals(other.checkquePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gtx.Checkque[ checkquePK=" + checkquePK + " ]";
    }
    
}
