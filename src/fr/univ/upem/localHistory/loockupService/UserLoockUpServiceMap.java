package fr.univ.upem.localHistory.loockupService;

import java.util.HashMap;

import java.util.Map;

import fr.univ.upem.localHistory.beans.UserBean;


public class UserLoockUpServiceMap implements IUserLoockUpService {

	private Map<String,UserBean> users ;
	
	public UserLoockUpServiceMap() {
		users = new HashMap<String, UserBean>();
	}
	
	@Override
	public UserBean logIn(UserBean user){
		UserBean x = users.get(user.getUserName());
		if(x!=null && x.getPassword().equals(user.getPassword())){
			return x;
		}
		return null;
	}

	@Override
	public UserBean addUser(UserBean user){
		System.out.println(" userLoockUpServiceBase.java :addUser :userName : "+user.getUserName() + " password :"+user.getPassword() + " mail : "+user.getMail());
		return users.put(user.getUserName(), new UserBean(user.getUserName(),user.getUserName(),user.getMail()));
		
		
	}
	

}
