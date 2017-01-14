package fr.univ.upem.localHistory.beans;

public class MonumentBean implements ILocationBean {
	
	private String name;
	private long latitude; 
	private long longitude;
	
	
	public MonumentBean(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getLatitude() {
		return latitude;
	}
	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}
	public long getLongitude() {
		return longitude;
	}
	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

}