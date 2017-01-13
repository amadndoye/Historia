package fr.univ.upem.localHistory.managedBeans;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fr.univ.upem.localHistory.beans.User;
import fr.univ.upem.localHistory.loockupService.UserLoockUpService;
import fr.univ.upem.localHistory.loockupService.UserLoockUpServiceMap;

@ManagedBean
public class UserManager implements Serializable{
	
	private static final long serialVersionUID = -7098814591506238090L;

	private User user = new User();

	private String errorMessage = "";
	
	private static ResourceBundle stringError;
	
	private boolean showForm =false ;


	private static UserLoockUpService userLS = new UserLoockUpServiceMap();
	
	
	public User getUser(){
		return user;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	public String login () {
		
		System.out.println("Login.java :login :userName : "+user.getUserName() + " password :"+user.getPassword());
		user = userLS.logIn(user);
		if(user == null){
			stringError = ResourceBundle.getBundle("StringError", FacesContext.getCurrentInstance().getViewRoot().getLocale());
			errorMessage = stringError.getString("userWrongID") ;
			user = new User();
			return null;
		}
	    return "login-success";
	  }
	
	public String registration(){
		System.out.println(" Login.java :registration :userName : "+user.getUserName() + " password :"+user.getPassword() + " mail : "+user.getMail());
		 user = userLS.addUser(user);
		if( user != null){
			stringError = ResourceBundle.getBundle("StringError", FacesContext.getCurrentInstance().getViewRoot().getLocale());
			errorMessage = stringError.getString("userExiste") ;
			user = new User();
			return null;
		}else{
			user = new User();
			showForm = false;
		    return "index";
		}
		
	}
	
	  public String logout() {
		  System.out.println(" Login.java :logout :userName : "+user.getUserName() + " password :"+user.getPassword() + " mail : "+user.getMail());
		  user = new User();
		  errorMessage = "";
		  return "index";
	  }
	  
	  public String cancel(){
		  user = new User();
		  this.showForm = false;
		  return null;
	  }

	  
	public boolean isShowForm() {
		return showForm;
	}

	public String updateShowForm() {
		this.showForm = true;
		return null;
	}
	  
		
		
	
}
