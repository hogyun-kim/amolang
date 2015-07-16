package amolang_AbstractedQuery.DML;

public class UpdateStmtQuery extends WhereStmtQuery {

	public UpdateStmtQuery update(String table_identifier) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			query += "update " +table_identifier +" ";
		}
		
		return this;
	}
	
	public UpdateStmtQuery update(SelectStmtQuery select_query) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			query += "update ";
			
			this.add(select_query);
		}

		return this;
	}
	
	public UpdateStmtQuery set(String column_identifier, String constant_type) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				query = query.replace(';', ',');
				query += column_identifier +" = " +"'" +constant_type +"';";
			}
			else {
				query = query.replace("into", "");
				query += "set " +column_identifier +" = " +"'" +constant_type +"';";
			}					
		}
		
		return this;
	}
	
	public UpdateStmtQuery set(String... constant_types) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {

			query += "values (";
			
			for(String constant_type : constant_types) {
				query += "'" +constant_type +"',";
			}
			
			int pos = query.lastIndexOf(",");
			query = query.substring(0, pos) + ");";
		}		
		
		return this;
	}
}
