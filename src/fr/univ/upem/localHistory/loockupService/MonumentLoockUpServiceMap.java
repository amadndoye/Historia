package fr.univ.upem.localHistory.loockupService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import fr.univ.upem.localHistory.beans.ILocationBean;
import fr.univ.upem.localHistory.beans.MonumentBean;
import fr.univ.upem.localHistory.beans.MuseumBean;


public class MonumentLoockUpServiceMap implements IMuseumLoockUpService, ILocationLoockUpService {

private Map<String,MonumentBean> monuments ;
	
	public MonumentLoockUpServiceMap() {
		monuments = new HashMap<String, MonumentBean>();
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
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String,MonumentBean> getMonuments() {
		return monuments;
	}


}