package amolang_AbstractedQuery.Query.DMLQuery;

import amolang_AbstractedQuery.AbstractedQuery.AbstractedQuery;
import amolang_AbstractedQuery.ExprType.ExprType;

public class DMLQueryOracle extends DMLQuery {
	
	@Override
	public DMLQuery select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery select(String column_identifier_or_function, String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery select(String... column_identifier_or_functions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery select(ExprType expr_type_or_function, String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery from(String table_identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery from(AbstractedQuery select_query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery from(String table_identifier, String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery from(AbstractedQuery select_query, String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery orderby(String asc_or_desc, String... column_identfiers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery orderby(String... column_identfiers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery limit(int constant_integer_type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery inner_join(String table_identifier_first,
			String column_identfier_first, String table_identifier_second,
			String column_identfier_second) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery left_join(String table_identifier_first,
			String column_identfier_first, String table_identifier_second,
			String column_identfier_second) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery right_join(String table_identifier_first,
			String column_identfier_first, String table_identifier_second,
			String column_identfier_second) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery full_join(String table_identifier_first,
			String column_identfier_first, String table_identifier_second,
			String column_identfier_second) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery union(AbstractedQuery select_query_first,
			AbstractedQuery select_query_second) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery union_all(AbstractedQuery select_query_first,
			AbstractedQuery select_query_second) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery into(String table_identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery group_by(String column_identfier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery having(ExprType expr_type_or_function) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery having(String function) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery update(String table_identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery update(AbstractedQuery select_query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery set(String column_identifier, String constant_type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery set(String... constant_types) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery insert(String table_identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery set(AbstractedQuery select_query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery set(AbstractedQuery select_query,
			String... column_identifiers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery where(ExprType expr_type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery where(AbstractedQuery where_query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery between(String identifier_type, String constant_type_first,
			String constant_type_second) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery not_between(String identifier_type,
			String constant_type_first, String constant_type_second) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery in(String identifier_type, String... constant_types) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery in(String identifier_type, AbstractedQuery select_query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery not_in(String identifier_type, String... constant_types) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery not_in(String identifier_type, AbstractedQuery select_query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DMLQuery like(String identifier_type, String constant_type) {
		// TODO Auto-generated method stub
		return null;
	}

}
