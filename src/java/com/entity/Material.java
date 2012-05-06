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
@Table(name = "materials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m"),
    @NamedQuery(name = "Material.findByMatId", query = "SELECT m FROM Material m WHERE m.matId = :matId"),
    @NamedQuery(name = "Material.findByUsrId", query = "SELECT m FROM Material m WHERE m.usrId = :usrId"),
    @NamedQuery(name = "Material.findByMatName", query = "SELECT m FROM Material m WHERE m.matName = :matName"),
    @NamedQuery(name = "Material.findByIntroduction", query = "SELECT m FROM Material m WHERE m.introduction = :introduction"),
    @NamedQuery(name = "Material.findByType", query = "SELECT m FROM Material m WHERE m.type = :type"),
    @NamedQuery(name = "Material.findBySubject", query = "SELECT m FROM Material m WHERE m.subject = :subject"),
    @NamedQuery(name = "Material.findByGrade", query = "SELECT m FROM Material m WHERE m.grade = :grade"),
    @NamedQuery(name = "Material.findByRegion", query = "SELECT m FROM Material m WHERE m.region = :region"),
    @NamedQuery(name = "Material.findByPath", query = "SELECT m FROM Material m WHERE m.path = :path"),
    @NamedQuery(name = "Material.findByScanNumber", query = "SELECT m FROM Material m WHERE m.scanNumber = :scanNumber"),
    @NamedQuery(name = "Material.findByWeekDownload", query = "SELECT m FROM Material m WHERE m.weekDownload = :weekDownload"),
    @NamedQuery(name = "Material.findByTotalDownload", query = "SELECT m FROM Material m WHERE m.totalDownload = :totalDownload"),
    @NamedQuery(name = "Material.findByCollectNumber", query = "SELECT m FROM Material m WHERE m.collectNumber = :collectNumber"),
    @NamedQuery(name = "Material.findBySize", query = "SELECT m FROM Material m WHERE m.size = :size"),
    @NamedQuery(name = "Material.findByPoint", query = "SELECT m FROM Material m WHERE m.point = :point"),
    @NamedQuery(name = "Material.findByCommentNumber", query = "SELECT m FROM Material m WHERE m.commentNumber = :commentNumber"),
    @NamedQuery(name = "Material.findByDate", query = "SELECT m FROM Material m WHERE m.date = :date"),
    @NamedQuery(name = "Material.findByStatus", query = "SELECT m FROM Material m WHERE m.status = :status")})
public class Material implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "mat_id")
    private Integer matId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_id")
    private int usrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "mat_name")
    private String matName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "introduction")
    private String introduction;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "grade")
    private String grade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "region")
    private String region;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "path")
    private String path;
    @Basic(optional = false)
    @NotNull
    @Column(name = "scan_number")
    private int scanNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "week_download")
    private int weekDownload;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_download")
    private int totalDownload;
    @Basic(optional = false)
    @NotNull
    @Column(name = "collect_number")
    private int collectNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "size")
    private String size;
    @Basic(optional = false)
    @NotNull
    @Column(name = "point")
    private int point;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comment_number")
    private int commentNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "status")
    private String status;

    public Material() {
    }

    public Material(Integer matId) {
        this.matId = matId;
    }

    public Material(Integer matId, int usrId, String matName, String introduction, String type, String subject, String grade, String region, String path, int scanNumber, int weekDownload, int totalDownload, int collectNumber, String size, int point, int commentNumber, Date date, String status) {
        this.matId = matId;
        this.usrId = usrId;
        this.matName = matName;
        this.introduction = introduction;
        this.type = type;
        this.subject = subject;
        this.grade = grade;
        this.region = region;
        this.path = path;
        this.scanNumber = scanNumber;
        this.weekDownload = weekDownload;
        this.totalDownload = totalDownload;
        this.collectNumber = collectNumber;
        this.size = size;
        this.point = point;
        this.commentNumber = commentNumber;
        this.date = date;
        this.status = status;
    }

    public Integer getMatId() {
        return matId;
    }

    public void setMatId(Integer matId) {
        this.matId = matId;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public String getMatName() {
        return matName;
    }

    public void setMatName(String matName) {
        this.matName = matName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getScanNumber() {
        return scanNumber;
    }

    public void setScanNumber(int scanNumber) {
        this.scanNumber = scanNumber;
    }

    public int getWeekDownload() {
        return weekDownload;
    }

    public void setWeekDownload(int weekDownload) {
        this.weekDownload = weekDownload;
    }

    public int getTotalDownload() {
        return totalDownload;
    }

    public void setTotalDownload(int totalDownload) {
        this.totalDownload = totalDownload;
    }

    public int getCollectNumber() {
        return collectNumber;
    }

    public void setCollectNumber(int collectNumber) {
        this.collectNumber = collectNumber;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        hash += (matId != null ? matId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.matId == null && other.matId != null) || (this.matId != null && !this.matId.equals(other.matId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javabean.Material[ matId=" + matId + " ]";
    }
    
}
