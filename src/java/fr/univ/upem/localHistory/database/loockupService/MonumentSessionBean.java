/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ.upem.localHistory.database.loockupService;

import fr.univ.upem.localHistory.database.Monument;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author bryan
 */
@Stateless
public class MonumentSessionBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "HistoriaPU")
    private EntityManager manager;
    private final String searchRequest = "SELECT m FROM MONUMENT m WHERE m.name =:name";
    
    public List<Monument> searchMonument(String name){
        Query request = manager.createQuery(searchRequest);
        request.setParameter("name", name);
        ArrayList<Monument> monuments = new ArrayList<Monument>();
        
        try{
            monuments = (ArrayList<Monument>) request.getResultList();
        }catch(NoResultException nre){
            return null;
        }
        return monuments;
    }
}
