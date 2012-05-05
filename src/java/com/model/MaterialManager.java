/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.javabean.Article;
import com.javabean.Material;
import com.javabean.Person_material;
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
import javax.transaction.UserTransaction;

/**
 *
 * @author Administrator
 */
public class MaterialManager {
    private EntityManager entityManager;
    public MaterialManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }
        
 public List<Material> getMaterial(int id){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        String sql = "select u from Person_material u where "+"u.usr_id"+" ="+ id;           
        Query _query = (Query) entityManager.createQuery(sql);
        List<Person_material> person_materials = _query.getResultList();
        
        List<Material> materials = new ArrayList<Material>();
        numbers.clear();
       
        Iterator _it = person_materials.iterator();
        while(_it.hasNext()){
            int index = ((Person_material)_it.next()).getMat_id();            
            numbers.add(index);
        }
        for(int i =0 ;i<numbers.size();i++){
            int index = numbers.get(i);
            Material find = entityManager.find(Material.class, index);
            materials.add(find);
        }
        return materials;
    }
}
