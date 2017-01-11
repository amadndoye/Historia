package fr.univ.upem.localHistory.managedBeans;

import javax.faces.bean.ManagedBean;

import fr.univ.upem.localHistory.beans.User;
import fr.univ.upem.localHistory.loockupService.UserLoockUpService;
import fr.univ.upem.localHistory.loockupService.UserLoockUpServiceBase;

@ManagedBean
public class UserManager {
	private User user = new User();

	private String errorMessage = "";
	
	private static UserLoockUpService userLS = new UserLoockUpServiceBase();
	
	public User getUser(){
		return user;
	}
	public String login () {
		System.out.println("Login.java :login :userName : "+user.getUserName() + " password :"+user.getPassword());
		user = userLS.logIn(user);
		if(user == null){
			errorMessage = "Wrong user Name or password" ;
			user = new User();
			return null;
		}
	    return "/jsf/home/home";
	  }
	
	public String registration(){
		System.out.println(" Login.java :registration :userName : "+user.getUserName() + " password :"+user.getPassword() + " mail : "+user.getMail());
		 user = userLS.addUser(user);
		if( user != null){
			errorMessage = "User already existe";
			user = new User();
			return null;
		}else{
			user = new User();
		    return "/jsf/index";
		}
		
	}
	
	  public String logout() {
		  System.out.println(" Login.java :logout :userName : "+user.getUserName() + " password :"+user.getPassword() + " mail : "+user.getMail());
		  user = new User();
		  errorMessage = "";
		  return "/jsf/index";
	  }
	  
		public String getErrorMessage() {
			return errorMessage;
		}
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
		
	
}
