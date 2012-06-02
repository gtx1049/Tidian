/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.entity.Users;
import java.io.IOException;
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author nankonami
 */
public class RegProcess extends HttpServlet {
      @PersistenceUnit
      private EntityManagerFactory entityManageFactory;
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
        request.setCharacterEncoding("UTF-8");
        
        try
        {
            
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
        
        Date date = null;
        
        EntityManager entityManager = entityManageFactory.createEntityManager();
        String sql = "select u from Users u where u.usrName = '" + userName + "'";
        Query query = (Query)entityManager.createQuery(sql);
        
        if(!query.getResultList().isEmpty())
        {
            request.getRequestDispatcher("Reg.jsp").forward(request, response);
        }else
        {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = userBirthY+"-"+userBirthM+"-"+ userBirthD;
            try
            {
                date = dateFormat.parse(strDate);
                
            }catch(ParseException e)
            {
                e.printStackTrace();
            }
            
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            
            Users user = new Users();
            user.setUsrName(userName);
            user.setPassword(userPwd);
            user.setStatus("y");
            user.setUsrId(1);
            user.setSex(userSex);
            user.setProvince(userPro);
            user.setPortrait("n");
            user.setNickname(userNickName);
            user.setExperience(0);
            user.setBirthday(sqlDate);
            user.setEmail(userEmail);
            

            entityManager.persist(user);
            userTransaction.commit();
            HttpSession session = request.getSession();
            session.setAttribute("TDuserName", userName);
        }}catch(Exception e){
        
        }
       
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
