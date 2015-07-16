package amolang_AbstractedQuery.DML;

public class InsertStmtQuery extends DMLQuery {

	//TODO insert(SelectStmtQuery select_query) 이거 필요한가?
	
	public InsertStmtQuery insert(String table_identifier) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			query += "insert into " +table_identifier +" ";
		}
		
		return this;
	}
	
	public InsertStmtQuery set(String column_identifier, String constant_type) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				query = query.replace(';', ',');
				query += column_identifier +" = " +"'" +constant_type +"';";
			}
			else {
				query = query.replace("into ", "");
				query += "set " +column_identifier +" = " +"'" +constant_type +"';";
			}					
		}
		
		return this;
	}
	
	public InsertStmtQuery set(String... constant_types) {
		
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
	
	public InsertStmtQuery set(SelectStmtQuery select_query) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			this.add(select_query);
		}
				
		return this;
	}
	
	public InsertStmtQuery set(SelectStmtQuery select_query, String... column_identifiers) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += "(";
			
			for(String column_identifier : column_identifiers) {
				query += "'" +column_identifier +"',";
				
				if(!select_query.getQuery().contains(column_identifier)) {
					//TODO 예외처리
				}
			}
			
			int pos = query.lastIndexOf(",");
			query = query.substring(0, pos) + ") ";
			
			this.add(select_query);
		}
				
		return this;
	}
}
