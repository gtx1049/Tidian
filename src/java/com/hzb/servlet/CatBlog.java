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
public class CatBlog extends HttpServlet {
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
        String category = request.getParameter("category");
        
        EntityManager entityManager = entityManageFactory.createEntityManager();
        ArticleManager articleManager = new ArticleManager(entityManager);
        
        
        int number_of_special_article = articleManager.GetSpecialArticlesCount(category);
        int page_of_special_article = number_of_special_article/sizeOfPage;
        int pageLeft_of_special_article = number_of_special_article%sizeOfPage;
        if(pageLeft_of_special_article == 0)
        {
            
        }else
        {
            page_of_special_article +=1;
        }
        
        int part_of_special_article = page_of_special_article/sizeOfPart;
        int partLeft_of_special_article = page_of_special_article%sizeOfPart;
        int pageMent_of_special_article = (Integer.valueOf(page)-1)/sizeOfPage;
        
        if(partLeft_of_special_article != 0)
        {
            part_of_special_article ++;
        }
        
        
        int currentPage = Integer.valueOf(page);
        
        if(currentPage < page_of_special_article)
        {
            List<Articles> specialArticles = articleManager.getSpecialArticlesForPage(category, currentPage, sizeOfPage);
            List<Articles> specialHotArticles = articleManager.GetArticlesForHot(8);
            request.setAttribute("hotArticlesForCat", specialHotArticles);
            request.setAttribute("pageArticlesForCat", specialArticles);
        }else 
        {
            List<Articles> specialArticles = articleManager.getSpecialArticlesForPage(category, currentPage, pageLeft_of_special_article);
            request.setAttribute("pageArticlesForCat", specialArticles);
            List<Articles> specialHotArticles = articleManager.GetArticlesForHot(8);
            request.setAttribute("hotArticlesForCat", specialHotArticles);
        }
        
        request.setAttribute("totalPageForCat", page_of_special_article);
        request.setAttribute("totalPartForCat", part_of_special_article);
        request.setAttribute("partLeftForCat", partLeft_of_special_article);
        
        String requestPath = "blogCat.jsp?category="+category+"&page="+page
                +"&pageMent="+pageMent_of_special_article;
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
