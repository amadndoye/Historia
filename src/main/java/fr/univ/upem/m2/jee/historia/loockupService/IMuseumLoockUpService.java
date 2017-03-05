package fr.univ.upem.m2.jee.historia.loockupService;

import java.util.List;

import fr.univ.upem.m2.jee.historia.entity.AbstractLocation;
import fr.univ.upem.m2.jee.historia.entity.Museum;
import fr.univ.upem.m2.jee.historia.entity.Search;

public interface IMuseumLoockUpService extends ILocationLoockUpService {
	
	public Museum getMuseum(long id);
	
	public List<AbstractLocation> searchMuseum(Search value);
	

}
