package fr.univ.upem.m2.jee.historia.loockupService;

import fr.univ.upem.m2.jee.historia.dbManager.DBManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.univ.upem.m2.jee.historia.entity.AbstractLocation;
import fr.univ.upem.m2.jee.historia.entity.Monument;
import java.util.Collection;


public class MonumentLoockUpServiceImpl implements IMonumentLoockUpService, ILocationLoockUpService {


	private static final long serialVersionUID = -1591550952675046727L;
        private  final DBManager manager;

	public MonumentLoockUpServiceImpl() {
            manager = new DBManager();

	}
	@Override
	public long getLatitude() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLongitude() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AbstractLocation> findCloseLocation(long latitude, long longitude) {
		// TODO Auto-generated method stub
		return null;
	}


	public Collection<Monument> getMonuments() {
		return manager.findAll(Monument.class);
	}
	@Override
	public Monument getMonument(long id) {
		return manager.findById(Monument.class,id);
	}
	@Override
	public List<AbstractLocation> searchMonument(String name) {
		ArrayList <AbstractLocation> bean = new ArrayList<>();
		for(Monument x : getMonuments()){
			if(x.getName()!=null && x.getName().toUpperCase().contains(name.toUpperCase())){
				bean.add(x);
			}
		}
		return bean;
	}
	public void init() {

		Monument a = new Monument("La Statue de la Libert�");
		a.setLatitude(40.689249);
		a.setLongitude(-74.0445);

                
                Monument b = new Monument("Palais de L'�lys�");
		b.setLatitude(48.870416);
		b.setLongitude(2.316754);

		Monument c = new Monument("Op�ra de National");
		c.setLatitude(44.842507);
		c.setLongitude(-0.574178);

		Monument d = new Monument("Basilique de Saint-Michel");
		d.setLatitude(44.834401);
		d.setLongitude(-0.565021);
                
                manager.save(a,b,c,d);

	}
	


}
