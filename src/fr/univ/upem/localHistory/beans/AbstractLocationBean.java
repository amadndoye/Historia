package fr.univ.upem.localHistory.beans;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractLocationBean implements Serializable{
	
	private static final long serialVersionUID = -8824598600667342320L;
	private long id;
	private String type;
	protected double latitude;
	protected double longitude;
	private boolean museum =false ;
	
	public AbstractLocationBean (String type){
		this.type = type;
		museum = Objects.equals(this.type, "Museum");
	}
	
	public AbstractLocationBean (long id, String type){
		this.id = id;
		this.type =type;
		museum = Objects.equals(this.type, "Museum");

	}
	public String getType() {
		return type;
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
	
	public boolean isMuseum(){
		return museum;
	}
}
