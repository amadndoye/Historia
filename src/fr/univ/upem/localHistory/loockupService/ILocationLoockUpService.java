package fr.univ.upem.localHistory.loockupService;

import java.util.List;

import fr.univ.upem.localHistory.beans.AbstractLocationBean;

public interface ILocationLoockUpService{
	
	public long getLatitude();
	public long getLongitude();

	public List<AbstractLocationBean> findCloseLocation(long latitude, long longitude);

}
