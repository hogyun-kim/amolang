package net.amolang.core.model;

public class DBinfo {

	private String dbtype;
	private String ip;
	private String port;
	private String dbname;
	private String username;
	private String password;
	
	public void setDbtype(String dbtype) {
		this.dbtype = dbtype;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public void setPort(String port) {
		this.port = port;
	}
	
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDbtype() {
		return this.dbtype;
	}
	
	public String getIp() {
		return this.ip;
	}
	
	public String getPort() {
		return this.port;
	}
	
	public String getDbname() {
		return this.dbname;
	}
	
	public String getUsername() {
		return this.username;		
	}
	
	public String getPassword() {
		return this.password;
	}
}
