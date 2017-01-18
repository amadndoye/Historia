package fr.univ.upem.localHistory.beans;


public class MonumentBean extends AbstractLocationBean {
	
	private String name;
		
	public MonumentBean(){
		super("Monument");
	}
	public MonumentBean(long id,String name, String string2) {
		super(id, "Monument");
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		

}
