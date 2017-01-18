package fr.univ.upem.localHistory.beans;

import java.util.ArrayList;
import java.util.List;



public class SearchBean {
	
	private String selected_match = null;
	private String search_field;
	private List<String> selected_matches ;
	private long latitude;
	private long  longitude;
	private boolean isFree;
	private boolean isMonument;
	private boolean isMuseum;
	
	public SearchBean() {
		selected_matches = new ArrayList<String>();
		selected_matches.add("Name");
		selected_matches.add("Region");
		selected_matches.add("Theme");
		selected_matches.add("All");

		isFree = true ;
		isMonument = true ;
		isMuseum = true;
	
	}

	public String getSearch_value() {
		return search_field;
	}

	public void setSearch_value(String search_value) {
		this.search_field = search_value;
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

	public boolean isMonument() {
		return isMonument;
	}


	public void setMonument(boolean isMonument) {
		this.isMonument = isMonument;
	}


	public boolean isMuseum() {
		return isMuseum;
	}


	public void setMuseum(boolean isMuseum) {
		this.isMuseum = isMuseum;
	}


	public String getSelected_match() {
		return selected_match;
	}


	public void setSelected_match(String selected_match) {
		this.selected_match = selected_match;
	}
}
