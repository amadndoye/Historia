package fr.univ.upem.m2.jee.historia.managedBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import fr.univ.upem.m2.jee.historia.entity.Search;
import fr.univ.upem.m2.jee.historia.entity.Login;
import fr.univ.upem.m2.jee.historia.loockupService.IUserLoockUpService;
import fr.univ.upem.m2.jee.historia.loockupService.UserLoockUpServiceImpl;
import java.util.Collection;
import java.util.Locale;

@ManagedBean(name = "userManager")
@SessionScoped
public class UserManager implements Serializable{
	
	private static final long serialVersionUID = 5087659609209633734L;

        private String password;
        private String userName;
        private String mail;

	private Locale locale;


	private boolean showForm ;

	private Search search;
	
	@ManagedProperty("#{searchManager}")
	private SearchManager searchManager;

	private IUserLoockUpService userLS ;
	
	
        private ArrayList<Search> tobeRemoved ;
	
	@PostConstruct
	public void init(){
            System.out.println("UserManager.java PostConstruct: UserManager is initializing");
            userLS = new UserLoockUpServiceImpl();
            showForm =false ;
            search = new Search();
            tobeRemoved = new ArrayList<>();
            locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
            System.out.println("UserManager.java PostConstruct: UserManager finished initializing");

	}

        public void registration(ActionEvent event){
            System.out.println(" UserManager.java :registration :userName : "+userName+ " password :"+password + " mail : "+mail);

            if(!userLS.addUser(userName,password, mail)){
                    addMessage("userExiste","StringError",FacesMessage.SEVERITY_ERROR);
            }else{
                    showForm = false;
                    addMessage("registrationSucceed","StringText", FacesMessage.SEVERITY_INFO);

            }
           clean();
	}
		
	public String login () {
            System.out.println("UserManager.java :login :userName : "+userName + " password :"+password);
            Login user = userLS.logIn(userName,password);

            if(user == null){
                addMessage("userWrongID","StringError",FacesMessage.SEVERITY_ERROR) ;
                clean();
                return "faillure";

            }else{
                SessionHandler.getSession().setAttribute("user", user);
                System.out.println("UserManager.java :login ok :userName : "+userName + " password :"+password + "previou search size :"+ user.getPreviousSearch().size());
                addMessage("loginSucceed","StringText",FacesMessage.SEVERITY_INFO);
                return "success";
            }
	  }
        
        public String logout() {
            System.out.println(" UserManager.java :logout :userName : "+userName );
            userLS.update(SessionHandler.getUser(),tobeRemoved);  
            SessionHandler.getSession().invalidate();
            addMessage("logOut", "StringText",FacesMessage.SEVERITY_INFO);
            clean();

	    return "success";

	  }	
	
	 
	  
	  public void cancel(ActionEvent event){
		  System.out.println("UserManager.java :Registration Canceled");
		  this.showForm = false;
                  clean();
		  addMessage("cancelRegistration","StringText", FacesMessage.SEVERITY_WARN);

	  }
	  public void clear(ActionEvent event){
		  System.out.println("UserManager.java :clear Search");
		  clean();     
		  addMessage("clearSearch","StringText", FacesMessage.SEVERITY_INFO);

	  }
	   

	public void updateShowForm(ActionEvent event) {
		this.showForm = true;
	}
	  	 

	public void addResearch(Search lastSearch){
            System.out.println("UserManager.java :add Search");
            Collection<Search>s = SessionHandler.getUser().getPreviousSearch();
            if(s==null ){
                    s = new ArrayList<>();
            }
            lastSearch.setLogin(SessionHandler.getUser());
            s.add(lastSearch);
            SessionHandler.getUser().setPreviousSearch(s);
		
	}
        public void deleteSearch(Search search){
            System.out.println("UserManager.java :delete Search");
            Collection<Search> searchList = SessionHandler.getUser().getPreviousSearch();
            if(searchList.remove(search)){
                tobeRemoved.add(search);
                SessionHandler.getUser().setPreviousSearch(searchList);
                addMessage("searchDeleted","StringText", FacesMessage.SEVERITY_WARN);
            }
		 
	  }
	  
       
         
	 public void  searchEvent(ActionEvent event){
            if(search.getSearch_value().isEmpty()){
                addMessage("searchEmpty","StringText", FacesMessage.SEVERITY_WARN);
                search= new Search();
                searchManager.clear();
            }else{
                search.setDate(DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT).format(new Date()));
                searchManager.search(search);
                addResearch(search);
                search = new Search();
            }
		
		 
	 }
	 
	 public void searchAgain(Search searchAgain){
            System.out.println("UserManager.java :searchAgain");
            this.search = searchAgain;
            search.setDate(DateFormat.getDateTimeInstance().format(new Date()));
            searchManager.search(search);
            search = new Search();		 
	  }

	public SearchManager getSearchManager() {
		return searchManager;
	}

	public void setSearchManager(SearchManager searchManager) {
		this.searchManager = searchManager;
	}
	
	
        public Search getSearch() {
            return search;
	 }
   
        public boolean isShowForm() {
		return showForm;
	}
        public String getPassword() {
        return password;
    }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String username) {
            this.userName = username;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }
        
        public Login getUser(){
            return SessionHandler.getUser();
        }
        
       
        public void clean(){
            userName = null;
            password = null;
            mail = null;
            search= new Search();
            searchManager.clear();
        }
        
        public Locale getLocale() {
        return locale;
        }

        public String getLanguage() {
            return locale.getLanguage();
        }

        public void setLanguage(String language) {
            locale = new Locale(language);
            FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        }
    
        public void addMessage(String summary,String type, Severity severity) {
            ResourceBundle StringText = ResourceBundle.getBundle("locale."+type,FacesContext.getCurrentInstance().getViewRoot().getLocale());
            System.out.println("UserManager.addMessage() message : "+StringText.getString(summary));
	    FacesMessage message = new FacesMessage(severity, StringText.getString(summary),  null);
	    FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
