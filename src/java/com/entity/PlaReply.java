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
@Table(name = "pla_reply")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlaReply.findAll", query = "SELECT p FROM PlaReply p"),
    @NamedQuery(name = "PlaReply.findByPlaReplyId", query = "SELECT p FROM PlaReply p WHERE p.plaReplyId = :plaReplyId"),
    @NamedQuery(name = "PlaReply.findByDate", query = "SELECT p FROM PlaReply p WHERE p.date = :date")})
public class PlaReply implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "pla_reply_id")
    private Integer plaReplyId;
    @Lob
    @Size(max = 65535)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private Users usrId;
    @JoinColumn(name = "pla_id", referencedColumnName = "pla_id")
    @ManyToOne(optional = false)
    private Platforms plaId;

    public PlaReply() {
    }

    public PlaReply(Integer plaReplyId) {
        this.plaReplyId = plaReplyId;
    }

    public PlaReply(Integer plaReplyId, Date date) {
        this.plaReplyId = plaReplyId;
        this.date = date;
    }

    public Integer getPlaReplyId() {
        return plaReplyId;
    }

    public void setPlaReplyId(Integer plaReplyId) {
        this.plaReplyId = plaReplyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Users getUsrId() {
        return usrId;
    }

    public void setUsrId(Users usrId) {
        this.usrId = usrId;
    }

    public Platforms getPlaId() {
        return plaId;
    }

    public void setPlaId(Platforms plaId) {
        this.plaId = plaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plaReplyId != null ? plaReplyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaReply)) {
            return false;
        }
        PlaReply other = (PlaReply) object;
        if ((this.plaReplyId == null && other.plaReplyId != null) || (this.plaReplyId != null && !this.plaReplyId.equals(other.plaReplyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.PlaReply[ plaReplyId=" + plaReplyId + " ]";
    }
    
}
