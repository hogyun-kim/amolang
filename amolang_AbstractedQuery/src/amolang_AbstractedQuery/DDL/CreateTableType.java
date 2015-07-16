package amolang_AbstractedQuery.DDL;

import java.util.HashMap;
import java.util.Map;

import amolang_AbstractedQuery.Database.DatabaseManager;

public class CreateTableType extends DatabaseManager {

	private Map<String, ColumnType> columnList;
	
	public CreateTableType() {
		columnList = new HashMap<String, ColumnType>();
	}
	
	public CreateTableType create_table(String table_identifier) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query = "CREATE TABLE " +table_identifier +"(";
			
			for(Map.Entry<String, ColumnType> column : columnList.entrySet()) {
				
				ColumnType col_data = column.getValue();
				
				query += column.getKey() +" " 
						+col_data.getDatatype() +" "
						+col_data.getNotnull() +" "
						+col_data.getAuto_increment() +" "
						+col_data.getDefault() +",";
				if(col_data.getPrimarykey() != null)
					query += col_data.getPrimarykey() +",";
				if(col_data.getUnique() != null)
					query += col_data.getUnique() +",";
				if(col_data.getForeignkey() != null)
					query += col_data.getForeignkey() +",";			
			}
			
			if(query.endsWith(",")) {
				query = query.replace(",", " ");
				query += ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
			}
			else {
				query += ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
			}
			
		}
				
		return this;
	}
	
	public CreateTableType add_column(String column_identifier,
			ColumnType column_type) {
		
		columnList.put(column_identifier, column_type);
		
		return this;
	}
}
