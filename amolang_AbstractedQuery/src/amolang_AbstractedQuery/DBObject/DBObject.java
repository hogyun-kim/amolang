package amolang_AbstractedQuery.DBObject;

import amolang_AbstractedQuery.AbstractedQuery.AbstractedQuery;
import amolang_AbstractedQuery.ExpressionType.ExprType;
import amolang_AbstractedQuery.Query.Query;
import amolang_AbstractedQuery.Query.DDLQuery.ColumnType;



public abstract class DBObject {

	private Query query;
	
	public DBObject() {
		query = getQuery();
	}
	
	public abstract Query getQuery();
	public abstract void connect(String ip, int port, String instance, String user_id, String password);
	//TODO excuteQuery()
	//TODO close()
	
	public String getSql() {
		
		return this.query.getSql();
	}
	
	//DDLQuery
	public abstract DBObject create_db(String database_identifier);
	public abstract DBObject create_table(String table_identifier);
	public abstract DBObject create_column(ColumnType column_type);
	public abstract DBObject create_view(String view_identifier, AbstractedQuery select_query);
	public abstract DBObject drop_table(String table_identifier);
	public abstract DBObject drop_index(String index_identifier, String table_identifier);
	public abstract DBObject drop_view(String view_identifier);
	public abstract DBObject alter_table(String table_identifier);
	public abstract DBObject add_column(String column_identifier, ColumnType column_type);
	public abstract DBObject drop_column(String column_identifier);
	public abstract DBObject add_primarykey(String... column_identifiers);
	public abstract DBObject drop_primarykey();
	public abstract DBObject add_foreignkey(String index_identifier, String column_identifier_first, String table_identifier, String column_identifier_second);
	public abstract DBObject drop_foreignkey(String index_identifier);
	public abstract DBObject add_index(String index_identifier, String index_type, String... column_identifiers);
	public abstract DBObject drop_index(String index_identifier);
	public abstract DBObject change_column(String column_identifier, ColumnType column_type);

	//DMLQuery
		//SelectStmtQuery
		public abstract DBObject select();
		public abstract DBObject select(String column_identifier_or_function, String alias);
		public abstract DBObject select(String... column_identifier_or_functions);
		public abstract DBObject select(ExprType expr_type_or_function, String alias);
		public abstract DBObject from(String table_identifier);
		public abstract DBObject from(AbstractedQuery select_query);
		public abstract DBObject from(String table_identifier, String alias);
		public abstract DBObject from(AbstractedQuery select_query, String alias);
		public abstract DBObject orderby(String asc_or_desc, String... column_identfiers);
		public abstract DBObject orderby(String... column_identfiers);
		public abstract DBObject limit(int constant_integer_type);
		public abstract DBObject inner_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second);
		public abstract DBObject left_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second);
		public abstract DBObject right_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second);
		public abstract DBObject full_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second);
		public abstract DBObject union(AbstractedQuery select_query_first, AbstractedQuery select_query_second);
		public abstract DBObject union_all(AbstractedQuery select_query_first, AbstractedQuery select_query_second);
		public abstract DBObject into(String table_identifier);
		public abstract DBObject group_by(String column_identfier);
		public abstract DBObject having(ExprType expr_type_or_function);
		public abstract DBObject having(String function);
		
		//UpdateStmtQuery
		public abstract DBObject update(String table_identifier);
		public abstract DBObject update(AbstractedQuery select_query);
		public abstract DBObject set(String column_identifier, String constant_type);
		public abstract DBObject set(String... constant_types);
		
		//InsertStmtQuery (UpdateStmtQuery의 set 메소드 2개 같이 사용)
		public abstract DBObject insert(String table_identifier);
		public abstract DBObject set(AbstractedQuery select_query);
		public abstract DBObject set(AbstractedQuery select_query, String... column_identifiers);
		
		//DeleteStmtQuery (from은 SelectStmtQuery 부분 걸 같이 사용)
		public abstract DBObject delete();
		
		//WhereStmtQuery
		public abstract DBObject where(ExprType expr_type);
		public abstract DBObject where(AbstractedQuery where_query);
		public abstract DBObject between(String identifier_type, String constant_type_first, String constant_type_second);
		public abstract DBObject not_between(String identifier_type, String constant_type_first, String constant_type_second);
		public abstract DBObject in(String identifier_type, String... constant_types);
		public abstract DBObject in(String identifier_type, AbstractedQuery select_query);
		public abstract DBObject not_in(String identifier_type, String... constant_types);
		public abstract DBObject not_in(String identifier_type, AbstractedQuery select_query);
		public abstract DBObject like(String identifier_type, String constant_type);	
}
