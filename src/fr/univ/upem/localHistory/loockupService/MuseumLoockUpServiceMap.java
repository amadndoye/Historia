package fr.univ.upem.localHistory.loockupService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.univ.upem.localHistory.beans.AbstractLocationBean;
import fr.univ.upem.localHistory.beans.MuseumBean;
import fr.univ.upem.localHistory.beans.SearchBean;


public class MuseumLoockUpServiceMap implements IMuseumLoockUpService, ILocationLoockUpService {


	private static final long serialVersionUID = -255460405361319002L;
	private Map<Long,MuseumBean> museums ;
	private long currentId  ;
	
	public MuseumLoockUpServiceMap() {
		museums = new HashMap<Long, MuseumBean>();
		
	}
	
	@Override
	public long getLatitude() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLongitude() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AbstractLocationBean> findCloseLocation(long latitude, long longitude) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MuseumBean getMuseum(long id) {
		// TODO Auto-generated method stub
		return museums.get(id);
	}

	@Override
	public List<AbstractLocationBean> searchMuseum(SearchBean search) {
		ArrayList <AbstractLocationBean> bean = new ArrayList<>();
		String match = search.getSelected_match();
		if(match == null){
			return bean;
		}
		if(search.getSearch_value()!= null || !search.getSearch_value().isEmpty()){
			String value = search.getSearch_value().toUpperCase();
			for(MuseumBean x : museums.values()){
				if(search.isFree()){
					if(x.isFree()){
						continue;
					}
				}
				if(match.equals("All")){
					if((x.getName()!= null && x.getName().toUpperCase().contains(value))
					|| (x.getCity()!= null && x.getCity().toUpperCase().contains(value))
					|| (x.getThemes()!=null && x.getThemes().toUpperCase().contains(value))){	
						bean.add(x);
					}
				}else if(match.equals("City")){
					if(x.getCity()!=null && x.getCity().toUpperCase().contains(value)){
						bean.add(x);

					}

				}else if(match.equals("Name")){
					if(x.getName()!=null && x.getName().toUpperCase().contains(value)){
						bean.add(x);

					}

				}else if(match.equals("Theme")){
					if(x.getThemes()!=null && x.getThemes().toUpperCase().contains(value)){
						bean.add(x);

					}
				}
			}
		
		}
		return bean;
	}

	public Map<Long,MuseumBean> getMuseums() {
		return museums;
	}
	
	public void init(){
		currentId = 0 ; 
		museums.put(currentId,new MuseumBean(currentId,"Musée de la Folie Marco", "BARR"));
		museums.get(currentId).setAdresse("30, Rue du Dr Sultzer");
		museums.get(currentId).setCountry("France");
		museums.get(currentId).setCodePostal(67140);
		currentId++;
		museums.put(currentId,new MuseumBean(currentId,"Ecomusée de la Grande Lande", "SABRES"));
		museums.get(currentId).setAdresse("Route de Soférino");
		museums.get(currentId).setCountry("France");
		museums.get(currentId).setCodePostal(40630);

		currentId++;

		museums.put(currentId,new MuseumBean(currentId,"Maison de la Magie", "BLOIS"));
		museums.get(currentId).setAdresse("1, Place du Château");
		museums.get(currentId).setCountry("France");
		museums.get(currentId).setCodePostal(41000);

		currentId++;

		museums.put(currentId,new MuseumBean(currentId,"Musée Roybet Fould", "COURBEVOIE"));
		museums.get(currentId).setAdresse("Parc de Bécon 178, Boulevard Saint Denis");
		museums.get(currentId).setCountry("France");
		museums.get(currentId).setCodePostal(92400);

		currentId++;

	}


}
