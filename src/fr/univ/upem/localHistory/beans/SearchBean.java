package fr.univ.upem.localHistory.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class SearchBean implements Serializable{
	
	
	private static final long serialVersionUID = -7847882994427618448L;
	private String selected_match = null;
	private String search_value;
	private List<String> selected_matches ;
	private long latitude;
	private long  longitude;
	private boolean isFree;
	private String type;
	private String date ;
	
	public SearchBean() {
		isFree = true ;
		type="Both";
		selected_matches = new ArrayList<String>();
		selected_matches.add("All");
		selected_matches.add("Name");
		selected_matches.add("City");
		selected_matches.add("Theme");
	
	}

	public String getSearch_value() {
		return search_value;
	}

	public void setSearch_value(String search_value) {
		this.search_value = search_value;
	}

	public List<String> getSelected_matches() {
		return selected_matches;
	}

	public void setSelected_matches(List<String> selected_matches) {
		this.selected_matches = selected_matches;
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

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public String getSelected_match() {
		return selected_match;
	}


	public void setSelected_match(String selected_match) {
		this.selected_match = selected_match;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
