package amolang_AbstractedQuery.DDL;

import amolang_AbstractedQuery.Database.DatabaseManager;

public class DropViewType extends DatabaseManager {

	public String drop_view(String view_identifier) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query = "DROP VIEW " +view_identifier +";";
		}		
		
		return query;
	}
}
