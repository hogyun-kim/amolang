package amolang_AbstractedQuery.ExpressionType;

import amolang_AbstractedQuery.Database.DatabaseManager;

public class ExprType extends DatabaseManager {
	
	public String getQuery() {
		return query;
	}
	
	public void add(ExprType expr_type) {		
		query += expr_type.getQuery();
	}
	
	public ExprType and(ExprType expr_type) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += " and ";
			this.add(expr_type);			
		}
		
		return this;
	}
	
	public ExprType and(String identifier_type) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += " and '" +identifier_type +"'";		
		}
		
		return this;
	}
	
	public ExprType or(ExprType expr_type) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += " or ";
			this.add(expr_type);			
		}
		
		return this;
	}
	
	public ExprType or(String identifier_type) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += " or '" +identifier_type +"'";		
		}
		
		return this;
	}
}
