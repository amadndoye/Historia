/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ.upem.localHistory.database;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author bryan
 */
@Entity
@Table(name = "MUSEUM")
public class Museum implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="NAME", length=64)
    private String name;
    @Column(name="ADDRESS", length=64)
	private String address;
    @Column(name="CITY", length=64)
	private String city;
    @Column(name="DEPARTMENT", length=32)
	private String department;
    @Column(name="POSTALCODE")
	private int codePostal;
    @Column(name="COUNTRY", length=64)
	private String country;
    @Column(name="PHONE", length=12)
	private String phone;

    @Column(name="ACESS", length=64)
	private String acces;
    @Column(name="MAIL", length=64)
	private String mail;
    @Column(name="WEBSITE", length=64) 
	private String website ; 
    @Column(name="FACEBOOKLINK", length=64)
	private String facebookLink;
    @Column(name="TWITTERLINK", length=64)
	private String twitterLink; 
	
    @Column(name="TITLE", length=32)
	private String title ; 
    @Column(name="DESCRIPTIONLONG",length=1024)
	private String descriptionLong;
    @Column(name="DESCRIPTIONSHORT", length=256)
	private String decriptionShort ;
    @Column(name="THEMES", length=128)
	private String themes;

    @Column(name="HOURS")
	private String horaires ;
	
    @Column(name="FREE")
	private boolean free;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegion() {
		return department;
	}
	public void setRegion(String region) {
		this.department = region;
	}
	public int getLieuCodePostal() {
		return codePostal;
	}
	public void setLieuCodePostal(int lieuCodePostal) {
		this.codePostal = lieuCodePostal;
	}
	public String getPays() {
		return country;
	}
	public void setPays(String pays) {
		this.country = pays;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAcces() {
		return acces;
	}
	public void setAcces(String acces) {
		this.acces = acces;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getFacebookLink() {
		return facebookLink;
	}
	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}
	public String getTwitterLink() {
		return twitterLink;
	}
	public void setTwitterLink(String twitterLink) {
		this.twitterLink = twitterLink;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescriptionLong() {
		return descriptionLong;
	}
	public void setDescriptionLong(String descriptionLong) {
		this.descriptionLong = descriptionLong;
	}
	public String getDecriptionShort() {
		return decriptionShort;
	}
	public void setDecriptionShort(String decriptionShort) {
		this.decriptionShort = decriptionShort;
	}
	public String getThemes() {
		return themes;
	}
	public void setThemes(String themes) {
		this.themes = themes;
	}
	public String getHoraires() {
		return horaires;
	}
	public void setHoraires(String horaires) {
		this.horaires = horaires;
	}
	
	public boolean isFree() {
		return free;
	}
	public void setFree(boolean free) {
		this.free = free;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Museum)) {
            return false;
        }
        Museum other = (Museum) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.univ.upem.localHistory.database.Museum[ id=" + id + " ]";
    }
    
}
