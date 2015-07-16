package amolang_AbstractedQuery.DDL;

import amolang_AbstractedQuery.Database.DatabaseManager;

public class PrimaryKeyType extends DatabaseManager {

	public PrimaryKeyType create_pk(String... column_identifiers) {
	
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query = "PRIMARY KEY (";
			for(String column_identifier : column_identifiers) {
				query += column_identifier +",";
			}
			
			int pos = query.lastIndexOf(",");
			query = query.substring(0, pos) + ")";
		}
		
		return this;
	}
	
	public PrimaryKeyType add_pk(String... column_identifiers) {
	
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query = "ADD PRIMARY KEY (";
			for(String column_identifier : column_identifiers) {
				query += column_identifier +",";
			}
			
			int pos = query.lastIndexOf(",");
			query = query.substring(0, pos) + ")";
		}
		
		return this;
	}
	
	public String getQuery() {
		return query;
	}
}
