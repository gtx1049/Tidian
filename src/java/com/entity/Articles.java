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
@Table(name = "articles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articles.findAll", query = "SELECT a FROM Articles a"),
    @NamedQuery(name = "Articles.findByArtId", query = "SELECT a FROM Articles a WHERE a.artId = :artId"),
    @NamedQuery(name = "Articles.findByCategory", query = "SELECT a FROM Articles a WHERE a.category = :category"),
    @NamedQuery(name = "Articles.findByTopic", query = "SELECT a FROM Articles a WHERE a.topic = :topic"),
    @NamedQuery(name = "Articles.findByWriteTime", query = "SELECT a FROM Articles a WHERE a.writeTime = :writeTime"),
    @NamedQuery(name = "Articles.findByMonthlyScan", query = "SELECT a FROM Articles a WHERE a.monthlyScan = :monthlyScan"),
    @NamedQuery(name = "Articles.findByTotalScan", query = "SELECT a FROM Articles a WHERE a.totalScan = :totalScan"),
    @NamedQuery(name = "Articles.findByCollectNumber", query = "SELECT a FROM Articles a WHERE a.collectNumber = :collectNumber"),
    @NamedQuery(name = "Articles.findByStatus", query = "SELECT a FROM Articles a WHERE a.status = :status")})
public class Articles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "art_id")
    private Integer artId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "category")
    private String category;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "topic")
    private String topic;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "write_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date writeTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monthly_scan")
    private int monthlyScan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_scan")
    private int totalScan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "collect_number")
    private int collectNumber;
    @Size(max = 4)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private Users usrId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artId")
    private Collection<ArtComments> artCommentsCollection;

    public Articles() {
    }

    public Articles(Integer artId) {
        this.artId = artId;
    }

    public Articles(Integer artId, String category, String topic, String content, Date writeTime, int monthlyScan, int totalScan, int collectNumber) {
        this.artId = artId;
        this.category = category;
        this.topic = topic;
        this.content = content;
        this.writeTime = writeTime;
        this.monthlyScan = monthlyScan;
        this.totalScan = totalScan;
        this.collectNumber = collectNumber;
    }

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(Date writeTime) {
        this.writeTime = writeTime;
    }

    public int getMonthlyScan() {
        return monthlyScan;
    }

    public void setMonthlyScan(int monthlyScan) {
        this.monthlyScan = monthlyScan;
    }

    public int getTotalScan() {
        return totalScan;
    }

    public void setTotalScan(int totalScan) {
        this.totalScan = totalScan;
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

    public Users getUsrId() {
        return usrId;
    }

    public void setUsrId(Users usrId) {
        this.usrId = usrId;
    }

    @XmlTransient
    public Collection<ArtComments> getArtCommentsCollection() {
        return artCommentsCollection;
    }

    public void setArtCommentsCollection(Collection<ArtComments> artCommentsCollection) {
        this.artCommentsCollection = artCommentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artId != null ? artId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articles)) {
            return false;
        }
        Articles other = (Articles) object;
        if ((this.artId == null && other.artId != null) || (this.artId != null && !this.artId.equals(other.artId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Articles[ artId=" + artId + " ]";
    }
    
}
