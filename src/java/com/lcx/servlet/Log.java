/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lcx.servlet;

import com.entity.Users;
import com.hzb.model.MD5;
import com.lcx.model.LogManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "Log", urlPatterns = {"/Log"})
public class Log extends HttpServlet {
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
        
        String login = request.getParameter("login");
        if(login == null){
            request.getSession().invalidate();
            response.sendRedirect("IndexControl");
            //request.getRequestDispatcher("IndexControl").forward(request, response);
            return;
        }
        String password = request.getParameter("password");
        MD5 md5=new MD5(password);
        password = md5.compute();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        LogManager logManager = new LogManager();
        Users user = new Users();
        if(login.equals("username")){
            String username = request.getParameter("username");
            user = logManager.getUser(1, username, password, entityManager, userTransaction);
        }
        else{
            String email = request.getParameter("email");
            user = logManager.getUser(2, email, password, entityManager, userTransaction);
            
        }
        if(user != null){
            request.getSession().setAttribute("user",user);
            response.sendRedirect("IndexControl");
        }
        else{
            response.sendRedirect("login.html");
        }
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