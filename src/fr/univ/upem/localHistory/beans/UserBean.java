package fr.univ.upem.localHistory.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserBean implements Serializable {
	
	private static final long serialVersionUID = -6725038536217314164L;
	private String userName;
	private String password;
	private String mail; 
	private List<SearchBean> previousSearch;
	private long userId;
	
	public UserBean(){
		this.previousSearch= new ArrayList<SearchBean>();
		
	}

	public UserBean(String userName2, String password2, String mail2) {
		this.userName = userName2;
		password = password2;
		setMail(mail2);
		this.previousSearch= new ArrayList<SearchBean>();

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

	public List<SearchBean> getPreviousSearch() {
		return previousSearch;
	}

	public void setPreviousSearch(List<SearchBean> previousSearch) {
		if(this.previousSearch.isEmpty()){
			this.previousSearch = previousSearch;

		}else{
			this.previousSearch.addAll(previousSearch);
		}
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
