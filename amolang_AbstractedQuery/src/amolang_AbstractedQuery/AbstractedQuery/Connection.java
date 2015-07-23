package amolang_AbstractedQuery.AbstractedQuery;

import java.sql.SQLException;

import amolang_AbstractedQuery.DBObject.DatabaseType;

public interface Connection {

	public void connect(DatabaseType database_type, String url, int port, String instance, String user_id, String password) throws ClassNotFoundException, SQLException;
	public void conn_close() throws SQLException;
}
