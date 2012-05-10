/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hzb.servlet;

import com.entity.Users;
import com.hzb.model.MD5;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.transaction.*;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "RegProcessServlet", urlPatterns = {"/RegProcessServlet"})
public class RegProcessServlet extends HttpServlet {

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
        try{
            userTransaction.begin();
            String userName = request.getParameter("user_name");
            String userNickName = request.getParameter("user_nick");
            String userPwd = request.getParameter("user_pwd");
            String userEmail = request.getParameter("user_email");
            String userSex = request.getParameter("user_sex");
            String userPro = request.getParameter("user_pro");
            String userBirthY = request.getParameter("user_birth_y");
            String userBirthM = request.getParameter("user_birth_m");
            String userBirthD = request.getParameter("user_birth_d");
            
            MD5 md5=new MD5(userPwd);
            userPwd = md5.compute();
        
            Date date = null;
        
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            String sql = "select u from Users u where u.usrName = '" + userName + "'";
            Query query = (Query)entityManager.createQuery(sql);
            if(query.getResultList().size() != 0){   
                request.getRequestDispatcher("Register.html").forward(request, response);
        }else
        {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            String strDate = userBirthY+"-"+userBirthM+"-"+userBirthD;
            
            try{
                date = dateFormat.parse(strDate);
            }catch(ParseException e){
                e.printStackTrace();
            }
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            
            out.println(sqlDate);
            Users user = new Users();
            user.setUsrName(userName);
            user.setPassword(userPwd);
            user.setStatus("yes");
            user.setUsrId(1);
            user.setSex(userSex);
            user.setProvince(userPro);
            user.setPortrait("resource/kobe.jpg");
            user.setNickname(userNickName);
            user.setExperience(1);
            user.setBirthday(sqlDate);
            user.setEmail(userEmail);

               
                
                entityManager.persist(user);
                               request.getSession().setAttribute("user", user);
                userTransaction.commit();
                
                
        }
}catch(Exception e){
            out.println("ss");
        }

            
            
              //默认的当用户注册的时候，我们需要保存一个cookie
//         Cookie c = new Cookie("TDcustomName",userName);
//         c.setMaxAge(30*24*60*60);
//         response.addCookie(c);
//            

            
         //request.getRequestDispatcher("index.html").forward(request, response);
         response.sendRedirect("index.html");
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
