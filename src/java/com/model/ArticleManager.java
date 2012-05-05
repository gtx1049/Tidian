/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.javabean.Article;
import com.javabean.Person_article;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        List<Article> articles = getArticle(id);
        return articles.size();
    }
    
    public List<Article> getSpecifyArticle(int page,int id){
        String sql = "select u from Person_article u where "+"u.usr_id"+" ="+ id;           
        Query query = (Query) entityManager.createQuery(sql);
        
        query.setFirstResult(page*10);
        query.setMaxResults(10);
        
        List<Person_article> person_articles = query.getResultList();
        
        List<Article> articles = new ArrayList<Article>();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Iterator it = person_articles.iterator();
        while(it.hasNext()){
            int index = ((Person_article)it.next()).getArt_id();            
            numbers.add(index);
        }
        for(int i =0 ;i<numbers.size();i++){
            int index = numbers.get(i);
            Article find = entityManager.find(Article.class, index);
            articles.add(find);
        }
        return articles;
    }
    
    public List<Article> getArticle(int id){
            String sql = "select u from Person_article u where "+"u.usr_id"+" ="+ id;           
        Query query = (Query) entityManager.createQuery(sql);
        
        List<Person_article> person_articles = query.getResultList();
        
        List<Article> articles = new ArrayList<Article>();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Iterator it = person_articles.iterator();
        while(it.hasNext()){
            int index = ((Person_article)it.next()).getArt_id();            
            numbers.add(index);
        }
        for(int i =0 ;i<numbers.size();i++){
            int index = numbers.get(i);
            Article find = entityManager.find(Article.class, index);
            articles.add(find);
        }
        return articles;
    }
}
