package amolang_AbstractedQuery.Query;

import amolang_AbstractedQuery.DBObject.DatabaseType;
import amolang_AbstractedQuery.DDL.ColumnType;
import amolang_AbstractedQuery.ExpressionType.ExprType;
import amolang_AbstractedQuery.Query.DDLQuery.DDLQuery;
import amolang_AbstractedQuery.Query.DDLQuery.DDLQueryMysql;
import amolang_AbstractedQuery.Query.DDLQuery.DDLQueryOracle;
import amolang_AbstractedQuery.Query.DMLQuery.DMLQuery;
import amolang_AbstractedQuery.Query.DMLQuery.DMLQueryMysql;
import amolang_AbstractedQuery.Query.DMLQuery.DMLQueryOracle;

public class Query {

	private DDLQuery ddlquery;
	private DMLQuery dmlquery;
	private String sql;
	
	public Query(DatabaseType database_type) {
		
		this.ddlquery = getDDLQuery(database_type);
		this.dmlquery = getDMLQuery(database_type);		
	}
	
	public DDLQuery getDDLQuery(DatabaseType database_type) {
		
		switch(database_type) {
		case DATABASE_TYPE_ORACLE:
			ddlquery = new DDLQueryOracle();
			break;
		case DATABASE_TYPE_MYSQL:
			ddlquery = new DDLQueryMysql();
			break;
		default:
			ddlquery = null;
		}
		
		return ddlquery;
	}
	
	public DMLQuery getDMLQuery(DatabaseType database_type) {
		
		switch(database_type) {
		case DATABASE_TYPE_ORACLE:
			dmlquery = new DMLQueryOracle();
			break;
		case DATABASE_TYPE_MYSQL:
			dmlquery = new DMLQueryMysql();
			break;
		default:
			dmlquery = null;
		}
		
		return dmlquery;
	}
	
	public String getSql() {
		
		return sql;
	}
	
	//DDLQuery
	public Query create_db(String database_identifier);
	public Query create_table(String table_identifier);
	public Query create_column(ColumnType column_type);
	public Query create_view(String view_identifier, AbstractedQuery select_query);
	public Query drop_table(String table_identifier);
	public Query drop_index(String index_identifier, String table_identifier);
	public Query drop_view(String view_identifier);
	public Query alter_table(String table_identifier);
	public Query add_column(String column_identifier, ColumnType column_type);
	public Query drop_column(String column_identifier);
	public Query add_primarykey(String... column_identifiers);
	public Query drop_primarykey();
	public Query add_foreignkey(String index_identifier, String column_identifier_first, String table_identifier, String column_identifier_second);
	public Query drop_foreignkey(String index_identifier);
	public Query add_index(String index_identifier, String index_type, String... column_identifiers);
	public Query drop_index(String index_identifier);
	public Query change_column(String column_identifier, ColumnType column_type);

	//DMLQuery
		//SelectStmtQuery
		public Query select();
		public Query select(String column_identifier_or_function, String alias);
		public Query select(String... column_identifier_or_functions);
		public Query select(ExprType expr_type_or_function, String alias);
		public Query from(String table_identifier);
		public Query from(AbstractedQuery select_query);
		public Query from(String table_identifier, String alias);
		public Query from(AbstractedQuery select_query, String alias);
		public Query orderby(String asc_or_desc, String... column_identfiers);
		public Query orderby(String... column_identfiers);
		public Query limit(int constant_integer_type);
		public Query inner_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second);
		public Query left_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second);
		public Query right_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second);
		public Query full_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second);
		public Query union(AbstractedQuery select_query_first, AbstractedQuery select_query_second);
		public Query union_all(AbstractedQuery select_query_first, AbstractedQuery select_query_second);
		public Query into(String table_identifier);
		public Query group_by(String column_identfier);
		public Query having(ExprType expr_type_or_function);
		public Query having(String function);
		
		//UpdateStmtQuery
		public Query update(String table_identifier);
		public Query update(AbstractedQuery select_query);
		public Query set(String column_identifier, String constant_type);
		public Query set(String... constant_types);
		
		//InsertStmtQuery (UpdateStmtQuery의 set 메소드 2개 같이 사용)
		public Query insert(String table_identifier);
		public Query set(AbstractedQuery select_query);
		public Query set(AbstractedQuery select_query, String... column_identifiers);
		
		//DeleteStmtQuery (from은 SelectStmtQuery 부분 걸 같이 사용)
		public Query delete();
		
		//WhereStmtQuery
		public Query where(ExprType expr_type);
		public Query where(AbstractedQuery where_query);
		public Query between(String identifier_type, String constant_type_first, String constant_type_second);
		public Query not_between(String identifier_type, String constant_type_first, String constant_type_second);
		public Query in(String identifier_type, String... constant_types);
		public Query in(String identifier_type, AbstractedQuery select_query);
		public Query not_in(String identifier_type, String... constant_types);
		public Query not_in(String identifier_type, AbstractedQuery select_query);
		public Query like(String identifier_type, String constant_type);
}
