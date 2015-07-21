package amolang_AbstractedQuery.Query.DDLQuery;

import amolang_AbstractedQuery.AbstractedQuery.AbstractedQuery;
import amolang_AbstractedQuery.ColumnType.ColumnType;

public class DDLQueryMysql extends DDLQuery {
	
	@Override
	public DDLQuery create_db(String database_identifier) {

		sql = "create database " +database_identifier +";";
		
		return this;
	}

	@Override
	public DDLQuery create_table(String table_identifier, ColumnType... column_types) {
		
		sql = "CREATE TABLE " +table_identifier +"(";
		
		for(ColumnType column_type : column_types) {
			
			sql += column_type.getColumn_identifier() +" "
					+column_type.getData_type() +" ";
			
			if(column_type.getNot_null()) 
				sql += "NOT NULL "; 
			else
				sql += "NULL ";
			
			sql += "DEFAULT " +column_type.getDefault() +",";
		}
				
		int pos = sql.lastIndexOf(",");
		sql = sql.substring(0, pos) + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
		
		return this;
	}

	@Override
	public DDLQuery create_view(String view_identifier,
			AbstractedQuery select_query) {
		
		sql = "CREATE VIEW " +view_identifier +" AS "
				+select_query.getSql();
		
		return this;
	}

	@Override
	public DDLQuery drop_table(String table_identifier) {

		sql = "DROP TABLE " +table_identifier +";";
		
		return this;
	}

	@Override
	public DDLQuery drop_view(String view_identifier) {

		sql = "DROP VIEW " +view_identifier +";";
		
		return this;
	}

	@Override
	public DDLQuery alter_table(String table_identifier) {

		sql = "ALTER TABLE " +table_identifier +" ";
		
		return this;
	}

	@Override
	public DDLQuery add_column(ColumnType column_type) {

		last_str_replace(sql, ";", ",");
		
		sql += " ADD COLUMN "
					+column_type.getColumn_identifier() +" "
					+column_type.getData_type() +" ";
		
		if(column_type.getNot_null()) 
			sql += "NOT NULL "; 
		else
			sql += "NULL ";
		
		sql += column_type.getDefault() +";";	
			
			return this;
	}

	@Override
	public DDLQuery drop_column(String column_identifier) {

		last_str_replace(sql, ";", ",");
		
		sql += " DROP COLUMN "
					+column_identifier +";";
			
			return this;
	}

	@Override
	public DDLQuery add_primarykey(String... column_identifiers) {

		last_str_replace(sql, ";", ",");
		
		sql += " ADD PRIMARY KEY (";
		for(String column_identifier : column_identifiers) {
			sql += column_identifier +",";
		}
		
		int pos = sql.lastIndexOf(",");
		sql = sql.substring(0, pos) + ");";
		
		return this;
	}

	@Override
	public DDLQuery drop_primarykey() {
		
		last_str_replace(sql, ";", ",");
		
		sql += " DROP PRIMARY KEY;";
		
		return this;
	}

	@Override
	public DDLQuery add_foreignkey(String index_identifier,
			String column_identifier_first, String table_identifier,
			String column_identifier_second) {

		last_str_replace(sql, ";", ",");
		
		sql = " ADD CONSTRAINT " +index_identifier
				+" FOREIGN KEY (" +column_identifier_first +"REFERENCES " +table_identifier 
				+" (" +column_identifier_second +");";
		
		return this;
	}

	@Override
	public DDLQuery drop_foreignkey(String index_identifier) {

		last_str_replace(sql, ";", ",");
		
		sql += " DROP FOREIGN KEY " +index_identifier +";";
		
		return this;
	}

	@Override
	public DDLQuery add_index(String index_identifier, String index_type,
			String... column_identifiers) {

		String index;
		
		last_str_replace(sql, ";", ",");
		
		if(index_type == "index" || index_type == "INDEX")
			index = "";
		else
			index = index_type;
		
		sql += " ADD " +index +" INDEX " +index_identifier +" (";
		
		for(String column_identifier : column_identifiers) {
			sql += column_identifier +",";
		}
		
		int pos = sql.lastIndexOf(",");
		sql = sql.substring(0, pos) + ");";	
	
		return this;
	}

	@Override
	public DDLQuery drop_index(String index_identifier) {

		last_str_replace(sql, ";", ",");
		
		sql += " DROP INDEX " +index_identifier +";";
		
		return this;
	}

	@Override
	public DDLQuery change_column(String column_identifier,
			ColumnType column_type) {

		last_str_replace(sql, ";", ",");
		
		sql += " CHANGE COLUMN " +column_identifier +" "
				+column_type.getColumn_identifier() +" "
				+column_type.getData_type() +" ";
		
		if(column_type.getNot_null()) 
			sql += "NOT NULL "; 
		else
			sql += "NULL ";
		
		sql += column_type.getDefault() +";";
		
		return this;
	}

	@Override
	public DDLQuery add_auto_increment(ColumnType column_type) {
		
		last_str_replace(sql, ";", ",");
		
		sql += " CHANGE COLUMN " +column_type.getColumn_identifier() +" "
				+column_type.getColumn_identifier() +" "
				+column_type.getData_type() +" ";
		
		if(column_type.getNot_null()) 
			sql += "NOT NULL "; 
		else
			sql += "NULL ";
		
		sql += "AUTO_INCREMENT;";
		
		return this;
	}
	
	@Override
	public DDLQuery handshake_auto_increment(int constant_integer_type) {
		
		sql += " AUTO_INCREMENT=" +constant_integer_type +";";
		
		return this;
	}

}
