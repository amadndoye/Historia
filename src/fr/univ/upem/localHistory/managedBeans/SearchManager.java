package fr.univ.upem.localHistory.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fr.univ.upem.localHistory.beans.AbstractLocationBean;
import fr.univ.upem.localHistory.beans.SearchBean;
import fr.univ.upem.localHistory.loockupService.MonumentLoockUpServiceMap;
import fr.univ.upem.localHistory.loockupService.MuseumLoockUpServiceMap;

@ManagedBean(eager=true , name ="searchManager")
@ApplicationScoped
public class SearchManager implements Serializable{

	
	private static final long serialVersionUID = -8942781212546633508L;
	private static  MonumentLoockUpServiceMap monumentLS ;
	private  static MuseumLoockUpServiceMap museumLS ;
	
	private List<AbstractLocationBean>result ;
		
	private boolean hasResult ;
	
	
	@PostConstruct
	public void init() {
		System.out.println("SearchManager.java : PostConstruct: SearChManager is initializing");
		monumentLS = new MonumentLoockUpServiceMap();
		museumLS = new MuseumLoockUpServiceMap();
		result = new ArrayList<>();
		hasResult = false;
		System.out.println("SearchManager.java : PostConstruct: SearChManager finished initializing");

	}
	

	 public void addMessage(String summary, Severity severity) {
			System.out.println("SearchManager.java :summary :message : "+summary);

	        FacesMessage message = new FacesMessage(severity, summary,  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	 
	 public void  search(SearchBean search){
		System.out.println("SearchManager.java :search :search.value : "+search.getSearch_value());
		result = null ;
		if(search.getType().equalsIgnoreCase("Museum")){
			 result = museumLS.searchMuseum(search);
		}else if(search.getType().equalsIgnoreCase("Monument")){
			 result = monumentLS.searchMonument(search.getSearch_value());
		}else{
			 result = museumLS.searchMuseum(search);
			 result.addAll(monumentLS.searchMonument(search.getSearch_value()));
		}
		
		 hasResult = !result.isEmpty();
		 if(!hasResult){
			ResourceBundle stringText = ResourceBundle.getBundle("StringText", FacesContext.getCurrentInstance().getViewRoot().getLocale());
			addMessage(stringText.getString("noMatch"), FacesMessage.SEVERITY_INFO);
		 }
		 System.out.println("SearchManager.java :search :search.value : "+search.getSearch_value() + " number of result : "+ result.size());


	 }
	 
	 public List<AbstractLocationBean> getResult() {
			return result;
		}


	public boolean isHasResult() {
		return hasResult;
	}


	public static AbstractLocationBean get(long id, String type) {
		if(type == "Museum"){
			return museumLS.getMuseum(id);

		}else{
			return monumentLS.getMonument(id);

		}
	}


	public void clear() {
		result = null;
	}
	

}
