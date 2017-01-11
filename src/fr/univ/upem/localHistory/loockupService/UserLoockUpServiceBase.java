package fr.univ.upem.localHistory.loockupService;

import java.util.HashMap;
import java.util.Map;

import fr.univ.upem.localHistory.beans.User;

public class UserLoockUpServiceBase implements UserLoockUpService {

	private Map<String,User> users ;
	
	public UserLoockUpServiceBase() {
		users = new HashMap<String, User>();
	}
	
	@Override
	public User logIn(String userName , String passWord){
		User x = users.get(userName);
		if(x!=null && x.getPassword().equals(passWord)){
			return x;
		}
		return null;
	}

	@Override
	public User addUser(String userName, String password, String mail){
		if(!users.containsKey(userName)){
			return users.put(userName, new User(userName,password,mail));
		}
		return null ;
	}
	

}
