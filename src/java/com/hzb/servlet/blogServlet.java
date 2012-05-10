/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hzb.servlet;

import com.entity.Articles;
import com.hzb.model.ArticleManager;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nankonami
 */
@WebServlet(name = "blogServlet", urlPatterns = {"/blogServlet"})
public class blogServlet extends HttpServlet {
    @PersistenceUnit
    EntityManagerFactory entityManageFactory;
    final int sizeOfPage = 1;
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
        String page = request.getParameter("page");
        
        EntityManager entityManager = entityManageFactory.createEntityManager();
        ArticleManager articleManager = new ArticleManager(entityManager);
        
        int totalArticles = articleManager.GetArticleCount();
        int totalPage = totalArticles/sizeOfPage;
        int pageLeft = totalArticles%sizeOfPage;
        int pageMent = (Integer.valueOf(page) - 1)/10;

        if(pageLeft == 0)
        {
            
        }else
        {
            totalPage += 1;
        }
        
        if(Integer.valueOf(page) <= totalPage)
        {
            List<Articles> pageArticles = articleManager.GetArticlesForPage(Integer.valueOf(page), sizeOfPage);
            request.setAttribute("pageArticles", pageArticles);
        }else
        {
            List<Articles> pageArticles = articleManager.GetArticlesForPage(Integer.valueOf(page), pageLeft);
            request.setAttribute("pageArticles", pageArticles);
        }
  
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageMent", pageMent);
        
        String requestPath = "blog.jsp?page=" + page;
        request.getRequestDispatcher(requestPath).forward(request, response);
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
