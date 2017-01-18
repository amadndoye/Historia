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
import javax.faces.event.ActionEvent;

import fr.univ.upem.localHistory.beans.AbstractLocationBean;
import fr.univ.upem.localHistory.beans.SearchBean;
import fr.univ.upem.localHistory.loockupService.MonumentLoockUpServiceMap;
import fr.univ.upem.localHistory.loockupService.MuseumLoockUpServiceMap;

@ManagedBean(eager=true)
@ApplicationScoped
public class SearchManager implements Serializable{

	
	
	private static final long serialVersionUID = -3391866230193825437L;
	private static  MonumentLoockUpServiceMap monumentLS ;
	private  static MuseumLoockUpServiceMap museumLS ;
	
	private List<AbstractLocationBean>result ;
	
	private boolean hasResult ;
	
	private  SearchBean search;
	
	@PostConstruct
	public void init() {
		System.out.println("SearchManager.java : PostConstruct: SearChManager is initializing");
		monumentLS = new MonumentLoockUpServiceMap();
		museumLS = new MuseumLoockUpServiceMap();
		search = new SearchBean();
		result = new ArrayList<>();
		hasResult = false;
		System.out.println("SearchManager.java : PostConstruct: SearChManager finished initializing");

	}
	

	 public void addMessage(String summary, Severity severity) {
			System.out.println("SearchManager.java :summary :message : "+summary);

	        FacesMessage message = new FacesMessage(severity, summary,  null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	 
	 public void  search(ActionEvent event){
		System.out.println("SearchManager.java :search :search.value : "+search.getSearch_value());

		 result = museumLS.searchMuseum(search.getSearch_value(), 0);
		 if(result != null){
			 result.addAll(monumentLS.searchMonument(search.getSearch_value()));
		 }
		 hasResult = !result.isEmpty();
		 if(!hasResult){
			ResourceBundle stringText = ResourceBundle.getBundle("StringText", FacesContext.getCurrentInstance().getViewRoot().getLocale());
			 addMessage(stringText.getString("noMatch"), FacesMessage.SEVERITY_INFO);

		 }
		 System.out.println("SearchManager.java :search :search.value : "+search.getSearch_value() + " number of result : "+ result.size());


	 }
	 
	 public SearchBean getSearch() {
		return search;
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
	

}
