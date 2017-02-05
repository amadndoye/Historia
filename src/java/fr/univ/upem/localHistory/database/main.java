/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ.upem.localHistory.database;

import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author bryan
 */
public class main {
    public static void main(String[] args){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HistoriaPU");
        EntityManager em = emf.createEntityManager();
        
        String searchRequest = "SELECT U FROM HISTORIAUSER u"
            + "WHERE u.userId=:userId";
        
        User u = new User();
        u.setPassword("password");
        u.setUserId(Long.MIN_VALUE);
        u.setUserName("user1");
        u.setMail("test@test.com");
        em.getTransaction().begin();
        em.persist(Objects.requireNonNull(u));
        em.getTransaction().commit();
        
        
        
         Query request = em.createQuery(searchRequest);
        request.setParameter("userId", u.getUserId());
        User uTmp;
        try{
            uTmp = (User) request.getSingleResult();
              System.out.println(uTmp);
        }catch(NoResultException nre){
            
        }
      
        
        em.close();
    }
}
