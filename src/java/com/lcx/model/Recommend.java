/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lcx.model;

import com.entity.Articles;
import com.entity.PersonArticles;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class Recommend {
    private EntityManager entityManager;
    private int usr_id;
    private int tran_number;
    private int art_number;
    public Recommend(EntityManager entityManager,int usr_id){
        this.entityManager = entityManager;
        this.usr_id = usr_id;
    }
    public List<Articles> getRecArticles(){
        List<Articles> articles = new ArrayList<Articles>();
        boolean[][] transaction = this.getTransaction();
        String sql = "select c from PersonArticles c where c.personArticlesPK.usrId = "+this.usr_id;
        Query query = entityManager.createQuery(sql);
        List<PersonArticles> personArticles =  query.getResultList();
        Iterator it = personArticles.iterator();
        PersonArticles personArticle = null;
        ArrayList<Integer>results = new ArrayList<Integer>();
        while(it.hasNext()){
            personArticle = (PersonArticles)it.next();
            int artId = personArticle.getPersonArticlesPK().getArtId();
            for(int i = 1; i < art_number + 1; i++){          
                if(artId != i && confidence(transaction,artId,i)){
                    results.add(i);
                }
            }        
        }
        Iterator _it = personArticles.iterator();
        while(_it.hasNext()){
            personArticle = (PersonArticles)_it.next();
            int artId = personArticle.getPersonArticlesPK().getArtId();
            for(int i = 0, j = results.size(); i < j; i++){
                if(results.get(i) == artId)
                    results.remove(i);
            }
        }
        for(int i = 0; i < results.size(); i++){
            Articles article = entityManager.find(Articles.class, results.get(i));
            articles.add(article);
        }
        return articles;
    }
    
    private boolean confidence(boolean[][] transaction,int artId,int art_Id){
        int single = 0;
        int together = 0;
        for(int i = 0; i < tran_number; i++){
            if(transaction[i][artId] == true && transaction[i][art_Id] == false){
                single +=1;
            }
            else if(transaction[i][artId] == true && transaction[i][art_Id] == true){
                together += 1;
                single += 1;
            }
        }
        if((double)together/(double)single >= 0.5){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean[][] getTransaction(){
        String sql = "select c from Articles c ";
        Query query = (Query) entityManager.createQuery(sql);
        List<PersonArticles> personArticles = query.getResultList();
        this.art_number = personArticles.size();
        query = null;
        personArticles = null;
        sql = "select c from PersonArticles c group by c.personArticlesPK.usrId";
        query = (Query) entityManager.createQuery(sql);
        personArticles = query.getResultList();
        this.tran_number = personArticles.size();
        boolean transaction[][] = new boolean[tran_number][art_number + 1];
        for(int i = 0; i < tran_number;i++)
            for(int j = 0; j < art_number + 1;j++){
                transaction[i][j] = false;
            }
        Iterator it = personArticles.iterator();
        PersonArticles personArticle = null;
        while(it.hasNext()){
            personArticle = (PersonArticles)it.next();
            transaction[personArticle.getPersonArticlesPK().getUsrId()][personArticle.getPersonArticlesPK().getArtId()]=true;            
        }
        return transaction;
    }
}