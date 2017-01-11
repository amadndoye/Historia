package fr.univ.upem.localHistory.managedBeans;

import javax.faces.bean.ManagedBean;

import fr.univ.upem.localHistory.beans.User;
import fr.univ.upem.localHistory.loockupService.UserLoockUpService;
import fr.univ.upem.localHistory.loockupService.UserLoockUpServiceBase;

@ManagedBean
public class UserManager {
	private User user;
	private String userName = "User Name";
	private String password ;
	private String mail = "Mail";
	
	private static UserLoockUpService userLS = new UserLoockUpServiceBase();
	
	public User getUser(){
		return user;
	}
	public String login () {
		System.out.println("Login.java :login :userName : "+userName + " password :"+password);
		user = userLS.logIn(userName, password);
		if(user == null){
			//Error page
		}
	    return "home/home";
	  }
	
	public String registration(){
		System.out.println(" Login.java :registration :userName : "+userName + " password :"+password + " mail : "+mail);
		 
		if(userLS.addUser(userName, password , mail) != null){
			password = "";
		}
		
	    return "/index";
	}
	

	  public String logout() {
		  user =null;
		  return "/index";
	  }
	  
	  public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}
		
	
}
