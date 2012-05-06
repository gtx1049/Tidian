/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "answers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Answers.findAll", query = "SELECT a FROM Answers a"),
    @NamedQuery(name = "Answers.findByAnwId", query = "SELECT a FROM Answers a WHERE a.anwId = :anwId"),
    @NamedQuery(name = "Answers.findByQueId", query = "SELECT a FROM Answers a WHERE a.question = :question"),
    @NamedQuery(name = "Answers.findByUsrId", query = "SELECT a FROM Answers a WHERE a.usrId = :usrId"),
    @NamedQuery(name = "Answers.findByPoint", query = "SELECT a FROM Answers a WHERE a.point = :point"),
    @NamedQuery(name = "Answers.findByDate", query = "SELECT a FROM Answers a WHERE a.date = :date")})
public class Answers implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "content")
    private byte[] content;
    @Basic(optional =     false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "anw_id")
    private Integer anwId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_id")
    private int usrId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "point")
    private int point;
    @ManyToOne(optional = false)
    @JoinColumn(name = "que_id", referencedColumnName = "que_id")
    private Questions question;
    
    public Answers() {
    }

    public Answers(Integer anwId) {
        this.anwId = anwId;
    }

    public Answers(Integer anwId, int queId, int usrId, byte[] content, int point, Date date) {
        this.anwId = anwId;
        this.usrId = usrId;
        this.content = content;
        this.point = point;
        this.date = date;
    }

    public Integer getAnwId() {
        return anwId;
    }

    public void setAnwId(Integer anwId) {
        this.anwId = anwId;
    }
    
    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anwId != null ? anwId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answers)) {
            return false;
        }
        Answers other = (Answers) object;
        if ((this.anwId == null && other.anwId != null) || (this.anwId != null && !this.anwId.equals(other.anwId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gtx.Answers[ anwId=" + anwId + " ]";
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
    
}
