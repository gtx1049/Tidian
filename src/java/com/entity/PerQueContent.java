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
@Table(name = "per_que_content")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerQueContent.findAll", query = "SELECT p FROM PerQueContent p"),
    @NamedQuery(name = "PerQueContent.findByPqId", query = "SELECT p FROM PerQueContent p WHERE p.perQueContentPK.pqId = :pqId"),
    @NamedQuery(name = "PerQueContent.findByQueId", query = "SELECT p FROM PerQueContent p WHERE p.perQueContentPK.queId = :queId")})
public class PerQueContent implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerQueContentPK perQueContentPK;
    @JoinColumn(name = "pq_id", referencedColumnName = "pq_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PersonQuestions personQuestions;

    public PerQueContent() {
    }

    public PerQueContent(PerQueContentPK perQueContentPK) {
        this.perQueContentPK = perQueContentPK;
    }

    public PerQueContent(int pqId, int queId) {
        this.perQueContentPK = new PerQueContentPK(pqId, queId);
    }

    public PerQueContentPK getPerQueContentPK() {
        return perQueContentPK;
    }

    public void setPerQueContentPK(PerQueContentPK perQueContentPK) {
        this.perQueContentPK = perQueContentPK;
    }

    public PersonQuestions getPersonQuestions() {
        return personQuestions;
    }

    public void setPersonQuestions(PersonQuestions personQuestions) {
        this.personQuestions = personQuestions;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perQueContentPK != null ? perQueContentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerQueContent)) {
            return false;
        }
        PerQueContent other = (PerQueContent) object;
        if ((this.perQueContentPK == null && other.perQueContentPK != null) || (this.perQueContentPK != null && !this.perQueContentPK.equals(other.perQueContentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.PerQueContent[ perQueContentPK=" + perQueContentPK + " ]";
    }
    
}
