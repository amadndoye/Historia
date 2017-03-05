package fr.univ.upem.m2.jee.historia.loockupService;

import fr.univ.upem.m2.jee.historia.dbManager.DBManager;
import fr.univ.upem.m2.jee.historia.entity.Login;
import fr.univ.upem.m2.jee.historia.entity.Search;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/**
 *
 * @author Lamine
 */
public class UserLoockUpServiceImpl implements IUserLoockUpService,Serializable {

    private  final DBManager manager;

    public UserLoockUpServiceImpl() {
        manager = new DBManager();
    }

    @Override
    public Login logIn(String userName, String password) {
        for (Login l: manager.findAll(Login.class)){
               if(Objects.equals(l.getUserName(), userName) || Objects.equals(l.getPassword(),password)){
                   return l; 
               }
           }
        return null; 
    }

    @Override
    public boolean addUser(String userName, String password, String email) {
        for (Login l: manager.findAll(Login.class)){
               if(Objects.equals(l.getUserName(), userName) ||Objects.equals(l.getMail(), email)){
                   return false; 
               }
           }
            Login login = new Login(userName,password,email);
            manager.save(login);
            
            return true;
    }

    @Override
    public void update(Login user, Collection<Search> tobeRemoved) {
        manager.save(user);
        for(Search s: tobeRemoved){
            manager.remove(s);
        }
        
    }
	
    
      

}
