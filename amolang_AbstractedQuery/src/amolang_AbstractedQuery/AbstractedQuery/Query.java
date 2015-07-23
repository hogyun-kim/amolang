package amolang_AbstractedQuery.AbstractedQuery;

import amolang_AbstractedQuery.ColumnType.ColumnType;
import amolang_AbstractedQuery.ExprType.ExprType;

public interface Query {

	//DDLQuery
	public abstract AbstractedQuery create_db(String database_identifier);
	public abstract AbstractedQuery create_table(String table_identifier, ColumnType... column_types);
	public abstract AbstractedQuery create_view(String view_identifier, AbstractedQuery select_query);
	public abstract AbstractedQuery drop_table(String table_identifier);
	public abstract AbstractedQuery drop_view(String view_identifier);
	//여기서부터 alter_table 하위 메소드
	public abstract AbstractedQuery alter_table(String table_identifier);
	public abstract AbstractedQuery add_column(ColumnType column_type);
	public abstract AbstractedQuery drop_column(String column_identifier);
	public abstract AbstractedQuery add_primarykey(String... column_identifiers);
	public abstract AbstractedQuery drop_primarykey();
	public abstract AbstractedQuery add_foreignkey(String index_identifier, String column_identifier_first, String table_identifier, String column_identifier_second);
	public abstract AbstractedQuery drop_foreignkey(String index_identifier);
	public abstract AbstractedQuery add_index(String index_identifier, String index_type, String... column_identifiers);
	public abstract AbstractedQuery drop_index(String index_identifier);
	public abstract AbstractedQuery change_column(String column_identifier, ColumnType column_type);
	public abstract AbstractedQuery add_auto_increment(ColumnType column_type);
	public abstract AbstractedQuery handshake_auto_increment(int constant_integer_type);

	//DMLQuery
		//SelectStmtQuery
		public abstract AbstractedQuery select();
		public abstract AbstractedQuery select(String column_identifier_or_function, String alias);
		public abstract AbstractedQuery select(String... column_identifier_or_functions);
		public abstract AbstractedQuery select(ExprType expr_type_or_function, String alias);
		public abstract AbstractedQuery from(String table_identifier);
		public abstract AbstractedQuery from(AbstractedQuery select_query);
		public abstract AbstractedQuery from(String table_identifier, String alias);
		public abstract AbstractedQuery from(AbstractedQuery select_query, String alias);
		public abstract AbstractedQuery orderby(String asc_or_desc, String... column_identfiers);
		public abstract AbstractedQuery orderby(String... column_identfiers);
		public abstract AbstractedQuery limit(int constant_integer_type);
		public abstract AbstractedQuery inner_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second);
		public abstract AbstractedQuery left_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second);
		public abstract AbstractedQuery right_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second);
		public abstract AbstractedQuery full_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second);
		public abstract AbstractedQuery union(AbstractedQuery select_query_first, AbstractedQuery select_query_second);
		public abstract AbstractedQuery union_all(AbstractedQuery select_query_first, AbstractedQuery select_query_second);
		public abstract AbstractedQuery into(String table_identifier);
		public abstract AbstractedQuery group_by(String column_identfier);
		public abstract AbstractedQuery having(ExprType expr_type_or_function);
		public abstract AbstractedQuery having(String function);
		
		//UpdateStmtQuery
		public abstract AbstractedQuery update(String table_identifier);
		public abstract AbstractedQuery update(AbstractedQuery select_query);
		public abstract AbstractedQuery set(String column_identifier, String constant_type);
		public abstract AbstractedQuery set(String... constant_types);
		
		//InsertStmtQuery (UpdateStmtQuery의 set 메소드 2개 같이 사용)
		public abstract AbstractedQuery insert(String table_identifier);
		public abstract AbstractedQuery set(AbstractedQuery select_query);
		public abstract AbstractedQuery set(AbstractedQuery select_query, String... column_identifiers);
		
		//DeleteStmtQuery (from은 SelectStmtQuery 부분 걸 같이 사용)
		public abstract AbstractedQuery delete();
		
		//WhereStmtQuery
		public abstract AbstractedQuery where(ExprType expr_type);
		public abstract AbstractedQuery where(AbstractedQuery where_query);
		public abstract AbstractedQuery between(String identifier_type, String constant_type_first, String constant_type_second);
		public abstract AbstractedQuery not_between(String identifier_type, String constant_type_first, String constant_type_second);
		public abstract AbstractedQuery in(String identifier_type, String... constant_types);
		public abstract AbstractedQuery in(String identifier_type, AbstractedQuery select_query);
		public abstract AbstractedQuery not_in(String identifier_type, String... constant_types);
		public abstract AbstractedQuery not_in(String identifier_type, AbstractedQuery select_query);
		public abstract AbstractedQuery like(String identifier_type, String constant_type);
}
