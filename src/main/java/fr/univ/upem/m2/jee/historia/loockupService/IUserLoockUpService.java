package fr.univ.upem.m2.jee.historia.loockupService;


import java.io.Serializable;

import fr.univ.upem.m2.jee.historia.entity.Login;
import fr.univ.upem.m2.jee.historia.entity.Search;
import java.util.Collection;
import java.util.Collections;

public interface IUserLoockUpService extends Serializable{
	
    /** log in an user to the database 
     *
     * @param userName
     * @param password
     * @return null if no user match
     */
    public Login logIn(String userName , String password);
	
    /**add a user to the database
     *
     * @param userName
     * @param password
     * @param email
     * @return true if the user with the same username or email doesn't existe
     */
    public boolean addUser(String userName , String password, String email);

    /**Update user in the dataBase and remove the previous search selected for removed
     *
     * @param user
     * @param tobeRemoved
     */
    public void update(Login user, Collection<Search> tobeRemoved);

}
