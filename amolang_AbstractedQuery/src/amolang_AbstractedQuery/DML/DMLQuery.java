package amolang_AbstractedQuery.DML;

import amolang_AbstractedQuery.Database.DatabaseManager;
import amolang_AbstractedQuery.ExpressionType.ExprType;

public class DMLQuery extends DatabaseManager {

	public String getQuery() {
		return query;
	}
	
	void add(ExprType expr_type) {		
		query += expr_type.getQuery();
	}
	
	void add(DMLQuery dml_query) {		
		query += dml_query.query;
	}	
}
