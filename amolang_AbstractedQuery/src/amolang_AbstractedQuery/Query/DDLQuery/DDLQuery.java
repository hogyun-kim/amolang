package amolang_AbstractedQuery.Query.DDLQuery;

import amolang_AbstractedQuery.AbstractedQuery.AbstractedQuery;
import amolang_AbstractedQuery.ColumnType.ColumnType;

public abstract class DDLQuery {
	
	protected String sql;
	
	public String getSql() {
		
		return sql;
	}
	
	public void handshake() {
		
		sql = new String("");
	}
	
	public void last_str_replace(String sql, String last_str, String shift_str) {
		
		if(sql.endsWith(last_str)) {
			int pos = sql.lastIndexOf(last_str);
			this.sql = sql.substring(0, pos) + shift_str;
		}
	}
	
	public abstract DDLQuery create_db(String database_identifier);
	public abstract DDLQuery create_table(String table_identifier, ColumnType... column_types);
	public abstract DDLQuery create_view(String view_identifier, AbstractedQuery select_query);
	public abstract DDLQuery drop_table(String table_identifier);
	public abstract DDLQuery drop_view(String view_identifier);
	//여기서부터 alter_table 하위 메소드
	public abstract DDLQuery alter_table(String table_identifier);
	public abstract DDLQuery add_column(ColumnType column_type);
	public abstract DDLQuery drop_column(String column_identifier);
	public abstract DDLQuery add_primarykey(String... column_identifiers);
	public abstract DDLQuery drop_primarykey();
	public abstract DDLQuery add_foreignkey(String index_identifier, String column_identifier_first, String table_identifier, String column_identifier_second);
	public abstract DDLQuery drop_foreignkey(String index_identifier);
	public abstract DDLQuery add_index(String index_identifier, String index_type, String... column_identifiers);
	public abstract DDLQuery drop_index(String index_identifier);
	public abstract DDLQuery change_column(String column_identifier, ColumnType column_type);
	public abstract DDLQuery add_auto_increment(ColumnType column_type);
	public abstract DDLQuery handshake_auto_increment(int constant_integer_type);
}
