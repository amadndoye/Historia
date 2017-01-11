package fr.univ.upem.localHistory.loockupService;

import fr.univ.upem.localHistory.beans.User;

public interface UserLoockUpService {
	public User logIn(String userName , String passWord);
	
	public User addUser(String userName, String password, String mail);

}
