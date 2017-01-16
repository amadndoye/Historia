package fr.univ.upem.localHistory.managedBeans;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import fr.univ.upem.localHistory.beans.SearchBean;
import fr.univ.upem.localHistory.beans.UserBean;
import fr.univ.upem.localHistory.loockupService.IUserLoockUpService;
import fr.univ.upem.localHistory.loockupService.UserLoockUpServiceMap;

@ManagedBean
@SessionScoped
public class UserManager implements Serializable{
	

	
	private static final long serialVersionUID = 5087659609209633734L;

	private UserBean user;

	private static ResourceBundle stringError;
	
	private boolean showForm ;
	private boolean isNotLoggedIn;

	
	private IUserLoockUpService userLS ;
	
	
	public UserBean getUser(){
		return user;
	}
	
	@PostConstruct
	public void init(){
		System.out.println("UserManager.java PostConstruct: UserManager is initializing");
		 userLS = new UserLoockUpServiceMap();
		 user = new UserBean();
		 showForm =false ;
		 isNotLoggedIn = true;
		System.out.println("UserManager.java PostConstruct: UserManager finished initializing");

	}

	
	public void login (ActionEvent event) {
		
		System.out.println("UserManager.java :login :userName : "+user.getUserName() + " password :"+user.getPassword());
		user = userLS.logIn(user);
		stringError = ResourceBundle.getBundle("StringError", FacesContext.getCurrentInstance().getViewRoot().getLocale());

		if(user == null){
			addMessage(stringError.getString("userWrongID"),FacesMessage.SEVERITY_ERROR) ;
			user = new UserBean();
		}else{
		    addMessage("login succeed",FacesMessage.SEVERITY_INFO);
		     isNotLoggedIn = false;
		}
	  }
	
	public void registration(ActionEvent event){
		System.out.println(" UserManager.java :registration :userName : "+user.getUserName() + " password :"+user.getPassword() + " mail : "+user.getMail());
		user = userLS.addUser(user);
		stringError = ResourceBundle.getBundle("StringError", FacesContext.getCurrentInstance().getViewRoot().getLocale());

		if( user != null){
			addMessage(stringError.getString("userExiste"),FacesMessage.SEVERITY_ERROR);
		}else{
			showForm = false;
			addMessage("registration succeed", FacesMessage.SEVERITY_INFO);

		}
		user = new UserBean();

		
	}
	
	  public void logout() {
		  stringError = ResourceBundle.getBundle("StringError", FacesContext.getCurrentInstance().getViewRoot().getLocale());
		  System.out.println(" UserManager.java :logout :userName : "+user.getUserName() + " password :"+user.getPassword() + " mail : "+user.getMail());
		  user = new UserBean();
		  addMessage("log out", FacesMessage.SEVERITY_INFO);
		  isNotLoggedIn = true;
	  }
	  
	  public void cancel(ActionEvent event){
		 System.out.println("UserManager.java :cancel form");
		  user = new UserBean();
		  this.showForm = false;
	  }

	  
	public boolean isShowForm() {
		return showForm;
	}

	public void updateShowForm(ActionEvent event) {
		this.showForm = true;
	}
	  
	 public void addMessage(String summary, Severity severity) {
			System.out.println("UserManager.java :summary :message : "+summary);

	        FacesMessage message = new FacesMessage(severity, summary,  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }


	public boolean isNotLoggedIn() {
		return isNotLoggedIn;
	}
	
	public void addResearch(List<SearchBean> listOfSurch){
		user.setPreviousSearch(listOfSurch);
		
	}
	
}
