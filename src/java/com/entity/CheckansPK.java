/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrator
 */
@Embeddable
public class CheckansPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_id")
    private int usrId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ans_id")
    private int ansId;

    public CheckansPK() {
    }

    public CheckansPK(int usrId, int ansId) {
        this.usrId = usrId;
        this.ansId = ansId;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public int getAnsId() {
        return ansId;
    }

    public void setAnsId(int ansId) {
        this.ansId = ansId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usrId;
        hash += (int) ansId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CheckansPK)) {
            return false;
        }
        CheckansPK other = (CheckansPK) object;
        if (this.usrId != other.usrId) {
            return false;
        }
        if (this.ansId != other.ansId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.CheckansPK[ usrId=" + usrId + ", ansId=" + ansId + " ]";
    }
    
}
