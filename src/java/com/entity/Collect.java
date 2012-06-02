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
@Table(name = "collect")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collect.findAll", query = "SELECT c FROM Collect c"),
    @NamedQuery(name = "Collect.findByCollectId", query = "SELECT c FROM Collect c WHERE c.collectId = :collectId"),
    @NamedQuery(name = "Collect.findByUsrId", query = "SELECT c FROM Collect c WHERE c.usrId = :usrId"),
    @NamedQuery(name = "Collect.findByMaterialId", query = "SELECT c FROM Collect c WHERE c.materialId = :materialId")})
public class Collect implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "collect_id")
    private Integer collectId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_id")
    private int usrId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "material_id")
    private int materialId;

    public Collect() {
    }

    public Collect(Integer collectId) {
        this.collectId = collectId;
    }

    public Collect(Integer collectId, int usrId, int materialId) {
        this.collectId = collectId;
        this.usrId = usrId;
        this.materialId = materialId;
    }

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
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
        hash += (collectId != null ? collectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collect)) {
            return false;
        }
        Collect other = (Collect) object;
        if ((this.collectId == null && other.collectId != null) || (this.collectId != null && !this.collectId.equals(other.collectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Collect[ collectId=" + collectId + " ]";
    }
    
}
