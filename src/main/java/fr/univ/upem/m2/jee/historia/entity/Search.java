package fr.univ.upem.m2.jee.historia.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.ElementCollection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Search implements Serializable{
	
        @Id
        @GeneratedValue
	private long id;

        @ManyToOne
        private Login login;
	
	private String selected_match = null;
	private String search_value;
	
        @ElementCollection(targetClass = String.class )
	private Collection<String> selected_matches ;
	
	private Long latitude;
	private Long  longitude;
	private boolean isFree;
	private String type;
	private String date ;
	
	public Search() {
		isFree = false ;
		type="Both";
		selected_matches = new ArrayList<>();
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

	public Collection<String> getSelected_matches() {
		return selected_matches;
	}

	public void setSelected_matches(Collection<String> selected_matches) {
		this.selected_matches = selected_matches;
	}

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
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
        
        
	public long getId() {
		return id;
	}

	public void setId(long userId) {
		this.id = userId;
	}
        
        public Login getLogin(){
            return login;
        }
        
        public void setLogin(Login login){
            this.login = login;
        }
        

}
