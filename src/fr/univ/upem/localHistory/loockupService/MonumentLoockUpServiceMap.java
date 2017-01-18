package fr.univ.upem.localHistory.loockupService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.univ.upem.localHistory.beans.AbstractLocationBean;
import fr.univ.upem.localHistory.beans.MonumentBean;


public class MonumentLoockUpServiceMap implements IMonumentLoockUpService, ILocationLoockUpService {


	private static final long serialVersionUID = -1591550952675046727L;
	private Map<Long,MonumentBean> monuments ;
	private long currentId  ;

	public MonumentLoockUpServiceMap() {
		monuments = new HashMap<Long, MonumentBean>();
		currentId = 0 ; 
		monuments.put(currentId,new MonumentBean(currentId,"Musée du Louvre", "ILE-DE-FRANCE"));
		currentId++;
		monuments.put(currentId,new MonumentBean(currentId,"Musée Français de la Photographie", "ILE-DE-FRANCE"));
		currentId++;

		monuments.put(currentId,new MonumentBean(currentId,"Musée d'Art Sacré", "DIJON"));
		currentId++;

		monuments.put(currentId,new MonumentBean(currentId,"Musée de la Mine", "LA MACHINE"));
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


	public Map<Long,MonumentBean> getMonuments() {
		return monuments;
	}
	@Override
	public MonumentBean getMonument(long id) {
		return monuments.get(id);
	}
	@Override
	public List<AbstractLocationBean> searchMonument(String name) {
		ArrayList <AbstractLocationBean> bean = new ArrayList<>();
		for(MonumentBean x : monuments.values()){
			if(x.getName()!=null && x.getName().toUpperCase().contains(name.toUpperCase())){
				bean.add(x);
			}
		}
		return bean;
	}
	


}
