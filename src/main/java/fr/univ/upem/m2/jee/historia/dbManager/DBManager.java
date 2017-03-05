package fr.univ.upem.m2.jee.historia.dbManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class DBManager {
	private static EntityManagerFactory MANAGERFACTORY ;
	private final EntityManager manager ;
	
	public DBManager(){
		manager = getFactory().createEntityManager();
                
	}
	
	
	private static EntityManagerFactory getFactory() {
	        if (MANAGERFACTORY == null) {
	        	MANAGERFACTORY = Persistence.createEntityManagerFactory("HistoriaPU");
	            return MANAGERFACTORY;
	        }
	        return MANAGERFACTORY;
	    }
	 
	public void save(Object... entities) {
            manager.getTransaction().begin();
            for(Object o : entities){
                System.out.println("saving an object of "+o.getClass());
                manager.persist(o);
                
            }
            manager.flush();
            manager.getTransaction().commit();
	}
	 
	public void remove(Object... entities) {
            manager.getTransaction().begin();
            for(Object o : entities){
                if (!manager.contains(o)) {
                   Object mergedEntity = manager.merge(o);
                   System.out.println("removing an object of "+o.getClass());
                   manager.remove(mergedEntity);
               } else {
                   manager.remove(o);
               }
            }
            manager.getTransaction().commit();
	}
	       
	 
	public <T> T findById(Class<T> className, long id){
	    return manager.find(className,id);
	 }

	public <T> void clear(Class<T> className){
            String name = className.getName();
            String deleteQuery = "DELETE from "+name;
            Query query = manager.createQuery(deleteQuery);
            manager.getTransaction().begin();
            query.executeUpdate();
            manager.getTransaction().commit();
	    }
	 
	public <T> List<T> findAll(Class<T> entityClass){
               String name = entityClass.getName();
               String query = "Select a from "+name+" a";
               TypedQuery<T> selectQuery = manager.createQuery(query, entityClass);
               return selectQuery.getResultList();
	}
	 
	 
	public EntityManager getEntityManager() {
	        return manager;
	}
        
    

}
