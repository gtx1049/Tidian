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
@Table(name = "art_comments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArtComments.findAll", query = "SELECT a FROM ArtComments a"),
    @NamedQuery(name = "ArtComments.findByComId", query = "SELECT a FROM ArtComments a WHERE a.comId = :comId")})
public class ArtComments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "com_id")
    private Integer comId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "content")
    private String content;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private Users usrId;
    @JoinColumn(name = "art_id", referencedColumnName = "art_id")
    @ManyToOne(optional = false)
    private Articles artId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comId")
    private Collection<ArtReply> artReplyCollection;

    public ArtComments() {
    }

    public ArtComments(Integer comId) {
        this.comId = comId;
    }

    public ArtComments(Integer comId, String content) {
        this.comId = comId;
        this.content = content;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Users getUsrId() {
        return usrId;
    }

    public void setUsrId(Users usrId) {
        this.usrId = usrId;
    }

    public Articles getArtId() {
        return artId;
    }

    public void setArtId(Articles artId) {
        this.artId = artId;
    }

    @XmlTransient
    public Collection<ArtReply> getArtReplyCollection() {
        return artReplyCollection;
    }

    public void setArtReplyCollection(Collection<ArtReply> artReplyCollection) {
        this.artReplyCollection = artReplyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comId != null ? comId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArtComments)) {
            return false;
        }
        ArtComments other = (ArtComments) object;
        if ((this.comId == null && other.comId != null) || (this.comId != null && !this.comId.equals(other.comId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.ArtComments[ comId=" + comId + " ]";
    }
    
}
