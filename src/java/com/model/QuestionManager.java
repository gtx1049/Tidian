/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.javabean.*;
import java.util.ArrayList;
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
        String sql = "select u from PersonQuestions u where "+"u.usrId"+" ="+ id;           
        Query query = (Query) entityManager.createQuery(sql);        
        List<PersonQuestions> personQuestions = new ArrayList<PersonQuestions>();
        personQuestions = query.getResultList();
        return personQuestions;

    }
    public List<Questions> getSpecifyQuestions(int id){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        String sql = "select u from Per_que_content u where "+"u.pq_id"+" ="+ id;
        Query query = (Query) entityManager.createQuery(sql);
        List<Per_que_content> per_que_content = query.getResultList();
        
        List<Questions> questions = new ArrayList<Questions>();
       
        Iterator it = per_que_content.iterator();
        while(it.hasNext()){
            int index = ((Per_que_content)it.next()).getQue_id();            
            numbers.add(index);
        }
        for(int i =0 ;i<numbers.size();i++){
            int index = numbers.get(i);
            Questions find = entityManager.find(Questions.class, index);
            questions.add(find);
        }
        return questions;
    }
}