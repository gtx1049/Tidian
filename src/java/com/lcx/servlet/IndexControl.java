/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lcx.servlet;

import com.entity.Platforms;
import com.entity.Questions;
import com.gtx.Quesdisplay;
import com.gtx.QuestionManager;
import com.lcx.model.PlatformManager;
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
@WebServlet(name = "IndexControl", urlPatterns = {"/IndexControl"})
public class IndexControl extends HttpServlet {
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
        EntityManager entitymanager = entityManagerFactory.createEntityManager();
        PlatformManager platformManager = new PlatformManager(entitymanager);
        List <Platforms> platforms = platformManager.getSpecifyPlatforms(0,8);
        QuestionManager questionManager = new QuestionManager(entitymanager,userTransaction);
        List displayli = questionManager.getQueslist();
        List lidis = questionManager.getTaglist();
        request.setAttribute("index_platforms", platforms);
        request.setAttribute("quesli", displayli);
        request.setAttribute("taglist", lidis);
        request.getRequestDispatcher("index.jsp").forward(request, response);       
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
