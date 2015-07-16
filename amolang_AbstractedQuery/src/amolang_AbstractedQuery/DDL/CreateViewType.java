package amolang_AbstractedQuery.DDL;

import amolang_AbstractedQuery.DML.SelectStmtQuery;
import amolang_AbstractedQuery.Database.DatabaseManager;

public class CreateViewType extends DatabaseManager {

	public String create_view(String view_identifier, SelectStmtQuery select_query) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query = "CREATE VIEW " +view_identifier +" AS "
					+select_query.getQuery();
		}		
		
		return query;
	}
}
