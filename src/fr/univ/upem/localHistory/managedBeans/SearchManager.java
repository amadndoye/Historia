package fr.univ.upem.localHistory.managedBeans;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fr.univ.upem.localHistory.beans.SearchBean;
import fr.univ.upem.localHistory.loockupService.MonumentLoockUpServiceMap;
import fr.univ.upem.localHistory.loockupService.MuseumLoockUpServiceMap;

@ManagedBean(eager=true)
@ApplicationScoped
public class SearchManager implements Serializable{


	private static final long serialVersionUID = 9032720137949207334L;
	
	private  MonumentLoockUpServiceMap monumentLS ;
	private  MuseumLoockUpServiceMap museumLS ;
	
	private static ResourceBundle stringError;

	
	private  SearchBean search;
	
	@PostConstruct
	public void init() {
		System.out.println("PostConstruct: SearChManager.java is initializing");
		monumentLS = new MonumentLoockUpServiceMap();
		museumLS = new MuseumLoockUpServiceMap();
		search = new SearchBean();
	}
	

	 public void addMessage(String summary, Severity severity) {
	        FacesMessage message = new FacesMessage(severity, summary,  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	 
	 public SearchBean getSearch() {
		return search;
	}

	
	 


}
