package net.amolang.core.model;

public class Component {

	private int id;
	private String name;
	private int parent_id;
	private String arg_table;
	private String arg_columns;
	private String arg_params;
	private String version;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	
	public void setArg_table(String arg_table) {
		this.arg_table = arg_table;
	}
	
	public void setArg_columns(String arg_columns) {
		this.arg_columns = arg_columns;
	}
	
	public void setArg_params(String arg_params) {
		this.arg_params = arg_params;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getParent_id() {
		return this.parent_id;
	}
	
	public String getArg_table() {
		return this.arg_table;
	}
	
	public String getArg_columns() {
		return this.arg_columns;
	}
	
	public String getArg_params() {
		return this.arg_params;
	}
	
	public String getVersion() {
		return this.version;
	}
	
	public boolean dbNecessity() {
		
		if(this.getArg_table() == null)
			return false;
		else return true;
	}
}
