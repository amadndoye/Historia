package fr.univ.upem.localHistory.loockupService;

import fr.univ.upem.localHistory.beans.UserBean;

public interface UserLoockUpService {
	public UserBean logIn(UserBean user);
	
	public UserBean addUser(UserBean user);

}
