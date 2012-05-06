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
public class PersonArticlesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_id")
    private int usrId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "art_id")
    private int artId;

    public PersonArticlesPK() {
    }

    public PersonArticlesPK(int usrId, int artId) {
        this.usrId = usrId;
        this.artId = artId;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public int getArtId() {
        return artId;
    }

    public void setArtId(int artId) {
        this.artId = artId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usrId;
        hash += (int) artId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonArticlesPK)) {
            return false;
        }
        PersonArticlesPK other = (PersonArticlesPK) object;
        if (this.usrId != other.usrId) {
            return false;
        }
        if (this.artId != other.artId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.PersonArticlesPK[ usrId=" + usrId + ", artId=" + artId + " ]";
    }
    
}
