/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lcx.model;

import com.entity.Articles;
import com.entity.PersonArticles;
import com.entity.PersonArticlesPK;
import com.entity.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.*;

/**
 *
 * @author Administrator
 */
public class ArticleManager {
    private EntityManager entityManager;
    public ArticleManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public int getSize(int id){
        List<Articles> articles = getArticle(id);
        return articles.size();
    }
    
    public List<Articles> getSpecifyArticle(int page,int id){
        String sql = "select u from PersonArticles u where " + "u.users.usrId" + "=" + id;           
        Query query = (Query) entityManager.createQuery(sql);
        
        
        query.setFirstResult(page*10);
        query.setMaxResults(10);
        
        List<PersonArticles> person_articles = query.getResultList();
        
        List<Articles> articles = new ArrayList<Articles>();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Iterator it = person_articles.iterator();
        while(it.hasNext()){
            int index = ((PersonArticles)it.next()).getPersonArticlesPK().getArtId();            
            numbers.add(index);
        }
        for(int i =0 ;i<numbers.size();i++){
            int index = numbers.get(i);
            Articles find = entityManager.find(Articles.class, index);
            articles.add(find);
        }
        return articles;
    }
    
    public List<Articles> getArticle(int id){
        
        Users theuser = entityManager.find(Users.class, id);
        Collection person_articles = theuser.getPersonArticlesCollection();
        
        
        List<Articles> articles = new ArrayList<Articles>();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Iterator it = person_articles.iterator();
        while(it.hasNext()){
            int index = ((PersonArticles)it.next()).getPersonArticlesPK().getArtId();            
            numbers.add(index);
        }
        for(int i =0 ;i<numbers.size();i++){
            int index = numbers.get(i);
            Articles find = entityManager.find(Articles.class, index);
            articles.add(find);
        }
        return articles;
    }
}
