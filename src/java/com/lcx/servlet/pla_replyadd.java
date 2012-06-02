/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lcx.servlet;

import com.entity.PlaReply;
import com.entity.Platforms;
import com.entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "pla_replyadd", urlPatterns = {"/pla_replyadd"})
public class pla_replyadd extends HttpServlet {
    @PersistenceUnit(unitName="TidianPU")
    private EntityManagerFactory entityManagerFactory;
    @Resource
    private UserTransaction userTransaction;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String spla_id = request.getParameter("pla_id");
        int pla_id = Integer.parseInt(spla_id);
        String content = request.getParameter("content");
        String susr_id = request.getParameter("usr_id");
        int usr_id = Integer.parseInt(susr_id);
        if(usr_id == 0){
            response.sendRedirect("login.html");
            return;
        }
        java.util.Date date = new java.util.Date();
        
        try{
            userTransaction.begin();
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            PlaReply plaReply = new PlaReply(1);
            Users user = entityManager.find(Users.class, usr_id);
            plaReply.setUsrId(user);
            plaReply.setContent(content);
            plaReply.setDate(date);
            
            Platforms platform = entityManager.find(Platforms.class, pla_id);
            int commentNumber = platform.getCommentNumber();
            platform.setCommentNumber(commentNumber + 1);
            platform.setLastDate(date);
            plaReply.setPlaId(platform);
            entityManager.merge(platform);
            out.println(platform.getCommentNumber());
            entityManager.persist(plaReply);            
            userTransaction.commit();
            entityManager.refresh(platform);
        }catch(Exception e){
            out.println("fail to add the comment");
        }
        response.sendRedirect("FindPlatform?pla_id="+pla_id);
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
