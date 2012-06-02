/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author nankonami
 */
public class UserManager 
{
    private EntityManager entityManager;
    public UserManager(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
    
    public boolean validater(String userName, String userPwd)
    {
        Query query = (Query)entityManager.createNamedQuery("Users.findByUsrName")
                .setParameter("usrName", userName);
        Users user = (Users)query.getSingleResult();
        if(user.getPassword().equals(userPwd))
        {
            return true;
        }else
        {
            return false;
        }
    }
    public Users getUserByName(String userName)
    {
        Query query = (Query)entityManager.createNamedQuery("Users.findByUsrName")
                .setParameter("usrName", userName);
        
        return (Users)query.getSingleResult();
    }
}

