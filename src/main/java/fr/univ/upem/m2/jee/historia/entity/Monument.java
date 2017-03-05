package fr.univ.upem.m2.jee.historia.entity;

import javax.persistence.Entity;

@Entity
public class Monument extends AbstractLocation {
	
	
	private static final long serialVersionUID = -5425067605553684478L;
	
	public Monument(){
		super();
		this.type= "Monument";

	}
	public Monument(String name){
		super(name,"Monument");
		museum = false;

	}
	public Monument(long id,String name) {
		super(id,name,"Monument");
		museum = false;
	}
	@Override
	public boolean isMuseum() {
		return false;
	}
	
	

}
