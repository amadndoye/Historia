package fr.univ.upem.localHistory.loockupService;

import java.util.List;

import fr.univ.upem.localHistory.beans.MuseumBean;

public interface IMuseumLoockUpService extends ILocationLoockUpService {
	
	public MuseumBean getMuseum(String name);
	
	public List<MuseumBean> searchMuseum(String value, int type);

}
