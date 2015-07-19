package amolang_AbstractedQuery.DDL;

import amolang_AbstractedQuery.Database.DatabaseManager;

public class IndexType extends DatabaseManager {

	public IndexType create_index(String index_identifier, String index_type, 
			String table_identifier, String... column_identifiers) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			String index;
			
			if(index_type == "index" || index_type == "INDEX")
				index = "";
			else
				index = index_type;
			
			query = index +" INDEX " +index_identifier +" (";
			for(String column_identifier : column_identifiers) {
				query += column_identifier +",";
			}
			
			int pos = query.lastIndexOf(",");
			query = query.substring(0, pos) + ")";	
		}
				
		return this;
	}
	
	public IndexType add_index(String index_identifier, String index_type, 
			String table_identifier, String... column_identifiers) {
				
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			String index;
			
			if(index_type == "index" || index_type == "INDEX")
				index = "";
			else
				index = index_type;
			
			query = "ADD " +index +" INDEX " +index_identifier +" (";
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
