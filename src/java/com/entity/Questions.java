/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import com.entity.Answers;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "questions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questions.findAll", query = "SELECT q FROM Questions q"),
    @NamedQuery(name = "Questions.findByQueId", query = "SELECT q FROM Questions q WHERE q.queId = :queId"),
    @NamedQuery(name = "Questions.findByUsrId", query = "SELECT q FROM Questions q WHERE q.usrId = :usrId"),
    @NamedQuery(name = "Questions.findByCategory", query = "SELECT q FROM Questions q WHERE q.category = :category"),
    @NamedQuery(name = "Questions.findBySubject", query = "SELECT q FROM Questions q WHERE q.subject = :subject"),
    @NamedQuery(name = "Questions.findByPoint", query = "SELECT q FROM Questions q WHERE q.point = :point"),
    @NamedQuery(name = "Questions.findByCollectNumber", query = "SELECT q FROM Questions q WHERE q.collectNumber = :collectNumber"),
    @NamedQuery(name = "Questions.findByDate", query = "SELECT q FROM Questions q WHERE q.date = :date"),
    @NamedQuery(name = "Questions.findByStatus", query = "SELECT q FROM Questions q WHERE q.status = :status")})
public class Questions implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "que_id")
    private Integer queId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_id")
    private int usrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "category")
    private String category;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @NotNull
    @Column(name = "point")
    private int point;
    @Basic(optional = false)
    @NotNull
    @Column(name = "collect_number")
    private int collectNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "question")
    private Set<Answers> answer;
    @ManyToMany
    @JoinTable(name = "que_tag", joinColumns = @JoinColumn(name = "que_id",
            referencedColumnName = "que_id"), inverseJoinColumns = @JoinColumn(name = "tagid",
            referencedColumnName = "tagid"))
    private Collection<Tag> tags;
    
    public Questions() {
    }

    public Questions(Integer queId) {
        this.queId = queId;
    }

    public Questions(Integer queId, int usrId, String category, String subject, String content, int point, int collectNumber, Date date, String status) {
        this.queId = queId;
        this.usrId = usrId;
        this.category = category;
        this.subject = subject;
        this.content = content;
        this.point = point;
        this.collectNumber = collectNumber;
        this.date = date;
        this.status = status;
    }

    public Integer getQueId() {
        return queId;
    }

    public void setQueId(Integer queId) {
        this.queId = queId;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getCollectNumber() {
        return collectNumber;
    }

    public void setCollectNumber(int collectNumber) {
        this.collectNumber = collectNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (queId != null ? queId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questions)) {
            return false;
        }
        Questions other = (Questions) object;
        if ((this.queId == null && other.queId != null) || (this.queId != null && !this.queId.equals(other.queId))) {
            return false;
        }
        return true;
    }
    
    public Set<Answers> getAnswers()
    {
        return answer;
    }
    public void setAnswers(Set<Answers> answers)
    {
        this.answer = answers;
    }

    public Collection<Tag> getTags() {
        return tags;
    }

    public void setTags(Collection<Tag> tags) {
        this.tags = tags;
    }
    
    @Override
    public String toString() {
        return "com.gtx.Questions[ queId=" + queId + " ]";
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
    
}
