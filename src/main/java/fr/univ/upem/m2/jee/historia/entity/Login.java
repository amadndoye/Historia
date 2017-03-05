package fr.univ.upem.m2.jee.historia.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;



@Entity
public class Login implements Serializable {
	
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
        @Column(nullable = false, unique = true)
	private String userName;
        
        @Column(nullable = false)
	private String password;
        
        @Column(nullable = false, unique = true)
	private String mail; 
	
        @OneToMany(mappedBy = "login")
        @Cascade(CascadeType.ALL)
	private Collection<Search> previousSearch;
	
	private boolean hasHistory;
	
	public Login(){
            super();
            previousSearch = new ArrayList<>();
		
	}

	public Login(String userName2, String password2, String mail2) {
            this.userName = userName2;
            password = password2;
            mail = mail2;
            previousSearch = new ArrayList<>();

	}
        
        public Login(Login login){
            this.id=login.id;
            this.password= login.password;
            this.mail=login.mail;
            this.userName =login.userName;
            this.previousSearch = login.previousSearch;
            this.hasHistory=login.hasHistory;
            previousSearch = new ArrayList<>();

            
        }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Search> getPreviousSearch() {
		return previousSearch;
	}

	public void setPreviousSearch(Collection<Search> previousSearch) {
		this.previousSearch = previousSearch;
		if(this.previousSearch!=null && !this.previousSearch.isEmpty()){
			hasHistory = true;
		}

	}

	public long getId() {
		return id;
	}

	public void setId(long userId) {
		this.id = userId;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public boolean isHasHistory() {
		return hasHistory;
	}

	public void setHasHistory(boolean hasHistory) {
		this.hasHistory= hasHistory;
	}

	
	
}
