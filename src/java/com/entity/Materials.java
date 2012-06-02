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
    @NamedQuery(name = "Materials.findAll", query = "SELECT m FROM Materials m"),
    @NamedQuery(name = "Materials.findByMaterialId", query = "SELECT m FROM Materials m WHERE m.materialId = :materialId"),
    @NamedQuery(name = "Materials.findByUsrId", query = "SELECT m FROM Materials m WHERE m.usrId = :usrId"),
    @NamedQuery(name = "Materials.findByMname", query = "SELECT m FROM Materials m WHERE m.mname = :mname"),
    @NamedQuery(name = "Materials.findByMpath", query = "SELECT m FROM Materials m WHERE m.mpath = :mpath"),
    @NamedQuery(name = "Materials.findByMsize", query = "SELECT m FROM Materials m WHERE m.msize = :msize"),
    @NamedQuery(name = "Materials.findByMintroduction", query = "SELECT m FROM Materials m WHERE m.mintroduction = :mintroduction"),
    @NamedQuery(name = "Materials.findByMtype", query = "SELECT m FROM Materials m WHERE m.mtype = :mtype"),
    @NamedQuery(name = "Materials.findByMsubject", query = "SELECT m FROM Materials m WHERE m.msubject = :msubject"),
    @NamedQuery(name = "Materials.findByMgrade", query = "SELECT m FROM Materials m WHERE m.mgrade = :mgrade"),
    @NamedQuery(name = "Materials.findByMregion", query = "SELECT m FROM Materials m WHERE m.mregion = :mregion"),
    @NamedQuery(name = "Materials.findByMtolvisit", query = "SELECT m FROM Materials m WHERE m.mtolvisit = :mtolvisit"),
    @NamedQuery(name = "Materials.findByMtoldownload", query = "SELECT m FROM Materials m WHERE m.mtoldownload = :mtoldownload"),
    @NamedQuery(name = "Materials.findByMweekdownload", query = "SELECT m FROM Materials m WHERE m.mweekdownload = :mweekdownload"),
    @NamedQuery(name = "Materials.findByMtolcollect", query = "SELECT m FROM Materials m WHERE m.mtolcollect = :mtolcollect"),
    @NamedQuery(name = "Materials.findByMlevelamount", query = "SELECT m FROM Materials m WHERE m.mlevelamount = :mlevelamount"),
    @NamedQuery(name = "Materials.findByMmarknumber", query = "SELECT m FROM Materials m WHERE m.mmarknumber = :mmarknumber"),
    @NamedQuery(name = "Materials.findByMtolcomment", query = "SELECT m FROM Materials m WHERE m.mtolcomment = :mtolcomment"),
    @NamedQuery(name = "Materials.findByMcreatedate", query = "SELECT m FROM Materials m WHERE m.mcreatedate = :mcreatedate"),
    @NamedQuery(name = "Materials.findByMstatus", query = "SELECT m FROM Materials m WHERE m.mstatus = :mstatus")})
public class Materials implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "material_id")
    private Integer materialId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_id")
    private int usrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "mname")
    private String mname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "mpath")
    private String mpath;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "msize")
    private String msize;
    @Size(max = 128)
    @Column(name = "mintroduction")
    private String mintroduction;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "mtype")
    private String mtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "msubject")
    private String msubject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "mgrade")
    private String mgrade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "mregion")
    private String mregion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mtolvisit")
    private int mtolvisit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mtoldownload")
    private int mtoldownload;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mweekdownload")
    private int mweekdownload;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mtolcollect")
    private int mtolcollect;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mlevelamount")
    private int mlevelamount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mmarknumber")
    private int mmarknumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mtolcomment")
    private int mtolcomment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mcreatedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mcreatedate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "mstatus")
    private String mstatus;

    public Materials() {
    }

    public Materials(Integer materialId) {
        this.materialId = materialId;
    }

    public Materials(Integer materialId, int usrId, String mname, String mpath, String msize, String mtype, String msubject, String mgrade, String mregion, int mtolvisit, int mtoldownload, int mweekdownload, int mtolcollect, int mlevelamount, int mmarknumber, int mtolcomment, Date mcreatedate, String mstatus) {
        this.materialId = materialId;
        this.usrId = usrId;
        this.mname = mname;
        this.mpath = mpath;
        this.msize = msize;
        this.mtype = mtype;
        this.msubject = msubject;
        this.mgrade = mgrade;
        this.mregion = mregion;
        this.mtolvisit = mtolvisit;
        this.mtoldownload = mtoldownload;
        this.mweekdownload = mweekdownload;
        this.mtolcollect = mtolcollect;
        this.mlevelamount = mlevelamount;
        this.mmarknumber = mmarknumber;
        this.mtolcomment = mtolcomment;
        this.mcreatedate = mcreatedate;
        this.mstatus = mstatus;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMpath() {
        return mpath;
    }

    public void setMpath(String mpath) {
        this.mpath = mpath;
    }

    public String getMsize() {
        return msize;
    }

    public void setMsize(String msize) {
        this.msize = msize;
    }

    public String getMintroduction() {
        return mintroduction;
    }

    public void setMintroduction(String mintroduction) {
        this.mintroduction = mintroduction;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public String getMsubject() {
        return msubject;
    }

    public void setMsubject(String msubject) {
        this.msubject = msubject;
    }

    public String getMgrade() {
        return mgrade;
    }

    public void setMgrade(String mgrade) {
        this.mgrade = mgrade;
    }

    public String getMregion() {
        return mregion;
    }

    public void setMregion(String mregion) {
        this.mregion = mregion;
    }

    public int getMtolvisit() {
        return mtolvisit;
    }

    public void setMtolvisit(int mtolvisit) {
        this.mtolvisit = mtolvisit;
    }

    public int getMtoldownload() {
        return mtoldownload;
    }

    public void setMtoldownload(int mtoldownload) {
        this.mtoldownload = mtoldownload;
    }

    public int getMweekdownload() {
        return mweekdownload;
    }

    public void setMweekdownload(int mweekdownload) {
        this.mweekdownload = mweekdownload;
    }

    public int getMtolcollect() {
        return mtolcollect;
    }

    public void setMtolcollect(int mtolcollect) {
        this.mtolcollect = mtolcollect;
    }

    public int getMlevelamount() {
        return mlevelamount;
    }

    public void setMlevelamount(int mlevelamount) {
        this.mlevelamount = mlevelamount;
    }

    public int getMmarknumber() {
        return mmarknumber;
    }

    public void setMmarknumber(int mmarknumber) {
        this.mmarknumber = mmarknumber;
    }

    public int getMtolcomment() {
        return mtolcomment;
    }

    public void setMtolcomment(int mtolcomment) {
        this.mtolcomment = mtolcomment;
    }

    public Date getMcreatedate() {
        return mcreatedate;
    }

    public void setMcreatedate(Date mcreatedate) {
        this.mcreatedate = mcreatedate;
    }

    public String getMstatus() {
        return mstatus;
    }

    public void setMstatus(String mstatus) {
        this.mstatus = mstatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materialId != null ? materialId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materials)) {
            return false;
        }
        Materials other = (Materials) object;
        if ((this.materialId == null && other.materialId != null) || (this.materialId != null && !this.materialId.equals(other.materialId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Materials[ materialId=" + materialId + " ]";
    }
    
}
