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
public class PersonMaterialsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_id")
    private int usrId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mat_id")
    private int matId;

    public PersonMaterialsPK() {
    }

    public PersonMaterialsPK(int usrId, int matId) {
        this.usrId = usrId;
        this.matId = matId;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public int getMatId() {
        return matId;
    }

    public void setMatId(int matId) {
        this.matId = matId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usrId;
        hash += (int) matId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonMaterialsPK)) {
            return false;
        }
        PersonMaterialsPK other = (PersonMaterialsPK) object;
        if (this.usrId != other.usrId) {
            return false;
        }
        if (this.matId != other.matId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.PersonMaterialsPK[ usrId=" + usrId + ", matId=" + matId + " ]";
    }
    
}
