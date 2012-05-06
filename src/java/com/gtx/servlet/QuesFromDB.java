/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gtx.servlet;

import com.entity.Questions;
import com.entity.Answers;
import com.entity.Tag;
import com.entity.Users;
import com.gtx.Ansdisplay;
import com.gtx.Quesdisplay;
import com.gtx.Tagdisplay;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "QuesFromDB", urlPatterns = {"/QuesFromDB"})
public class QuesFromDB extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @PersistenceUnit(unitName="TidianPU")
    private EntityManagerFactory entityManagerFactory;
    
    @Resource
    private UserTransaction userTransaction;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Integer queid = Integer.parseInt(request.getParameter("quesID"));

            Questions question = null;
            Users user = null;
            Set<Answers> answers = null;
            Collection tags = null;
            List ansdis = new ArrayList();
            List tagdis = new ArrayList();

            EntityManager entityManager = entityManagerFactory.createEntityManager();
            try
            {
                userTransaction.begin();                
                question = entityManager.find(Questions.class, queid);
                user = entityManager.find(Users.class, question.getUsrId());
                entityManager.refresh(question);
                entityManager.refresh(user);
                answers = question.getAnswers();
                Iterator it = answers.iterator();
                while(it.hasNext())
                {
                    Answers tempans = (Answers)it.next();
                    Users ansuser = entityManager.find(Users.class, tempans.getUsrId());
                    entityManager.refresh(ansuser);
                    Ansdisplay ans = new Ansdisplay();
                    ans.setAnswers(tempans);
                    ans.setTheuser(ansuser);
                    ansdis.add(ans);
                }
                tags = question.getTags();
                Iterator tagit = tags.iterator();
                while(tagit.hasNext())
                {
                    Tagdisplay t = new Tagdisplay();
                    t.setThetag((Tag)tagit.next());
                    System.out.println(t.getTag());
                    tagdis.add(t);
                }
                userTransaction.commit();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
            if(question == null || user == null)
            {
                request.getRequestDispatcher("errorpage.jsp").forward(request, response);
            }                        
            
            Quesdisplay quesdisplay = new Quesdisplay();
            quesdisplay.setQuestion(question);
            quesdisplay.setTheuser(user);
            ansSort(ansdis);
            request.setAttribute("theques", quesdisplay);
            request.setAttribute("answers", ansdis);            
            request.setAttribute("tag", tagdis);
            
            request.getRequestDispatcher("QandA.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    
    public void ansSort(List answers)
    {
        for(int i = 0; i < answers.size(); i++)
        {
            for(int j = i + 1; j < answers.size(); j++)
            {     
                Ansdisplay ansforward = (Ansdisplay) answers.get(i);
                Ansdisplay ansback = (Ansdisplay)answers.get(j);
                if(ansforward.getAnsID() > ansback.getAnsID())
                {
                    answers.set(i, ansback);
                    answers.set(j, ansforward);
                }
            }
        }
    }
}
