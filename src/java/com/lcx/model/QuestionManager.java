/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lcx.model;

import com.entity.PerQueContent;
import com.entity.Questions;
import com.entity.PersonQuestions;
import com.entity.Users;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class QuestionManager {
    private EntityManager entityManager;
    public QuestionManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public int getNumber(int id){
        List<PersonQuestions> personQuestions = getPersonQuestions(id);
                return personQuestions.size();
    }
    public PersonQuestions getSpecifyQuestion(int id,int qpage){
        List<PersonQuestions> personQuestions = null;
        personQuestions = getPersonQuestions(id);
        if(personQuestions.size() != 0){
            return personQuestions.get(qpage-1);
            
        }
        else
            return null;
    }
    public List<PersonQuestions> getPersonQuestions(int id){
        Users user = entityManager.find(Users.class, id);
        Collection personque = user.getPersonQuestionsCollection();
        List<PersonQuestions> personQuestions = new ArrayList<PersonQuestions>(personque);
        
        return personQuestions;

    }
    public List<PerQueContent> getSpecifyQuestions(int id){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        String sql = "select u from PerQueContent u where "+"u.pqId"+" ="+ id;
        Query query = (Query) entityManager.createQuery(sql);
        List<PerQueContent> per_que_content = query.getResultList();
        
        return per_que_content;
    }
}