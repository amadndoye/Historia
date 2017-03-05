package fr.univ.upem.m2.jee.historia.entity;

import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.annotations.Replace;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class AbstractLocation implements Serializable{
	
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
                
        @Parsed(field = "lieuLatitude")
        @Replace(expression = ",",replacement = ".")
	private double latitude;
        @Parsed(field = "lieuLongitude")
        @Replace(expression = ",",replacement = ".")
	private double longitude;
        @Parsed(field = "lieuNom")
        @Column(length = 1000)
	private String name;
        
        
	protected boolean museum;
        
        @Column(length = 5000)
	private String adresse;
	protected String type;


	protected AbstractLocation(){
	}
	
	public AbstractLocation (String name, String type){
		Objects.requireNonNull(name);
		this.name=name;
		this.type = type;
	}
	
	public AbstractLocation (long id,String name,String type){
		Objects.requireNonNull(name);
		if(id< 0){
			throw new IllegalArgumentException();
		}
		this.id = id;
		this.name=name;
		this.type = type;

	}
	
	
	public AbstractLocation(String type) {
		Objects.requireNonNull(name);

		this.type = type;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double d) {
		this.latitude = d;
	}

	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
	public boolean isMuseum(){
		return Objects.equals(type,"Museum");
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

	public String getType() {
		return type;
        }

	public void setType(String type) {
		this.type = type;
	}
        
        public boolean arrouMe(double latitude, double longitude , double distance){
                
            return getDistance(latitude,longitude) <= distance;
        }
        
        public double  getDistance(double x , double y){
           double x1 = Math.toRadians( x);
           double y1= y;
           double x2 = Math.toRadians(latitude);
           double y2 = longitude;
           
           double teta = Math.toRadians(y1-y2);
           
           double distance = Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(teta) ;
           distance = Math.acos(distance);
           distance = Math.toDegrees(distance);
           distance = distance *60 *1.1515 * 1.609344 ;
          
           return Double.parseDouble((distance+"").substring(0, (distance+"").indexOf('.')+3));
        }
}
