/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hzb.model;

import com.entity.Articles;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author nankonami
 */
public class ArticleManager 
{
    private EntityManager entityManager;
    public ArticleManager(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
    public List<Articles> GetArticles()
    {
        Query query = (Query) entityManager.createNamedQuery("Articles.findAll");  
        List<Articles> articles = query.getResultList();
        return articles;
    }
    public int GetArticleCount()
    {
        return this.GetArticles().size();
    }
    public List<Articles> GetArticlesForPage(int page,int count)
    {
        String sql = "select a from Articles a order by a.writeTime desc";
        Query query = (Query)entityManager.createQuery(sql);
        query.setFirstResult((page-1)*1);
        query.setMaxResults(count);
        List<Articles> articles = query.getResultList();
        
        return articles;
    }
    public int GetSpecialArticlesCount(String articleCategory)
    {
        Query query = (Query)entityManager.createNamedQuery("Articles.findByCategory")
                .setParameter("category", articleCategory);
        return query.getResultList().size();
    }
    public List<Articles> GetArticlesForHot()
    {
        String sql = "select a from Articles a order by a.writeTime desc , a.collectNumber asc";
        Query query = (Query)entityManager.createQuery(sql);
        
        List<Articles> hotArticles = query.getResultList();
        return hotArticles;
    }

}