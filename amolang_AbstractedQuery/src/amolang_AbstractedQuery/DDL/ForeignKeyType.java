package amolang_AbstractedQuery.DDL;

import amolang_AbstractedQuery.Database.DatabaseManager;

public class ForeignKeyType extends DatabaseManager {

	public ForeignKeyType create_fk(String index_identfier, String column_identifier_first, String table_identifier, String column_identifier_second) {
			
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query = "CONSTRAINT " +index_identfier +" FOREIGN KEY (" +column_identifier_first
					+"REFERENCES " +table_identifier +" (" +column_identifier_second +")";
		}
		
		return this;
	}
	
	public ForeignKeyType add_fk(String index_identfier_old, String index_identfier_new,
			String column_identifier_first, String table_identifier, String column_identifier_second) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query = "ADD CONSTRAINT " +index_identfier_new
					+" FOREIGN KEY (" +column_identifier_first +"REFERENCES " +table_identifier 
					+" (" +column_identifier_second +")";
		}
		
		return this;
	}
	
	public String getQuery() {
		return query;
	}
}
