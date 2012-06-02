/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "mark")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mark.findAll", query = "SELECT m FROM Mark m"),
    @NamedQuery(name = "Mark.findByMarkId", query = "SELECT m FROM Mark m WHERE m.markId = :markId"),
    @NamedQuery(name = "Mark.findByUsrId", query = "SELECT m FROM Mark m WHERE m.usrId = :usrId"),
    @NamedQuery(name = "Mark.findByMaterialId", query = "SELECT m FROM Mark m WHERE m.materialId = :materialId")})
public class Mark implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "mark_id")
    private Integer markId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_id")
    private int usrId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "material_id")
    private int materialId;

    public Mark() {
    }

    public Mark(Integer markId) {
        this.markId = markId;
    }

    public Mark(Integer markId, int usrId, int materialId) {
        this.markId = markId;
        this.usrId = usrId;
        this.materialId = materialId;
    }

    public Integer getMarkId() {
        return markId;
    }

    public void setMarkId(Integer markId) {
        this.markId = markId;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (markId != null ? markId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mark)) {
            return false;
        }
        Mark other = (Mark) object;
        if ((this.markId == null && other.markId != null) || (this.markId != null && !this.markId.equals(other.markId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Mark[ markId=" + markId + " ]";
    }
    
}
