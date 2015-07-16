package amolang_AbstractedQuery.DML;

import amolang_AbstractedQuery.ExpressionType.ExprType;

public class WhereStmtQuery extends DMLQuery {

	public WhereStmtQuery where(ExprType expr_type) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				query = query.replace(";", " ");
				query += "where ";
			}
			else {
				query += " where ";
			}	
			this.add(expr_type);
			query += ";";
		}		
		
		return this;
	}
	
	public WhereStmtQuery where(WhereStmtQuery where_query) {
		
		if(db == Database.valueOf("oracle")) {
		
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				query = query.replace(";", " ");
				query += "where ";
			}
			else {
				query += " where ";
			}	
			this.add(where_query);
		}		
		
		return this;
	}
	
	public WhereStmtQuery between(String identifier_type, String constant_type_first, String constant_type_second) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += identifier_type +" between '" +constant_type_first +"' and '" +constant_type_second +"';";
		}		
		
		return this;
	}
	
	public WhereStmtQuery not_between(String identifier_type, String constant_type_first, String constant_type_second) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += identifier_type +" not between '" +constant_type_first +"' and '" +constant_type_second +"';";
		}		
		
		return this;
	}
	
	public WhereStmtQuery in(String identifier_type, String... constant_types) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += identifier_type +" in (";
			for(String constant_type : constant_types) {
				query += "'" +constant_type +"',";
			}
			
			int pos = query.lastIndexOf(",");
			query = query.substring(0, pos) + ");";
		}		
		
		return this;
	}
	
	public WhereStmtQuery in(String identifier_type, SelectStmtQuery select_query) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += identifier_type +" in (";
			this.add(select_query);
			
			if(query.endsWith(";")) {
				query = query.replace(';', ')');
				query += ";";
			}
			else {
				query += ");";
			}	
		}		
		
		return this;
	}
	
	public WhereStmtQuery not_in(String identifier_type, String... constant_types) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += identifier_type +" not in (";
			for(String constant_type : constant_types) {
				query += "'" +constant_type +"',";
			}
			
			int pos = query.lastIndexOf(",");
			query = query.substring(0, pos) + ");";
		}		
		
		return this;
	}
	
	public WhereStmtQuery not_in(String identifier_type, SelectStmtQuery select_query) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += identifier_type +" not in (";
			this.add(select_query);
			
			if(query.endsWith(";")) {
				query = query.replace(';', ')');
				query += ";";
			}
			else {
				query += ");";
			}	
		}		
		
		return this;
	}
	
	public WhereStmtQuery like(String identifier_type, String constant_type) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += identifier_type +"like '" +constant_type +"';";
		}		
		
		return this;
	}
	
}
