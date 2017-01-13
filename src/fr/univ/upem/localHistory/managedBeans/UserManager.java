package fr.univ.upem.localHistory.managedBeans;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import fr.univ.upem.localHistory.beans.User;
import fr.univ.upem.localHistory.loockupService.UserLoockUpService;
import fr.univ.upem.localHistory.loockupService.UserLoockUpServiceMap;

@ManagedBean
@SessionScoped
public class UserManager implements Serializable{
	
	private static final long serialVersionUID = -4561164179000594735L;

	private User user = new User();

	private static ResourceBundle stringError;
	
	private boolean showForm =false ;
	private boolean isNotLoggedIn = true;


	private static UserLoockUpService userLS = new UserLoockUpServiceMap();
	
	
	public User getUser(){
		return user;
	}

	
	public void login (ActionEvent event) {
		
		System.out.println("Login.java :login :userName : "+user.getUserName() + " password :"+user.getPassword());
		user = userLS.logIn(user);
		stringError = ResourceBundle.getBundle("StringError", FacesContext.getCurrentInstance().getViewRoot().getLocale());

		if(user == null){
			addMessage(stringError.getString("userWrongID"),FacesMessage.SEVERITY_ERROR) ;
			user = new User();
		}else{
		    addMessage("login succeed",FacesMessage.SEVERITY_INFO);
		     isNotLoggedIn = false;
		}
	  }
	
	public void registration(ActionEvent event){
		System.out.println(" Login.java :registration :userName : "+user.getUserName() + " password :"+user.getPassword() + " mail : "+user.getMail());
		user = userLS.addUser(user);
		stringError = ResourceBundle.getBundle("StringError", FacesContext.getCurrentInstance().getViewRoot().getLocale());

		if( user != null){
			addMessage(stringError.getString("userExiste"),FacesMessage.SEVERITY_ERROR);
		}else{
			showForm = false;
			addMessage("registration succeed", FacesMessage.SEVERITY_INFO);

		}
		user = new User();

		
	}
	
	  public void logout() {
		  stringError = ResourceBundle.getBundle("StringError", FacesContext.getCurrentInstance().getViewRoot().getLocale());
		  System.out.println(" Login.java :logout :userName : "+user.getUserName() + " password :"+user.getPassword() + " mail : "+user.getMail());
		  user = new User();
		  addMessage("log out", FacesMessage.SEVERITY_INFO);
		  isNotLoggedIn = true;
	  }
	  
	  public void cancel(ActionEvent event){
		  user = new User();
		  this.showForm = false;
	  }

	  
	public boolean isShowForm() {
		return showForm;
	}

	public void updateShowForm(ActionEvent event) {
		this.showForm = true;
	}
	  
	 public void addMessage(String summary, Severity severity) {
	        FacesMessage message = new FacesMessage(severity, summary,  null);
	        FacesContext.getCurrentInstance().addMessage("growl", message);
	    }


	public boolean isNotLoggedIn() {
		return isNotLoggedIn;
	}
	
}
