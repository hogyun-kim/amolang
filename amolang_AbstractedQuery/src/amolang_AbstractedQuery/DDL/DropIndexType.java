package amolang_AbstractedQuery.DDL;

import amolang_AbstractedQuery.Database.DatabaseManager;

public class DropIndexType extends DatabaseManager {

	public String drop_index(String index_identifier, String table_identifier) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query = "DROP INDEX " +index_identifier +" ON " +table_identifier +";";
		}	
				
		return query;
	}
}
