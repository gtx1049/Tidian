/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myk.JPAEntityControllers;

import com.entity.Collect;
import com.myk.JPAEntityControllers.exceptions.NonexistentEntityException;
import com.myk.JPAEntityControllers.exceptions.PreexistingEntityException;
import com.myk.JPAEntityControllers.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author Michael
 */
public class CollectJpaController implements Serializable {

    public CollectJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Collect collect) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(collect);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findCollect(collect.getCollectId()) != null) {
                throw new PreexistingEntityException("Collect " + collect + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Collect collect) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            collect = em.merge(collect);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = collect.getCollectId();
                if (findCollect(id) == null) {
                    throw new NonexistentEntityException("The collect with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collect collect;
            try {
                collect = em.getReference(Collect.class, id);
                collect.getCollectId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The collect with id " + id + " no longer exists.", enfe);
            }
            em.remove(collect);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Collect> findCollectEntities() {
        return findCollectEntities(true, -1, -1);
    }

    public List<Collect> findCollectEntities(int maxResults, int firstResult) {
        return findCollectEntities(false, maxResults, firstResult);
    }

    private List<Collect> findCollectEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Collect.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Collect findCollect(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Collect.class, id);
        } finally {
            em.close();
        }
    }

    public int getCollectCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Collect> rt = cq.from(Collect.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
