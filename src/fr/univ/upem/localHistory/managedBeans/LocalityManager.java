package fr.univ.upem.localHistory.managedBeans;


import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fr.univ.upem.localHistory.beans.AbstractLocationBean;
import fr.univ.upem.localHistory.beans.MuseumBean;

@ManagedBean
public class LocalityManager {

	private long id ;
	private String type;
	private  AbstractLocationBean locality;
	
	public void init() {
		System.out.println("LocalityManager.java : PostConstruct: Locality is initializing");
		locality = SearchManager.get(id,type);
		System.out.println("LocalityManager.java : PostConstruct: LocalityManager finished initializing");

	}
	

	 public void addMessage(String summary, Severity severity) {
			System.out.println("SearchManager.java :summary :message : "+summary);

	        FacesMessage message = new FacesMessage(severity, summary,  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	 }

	public void setId(long id) {
		this.id = id;
	}
	
	public long getId(){
		return id;
	}
	public void setType(String type) {
		this.type = type;
		init();

	}
	public String getType(){
		return type;
	}


	public AbstractLocationBean getLocality() {
		return locality;
	}


	public void setLocality(MuseumBean museum) {
		this.locality = museum;
	}


	
	
}
