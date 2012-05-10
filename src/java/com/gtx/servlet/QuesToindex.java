/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gtx.servlet;

import com.entity.Questions;
import com.gtx.Quesdisplay;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
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
@WebServlet(name = "QuesToindex", urlPatterns = {"/QuesToindex"})
public class QuesToindex extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        EntityManager entitymanager = entityManagerFactory.createEntityManager();
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
        
        request.setAttribute("quesli", displayli);
        request.getRequestDispatcher("DisplayQues.jsp").forward(request, response);
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
}
