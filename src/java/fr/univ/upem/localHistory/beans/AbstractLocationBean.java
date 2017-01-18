package fr.univ.upem.localHistory.beans;

public abstract class AbstractLocationBean {
	private long id;
	private String type;
	protected long latitude;
	protected long longitude;
	
	public AbstractLocationBean (String type){
		this.type = type;
	}
	
	public AbstractLocationBean (long id, String type){
		this.id = id;
		this.type =type;
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
