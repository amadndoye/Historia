package fr.univ.upem.localHistory.loockupService;

import java.util.List;

import fr.univ.upem.localHistory.beans.MonumentBean;

public interface IMonumentLoockUpService {
	
	public MonumentBean getMonument(String name);
	
	public List<MonumentBean> searchMonument(String name);

}
