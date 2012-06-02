/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myk.JPAEntityControllers;

import com.entity.Materialcomment;
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
public class MaterialcommentJpaController implements Serializable {

    public MaterialcommentJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Materialcomment materialcomment) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(materialcomment);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findMaterialcomment(materialcomment.getMaterialcommentId()) != null) {
                throw new PreexistingEntityException("Materialcomment " + materialcomment + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Materialcomment materialcomment) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            materialcomment = em.merge(materialcomment);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = materialcomment.getMaterialcommentId();
                if (findMaterialcomment(id) == null) {
                    throw new NonexistentEntityException("The materialcomment with id " + id + " no longer exists.");
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
            Materialcomment materialcomment;
            try {
                materialcomment = em.getReference(Materialcomment.class, id);
                materialcomment.getMaterialcommentId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The materialcomment with id " + id + " no longer exists.", enfe);
            }
            em.remove(materialcomment);
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

    public List<Materialcomment> findMaterialcommentEntities() {
        return findMaterialcommentEntities(true, -1, -1);
    }

    public List<Materialcomment> findMaterialcommentEntities(int maxResults, int firstResult) {
        return findMaterialcommentEntities(false, maxResults, firstResult);
    }

    private List<Materialcomment> findMaterialcommentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Materialcomment.class));
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

    public Materialcomment findMaterialcomment(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Materialcomment.class, id);
        } finally {
            em.close();
        }
    }

    public int getMaterialcommentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Materialcomment> rt = cq.from(Materialcomment.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
