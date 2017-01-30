package fr.univ.upem.localHistory.beans;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractLocationBean implements Serializable{
	
	private static final long serialVersionUID = -8824598600667342320L;
	private long id;
	private double latitude;
	private double longitude;
	protected boolean museum;
	private String name;
	private String adresse;
	private String type;

	
	public AbstractLocationBean (String name, String type){
		Objects.requireNonNull(name);
		this.name=name;
		this.type = type;
	}
	
	public AbstractLocationBean (long id,String name,String type){
		Objects.requireNonNull(name);
		if(id< 0){
			throw new IllegalArgumentException();
		}
		this.id = id;
		this.name=name;
		this.type = type;




	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double d) {
		this.latitude = d;
	}

	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
	public abstract boolean isMuseum();

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
