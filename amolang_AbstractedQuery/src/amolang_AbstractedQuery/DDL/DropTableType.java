package amolang_AbstractedQuery.DDL;

import amolang_AbstractedQuery.Database.DatabaseManager;

public class DropTableType extends DatabaseManager {

	public String drop_table(String table_identifier) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query = "DROP TABLE " +table_identifier +";";
		}		
		
		return query;
	}
}
