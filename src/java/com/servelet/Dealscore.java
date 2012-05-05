/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servelet;

import com.entity.*;
import com.gtx.Dealuser;
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
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "Dealscore", urlPatterns = {"/Dealscore"})
public class Dealscore extends HttpServlet {

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
    @PersistenceUnit(unitName="TidianPU")
    private EntityManagerFactory entityManagerFactory;
    
    @Resource
    private UserTransaction userTransaction;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession usersession = request.getSession();
        //class to jugde user
        Dealuser dealuser = new Dealuser(usersession);
        int userid = dealuser.judgeUser();
        
        //use classify to jugde which operation should we do
        request.setCharacterEncoding("UTF-8");
        String type = request.getParameter("classify");
        String action = request.getParameter("action");
        
        Questions ques = null;
        Answers ans = null;
        Users users = null;
        //if we don't find check, we will create a check,next time we can't operate
        if(type.equals("ques"))
        {
            int queid = Integer.parseInt(request.getParameter("ID"));           
            EntityManager entitymanager = entityManagerFactory.createEntityManager();
            try
            {
                userTransaction.begin();
                ques = entitymanager.find(Questions.class, queid);
                users = entitymanager.find(Users.class, userid);
                entitymanager.refresh(ques);
                entitymanager.refresh(users);
                Checkque check = entitymanager.find(Checkque.class, new CheckquePK(userid, queid));
                if(check != null)
                {
                    entitymanager.refresh(check);
                    userTransaction.commit();
                    response.getWriter().write("false");                  
                    return;
                }
                if(action.equals("add"))
                {
                    ques.setPoint(ques.getPoint() + 1);
                }
                else if(action.equals("decrease"))
                {
                    ques.setPoint(ques.getPoint() - 1);        
                }
                check = new Checkque();
                check.setCheckquePK(new CheckquePK(userid, queid));
                entitymanager.persist(check);
                entitymanager.merge(ques);
                response.getWriter().write("true");
                userTransaction.commit();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }        
        else if(type.equals("ans"))
        {
            int ansid = Integer.parseInt(request.getParameter("ID"));  
            
            EntityManager entitymanager = entityManagerFactory.createEntityManager();
            try
            {
                userTransaction.begin();
                ans = entitymanager.find(Answers.class, ansid);
                entitymanager.refresh(ans);
                Checkans check = entitymanager.find(Checkans.class, new CheckansPK(userid, ansid));               
                if(check != null)
                {
                    entitymanager.refresh(check);
                    userTransaction.commit();
                    response.getWriter().write("false");                  
                    return;
                }
                if(action.equals("add"))
                {
                    ans.setPoint(ans.getPoint() + 1);
                }
                else if(action.equals("decrease"))
                {
                    ans.setPoint(ans.getPoint() - 1);        
                }
                check = new Checkans();
                check.setCheckansPK(new CheckansPK(userid, ansid));
                entitymanager.persist(check);
                entitymanager.merge(ans);
                //give a callback value to ajax
                response.getWriter().write("true");
                userTransaction.commit();
            }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
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
