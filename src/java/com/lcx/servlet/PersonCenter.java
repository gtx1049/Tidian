/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lcx.servlet;
import com.entity.Articles;
import com.entity.Users;
import com.entity.Material;
import com.entity.Questions;
import com.entity.PersonQuestions;
import com.lcx.model.ArticleManager;
import com.lcx.model.MaterialManager;
import com.lcx.model.QuestionManager;
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
       // Users kobe = entityManager.find(Users.class, 1);
        Users kobe = (Users) request.getSession().getAttribute("user");
        if(kobe==null){
            response.sendRedirect("login.html");
            return;          
        }
        String spage = request.getParameter("page");
        int page = 0;
        if(spage!=null){
            page = Integer.parseInt(spage);
        }
        List<Articles> articles = new ArrayList<Articles>();
        ArticleManager articleManager = new ArticleManager(entityManager);
        articles = articleManager.getSpecifyArticle(page,kobe.getUsrId());
        Integer art_number = articleManager.getSize(kobe.getUsrId());  
        List<Material> materials = new ArrayList<Material>();
        MaterialManager materialManager = new MaterialManager(entityManager);
        materials = materialManager.getMaterial(kobe.getUsrId());
        
        String sqpage = request.getParameter("qpage");
        int qpage = 1;
        if(sqpage!=null){
            qpage = Integer.parseInt(sqpage);
        }
        QuestionManager questionManager = new QuestionManager(entityManager);
        List<Questions> questions = new ArrayList<Questions>();

        PersonQuestions personQuestions = questionManager.getSpecifyQuestion(kobe.getUsrId(),qpage);
        Integer question_number = 0;
        if(personQuestions != null){
            questions = questionManager.getSpecifyQuestions(personQuestions.getPqId());
            question_number = questionManager.getNumber(kobe.getUsrId());
        }

        HttpSession session = request.getSession();
       // session.setAttribute("user", kobe);
        session.setAttribute("art_number", art_number);
        request.setAttribute("articles", articles);
        request.setAttribute("materials", materials);
        request.setAttribute("personQuestions", personQuestions);
        request.setAttribute("questions", questions);

        out.println(questions.size());
        session.setAttribute("question_number", question_number);
        out.println(kobe.getPortrait());
        request.getRequestDispatcher("/person_center.jsp").forward(request, response);
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
