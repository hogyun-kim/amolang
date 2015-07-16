package amolang_AbstractedQuery.DDL;

import amolang_AbstractedQuery.Database.DatabaseManager;

public class AlterTableType extends DatabaseManager {

	public AlterTableType alter_table(String table_identifier) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query = "ALTER TABLE " +table_identifier;
		}		
		
		return this;
	}
	
	public AlterTableType add_column(String column_identifier,
			ColumnType column_type) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				int pos = query.lastIndexOf(";");
				query = query.substring(0, pos) + ",";
			}
				query += " ADD COLUMN "
						+column_identifier +" "
						+column_type.getDatatype() +" "
						+column_type.getNotnull() +" "
						+column_type.getAuto_increment() +" "
						+column_type.getDefault() +";";			
		}
		
		return this;
	}
	
	public AlterTableType drop_column(String column_identifier) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				int pos = query.lastIndexOf(";");
				query = query.substring(0, pos) + ",";
			}
				query += " DROP COLUMN "
						+column_identifier +";";		
		}
		
		return this;
	}
}
