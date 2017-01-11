package fr.univ.upem.localHistory.loockupService;

import fr.univ.upem.localHistory.beans.User;

public interface UserLoockUpService {
	public User logIn(User user);
	
	public User addUser(User user);

}
