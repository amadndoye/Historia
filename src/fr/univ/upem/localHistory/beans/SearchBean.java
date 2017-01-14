package fr.univ.upem.localHistory.beans;

import java.util.List;

public class SearchBean {
	
	private List<String> selected_type;
	private String search_value;
	private List<String> selected_match ;
	private long latitude;
	private long  longitude;
	private boolean isFree;
	
	public SearchBean() {
		
	}

	public List<String> getSelected_type() {
		return selected_type;
	}

	public void setSelected_type(List<String> selected_type) {
		this.selected_type = selected_type;
	}

	public String getSearch_value() {
		return search_value;
	}

	public void setSearch_value(String search_value) {
		this.search_value = search_value;
	}

	public List<String> getSelected_match() {
		return selected_match;
	}

	public void setSelected_match(List<String> selected_match) {
		this.selected_match = selected_match;
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
}
