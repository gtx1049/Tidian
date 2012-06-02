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
@Table(name = "art_reply")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArtReply.findAll", query = "SELECT a FROM ArtReply a"),
    @NamedQuery(name = "ArtReply.findByReplyId", query = "SELECT a FROM ArtReply a WHERE a.replyId = :replyId"),
    @NamedQuery(name = "ArtReply.findByReplyTime", query = "SELECT a FROM ArtReply a WHERE a.replyTime = :replyTime")})
public class ArtReply implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "reply_id")
    private Integer replyId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reply_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date replyTime;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private Users usrId;
    @JoinColumn(name = "com_id", referencedColumnName = "com_id")
    @ManyToOne(optional = false)
    private ArtComments comId;

    public ArtReply() {
    }

    public ArtReply(Integer replyId) {
        this.replyId = replyId;
    }

    public ArtReply(Integer replyId, String content, Date replyTime) {
        this.replyId = replyId;
        this.content = content;
        this.replyTime = replyTime;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Users getUsrId() {
        return usrId;
    }

    public void setUsrId(Users usrId) {
        this.usrId = usrId;
    }

    public ArtComments getComId() {
        return comId;
    }

    public void setComId(ArtComments comId) {
        this.comId = comId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (replyId != null ? replyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArtReply)) {
            return false;
        }
        ArtReply other = (ArtReply) object;
        if ((this.replyId == null && other.replyId != null) || (this.replyId != null && !this.replyId.equals(other.replyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.ArtReply[ replyId=" + replyId + " ]";
    }
    
}
