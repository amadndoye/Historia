package fr.univ.upem.localHistory.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserBean implements Serializable {
	
	private static final long serialVersionUID = -6725038536217314164L;
	private String userName;
	private String password;
	private String mail; 
	private List<String> previousSearch;
	private long userId;
	
	public UserBean(){
		setPreviousSearch(new ArrayList<String>());
		
	}

	public UserBean(String userName2, String password2, String mail2) {
		this.userName = userName2;
		password = password2;
		setMail(mail2);
		setPreviousSearch(new ArrayList<String>());

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

	public List<String> getPreviousSearch() {
		return previousSearch;
	}

	public void setPreviousSearch(List<String> previousSearch) {
		this.previousSearch = previousSearch;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
