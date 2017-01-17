package fr.univ.upem.localHistory.loockupService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.univ.upem.localHistory.beans.AbstractLocationBean;
import fr.univ.upem.localHistory.beans.MuseumBean;


public class MuseumLoockUpServiceMap implements IMuseumLoockUpService, ILocationLoockUpService {

private Map<Long,MuseumBean> museums ;
private long currentId  ;
	
	public MuseumLoockUpServiceMap() {
		museums = new HashMap<Long, MuseumBean>();
		currentId = 0 ; 
		museums.put(currentId,new MuseumBean(currentId,"Mus�e du Louvre", "ILE-DE-FRANCE"));
		currentId++;
		museums.put(currentId,new MuseumBean(currentId,"Mus�e Fran�ais de la Photographie", "ILE-DE-FRANCE"));
		currentId++;

		museums.put(currentId,new MuseumBean(currentId,"Mus�e d'Art Sacr�", "DIJON"));
		currentId++;

		museums.put(currentId,new MuseumBean(currentId,"Mus�e de la Mine", "LA MACHINE"));
		currentId++;

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
	public List<AbstractLocationBean> searchMuseum(String value, int type) {
		ArrayList <AbstractLocationBean> bean = new ArrayList<>();
		for(MuseumBean x : museums.values()){
			if(x.getName().toUpperCase().contains(value.toUpperCase())){
				bean.add(x);
			}
		}
		return bean;
	}

	public Map<Long,MuseumBean> getMuseums() {
		return museums;
	}


}
