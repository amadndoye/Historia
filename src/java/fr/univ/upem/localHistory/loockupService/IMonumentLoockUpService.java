package fr.univ.upem.localHistory.loockupService;

import java.util.List;

import fr.univ.upem.localHistory.beans.AbstractLocationBean;
import fr.univ.upem.localHistory.beans.MonumentBean;

public interface IMonumentLoockUpService {
	
	public MonumentBean getMonument(long id);
	
	public List<AbstractLocationBean> searchMonument(String name);


}
