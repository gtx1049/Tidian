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
@Table(name = "person_materials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonMaterials.findAll", query = "SELECT p FROM PersonMaterials p"),
    @NamedQuery(name = "PersonMaterials.findByUsrId", query = "SELECT p FROM PersonMaterials p WHERE p.personMaterialsPK.usrId = :usrId"),
    @NamedQuery(name = "PersonMaterials.findByMatId", query = "SELECT p FROM PersonMaterials p WHERE p.personMaterialsPK.matId = :matId")})
public class PersonMaterials implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonMaterialsPK personMaterialsPK;

    public PersonMaterials() {
    }

    public PersonMaterials(PersonMaterialsPK personMaterialsPK) {
        this.personMaterialsPK = personMaterialsPK;
    }

    public PersonMaterials(int usrId, int matId) {
        this.personMaterialsPK = new PersonMaterialsPK(usrId, matId);
    }

    public PersonMaterialsPK getPersonMaterialsPK() {
        return personMaterialsPK;
    }

    public void setPersonMaterialsPK(PersonMaterialsPK personMaterialsPK) {
        this.personMaterialsPK = personMaterialsPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personMaterialsPK != null ? personMaterialsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonMaterials)) {
            return false;
        }
        PersonMaterials other = (PersonMaterials) object;
        if ((this.personMaterialsPK == null && other.personMaterialsPK != null) || (this.personMaterialsPK != null && !this.personMaterialsPK.equals(other.personMaterialsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.PersonMaterials[ personMaterialsPK=" + personMaterialsPK + " ]";
    }
    
}
