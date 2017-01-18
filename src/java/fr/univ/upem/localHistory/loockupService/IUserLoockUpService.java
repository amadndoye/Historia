package fr.univ.upem.localHistory.loockupService;


import java.io.Serializable;

import fr.univ.upem.localHistory.beans.UserBean;

public interface IUserLoockUpService extends Serializable{
	public UserBean logIn(UserBean user);
	
	
	public UserBean addUser(UserBean user);

}
