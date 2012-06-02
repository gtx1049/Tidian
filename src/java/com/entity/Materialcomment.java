/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "materialcomment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materialcomment.findAll", query = "SELECT m FROM Materialcomment m"),
    @NamedQuery(name = "Materialcomment.findByMaterialcommentId", query = "SELECT m FROM Materialcomment m WHERE m.materialcommentId = :materialcommentId"),
    @NamedQuery(name = "Materialcomment.findByMaterialId", query = "SELECT m FROM Materialcomment m WHERE m.materialId = :materialId"),
    @NamedQuery(name = "Materialcomment.findByUsrId", query = "SELECT m FROM Materialcomment m WHERE m.usrId = :usrId"),
    @NamedQuery(name = "Materialcomment.findByCreatedate", query = "SELECT m FROM Materialcomment m WHERE m.createdate = :createdate")})
public class Materialcomment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "materialcomment_id")
    private Integer materialcommentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "material_id")
    private int materialId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_id")
    private int usrId;
    @Lob
    @Size(max = 65535)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    public Materialcomment() {
    }

    public Materialcomment(Integer materialcommentId) {
        this.materialcommentId = materialcommentId;
    }

    public Materialcomment(Integer materialcommentId, int materialId, int usrId, Date createdate) {
        this.materialcommentId = materialcommentId;
        this.materialId = materialId;
        this.usrId = usrId;
        this.createdate = createdate;
    }

    public Integer getMaterialcommentId() {
        return materialcommentId;
    }

    public void setMaterialcommentId(Integer materialcommentId) {
        this.materialcommentId = materialcommentId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materialcommentId != null ? materialcommentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materialcomment)) {
            return false;
        }
        Materialcomment other = (Materialcomment) object;
        if ((this.materialcommentId == null && other.materialcommentId != null) || (this.materialcommentId != null && !this.materialcommentId.equals(other.materialcommentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Materialcomment[ materialcommentId=" + materialcommentId + " ]";
    }
    
}
