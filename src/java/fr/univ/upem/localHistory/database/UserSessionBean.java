/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ.upem.localHistory.database;

import java.util.Objects;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author bryan
 */
@Stateful
public class UserSessionBean {

    @PersistenceContext(unitName = "HistoriaPU")
    private EntityManager manager;
    private final String searchRequest = "SELECT U FROM HISTORIAUSER u"
            + "WHERE u.userId=:userId";
    // mettre des throws/catch ?
    
    public void insertUser(User u){
        
        manager.getTransaction().begin();
        manager.persist(Objects.requireNonNull(u));
        manager.getTransaction().commit();
        manager.close();
      
       
    }
    
    public User searchUser(Long id){
        Query request = manager.createQuery(searchRequest);
        request.setParameter("userId", id);
        User u;
        try{
            u = (User) request.getSingleResult();
        }catch(NoResultException nre){
            return null;
        }
        return u;
    }

}
