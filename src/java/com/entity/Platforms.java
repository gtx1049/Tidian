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
@Table(name = "platforms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Platforms.findAll", query = "SELECT p FROM Platforms p"),
    @NamedQuery(name = "Platforms.findByPlaId", query = "SELECT p FROM Platforms p WHERE p.plaId = :plaId"),
    @NamedQuery(name = "Platforms.findByTopic", query = "SELECT p FROM Platforms p WHERE p.topic = :topic"),
    @NamedQuery(name = "Platforms.findByDate", query = "SELECT p FROM Platforms p WHERE p.date = :date"),
    @NamedQuery(name = "Platforms.findByLastDate", query = "SELECT p FROM Platforms p WHERE p.lastDate = :lastDate"),
    @NamedQuery(name = "Platforms.findByFavNumber", query = "SELECT p FROM Platforms p WHERE p.favNumber = :favNumber"),
    @NamedQuery(name = "Platforms.findByClickNumber", query = "SELECT p FROM Platforms p WHERE p.clickNumber = :clickNumber"),
    @NamedQuery(name = "Platforms.findByCommentNumber", query = "SELECT p FROM Platforms p WHERE p.commentNumber = :commentNumber"),
    @NamedQuery(name = "Platforms.findByStatus", query = "SELECT p FROM Platforms p WHERE p.status = :status")})
public class Platforms implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "pla_id")
    private Integer plaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "topic")
    private String topic;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "content")
    private byte[] content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fav_number")
    private int favNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "click_number")
    private int clickNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comment_number")
    private int commentNumber;
    @Size(max = 4)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private Users usrId;

    public Platforms() {
    }

    public Platforms(Integer plaId) {
        this.plaId = plaId;
    }

    public Platforms(Integer plaId, String topic, byte[] content, Date date, Date lastDate, int favNumber, int clickNumber, int commentNumber) {
        this.plaId = plaId;
        this.topic = topic;
        this.content = content;
        this.date = date;
        this.lastDate = lastDate;
        this.favNumber = favNumber;
        this.clickNumber = clickNumber;
        this.commentNumber = commentNumber;
    }

    public Integer getPlaId() {
        return plaId;
    }

    public void setPlaId(Integer plaId) {
        this.plaId = plaId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public int getFavNumber() {
        return favNumber;
    }

    public void setFavNumber(int favNumber) {
        this.favNumber = favNumber;
    }

    public int getClickNumber() {
        return clickNumber;
    }

    public void setClickNumber(int clickNumber) {
        this.clickNumber = clickNumber;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        hash += (plaId != null ? plaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Platforms)) {
            return false;
        }
        Platforms other = (Platforms) object;
        if ((this.plaId == null && other.plaId != null) || (this.plaId != null && !this.plaId.equals(other.plaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Platforms[ plaId=" + plaId + " ]";
    }
    
}
