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
public class CheckquePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_id")
    private int usrId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "que_id")
    private int queId;

    public CheckquePK() {
    }

    public CheckquePK(int usrId, int queId) {
        this.usrId = usrId;
        this.queId = queId;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public int getQueId() {
        return queId;
    }

    public void setQueId(int queId) {
        this.queId = queId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usrId;
        hash += (int) queId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CheckquePK)) {
            return false;
        }
        CheckquePK other = (CheckquePK) object;
        if (this.usrId != other.usrId) {
            return false;
        }
        if (this.queId != other.queId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.CheckquePK[ usrId=" + usrId + ", queId=" + queId + " ]";
    }
    
}
