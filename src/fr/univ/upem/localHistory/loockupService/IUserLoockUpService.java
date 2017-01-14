package fr.univ.upem.localHistory.loockupService;

import fr.univ.upem.localHistory.beans.UserBean;

public interface IUserLoockUpService {
	public UserBean logIn(UserBean user);
	
	public UserBean addUser(UserBean user);

}
