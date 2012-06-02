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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUsrId", query = "SELECT u FROM Users u WHERE u.usrId = :usrId"),
    @NamedQuery(name = "Users.findByUsrName", query = "SELECT u FROM Users u WHERE u.usrName = :usrName"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByNickname", query = "SELECT u FROM Users u WHERE u.nickname = :nickname"),
    @NamedQuery(name = "Users.findByProvince", query = "SELECT u FROM Users u WHERE u.province = :province"),
    @NamedQuery(name = "Users.findByBirthday", query = "SELECT u FROM Users u WHERE u.birthday = :birthday"),
    @NamedQuery(name = "Users.findBySex", query = "SELECT u FROM Users u WHERE u.sex = :sex"),
    @NamedQuery(name = "Users.findByExperience", query = "SELECT u FROM Users u WHERE u.experience = :experience"),
    @NamedQuery(name = "Users.findByPortrait", query = "SELECT u FROM Users u WHERE u.portrait = :portrait"),
    @NamedQuery(name = "Users.findByStatus", query = "SELECT u FROM Users u WHERE u.status = :status")})
public class Users implements Serializable {
    @Basic(optional =     false)
    @NotNull
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_id")
    private Integer usrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "usr_name")
    private String usrName;
    @Size(max = 36)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="电子邮件无效")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "nickname")
    private String nickname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "province")
    private String province;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "sex")
    private String sex;
    @Basic(optional = false)
    @NotNull
    @Column(name = "experience")
    private int experience;
    @Size(max = 96)
    @Column(name = "portrait")
    private String portrait;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId")
    private Collection<PersonQuestions> personQuestionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId")
    private Collection<Articles> articlesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<PersonArticles> personArticlesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId")
    private Collection<Platforms> platformsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId")
    private Collection<PlaReply> plaReplyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId")
    private Collection<ArtComments> artCommentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId")
    private Collection<ArtReply> artReplyCollection;

    public Users() {
    }

    public Users(Integer usrId) {
        this.usrId = usrId;
    }

    public Users(Integer usrId, String usrName, String email, String nickname, String province, Date birthday, String sex, int experience, String status) {
        this.usrId = usrId;
        this.usrName = usrName;
        this.email = email;
        this.nickname = nickname;
        this.province = province;
        this.birthday = birthday;
        this.sex = sex;
        this.experience = experience;
        this.status = status;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<PersonQuestions> getPersonQuestionsCollection() {
        return personQuestionsCollection;
    }

    public void setPersonQuestionsCollection(Collection<PersonQuestions> personQuestionsCollection) {
        this.personQuestionsCollection = personQuestionsCollection;
    }

    @XmlTransient
    public Collection<Articles> getArticlesCollection() {
        return articlesCollection;
    }

    public void setArticlesCollection(Collection<Articles> articlesCollection) {
        this.articlesCollection = articlesCollection;
    }

    @XmlTransient
    public Collection<PersonArticles> getPersonArticlesCollection() {
        return personArticlesCollection;
    }

    public void setPersonArticlesCollection(Collection<PersonArticles> personArticlesCollection) {
        this.personArticlesCollection = personArticlesCollection;
    }

    @XmlTransient
    public Collection<Platforms> getPlatformsCollection() {
        return platformsCollection;
    }

    public void setPlatformsCollection(Collection<Platforms> platformsCollection) {
        this.platformsCollection = platformsCollection;
    }

    @XmlTransient
    public Collection<PlaReply> getPlaReplyCollection() {
        return plaReplyCollection;
    }

    public void setPlaReplyCollection(Collection<PlaReply> plaReplyCollection) {
        this.plaReplyCollection = plaReplyCollection;
    }

    @XmlTransient
    public Collection<ArtComments> getArtCommentsCollection() {
        return artCommentsCollection;
    }

    public void setArtCommentsCollection(Collection<ArtComments> artCommentsCollection) {
        this.artCommentsCollection = artCommentsCollection;
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
        hash += (usrId != null ? usrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.usrId == null && other.usrId != null) || (this.usrId != null && !this.usrId.equals(other.usrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Users[ usrId=" + usrId + " ]";
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
}
