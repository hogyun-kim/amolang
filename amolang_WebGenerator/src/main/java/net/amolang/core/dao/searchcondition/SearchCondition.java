package net.amolang.core.dao.searchcondition;

public class SearchCondition {

	private String[] component_names;
	
	public void setComponent_names(String[] component_names) {
		this.component_names = component_names;
	}
	
	public String[] getComponent_names() {
		return this.component_names;
	}
	
	public int getPathCount() {
		return this.component_names.length;
	}
}
