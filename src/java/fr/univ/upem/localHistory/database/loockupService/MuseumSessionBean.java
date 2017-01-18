/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ.upem.localHistory.database.loockupService;

import fr.univ.upem.localHistory.database.Monument;
import fr.univ.upem.localHistory.database.Museum;
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
public class MuseumSessionBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(name = "HistoriaPU")
    EntityManager manager;
   
    private final String searchRequest = "SELECT m FROM MUSEUM m WHERE m.city =:city";
    
    public List<Museum> searchMuseum(String city){
         Query request = manager.createQuery(searchRequest);
        request.setParameter("city", city);
        ArrayList<Museum> museums = new ArrayList<Museum>();
        
        try{
            museums = (ArrayList<Museum>) request.getResultList();
        }catch(NoResultException nre){
            return null;
        }
        return museums;
    }
    
}
