package fr.univ.upem.localHistory.loockupService;

import java.io.Serializable;
import java.util.List;

import fr.univ.upem.localHistory.beans.AbstractLocationBean;

public interface ILocationLoockUpService extends Serializable{
	
	public long getLatitude();
	public long getLongitude();

	public List<AbstractLocationBean> findCloseLocation(long latitude, long longitude);

}
