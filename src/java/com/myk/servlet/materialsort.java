/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myk.servlet;

import com.entity.Materials;
import com.myk.Class.MaterialFunction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
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
@WebServlet(name = "materialsort", urlPatterns = {"/materialsort"})
public class materialsort extends HttpServlet {
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
        
        String subject = request.getParameter("subject");
        String grade = request.getParameter("grade");
        
        MaterialFunction mf = new MaterialFunction(userTransaction, entityManagerFactory);
        List<Materials> content = new ArrayList<Materials>();
        if(subject.equals("chinese")){            
            content = mf.getArrayListBySubject("chinese");
        }else if(subject.equals("math")){
            content = mf.getArrayListBySubject("math");
        }else if(subject.equals("english")){
            content = mf.getArrayListBySubject("english");
        }else if(subject.equals("physics")){
            content = mf.getArrayListBySubject("physics");
        }else if(subject.equals("chemistry")){
            content = mf.getArrayListBySubject("chemistry");
        }else if(subject.equals("biology")){
            content = mf.getArrayListBySubject("biology");
        }
        content = content.subList(0, 7);
        request.setAttribute("content", content);
        request.getRequestDispatcher("materialsort.jsp").forward(request, response);
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
