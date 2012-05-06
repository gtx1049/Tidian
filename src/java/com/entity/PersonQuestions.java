/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "person_questions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonQuestions.findAll", query = "SELECT p FROM PersonQuestions p"),
    @NamedQuery(name = "PersonQuestions.findByPqId", query = "SELECT p FROM PersonQuestions p WHERE p.pqId = :pqId"),
    @NamedQuery(name = "PersonQuestions.findByPqName", query = "SELECT p FROM PersonQuestions p WHERE p.pqName = :pqName"),
    @NamedQuery(name = "PersonQuestions.findBySetTime", query = "SELECT p FROM PersonQuestions p WHERE p.setTime = :setTime"),
    @NamedQuery(name = "PersonQuestions.findByRank", query = "SELECT p FROM PersonQuestions p WHERE p.rank = :rank")})
public class PersonQuestions implements Serializable {
    @Basic(optional =     false)
    @NotNull
    @Column(name = "set_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date setTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personQuestions")
    private Collection<PerQueContent> perQueContentCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "pq_id")
    private Integer pqId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "pq_name")
    private String pqName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rank")
    private int rank;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private Users usrId;

    public PersonQuestions() {
    }

    public PersonQuestions(Integer pqId) {
        this.pqId = pqId;
    }

    public PersonQuestions(Integer pqId, String pqName, Date setTime, int rank) {
        this.pqId = pqId;
        this.pqName = pqName;
        this.setTime = setTime;
        this.rank = rank;
    }

    public Integer getPqId() {
        return pqId;
    }

    public void setPqId(Integer pqId) {
        this.pqId = pqId;
    }

    public String getPqName() {
        return pqName;
    }

    public void setPqName(String pqName) {
        this.pqName = pqName;
    }

    public Date getSetTime() {
        return setTime;
    }

    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Users getUsrId() {
        return usrId;
    }

    public void setUsrId(Users usrId) {
        this.usrId = usrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pqId != null ? pqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonQuestions)) {
            return false;
        }
        PersonQuestions other = (PersonQuestions) object;
        if ((this.pqId == null && other.pqId != null) || (this.pqId != null && !this.pqId.equals(other.pqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.PersonQuestions[ pqId=" + pqId + " ]";
    }

    @XmlTransient
    public Collection<PerQueContent> getPerQueContentCollection() {
        return perQueContentCollection;
    }

    public void setPerQueContentCollection(Collection<PerQueContent> perQueContentCollection) {
        this.perQueContentCollection = perQueContentCollection;
    }
    
}
