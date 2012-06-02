/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.entity.Articles;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author nankonami
 */
public class ArticleManager 
{
    private EntityManager entityManager;
    public ArticleManager(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
    public List<Articles> GetArticles()
    {
        Query query = (Query) entityManager.createNamedQuery("Articles.findAll");  
        List<Articles> articles = query.getResultList();
        return articles;
    }
    public int GetArticleCount()
    {
        return this.GetArticles().size();
    }
    public List<Articles> GetArticlesForPage(int page,int count)
    {
        String sql = "select a from Articles a order by a.writeTime desc";
        Query query = (Query)entityManager.createQuery(sql);
        query.setFirstResult((page-1)*5);
        query.setMaxResults(count);
        List<Articles> articles = query.getResultList();
        
        return articles;
    }
    public int GetSpecialArticlesCount(String articleCategory)
    {
        Query query = (Query)entityManager.createNamedQuery("Articles.findByCategory")
                .setParameter("category", articleCategory);
        return query.getResultList().size();
    }
    public List<Articles> getSpecialArticlesForPage(String articleCategory, int page, int count)
    {
        Query query = (Query)entityManager.createNamedQuery("Articles.findByCategory")
                .setParameter("category", articleCategory);
        query.setFirstResult((page-1)*5);
        query.setMaxResults(count);
        
        return (List<Articles>)query.getResultList();
    }
    public List<Articles> GetArticlesForCommand()
    {
        String sql = "select a from Articles a order by a.writeTime desc , a.collectNumber desc";
        Query query = (Query)entityManager.createQuery(sql);
        
        List<Articles> hotArticles = query.getResultList();
        return hotArticles;
    }
    public List<Articles> GetArticlesForCommand(int number)
    {
        List<Articles> hotArticles = this.GetArticlesForCommand().subList(0, number);
        return hotArticles;
    }
    public List<Articles> GetArticlesForHot()
    {
        String sql = "select a from Articles a order by a.writeTime desc , a.totalScan desc";
        Query query = (Query)entityManager.createQuery(sql);
        
        return (List<Articles>)query.getResultList();
    }
    public List<Articles> GetArticlesForHot(int number)
    {
        List<Articles> hotArticles = this.GetArticlesForHot().subList(0, number);
        return hotArticles;
    }
    public List<Articles> GetArticlesForHotPage()
    {
        String sql = "select a from Articles a order by a.totalScan desc";
        Query query = (Query)entityManager.createQuery(sql);
        
        return (List<Articles>)query.getResultList();
    }
    public List<Articles> GetArticlesForHotPage(int page, int count)
    {
        String sql = "select a from Articles a order by a.totalScan desc";
        Query query = (Query)entityManager.createQuery(sql);
        query.setFirstResult((page-1)*5);
        query.setMaxResults(count);
        List<Articles> articles = query.getResultList();
        
        return articles;
    }
    public List<Articles> GetArticlesForCollect(int count)
    {
        String sql = "select a from Articles a order by a.collectNumber desc";
        Query query = (Query)entityManager.createQuery(sql);
        
        return (List<Articles>)query.getResultList().subList(0, count);
    }
    public List<Articles> GetArticlesForMonth(int count)
    {
        String sql = "select a from Articles a order by a.monthlyScan desc";
        Query query = (Query)entityManager.createQuery(sql);
        
        return (List<Articles>)query.getResultList().subList(0, count);
    }
    public List<Articles> GetArticlesForTotal(int count)
    {
        String sql = "select a from Articles a order by a.totalScan desc";
        Query query = (Query)entityManager.createQuery(sql);
        
        return (List<Articles>)query.getResultList().subList(0, count);
    }
}