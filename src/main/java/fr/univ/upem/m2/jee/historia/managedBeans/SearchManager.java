package fr.univ.upem.m2.jee.historia.managedBeans;

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



import fr.univ.upem.m2.jee.historia.entity.AbstractLocation;
import fr.univ.upem.m2.jee.historia.entity.Monument;
import fr.univ.upem.m2.jee.historia.entity.Museum;
import fr.univ.upem.m2.jee.historia.entity.Search;
import fr.univ.upem.m2.jee.historia.loockupService.MonumentLoockUpServiceImpl;
import fr.univ.upem.m2.jee.historia.loockupService.MuseumLoockUpServiceImpl;
import javax.faces.event.ActionEvent;

@ManagedBean(name ="searchManager")
@ApplicationScoped
public class SearchManager implements Serializable{

	
	private static final long serialVersionUID = -8942781212546633508L;
	private static  MonumentLoockUpServiceImpl monumentLS ;
	private static MuseumLoockUpServiceImpl museumLS ;
	private List<AbstractLocation>result ;
		
	private double latitude ;
	private double longitude;
	private String address ;

    
        private double distance = 5;
	
	private boolean hasResult ;
	
	
	@PostConstruct
	public void init() {
		System.out.println("SearchManager.java : PostConstruct: SearChManager is initializing");
		monumentLS = new MonumentLoockUpServiceImpl();
		museumLS = new MuseumLoockUpServiceImpl();
		result = new ArrayList<>();
		hasResult = false;

		System.out.println("SearchManager.java : PostConstruct: SearChManager finished initializing");

	}
	 
	 public void  search(Search search){
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
			addMessage("noMatch","StringText", FacesMessage.SEVERITY_INFO);
		 }
		
		 System.out.println("SearchManager.java :search :search.value : "+search.getSearch_value() + " number of result : "+ result.size());


	 }
	 
	 public List<AbstractLocation> getResult() {
		 
		return result;
		}


	public boolean isHasResult() {
		return hasResult;
	}
       

	public static AbstractLocation get(long id, String type) {
		System.out.println(type);
		if("Museum".equalsIgnoreCase(type)){
			return museumLS.getMuseum(id);

		}else{
			return monumentLS.getMonument(id);

		}
	}


	public void clear() {
		result = null;
		hasResult= false;
                distance = 5;

	}
          public void  searchArroundMeEvent(ActionEvent event){
                searchArroundMe(latitude,longitude, distance);
            }

  private  void searchArroundMe(double latitude, double longitude, double distance) {
        result = new ArrayList<>();
        
        for(Museum x :museumLS.getMuseums() ){
            if(x.arrouMe(latitude,longitude, distance)){
                result.add(x);
            }
        }
       for(Monument x :monumentLS.getMonuments()){
            if(x.arrouMe(latitude,longitude, distance)){
                result.add(x);
            }
            
       }        
	 hasResult = !result.isEmpty();
		 if(!hasResult){
			addMessage("noMatch","StringText", FacesMessage.SEVERITY_INFO);
		 }
		
		 System.out.println("SearchManager.java :searchArroundMe :  number of result : "+ result.size());

    }
    
    public double getLatitude(){
		return latitude;
	}
	public double getLongitude(){
		return longitude;
	}
         public String getAddress() {
                return address;
            }

        public void setAddress(String address) {
            this.address = address;
        }

	public void setLatitude( double x){
		latitude = x;
	}
	public void setLongitude(double y){
		 longitude = y ;
	}
        
          public void setDistance(double distance) {
            this.distance = distance;
        }
        
        public double getDistance(){
            return distance;
        }
        
         public void addMessage(String summary,String type, Severity severity) {
            ResourceBundle StringText = ResourceBundle.getBundle("locale."+type,FacesContext.getCurrentInstance().getViewRoot().getLocale());
            System.out.println("SearchManager.addMessage() message : "+StringText.getString(summary));
	    FacesMessage message = new FacesMessage(severity, StringText.getString(summary),  null);
	    FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
