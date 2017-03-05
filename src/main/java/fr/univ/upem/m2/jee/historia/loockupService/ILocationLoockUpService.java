package fr.univ.upem.m2.jee.historia.loockupService;

import java.io.Serializable;
import java.util.List;

import fr.univ.upem.m2.jee.historia.entity.AbstractLocation;

public interface ILocationLoockUpService extends Serializable{
	
	public long getLatitude();
	public long getLongitude();

	public List<AbstractLocation> findCloseLocation(long latitude, long longitude);

}
