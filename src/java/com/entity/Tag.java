/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "tag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tag.findAll", query = "SELECT t FROM Tag t"),
    @NamedQuery(name = "Tag.findByTagid", query = "SELECT t FROM Tag t WHERE t.tagid = :tagid"),
    @NamedQuery(name = "Tag.findByTag", query = "SELECT t FROM Tag t WHERE t.tag = :tag")})
public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "tagid")
    private Integer tagid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "tag")
    private String tag;
//    @JoinTable(name = "que_tag", joinColumns = {
//        @JoinColumn(name = "tagid", referencedColumnName = "tagid")}, inverseJoinColumns = {
//        @JoinColumn(name = "que_id", referencedColumnName = "que_id")})
//    @ManyToMany
//    private Collection<Questions> questionsCollection;

    public Tag() {
    }

    public Tag(Integer tagid) {
        this.tagid = tagid;
    }

    public Tag(Integer tagid, String tag) {
        this.tagid = tagid;
        this.tag = tag;
    }

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

//    @XmlTransient
//    public Collection<Questions> getQuestionsCollection() {
//        return questionsCollection;
//    }
//
//    public void setQuestionsCollection(Collection<Questions> questionsCollection) {
//        this.questionsCollection = questionsCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tagid != null ? tagid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tag)) {
            return false;
        }
        Tag other = (Tag) object;
        if ((this.tagid == null && other.tagid != null) || (this.tagid != null && !this.tagid.equals(other.tagid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Tag[ tagid=" + tagid + " ]";
    }
    
}
