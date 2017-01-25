package fr.univ.upem.localHistory.managedBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
	
	private boolean showForm ;

	private  SearchBean search;
	
	@ManagedProperty("#{searchManager}")
	private SearchManager searchManager;

	private IUserLoockUpService userLS ;
	
	private float latitude;
	private float longitude;
	
	public UserBean getUser(){
		return user;
	}
	
	@PostConstruct
	public void init(){
		System.out.println("UserManager.java PostConstruct: UserManager is initializing");
		 userLS = new UserLoockUpServiceMap();
		 user = new UserBean();
		 showForm =false ;
		 search = new SearchBean();
		System.out.println("UserManager.java PostConstruct: UserManager finished initializing");

	}

	
	public String login () {
		
		System.out.println("UserManager.java :login :userName : "+user.getUserName() + " password :"+user.getPassword());
		user = userLS.logIn(user);

		if(user == null){
			ResourceBundle stringError = ResourceBundle.getBundle("StringError", FacesContext.getCurrentInstance().getViewRoot().getLocale());
			addMessage(stringError.getString("userWrongID"),FacesMessage.SEVERITY_ERROR) ;
			user = new UserBean();
		    return "faillure";

		}else{
			ResourceBundle stringText = ResourceBundle.getBundle("StringText", FacesContext.getCurrentInstance().getViewRoot().getLocale());
		    addMessage(stringText.getString("loginSucceed"),FacesMessage.SEVERITY_INFO);
		    return "success";
		}
	  }
	
	public void registration(ActionEvent event){
		System.out.println(" UserManager.java :registration :userName : "+user.getUserName() + " password :"+user.getPassword() + " mail : "+user.getMail());
		user = userLS.addUser(user);

		if( user != null){
			ResourceBundle stringError = ResourceBundle.getBundle("StringError", FacesContext.getCurrentInstance().getViewRoot().getLocale());
			addMessage(stringError.getString("userExiste"),FacesMessage.SEVERITY_ERROR);
		}else{
			showForm = false;
			ResourceBundle stringText = ResourceBundle.getBundle("StringText", FacesContext.getCurrentInstance().getViewRoot().getLocale());
			addMessage(stringText.getString("registrationSucceed"), FacesMessage.SEVERITY_INFO);

		}
		user = new UserBean();

		
	}
	
	  public String logout() {
		ResourceBundle stringText = ResourceBundle.getBundle("StringText", FacesContext.getCurrentInstance().getViewRoot().getLocale());
		System.out.println(" UserManager.java :logout :userName : "+user.getUserName() + " password :"+user.getPassword() + " mail : "+user.getMail());
		user = new UserBean();
		search= new SearchBean();
		searchManager.clear();
		addMessage(stringText.getString("logOut"), FacesMessage.SEVERITY_INFO);
	    return "success";

	  }
	  
	  public void cancel(ActionEvent event){
		  System.out.println("UserManager.java :Registration Canceled");
		  user = new UserBean();
		  this.showForm = false;
		  searchManager.clear();
		  ResourceBundle stringText = ResourceBundle.getBundle("StringText", FacesContext.getCurrentInstance().getViewRoot().getLocale());
		  addMessage(stringText.getString("cancelRegistration"), FacesMessage.SEVERITY_WARN);

	  }
	  public void clear(ActionEvent event){
		  System.out.println("UserManager.java :clear Search");
		  search= new SearchBean();
		  searchManager.clear();
		  ResourceBundle stringText = ResourceBundle.getBundle("StringText", FacesContext.getCurrentInstance().getViewRoot().getLocale());
		  addMessage(stringText.getString("clearSearch"), FacesMessage.SEVERITY_INFO);

	  }
	  
	  public void deleteSearch(SearchBean search){
		  System.out.println("UserManager.java :delete Search");
		  List<SearchBean> searchList = user.getPreviousSearch();
		  if(searchList.remove(search)){
			  user.setPreviousSearch(searchList);
			  ResourceBundle stringText = ResourceBundle.getBundle("StringText", FacesContext.getCurrentInstance().getViewRoot().getLocale());
			  addMessage(stringText.getString("searchDeleted"), FacesMessage.SEVERITY_WARN);

		  }
		 
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

	public void addResearch(SearchBean lastSearch){
		List<SearchBean>s = user.getPreviousSearch();
		if(s==null ){
			s = new ArrayList<SearchBean>();
		}
		s.add(lastSearch);
		user.setPreviousSearch(s);
		
	}
	 public SearchBean getSearch() {
			return search;
	 }
	 
	 public void  search(ActionEvent event){
		 if(search.getSearch_value().isEmpty()){
			 ResourceBundle stringText = ResourceBundle.getBundle("StringText", FacesContext.getCurrentInstance().getViewRoot().getLocale());
			 addMessage(stringText.getString("searchEmpty"), FacesMessage.SEVERITY_WARN);
			 search= new SearchBean();
			 searchManager.clear();
		 }else{
			search.setDate(DateFormat.getDateTimeInstance().format(new Date()));
			searchManager.search(search);
			addResearch(search);
			search = new SearchBean();
		 }
		
		 
	 }
	 
	 public void searchAgain(SearchBean searchAgain){
		  System.out.println("UserManager.java :searchAgain");
		  	this.search = searchAgain;
		  	search.setDate(DateFormat.getDateTimeInstance().format(new Date()));
			searchManager.search(search);
			search = new SearchBean();
		 
		 
	  }

	public SearchManager getSearchManager() {
		return searchManager;
	}

	public void setSearchManager(SearchManager searchManager) {
		this.searchManager = searchManager;
	}
	
	public String setPosition(){
		 System.out.println("UserManager.java :setPosition : latitude = "+latitude +" longitude = "+longitude);
		return "";
	}
	
	public float getLatitude(){
		return latitude;
	}
	public float getLongitude(){
		return longitude;
	}

	public void setLatitude( float x){
		latitude = x;
	}
	public void setLongitude(float y){
		 longitude = y ;
	}
}
