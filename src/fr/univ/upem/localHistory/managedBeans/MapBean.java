package fr.univ.upem.localHistory.managedBeans;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

public class MapBean {
	
	private MapModel model = new DefaultMapModel();
	
	
	public MapBean() {
		model.addOverlay(new Marker(new LatLng(36, 37), "M1"));
	}
	

	public MapModel getModel(){
		return model;
	}
	
}
