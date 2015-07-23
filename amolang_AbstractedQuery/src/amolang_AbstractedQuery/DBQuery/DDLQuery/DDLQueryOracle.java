package amolang_AbstractedQuery.DBQuery.DDLQuery;

import amolang_AbstractedQuery.AbstractedQuery.AbstractedQuery;
import amolang_AbstractedQuery.ColumnType.ColumnType;

public class DDLQueryOracle extends DDLQuery {

	@Override
	public DDLQuery create_db(String database_identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DDLQuery create_table(String table_identifier, ColumnType... column_types) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DDLQuery create_view(String view_identifier,
			AbstractedQuery select_query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DDLQuery drop_table(String table_identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DDLQuery drop_view(String view_identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DDLQuery alter_table(String table_identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DDLQuery add_column(ColumnType column_type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DDLQuery drop_column(String column_identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DDLQuery add_primarykey(String... column_identifiers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DDLQuery drop_primarykey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DDLQuery add_foreignkey(String index_identifier,
			String column_identifier_first, String table_identifier,
			String column_identifier_second) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DDLQuery drop_foreignkey(String index_identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DDLQuery add_index(String index_identifier, String index_type,
			String... column_identifiers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DDLQuery drop_index(String index_identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DDLQuery change_column(String column_identifier,
			ColumnType column_type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DDLQuery add_auto_increment(ColumnType column_type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DDLQuery handshake_auto_increment(int constant_integer_type) {
		// TODO Auto-generated method stub
		return null;
	}
}
