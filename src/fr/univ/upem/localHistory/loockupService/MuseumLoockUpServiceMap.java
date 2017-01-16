package fr.univ.upem.localHistory.loockupService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.univ.upem.localHistory.beans.ILocationBean;
import fr.univ.upem.localHistory.beans.MuseumBean;


public class MuseumLoockUpServiceMap implements IMuseumLoockUpService, ILocationLoockUpService {

private Map<Long,MuseumBean> museums ;
private long currentId  ;
	
	public MuseumLoockUpServiceMap() {
		museums = new HashMap<Long, MuseumBean>();
		currentId = 0 ; 
		museums.put(currentId,new MuseumBean("Musée du Louvre", "ILE-DE-FRANCE"));
		currentId++;
		museums.put(currentId,new MuseumBean("Musée Français de la Photographie", "ILE-DE-FRANCE"));
		currentId++;

		museums.put(currentId,new MuseumBean("Musée d'Art Sacré", "DIJON"));
		currentId++;

		museums.put(currentId,new MuseumBean("Musée de la Mine", "LA MACHINE"));
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
	public List<ILocationBean> findCloseLocation(long latitude, long longitude) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MuseumBean getMuseum(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MuseumBean> searchMuseum(String value, int type) {
		ArrayList <MuseumBean> bean = new ArrayList<>();
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
