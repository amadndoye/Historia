package fr.univ.upem.localHistory.loockupService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import fr.univ.upem.localHistory.beans.ILocationBean;
import fr.univ.upem.localHistory.beans.MonumentBean;


public class MonumentLoockUpServiceMap implements IMonumentLoockUpService, ILocationLoockUpService {

private Map<Long,MonumentBean> monuments ;
private long currentId  ;

	public MonumentLoockUpServiceMap() {
		monuments = new HashMap<Long, MonumentBean>();
		currentId = 0 ; 
		monuments.put(currentId,new MonumentBean("Musée du Louvre", "ILE-DE-FRANCE"));
		currentId++;
		monuments.put(currentId,new MonumentBean("Musée Français de la Photographie", "ILE-DE-FRANCE"));
		currentId++;

		monuments.put(currentId,new MonumentBean("Musée d'Art Sacré", "DIJON"));
		currentId++;

		monuments.put(currentId,new MonumentBean("Musée de la Mine", "LA MACHINE"));
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


	public Map<Long,MonumentBean> getMonuments() {
		return monuments;
	}
	@Override
	public MonumentBean getMonument(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<MonumentBean> searchMonument(String name) {
		// TODO Auto-generated method stub
		return null;
	}


}
