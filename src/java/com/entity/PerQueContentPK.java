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
public class PerQueContentPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "pq_id")
    private int pqId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "que_id")
    private int queId;

    public PerQueContentPK() {
    }

    public PerQueContentPK(int pqId, int queId) {
        this.pqId = pqId;
        this.queId = queId;
    }

    public int getPqId() {
        return pqId;
    }

    public void setPqId(int pqId) {
        this.pqId = pqId;
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
        hash += (int) pqId;
        hash += (int) queId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerQueContentPK)) {
            return false;
        }
        PerQueContentPK other = (PerQueContentPK) object;
        if (this.pqId != other.pqId) {
            return false;
        }
        if (this.queId != other.queId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.PerQueContentPK[ pqId=" + pqId + ", queId=" + queId + " ]";
    }
    
}
