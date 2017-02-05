/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ.upem.localHistory.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bryan
 */
public class GestEntity {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("HistoriaPU");
    EntityManager em = emf.createEntityManager();
    
    User user = new User();
}
