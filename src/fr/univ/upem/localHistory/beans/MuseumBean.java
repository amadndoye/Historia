package fr.univ.upem.localHistory.beans;


public class MuseumBean extends AbstractLocationBean{
	

	private static final long serialVersionUID = 8200204668525482940L;
	private String name;
	private String adresse;
	private String city;
	private String department;
	private int codePostal;
	private String country;
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
	
	
	private boolean free;
		
	public MuseumBean(){
		super("Museum");
	}
	
	public MuseumBean(long id,String name ,String city){
		super(id,"Museum");
		this.name = name; 
		this.city = city;
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

}
