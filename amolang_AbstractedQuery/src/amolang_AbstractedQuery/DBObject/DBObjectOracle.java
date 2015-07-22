package amolang_AbstractedQuery.DBObject;

import java.sql.Connection;

import amolang_AbstractedQuery.Query.Query;

public class DBObjectOracle extends DBObject {

	@Override
	public Query getQuery() {
		
		return new Query(DatabaseType.DATABASE_TYPE_ORACLE);
	}

	@Override
	public Connection connect(String ip, int port, String instance, String user_id,
			String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOperator(String abstracted_operator) {
		// TODO Auto-generated method stub
		return null;
	}
}
