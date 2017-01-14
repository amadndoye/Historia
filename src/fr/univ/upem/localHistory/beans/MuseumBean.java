package fr.univ.upem.localHistory.beans;

public class MuseumBean implements ILocationBean{
	private String name;
	private String adresse;
	private String commune;
	private String region;
	private int lieuCodePostal;
	private String pays;
	private String phone;

	private String acces;
	private String mail;
	private String website ; 
	private String facebookLink;
	private String twitterLink; 
	
	private String title ; 
	private String descriptionLong;
	private String decriptionShort ;
	private String themes;

	private String horaires ;
	private long latitude;
	private long longitude;
	
	private boolean gratuit;
	
	public MuseumBean(){
		
	}
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
	public String getCommune() {
		return commune;
	}
	public void setCommune(String commune) {
		this.commune = commune;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getLieuCodePostal() {
		return lieuCodePostal;
	}
	public void setLieuCodePostal(int lieuCodePostal) {
		this.lieuCodePostal = lieuCodePostal;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
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
	public boolean isGratuit() {
		return gratuit;
	}
	public void setGratuit(boolean gratuit) {
		this.gratuit = gratuit;
	}
	
}
