/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myk.JPAEntityControllers;

import com.entity.Materials;
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
public class MaterialsJpaController implements Serializable {

    public MaterialsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Materials materials) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(materials);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findMaterials(materials.getMaterialId()) != null) {
                throw new PreexistingEntityException("Materials " + materials + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Materials materials) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            materials = em.merge(materials);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = materials.getMaterialId();
                if (findMaterials(id) == null) {
                    throw new NonexistentEntityException("The materials with id " + id + " no longer exists.");
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
            Materials materials;
            try {
                materials = em.getReference(Materials.class, id);
                materials.getMaterialId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The materials with id " + id + " no longer exists.", enfe);
            }
            em.remove(materials);
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

    public List<Materials> findMaterialsEntities() {
        return findMaterialsEntities(true, -1, -1);
    }

    public List<Materials> findMaterialsEntities(int maxResults, int firstResult) {
        return findMaterialsEntities(false, maxResults, firstResult);
    }

    private List<Materials> findMaterialsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Materials.class));
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

    public Materials findMaterials(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Materials.class, id);
        } finally {
            em.close();
        }
    }

    public int getMaterialsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Materials> rt = cq.from(Materials.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
