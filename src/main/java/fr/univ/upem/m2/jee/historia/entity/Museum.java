package fr.univ.upem.m2.jee.historia.entity;

import com.univocity.parsers.annotations.Parsed;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Museum extends AbstractLocation {
   
        @Parsed(field = "lieuAdresse",defaultNullRead = "0")
        @Column(length = 5000)
        private String street;
        @Parsed(field = "lieuCommune",defaultNullRead = "0")
        private String city;
        
        @Parsed(field = "lieuRegion",defaultNullRead = "0")        
	private String department;
	
        @Parsed(field = "lieuCodePostal",defaultNullRead = "0")
        private String codePostal;
	
        @Parsed(field = "lieuPays",defaultNullRead = "0")
        private String country;
	
        @Parsed(field = "lieuTelPublic",defaultNullRead = "0")
        private String phone;

       @Parsed(field = "lieuAcces",defaultNullRead = "0")
        @Column(length = 5000)
       private String acces;
	
        @Parsed(field = "lieuCourriel",defaultNullRead = "0")
        private String mail;
	
        @Parsed(field = "lieuSiteInternet",defaultNullRead = "0")
        @Column(length = 2000)
        private String website ; 
	
        @Parsed(field = "lieuFacebook",defaultNullRead = "0")
        private String facebookLink;
	
        @Parsed(field = "lieuTwitter",defaultNullRead = "0")
        @Column(length = 2000)
        private String twitterLink; 
	
	@Parsed(field = "titre",defaultNullRead = "0")
        @Column(length = 5000)
        private String title ; 
	
        @Parsed(field = "lieuDescriptifLong",defaultNullRead = "0")
        @Column(length = 5000)
        private String descriptionLong;
	
        @Parsed(field = "descriptif",defaultNullRead = "0")
        @Column(length = 5000)
        private String decriptionShort ;
	
        @Parsed(field = "gratuit")
	private String free;
		
        @Parsed(field = "themes",defaultNullRead = "0")
        @Column(length = 5000)
        private String themes;

	public Museum(){
                super();
		this.type = "Museum";
	}
       
	public Museum(String name){
		super(name,"Museum");
		museum = true;

	}
	
	public Museum(long id,String name ,String city){
		super(id,name,"Museum");
		this.city = city;
		museum = true;

	}
        public Museum(String name ,String city){
		super(name,"Museum");
		this.city = city;
		museum = true;

	}
        
	
	public String getRegion() {
		return department;
	}
	public void setRegion(String region) {
		this.department = region;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String lieuCodePostal) {
		this.codePostal = lieuCodePostal;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	
	
	public String isFree() {
		return free;
	}
	public void setFree(String free) {
		this.free = free;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
        
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    @Override
	public boolean isMuseum() {
		return true;
	}
   
}
