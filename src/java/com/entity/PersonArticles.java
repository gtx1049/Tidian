/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "person_articles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonArticles.findAll", query = "SELECT p FROM PersonArticles p"),
    @NamedQuery(name = "PersonArticles.findByUsrId", query = "SELECT p FROM PersonArticles p WHERE p.personArticlesPK.usrId = :usrId"),
    @NamedQuery(name = "PersonArticles.findByArtId", query = "SELECT p FROM PersonArticles p WHERE p.personArticlesPK.artId = :artId")})
public class PersonArticles implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonArticlesPK personArticlesPK;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public PersonArticles() {
    }

    public PersonArticles(PersonArticlesPK personArticlesPK) {
        this.personArticlesPK = personArticlesPK;
    }

    public PersonArticles(int usrId, int artId) {
        this.personArticlesPK = new PersonArticlesPK(usrId, artId);
    }

    public PersonArticlesPK getPersonArticlesPK() {
        return personArticlesPK;
    }

    public void setPersonArticlesPK(PersonArticlesPK personArticlesPK) {
        this.personArticlesPK = personArticlesPK;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personArticlesPK != null ? personArticlesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonArticles)) {
            return false;
        }
        PersonArticles other = (PersonArticles) object;
        if ((this.personArticlesPK == null && other.personArticlesPK != null) || (this.personArticlesPK != null && !this.personArticlesPK.equals(other.personArticlesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.PersonArticles[ personArticlesPK=" + personArticlesPK + " ]";
    }
    
}
