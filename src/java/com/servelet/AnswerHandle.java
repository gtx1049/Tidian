/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servelet;

import com.entity.Questions;
import com.entity.Answers;
import com.gtx.Dealuser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "AnswerHandle", urlPatterns = {"/AnswerHandle"})
public class AnswerHandle extends HttpServlet {

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
        
        HttpSession usersession = request.getSession();
        //class to jugde user
        Dealuser dealuser = new Dealuser(usersession);
        int userid = dealuser.judgeUser();
        
        request.setCharacterEncoding("UTF-8");
        int queID = Integer.parseInt(request.getParameter("queID"));
        
        Answers ans = new Answers();
        Questions ques = null;
        EntityManager entitymanager = entityManagerFactory.createEntityManager();
        try
        {           
        userTransaction.begin(); 
        ques = entitymanager.find(Questions.class, queID);
        entitymanager.refresh(ques);
        ans.setAnwId(0);
        ans.setContent(request.getParameter("content").getBytes());
        ans.setDate(new Date());
        ans.setPoint(0);
        ans.setQuestion(ques);
        ans.setUsrId(userid);
        entitymanager.persist(ans);
        userTransaction.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        String jump = "QuesFromDB" + "?quesID=" + queID;
        System.out.println(jump);
        response.sendRedirect(jump);
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
