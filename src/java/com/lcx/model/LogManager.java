/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lcx.model;

import com.entity.Users;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author Administrator
 */
public class LogManager {
    public Users getUser(int type,String name,String password,EntityManager entityManager,UserTransaction userTransaction){
        try{        
            userTransaction.begin();            
            String sql = null;
            if(type==1){
                sql = "select u from Users u where u.usrName="+"'"+name+"'";
            }
            else if(type==2){
                sql = "select u from Users u where u.email="+"'"+name+"'";
            }
            Query query = entityManager.createQuery(sql);
            List<Users> user = new ArrayList<Users>();
            user = query.getResultList();
            userTransaction.commit();
            if(user.size() != 0 && user.get(0).getPassword().equals(password)){
                return user.get(0);
            }
            else{
                return null;
            }
 
        }catch(Exception e){
            return null;
        }
    }
}
