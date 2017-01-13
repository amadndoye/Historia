package fr.univ.upem.localHistory.loockupService;

import java.util.HashMap;
import java.util.Map;

import fr.univ.upem.localHistory.beans.User;

public class UserLoockUpServiceMap implements UserLoockUpService {

	private Map<String,User> users ;
	
	public UserLoockUpServiceMap() {
		users = new HashMap<String, User>();
	}
	
	@Override
	public User logIn(User user){
		User x = users.get(user.getUserName());
		if(x!=null && x.getPassword().equals(user.getPassword())){
			return x;
		}
		return null;
	}

	@Override
	public User addUser(User user){
		System.out.println(" userLoockUpServiceBase.java :addUser :userName : "+user.getUserName() + " password :"+user.getPassword() + " mail : "+user.getMail());
		return users.put(user.getUserName(), new User(user.getUserName(),user.getUserName(),user.getMail()));
		
		
	}
	

}
