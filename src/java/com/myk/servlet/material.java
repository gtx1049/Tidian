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
@WebServlet(name = "material", urlPatterns = {"/material"})
public class material extends HttpServlet {
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
        MaterialFunction mf = new MaterialFunction(userTransaction, entityManagerFactory);
        List<Materials> chinese = new ArrayList<Materials>();
        List<Materials> math = new ArrayList<Materials>();
        List<Materials> english = new ArrayList<Materials>();
        List<Materials> physics = new ArrayList<Materials>();
        List<Materials> chemistry = new ArrayList<Materials>();
        List<Materials> biology = new ArrayList<Materials>();
        List<Materials> tolCollectedSorted = new ArrayList<Materials>(); 
        List<Materials> weekDownloadSorted = new ArrayList<Materials>();
        List<Materials> totalDownloadSorted = new ArrayList<Materials>();
        chinese = mf.getArrayListBySubject("chinese");
        math = mf.getArrayListBySubject("math");
        english = mf.getArrayListBySubject("english");
        physics = mf.getArrayListBySubject("physics");
        chemistry = mf.getArrayListBySubject("chemistry");
        biology = mf.getArrayListBySubject("biology");
        weekDownloadSorted = mf.getListSortedByWeekDownload();
        tolCollectedSorted = mf.getListSortedByCollect();
        totalDownloadSorted = mf.getListSortedByTolDownload();

        request.setAttribute("chinese", chinese);
        request.setAttribute("math", math);
        request.setAttribute("english", english);
        request.setAttribute("physics", physics);
        request.setAttribute("chemistry", chemistry);
        request.setAttribute("biology", biology);
        request.setAttribute("weekDownloadSorted", weekDownloadSorted);
        request.setAttribute("totalDownloadSorted", totalDownloadSorted);
        request.setAttribute("tolCollectedSorted", tolCollectedSorted);
        request.getRequestDispatcher("material.jsp").forward(request, response);
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
