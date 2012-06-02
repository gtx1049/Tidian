/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lcx.servlet;
import com.entity.*;
import com.lcx.model.ArticleManager;
import com.lcx.model.QuestionManager;
import com.lcx.model.Recommend;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
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
@WebServlet(name = "person_center", urlPatterns = {"/person_center"})
public class PersonCenter extends HttpServlet {

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
            throws ServletException, IOException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Users kobe = (Users) request.getSession().getAttribute("user");
        if(kobe==null){
            response.sendRedirect("login.html");
            return;
        }  

        HttpSession session = request.getSession();
        String sid = request.getParameter("id");
        if(sid == null){
            request.getRequestDispatcher("/person_center.jsp").forward(request, response);
        }
        int id = Integer.parseInt(sid);
        switch (id)
        {
            case 1:
                String sqpage = request.getParameter("qpage");
                int qpage = 1;
                if(sqpage!=null){
                    qpage = Integer.parseInt(sqpage);
                }
                QuestionManager questionManager = new QuestionManager(entityManager);
                List<PerQueContent> questions = new ArrayList<PerQueContent>();
                if(qpage < 1){
                    qpage = 1;
                }
                else if(qpage > questionManager.getNumber(kobe.getUsrId())){
                    qpage = questionManager.getNumber(kobe.getUsrId());
                }
                PersonQuestions personQuestions = questionManager.getSpecifyQuestion(kobe.getUsrId(),qpage);
                Integer question_number = 0;
                if(personQuestions != null){
                    questions = questionManager.getSpecifyQuestions(personQuestions.getPqId());
                    question_number = questionManager.getNumber(kobe.getUsrId());
                }
                request.setAttribute("personQuestions", personQuestions);
                request.setAttribute("questions", questions);
                request.setAttribute("qpage", qpage);
                session.setAttribute("question_number", question_number);
                request.getRequestDispatcher("/person_centerq.jsp").forward(request, response);
                break;
            case 2:
                String sapage = request.getParameter("apage");
                int apage = 0;
                if(sapage!=null){
                    apage = Integer.parseInt(sapage);
                }
                List<Articles> articles = new ArrayList<Articles>();
                ArticleManager articleManager = new ArticleManager(entityManager);
                articles = articleManager.getSpecifyArticle(apage,kobe.getUsrId());
                Integer art_number = articleManager.getSize(kobe.getUsrId());
                session.setAttribute("art_number", art_number);
                request.setAttribute("articles", articles);
                request.setAttribute("apage", apage);
                request.getRequestDispatcher("/person_centera.jsp").forward(request, response);
                break;
            case 3:
                request.getRequestDispatcher("/person_centerm.jsp").forward(request, response);
                break;
            case 4:
                Recommend recommend = new Recommend(entityManager,kobe.getUsrId());
                ArrayList<Articles> recArticles = (ArrayList<Articles>) recommend.getRecArticles();
                request.setAttribute("recArticles", recArticles);
                request.getRequestDispatcher("/person_centerr.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/person_center.jsp").forward(request, response);
        }
        
       // response.sendRedirect("index.jsp");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PersonCenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(PersonCenter.class.getName()).log(Level.SEVERE, null, ex);
        }


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
        try {
            try {
                processRequest(request, response);
            } catch (NamingException ex) {
                Logger.getLogger(PersonCenter.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonCenter.class.getName()).log(Level.SEVERE, null, ex);
        }
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
