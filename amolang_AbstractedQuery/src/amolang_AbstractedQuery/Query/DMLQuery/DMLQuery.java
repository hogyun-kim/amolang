package amolang_AbstractedQuery.Query.DMLQuery;

import amolang_AbstractedQuery.AbstractedQuery.AbstractedQuery;
import amolang_AbstractedQuery.Analyzer.OperatorAnalyzer;
import amolang_AbstractedQuery.ExprType.ExprType;

public abstract class DMLQuery {
	
	protected String sql;
	protected OperatorAnalyzer operator_assembler;
	
	public DMLQuery() {
		
		operator_assembler = new OperatorAnalyzer();
	};
	
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
	
	//SelectStmtQuery
	public abstract DMLQuery select();
	public abstract DMLQuery select(String column_identifier_or_function, String alias);
	public abstract DMLQuery select(String... column_identifier_or_functions);
	public abstract DMLQuery select(ExprType expr_type_or_function, String alias);
	public abstract DMLQuery from(String table_identifier);
	public abstract DMLQuery from(AbstractedQuery select_query);
	public abstract DMLQuery from(String table_identifier, String alias);
	public abstract DMLQuery from(AbstractedQuery select_query, String alias);
	public abstract DMLQuery orderby(String asc_or_desc, String... column_identfiers);
	public abstract DMLQuery orderby(String... column_identfiers);
	public abstract DMLQuery limit(int constant_integer_type);
	public abstract DMLQuery inner_join(String table_identifier_first, String column_identfier_first,
			String table_identifier_second, String column_identfier_second);
	public abstract DMLQuery left_join(String table_identifier_first, String column_identfier_first,
			String table_identifier_second, String column_identfier_second);
	public abstract DMLQuery right_join(String table_identifier_first, String column_identfier_first,
			String table_identifier_second, String column_identfier_second);
	public abstract DMLQuery full_join(String table_identifier_first, String column_identfier_first,
			String table_identifier_second, String column_identfier_second);
	public abstract DMLQuery union(AbstractedQuery select_query_first, AbstractedQuery select_query_second);
	public abstract DMLQuery union_all(AbstractedQuery select_query_first, AbstractedQuery select_query_second);
	public abstract DMLQuery into(String table_identifier);
	public abstract DMLQuery group_by(String column_identfier);
	public abstract DMLQuery having(ExprType expr_type_or_function);
	public abstract DMLQuery having(String function);
	
	//UpdateStmtQuery
	public abstract DMLQuery update(String table_identifier);
	public abstract DMLQuery update(AbstractedQuery select_query);
	public abstract DMLQuery set(String column_identifier, String constant_type);
	public abstract DMLQuery set(String... constant_types);
	
	//InsertStmtQuery (UpdateStmtQuery의 set 메소드 2개 같이 사용)
	public abstract DMLQuery insert(String table_identifier);
	public abstract DMLQuery set(AbstractedQuery select_query);
	public abstract DMLQuery set(AbstractedQuery select_query, String... column_identifiers);
	
	//DeleteStmtQuery (from은 SelectStmtQuery 부분 걸 같이 사용)
	public abstract DMLQuery delete();
	
	//WhereStmtQuery
	public abstract DMLQuery where(ExprType expr_type);
	public abstract DMLQuery where(AbstractedQuery where_query);
	public abstract DMLQuery between(String identifier_type, String constant_type_first, String constant_type_second);
	public abstract DMLQuery not_between(String identifier_type, String constant_type_first, String constant_type_second);
	public abstract DMLQuery in(String identifier_type, String... constant_types);
	public abstract DMLQuery in(String identifier_type, AbstractedQuery select_query);
	public abstract DMLQuery not_in(String identifier_type, String... constant_types);
	public abstract DMLQuery not_in(String identifier_type, AbstractedQuery select_query);
	public abstract DMLQuery like(String identifier_type, String constant_type);
}
