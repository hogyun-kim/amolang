package amolang_AbstractedQuery.Query.DDLQuery;

import amolang_AbstractedQuery.AbstractedQuery.AbstractedQuery;
import amolang_AbstractedQuery.DDL.ColumnType;
import amolang_AbstractedQuery.Query.DMLQuery.DMLQuery;

public interface DDLQuery {

	public DDLQuery create_db(String database_identifier);
	public DDLQuery create_table(String table_identifier);
	public DDLQuery create_column(ColumnType column_type);
	public DDLQuery create_view(String view_identifier, AbstractedQuery select_query);
	public DDLQuery drop_table(String table_identifier);
	public DDLQuery drop_index(String index_identifier, String table_identifier);
	public DDLQuery drop_view(String view_identifier);
	public DDLQuery alter_table(String table_identifier);
	public DDLQuery add_column(String column_identifier, ColumnType column_type);
	public DDLQuery drop_column(String column_identifier);
	public DDLQuery add_primarykey(String... column_identifiers);
	public DDLQuery drop_primarykey();
	public DDLQuery add_foreignkey(String index_identifier, String column_identifier_first, String table_identifier, String column_identifier_second);
	public DDLQuery drop_foreignkey(String index_identifier);
	public DDLQuery add_index(String index_identifier, String index_type, String... column_identifiers);
	public DDLQuery drop_index(String index_identifier);
	public DDLQuery change_column(String column_identifier, ColumnType column_type);
}
