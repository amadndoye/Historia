package fr.univ.upem.localHistory.beans;


public class MonumentBean extends AbstractLocationBean {
	
	
	private static final long serialVersionUID = -5425067605553684478L;
		
	public MonumentBean(String name){
		super(name,"Monument");
		museum = false;

	}
	public MonumentBean(long id,String name) {
		super(id,name,"Monument");
		museum = false;
	}
	@Override
	public boolean isMuseum() {
		return false;
	}
	
	

}
