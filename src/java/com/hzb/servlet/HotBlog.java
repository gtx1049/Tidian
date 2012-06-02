/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.entity.Articles;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nankonami
 */
public class HotBlog extends HttpServlet {
    @PersistenceUnit
    EntityManagerFactory entityManageFactory;
    final int sizeOfPage = 5;
    final int sizeOfPart = 5;
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
        
        String page = request.getParameter("page");
        
        EntityManager entityManager = entityManageFactory.createEntityManager();
        ArticleManager articleManager = new ArticleManager(entityManager);
        
        int totalArticles = articleManager.GetArticleCount();
        int totalPage = totalArticles/sizeOfPage;
        int pageLeft = totalArticles%sizeOfPage;
        if(pageLeft == 0)
        {
            
        }else
        {
            totalPage += 1;
        }
        
        int totalPart = totalPage/sizeOfPart;
        int partLeft = totalPage%sizeOfPart;
        int pageMent = (Integer.valueOf(page) - 1)/5;
        
        if(partLeft != 0)
        {
            totalPart +=1;
        }
        
        if(Integer.valueOf(page) <= totalPage)
        {
            List<Articles> hotArticles = articleManager.GetArticlesForHotPage(Integer.valueOf(page), sizeOfPage);
            request.setAttribute("pageArticlesForHot", hotArticles);
        }else
        {
            List<Articles> hotArticles = articleManager.GetArticlesForHotPage(Integer.valueOf(page), pageLeft);
            request.setAttribute("pageArticlesForHot", hotArticles);
        }
        
        request.setAttribute("totalPageForHot", totalPage);
        request.setAttribute("totalPartForHot", totalPart);
        request.setAttribute("partLeftForHot", partLeft);
        
        String requestPath = "hotBlog.jsp?page=" + page +"&pagement=" + pageMent;
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
