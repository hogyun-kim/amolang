package amolang_AbstractedQuery.DBObject;

import amolang_AbstractedQuery.Query.Query;

public class DBObjectOracle extends DBObject {

	@Override
	public Query getQuery() {
		
		return new Query(DatabaseType.DATABASE_TYPE_ORACLE);
	}

	@Override
	public void connect(String ip, int port, String instance, String user_id,
			String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getOperator(String abstracted_operator) {
		// TODO Auto-generated method stub
		return null;
	}
}
