package amolang_AbstractedQuery.DDL;

import amolang_AbstractedQuery.Database.DatabaseManager;

public class CreateDatabaseType extends DatabaseManager {
	
	public String create_db(String database_identifier) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query = "create database " +database_identifier +";";
		}
		
		return query;
	}
}
