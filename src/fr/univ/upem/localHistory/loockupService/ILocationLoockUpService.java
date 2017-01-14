package fr.univ.upem.localHistory.loockupService;

import java.util.List;

import fr.univ.upem.localHistory.beans.ILocationBean;

public interface ILocationLoockUpService{
	
	public long getLatitude();
	public long getLongitude();

	public List<ILocationBean> findCloseLocation(long latitude, long longitude);

}
