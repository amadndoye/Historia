package fr.univ.upem.m2.jee.historia.loockupService;

import java.util.List;

import fr.univ.upem.m2.jee.historia.entity.AbstractLocation;
import fr.univ.upem.m2.jee.historia.entity.Monument;

public interface IMonumentLoockUpService {
	
	public Monument getMonument(long id);
	
	public List<AbstractLocation> searchMonument(String name);


}
