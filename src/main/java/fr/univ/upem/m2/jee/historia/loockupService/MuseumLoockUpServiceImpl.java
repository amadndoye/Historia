package fr.univ.upem.m2.jee.historia.loockupService;

import fr.univ.upem.m2.jee.historia.dbManager.DBManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.univ.upem.m2.jee.historia.entity.AbstractLocation;
import fr.univ.upem.m2.jee.historia.entity.Museum;
import fr.univ.upem.m2.jee.historia.entity.Search;
import java.util.Collection;


public class MuseumLoockUpServiceImpl implements IMuseumLoockUpService, ILocationLoockUpService {


	private static final long serialVersionUID = -255460405361319002L;
        private  final DBManager manager;
	
	public MuseumLoockUpServiceImpl() {
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

	@Override
	public Museum getMuseum(long id) {
               return  manager.findById(Museum.class, id);
	}

	@Override
	public List<AbstractLocation> searchMuseum(Search search) {
		ArrayList <AbstractLocation> bean = new ArrayList<>();
		String match = search.getSelected_match();
		if(match == null){
			return bean;
		}
		if(search.getSearch_value()!= null || !search.getSearch_value().isEmpty()){
			String value = search.getSearch_value().toUpperCase();
			for(Museum x : getMuseums()){
				if(search.isFree()){
					if(x.isFree().equals("1")){
						continue;
					}
				}
				if(match.equals("All")){
					if((x.getName()!= null && x.getName().toUpperCase().contains(value))
					|| (x.getCity()!= null && x.getCity().toUpperCase().contains(value))
					|| (x.getThemes()!=null && x.getThemes().toUpperCase().contains(value))){	
						bean.add(x);
					}
				}else if(match.equals("City")){
					if(x.getCity()!=null && x.getCity().toUpperCase().contains(value)){
						bean.add(x);

					}

				}else if(match.equals("Name")){
					if(x.getName()!=null && x.getName().toUpperCase().contains(value)){
						bean.add(x);

					}

				}else if(match.equals("Theme")){
					if(x.getThemes()!=null && x.getThemes().toUpperCase().contains(value)){
						bean.add(x);

					}
				}
			}
		
		}
		return bean;
	}

	public Collection<Museum> getMuseums() {
		return manager.findAll(Museum.class);
	}
	
	public void init(){
		Museum a = new Museum("Mus�e de la Folie Marco", "BARR");
		a.setAdresse("30, Rue du Dr Sultzer,67140 BARR France");
		a.setCountry("France");
		a.setCodePostal(""+67140);

                Museum b = new Museum("Ecomus�e de la Grande Lande", "SABRES");
		b.setAdresse("Route de Sof�rino,40630 SABRES France");
		b.setCountry("France");
		b.setCodePostal(""+40630);


		Museum c = new Museum("Maison de la Magie", "BLOIS");
		c.setAdresse("1, Place du Ch�teau, 41000 BLOIS France");
		c.setCountry("France");
		c.setCodePostal(""+41000);


		Museum d = new Museum("Mus�e Roybet Fould", "COURBEVOIE");
		d.setAdresse("Parc de B�con 178, Boulevard Saint Denis, 92400 COURBEVOIE France");
		d.setCountry("France");
		d.setCodePostal(""+92400);
                
                manager.save(a,b,c,d);


	}


}
