/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "per_que_content")
public class PerQueContent {
    @Column(name="pq_id")
    private int pqId;
    @Id
    @Column(name="que_id")
    private int queId;
    @Column(name="content")
    private String content;
    public void setQueId(int queId){
        this.queId = queId;
    }
    public int getQueId(){
        return this.queId;
    }
    public void setPqId(int pqId){
        this.pqId = pqId;
    }
    public int getPqId(){
        return this.pqId;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }
}