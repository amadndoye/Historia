package fr.univ.upem.localHistory.loockupService;

import java.util.List;

import fr.univ.upem.localHistory.beans.AbstractLocationBean;
import fr.univ.upem.localHistory.beans.MuseumBean;
import fr.univ.upem.localHistory.beans.SearchBean;

public interface IMuseumLoockUpService extends ILocationLoockUpService {
	
	public MuseumBean getMuseum(long id);
	
	public List<AbstractLocationBean> searchMuseum(SearchBean value);
	

}
