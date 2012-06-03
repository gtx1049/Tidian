/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gtx.servlet;

import com.entity.Questions;
import com.entity.Tag;
import com.entity.Users;
import com.gtx.Dealuser;
import com.gtx.Quesdisplay;
import com.gtx.Tagdisplay;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author Administrator
 */
public class EditHandle extends HttpServlet {

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
        
        HttpSession usersession = request.getSession();
        //class to jugde user
        Dealuser dealuser = new Dealuser(usersession);
        int userid = dealuser.judgeUser();
        
        request.setCharacterEncoding("UTF-8");
        String htmlData = request.getParameter("content") != null ? request.getParameter("content") : "";
        String grade = request.getParameter("grade");
        String subject = request.getParameter("subject");
        String cateloge = request.getParameter("qtype");
        String tagid = request.getParameter("tag");
        
        if(htmlData.length() == 0)
        {
            return;
        }
        Tag atag = null;
        Users theuser = null;
        Questions newques = null;
        newques = new Questions();
        newques.setContent(htmlData);      
        newques.setPoint(0);
        newques.setCategory(cateloge);
        newques.setSubject(grade + subject);
        newques.setUsrId(userid);
        newques.setCollectNumber(0);
        newques.setDate(new Date());
        newques.setQueId(0);
        newques.setStatus("norm");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
            try
            {
                userTransaction.begin();
                theuser = entityManager.find(Users.class, userid);
                entityManager.refresh(theuser);
                atag = entityManager.find(Tag.class, Integer.parseInt(tagid));

                Collection<Tag> tags = new ArrayList<Tag>();
                tags.add(atag);
                newques.setTags(tags);
                entityManager.persist(newques);
                userTransaction.commit();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        List tagdis = new ArrayList();
        Tagdisplay tagdisplay = new Tagdisplay();
        tagdisplay.setThetag(atag);
        tagdis.add(tagdisplay);
         
        Quesdisplay quesdisplay = new Quesdisplay();
        quesdisplay.setQuestion(newques);
        quesdisplay.setTheuser(theuser);
        request.setAttribute("theques", quesdisplay);
        request.setAttribute("tag", tagdis);
        request.getRequestDispatcher("QandA.jsp").forward(request, response);
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
