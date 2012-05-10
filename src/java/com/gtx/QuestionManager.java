/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gtx;

import com.entity.Questions;
import com.entity.Tag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author Administrator
 */
public class QuestionManager {
    EntityManager entitymanager;
    UserTransaction userTransaction;
    public QuestionManager(EntityManager entityManager, UserTransaction userTransaction){
        this.entitymanager = entityManager;
        this.userTransaction = userTransaction;
    }
    public List getQueslist(){
        List<Questions> li = null;
        try
        {
            userTransaction.begin();
            Query query = (Query)entitymanager.createQuery("select q from Questions q order by q.usrId desc");
            if(query.getResultList().size() < 5)//amend bug
            {
                query.setFirstResult(0);
            }
            else
            {
                query.setFirstResult(query.getResultList().size() - 5);            
            }
            query.setMaxResults(5);
            li = query.getResultList();
            userTransaction.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        List displayli = new ArrayList();
        Iterator<Questions> it = li.iterator();
        while(it.hasNext())
        {
            Quesdisplay ques = new Quesdisplay();
            ques.setQuestion(it.next());            
            displayli.add(ques);            
        }
        return displayli;
    }
    public List getTaglist(){
        List li = null;
        List lidis = new ArrayList();
        try
        {
            userTransaction.begin();
            Query query = entitymanager.createQuery("select t from Tag t");
            li = query.getResultList();
            userTransaction.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        Iterator it = li.iterator();
        while(it.hasNext())
        {
            Tagdisplay tagdis = new Tagdisplay();
            tagdis.setThetag((Tag)it.next());
            lidis.add(tagdis);
        }
        return lidis;
    }
}
