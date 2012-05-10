package com.lcx.servlet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.lcx.model.FileManager;
import com.lcx.model.FileManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.NamingException;
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
@WebServlet(name = "FileUploadServlet", urlPatterns = {"/FileUploadServlet"})
public class FileUploadServlet extends HttpServlet {
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
        FileManager fileManager = new FileManager();
        try {
                EntityManager entityManager = entityManagerFactory.createEntityManager();
                fileManager.upLoad(request,entityManager,userTransaction);
        
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FileUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        //request.getRequestDispatcher("/person_center.jsp").forward(request, response);
        response.sendRedirect("person_center");

        
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
