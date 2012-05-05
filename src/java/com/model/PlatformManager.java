/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.javabean.Platforms;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class PlatformManager {
    private EntityManager entityManager;
    public PlatformManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public int getSize(){
        List<Platforms> platforms = getPlatforms();
        return platforms.size();
    }
    public List<Platforms> getByComment(){
        String sql = "select u from Platforms u order by u.commentNumber";
        Query query = (Query) entityManager.createQuery(sql);
        query.setFirstResult(0);
        query.setMaxResults(10);
        List<Platforms> platforms = query.getResultList();
        return platforms;
    }
    public List<Platforms> getByFavorite(){
        String sql = "select u from Platforms u order by u.favNumber";
        Query query = (Query) entityManager.createQuery(sql);
        query.setFirstResult(0);
        query.setMaxResults(10);
        List<Platforms> platforms = query.getResultList();
        return platforms;
    }
    public List<Platforms> getSpecifyPlatforms(int page){
        String sql = "select u from Platforms u order by u.lastDate desc";
        Query query = (Query) entityManager.createQuery(sql);
        query.setFirstResult(page*40);
        query.setMaxResults(40);
        List<Platforms> platforms = query.getResultList();
        return platforms;
    }
    public List<Platforms> getPlatforms(){
        String sql = "select u from Platforms u";
        Query query = (Query) entityManager.createQuery(sql);        
        List<Platforms> platforms = query.getResultList();
        return platforms;
    }
}
