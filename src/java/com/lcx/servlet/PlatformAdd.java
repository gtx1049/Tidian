/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lcx.servlet;

import com.entity.Platforms;
import com.entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
import javax.transaction.UserTransaction;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "Platform_add", urlPatterns = {"/Platform_add"})
public class PlatformAdd extends HttpServlet {
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
        PrintWriter out = response.getWriter();
        if(request.getSession().getAttribute("user")==null){
            response.sendRedirect("login.html");
            return;
        }
        request.setCharacterEncoding("UTF-8");
        try{
            userTransaction.begin();
            String topic = request.getParameter("topic");
            String content = request.getParameter("content");
           
            Date date = new Date();           
            out.println(date.toString().substring(3, 10));
            out.println("<br/>");
            out.println(date.getTime());
            String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            Timestamp now = Timestamp.valueOf(nowTime);
            out.println(now);
            Platforms newPlatform = new Platforms(1);
            Users user = (Users) request.getSession().getAttribute("user");
            if(user == null){
                response.sendRedirect("Login");
            }
            newPlatform.setUsrId(user);
            newPlatform.setTopic(topic);
            newPlatform.setContent(content.getBytes());
            newPlatform.setSetDate(new Date());
            newPlatform.setLastDate(new Date());
            newPlatform.setClickNumber(0);
            newPlatform.setFavNumber(0);            
            newPlatform.setCommentNumber(0);
            newPlatform.setStatus("yes");
            
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.persist(newPlatform);            
            userTransaction.commit();

            }
            catch(Exception e)
            {
                e.printStackTrace();
                
            }
        response.sendRedirect("Platform");
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
