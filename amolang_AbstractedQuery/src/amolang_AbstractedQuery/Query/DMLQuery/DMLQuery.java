package amolang_AbstractedQuery.Query.DMLQuery;

import amolang_AbstractedQuery.AbstractedQuery.AbstractedQuery;
import amolang_AbstractedQuery.ExpressionType.ExprType;

public interface DMLQuery {

	//SelectStmtQuery
	public DMLQuery select();
	public DMLQuery select(String column_identifier_or_function, String alias);
	public DMLQuery select(String... column_identifier_or_functions);
	public DMLQuery select(ExprType expr_type_or_function, String alias);
	public DMLQuery from(String table_identifier);
	public DMLQuery from(AbstractedQuery select_query);
	public DMLQuery from(String table_identifier, String alias);
	public DMLQuery from(AbstractedQuery select_query, String alias);
	public DMLQuery orderby(String asc_or_desc, String... column_identfiers);
	public DMLQuery orderby(String... column_identfiers);
	public DMLQuery limit(int constant_integer_type);
	public DMLQuery inner_join(String table_identifier_first, String column_identfier_first,
			String table_identifier_second, String column_identfier_second);
	public DMLQuery left_join(String table_identifier_first, String column_identfier_first,
			String table_identifier_second, String column_identfier_second);
	public DMLQuery right_join(String table_identifier_first, String column_identfier_first,
			String table_identifier_second, String column_identfier_second);
	public DMLQuery full_join(String table_identifier_first, String column_identfier_first,
			String table_identifier_second, String column_identfier_second);
	public DMLQuery union(AbstractedQuery select_query_first, AbstractedQuery select_query_second);
	public DMLQuery union_all(AbstractedQuery select_query_first, AbstractedQuery select_query_second);
	public DMLQuery into(String table_identifier);
	public DMLQuery group_by(String column_identfier);
	public DMLQuery having(ExprType expr_type_or_function);
	public DMLQuery having(String function);
	
	//UpdateStmtQuery
	public DMLQuery update(String table_identifier);
	public DMLQuery update(AbstractedQuery select_query);
	public DMLQuery set(String column_identifier, String constant_type);
	public DMLQuery set(String... constant_types);
	
	//InsertStmtQuery (UpdateStmtQuery의 set 메소드 2개 같이 사용)
	public DMLQuery insert(String table_identifier);
	public DMLQuery set(AbstractedQuery select_query);
	public DMLQuery set(AbstractedQuery select_query, String... column_identifiers);
	
	//DeleteStmtQuery (from은 SelectStmtQuery 부분 걸 같이 사용)
	public DMLQuery delete();
	
	//WhereStmtQuery
	public DMLQuery where(ExprType expr_type);
	public DMLQuery where(AbstractedQuery where_query);
	public DMLQuery between(String identifier_type, String constant_type_first, String constant_type_second);
	public DMLQuery not_between(String identifier_type, String constant_type_first, String constant_type_second);
	public DMLQuery in(String identifier_type, String... constant_types);
	public DMLQuery in(String identifier_type, AbstractedQuery select_query);
	public DMLQuery not_in(String identifier_type, String... constant_types);
	public DMLQuery not_in(String identifier_type, AbstractedQuery select_query);
	public DMLQuery like(String identifier_type, String constant_type);
}
