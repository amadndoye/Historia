package fr.univ.upem.localHistory.configBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

@ManagedBean
public class PanelBean {

	private boolean collapsed = true;
	
	public void toggle(ActionEvent event){
		collapsed = !collapsed;
		
	}

	public boolean isCollapsed() {
		return collapsed;
	}

	public void setCollapsed(boolean collapsed) {
		this.collapsed = collapsed;
	}
}
