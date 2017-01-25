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
	public void init() {

		currentId = 0 ; 
		monuments.put(currentId,new MonumentBean(currentId,"La Statue de la Liberté", "ILE-DE-FRANCE"));
		monuments.get(currentId).setLatitude(40.689249);
		monuments.get(currentId).setLongitude(-74.0445);
		currentId++;
		monuments.put(currentId,new MonumentBean(currentId,"Palais de L'élysé", "ILE-DE-FRANCE"));
		monuments.get(currentId).setLatitude(48.870416);
		monuments.get(currentId).setLongitude(2.316754);
		currentId++;

		monuments.put(currentId,new MonumentBean(currentId,"Opéra de National", "DIJON"));
		monuments.get(currentId).setLatitude(44.842507);
		monuments.get(currentId).setLongitude(-0.574178);
		currentId++;

		monuments.put(currentId,new MonumentBean(currentId,"Basilique de Saint-Michel", "LA MACHINE"));
		monuments.get(currentId).setLatitude(44.834401);
		monuments.get(currentId).setLongitude(-0.565021);
		currentId++;
	}
	


}
