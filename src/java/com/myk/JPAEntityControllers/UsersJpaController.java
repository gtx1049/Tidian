/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myk.JPAEntityControllers;

import com.entity.PersonArticles;
import com.entity.PersonQuestions;
import com.entity.Platforms;
import com.entity.Users;
import com.myk.JPAEntityControllers.exceptions.IllegalOrphanException;
import com.myk.JPAEntityControllers.exceptions.NonexistentEntityException;
import com.myk.JPAEntityControllers.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Administrator
 */
public class UsersJpaController implements Serializable {

    public UsersJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Users users) throws RollbackFailureException, Exception {
        if (users.getPersonQuestionsCollection() == null) {
            users.setPersonQuestionsCollection(new ArrayList<PersonQuestions>());
        }
        if (users.getPersonArticlesCollection() == null) {
            users.setPersonArticlesCollection(new ArrayList<PersonArticles>());
        }
        if (users.getPlatformsCollection() == null) {
            users.setPlatformsCollection(new ArrayList<Platforms>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<PersonQuestions> attachedPersonQuestionsCollection = new ArrayList<PersonQuestions>();
            for (PersonQuestions personQuestionsCollectionPersonQuestionsToAttach : users.getPersonQuestionsCollection()) {
                personQuestionsCollectionPersonQuestionsToAttach = em.getReference(personQuestionsCollectionPersonQuestionsToAttach.getClass(), personQuestionsCollectionPersonQuestionsToAttach.getPqId());
                attachedPersonQuestionsCollection.add(personQuestionsCollectionPersonQuestionsToAttach);
            }
            users.setPersonQuestionsCollection(attachedPersonQuestionsCollection);
            Collection<PersonArticles> attachedPersonArticlesCollection = new ArrayList<PersonArticles>();
            for (PersonArticles personArticlesCollectionPersonArticlesToAttach : users.getPersonArticlesCollection()) {
                personArticlesCollectionPersonArticlesToAttach = em.getReference(personArticlesCollectionPersonArticlesToAttach.getClass(), personArticlesCollectionPersonArticlesToAttach.getPersonArticlesPK());
                attachedPersonArticlesCollection.add(personArticlesCollectionPersonArticlesToAttach);
            }
            users.setPersonArticlesCollection(attachedPersonArticlesCollection);
            Collection<Platforms> attachedPlatformsCollection = new ArrayList<Platforms>();
            for (Platforms platformsCollectionPlatformsToAttach : users.getPlatformsCollection()) {
                platformsCollectionPlatformsToAttach = em.getReference(platformsCollectionPlatformsToAttach.getClass(), platformsCollectionPlatformsToAttach.getPlaId());
                attachedPlatformsCollection.add(platformsCollectionPlatformsToAttach);
            }
            users.setPlatformsCollection(attachedPlatformsCollection);
            em.persist(users);
            for (PersonQuestions personQuestionsCollectionPersonQuestions : users.getPersonQuestionsCollection()) {
                Users oldUsrIdOfPersonQuestionsCollectionPersonQuestions = personQuestionsCollectionPersonQuestions.getUsrId();
                personQuestionsCollectionPersonQuestions.setUsrId(users);
                personQuestionsCollectionPersonQuestions = em.merge(personQuestionsCollectionPersonQuestions);
                if (oldUsrIdOfPersonQuestionsCollectionPersonQuestions != null) {
                    oldUsrIdOfPersonQuestionsCollectionPersonQuestions.getPersonQuestionsCollection().remove(personQuestionsCollectionPersonQuestions);
                    oldUsrIdOfPersonQuestionsCollectionPersonQuestions = em.merge(oldUsrIdOfPersonQuestionsCollectionPersonQuestions);
                }
            }
            for (PersonArticles personArticlesCollectionPersonArticles : users.getPersonArticlesCollection()) {
                Users oldUsersOfPersonArticlesCollectionPersonArticles = personArticlesCollectionPersonArticles.getUsers();
                personArticlesCollectionPersonArticles.setUsers(users);
                personArticlesCollectionPersonArticles = em.merge(personArticlesCollectionPersonArticles);
                if (oldUsersOfPersonArticlesCollectionPersonArticles != null) {
                    oldUsersOfPersonArticlesCollectionPersonArticles.getPersonArticlesCollection().remove(personArticlesCollectionPersonArticles);
                    oldUsersOfPersonArticlesCollectionPersonArticles = em.merge(oldUsersOfPersonArticlesCollectionPersonArticles);
                }
            }
            for (Platforms platformsCollectionPlatforms : users.getPlatformsCollection()) {
                Users oldUsrIdOfPlatformsCollectionPlatforms = platformsCollectionPlatforms.getUsrId();
                platformsCollectionPlatforms.setUsrId(users);
                platformsCollectionPlatforms = em.merge(platformsCollectionPlatforms);
                if (oldUsrIdOfPlatformsCollectionPlatforms != null) {
                    oldUsrIdOfPlatformsCollectionPlatforms.getPlatformsCollection().remove(platformsCollectionPlatforms);
                    oldUsrIdOfPlatformsCollectionPlatforms = em.merge(oldUsrIdOfPlatformsCollectionPlatforms);
                }
            }
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

    public void edit(Users users) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Users persistentUsers = em.find(Users.class, users.getUsrId());
            Collection<PersonQuestions> personQuestionsCollectionOld = persistentUsers.getPersonQuestionsCollection();
            Collection<PersonQuestions> personQuestionsCollectionNew = users.getPersonQuestionsCollection();
            Collection<PersonArticles> personArticlesCollectionOld = persistentUsers.getPersonArticlesCollection();
            Collection<PersonArticles> personArticlesCollectionNew = users.getPersonArticlesCollection();
            Collection<Platforms> platformsCollectionOld = persistentUsers.getPlatformsCollection();
            Collection<Platforms> platformsCollectionNew = users.getPlatformsCollection();
            List<String> illegalOrphanMessages = null;
            for (PersonQuestions personQuestionsCollectionOldPersonQuestions : personQuestionsCollectionOld) {
                if (!personQuestionsCollectionNew.contains(personQuestionsCollectionOldPersonQuestions)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PersonQuestions " + personQuestionsCollectionOldPersonQuestions + " since its usrId field is not nullable.");
                }
            }
            for (PersonArticles personArticlesCollectionOldPersonArticles : personArticlesCollectionOld) {
                if (!personArticlesCollectionNew.contains(personArticlesCollectionOldPersonArticles)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PersonArticles " + personArticlesCollectionOldPersonArticles + " since its users field is not nullable.");
                }
            }
            for (Platforms platformsCollectionOldPlatforms : platformsCollectionOld) {
                if (!platformsCollectionNew.contains(platformsCollectionOldPlatforms)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Platforms " + platformsCollectionOldPlatforms + " since its usrId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<PersonQuestions> attachedPersonQuestionsCollectionNew = new ArrayList<PersonQuestions>();
            for (PersonQuestions personQuestionsCollectionNewPersonQuestionsToAttach : personQuestionsCollectionNew) {
                personQuestionsCollectionNewPersonQuestionsToAttach = em.getReference(personQuestionsCollectionNewPersonQuestionsToAttach.getClass(), personQuestionsCollectionNewPersonQuestionsToAttach.getPqId());
                attachedPersonQuestionsCollectionNew.add(personQuestionsCollectionNewPersonQuestionsToAttach);
            }
            personQuestionsCollectionNew = attachedPersonQuestionsCollectionNew;
            users.setPersonQuestionsCollection(personQuestionsCollectionNew);
            Collection<PersonArticles> attachedPersonArticlesCollectionNew = new ArrayList<PersonArticles>();
            for (PersonArticles personArticlesCollectionNewPersonArticlesToAttach : personArticlesCollectionNew) {
                personArticlesCollectionNewPersonArticlesToAttach = em.getReference(personArticlesCollectionNewPersonArticlesToAttach.getClass(), personArticlesCollectionNewPersonArticlesToAttach.getPersonArticlesPK());
                attachedPersonArticlesCollectionNew.add(personArticlesCollectionNewPersonArticlesToAttach);
            }
            personArticlesCollectionNew = attachedPersonArticlesCollectionNew;
            users.setPersonArticlesCollection(personArticlesCollectionNew);
            Collection<Platforms> attachedPlatformsCollectionNew = new ArrayList<Platforms>();
            for (Platforms platformsCollectionNewPlatformsToAttach : platformsCollectionNew) {
                platformsCollectionNewPlatformsToAttach = em.getReference(platformsCollectionNewPlatformsToAttach.getClass(), platformsCollectionNewPlatformsToAttach.getPlaId());
                attachedPlatformsCollectionNew.add(platformsCollectionNewPlatformsToAttach);
            }
            platformsCollectionNew = attachedPlatformsCollectionNew;
            users.setPlatformsCollection(platformsCollectionNew);
            users = em.merge(users);
            for (PersonQuestions personQuestionsCollectionNewPersonQuestions : personQuestionsCollectionNew) {
                if (!personQuestionsCollectionOld.contains(personQuestionsCollectionNewPersonQuestions)) {
                    Users oldUsrIdOfPersonQuestionsCollectionNewPersonQuestions = personQuestionsCollectionNewPersonQuestions.getUsrId();
                    personQuestionsCollectionNewPersonQuestions.setUsrId(users);
                    personQuestionsCollectionNewPersonQuestions = em.merge(personQuestionsCollectionNewPersonQuestions);
                    if (oldUsrIdOfPersonQuestionsCollectionNewPersonQuestions != null && !oldUsrIdOfPersonQuestionsCollectionNewPersonQuestions.equals(users)) {
                        oldUsrIdOfPersonQuestionsCollectionNewPersonQuestions.getPersonQuestionsCollection().remove(personQuestionsCollectionNewPersonQuestions);
                        oldUsrIdOfPersonQuestionsCollectionNewPersonQuestions = em.merge(oldUsrIdOfPersonQuestionsCollectionNewPersonQuestions);
                    }
                }
            }
            for (PersonArticles personArticlesCollectionNewPersonArticles : personArticlesCollectionNew) {
                if (!personArticlesCollectionOld.contains(personArticlesCollectionNewPersonArticles)) {
                    Users oldUsersOfPersonArticlesCollectionNewPersonArticles = personArticlesCollectionNewPersonArticles.getUsers();
                    personArticlesCollectionNewPersonArticles.setUsers(users);
                    personArticlesCollectionNewPersonArticles = em.merge(personArticlesCollectionNewPersonArticles);
                    if (oldUsersOfPersonArticlesCollectionNewPersonArticles != null && !oldUsersOfPersonArticlesCollectionNewPersonArticles.equals(users)) {
                        oldUsersOfPersonArticlesCollectionNewPersonArticles.getPersonArticlesCollection().remove(personArticlesCollectionNewPersonArticles);
                        oldUsersOfPersonArticlesCollectionNewPersonArticles = em.merge(oldUsersOfPersonArticlesCollectionNewPersonArticles);
                    }
                }
            }
            for (Platforms platformsCollectionNewPlatforms : platformsCollectionNew) {
                if (!platformsCollectionOld.contains(platformsCollectionNewPlatforms)) {
                    Users oldUsrIdOfPlatformsCollectionNewPlatforms = platformsCollectionNewPlatforms.getUsrId();
                    platformsCollectionNewPlatforms.setUsrId(users);
                    platformsCollectionNewPlatforms = em.merge(platformsCollectionNewPlatforms);
                    if (oldUsrIdOfPlatformsCollectionNewPlatforms != null && !oldUsrIdOfPlatformsCollectionNewPlatforms.equals(users)) {
                        oldUsrIdOfPlatformsCollectionNewPlatforms.getPlatformsCollection().remove(platformsCollectionNewPlatforms);
                        oldUsrIdOfPlatformsCollectionNewPlatforms = em.merge(oldUsrIdOfPlatformsCollectionNewPlatforms);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = users.getUsrId();
                if (findUsers(id) == null) {
                    throw new NonexistentEntityException("The users with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Users users;
            try {
                users = em.getReference(Users.class, id);
                users.getUsrId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The users with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<PersonQuestions> personQuestionsCollectionOrphanCheck = users.getPersonQuestionsCollection();
            for (PersonQuestions personQuestionsCollectionOrphanCheckPersonQuestions : personQuestionsCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Users (" + users + ") cannot be destroyed since the PersonQuestions " + personQuestionsCollectionOrphanCheckPersonQuestions + " in its personQuestionsCollection field has a non-nullable usrId field.");
            }
            Collection<PersonArticles> personArticlesCollectionOrphanCheck = users.getPersonArticlesCollection();
            for (PersonArticles personArticlesCollectionOrphanCheckPersonArticles : personArticlesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Users (" + users + ") cannot be destroyed since the PersonArticles " + personArticlesCollectionOrphanCheckPersonArticles + " in its personArticlesCollection field has a non-nullable users field.");
            }
            Collection<Platforms> platformsCollectionOrphanCheck = users.getPlatformsCollection();
            for (Platforms platformsCollectionOrphanCheckPlatforms : platformsCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Users (" + users + ") cannot be destroyed since the Platforms " + platformsCollectionOrphanCheckPlatforms + " in its platformsCollection field has a non-nullable usrId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(users);
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

    public List<Users> findUsersEntities() {
        return findUsersEntities(true, -1, -1);
    }

    public List<Users> findUsersEntities(int maxResults, int firstResult) {
        return findUsersEntities(false, maxResults, firstResult);
    }

    private List<Users> findUsersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Users.class));
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

    public Users findUsers(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Users.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Users> rt = cq.from(Users.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
