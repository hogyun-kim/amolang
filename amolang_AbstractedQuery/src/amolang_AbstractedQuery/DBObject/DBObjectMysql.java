package amolang_AbstractedQuery.DBObject;

import amolang_AbstractedQuery.Query.Query;

public class DBObjectMysql extends DBObject {
	
	@Override
	public Query getQuery() {
		
		return new Query(DatabaseType.DATABASE_TYPE_MYSQL);
	}
}
