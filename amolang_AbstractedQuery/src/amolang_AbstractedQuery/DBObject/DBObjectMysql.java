package amolang_AbstractedQuery.DBObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import amolang_AbstractedQuery.Query.Query;

public class DBObjectMysql extends DBObject {
	
	private static final String driverName = "com.mysql.jdbc.Driver";
	
	public enum Operator {
		EQUAL("="), NOT_EQUAL("!="), 
		GREATER(">"), GREATER_EQUAL(">="),
		LESS("<"), LESS_EQUAL("<=");
		
		private String operator;
		
		Operator(String operator) {
			this.operator = operator;
		}
		
		public String getOperator() {
			return operator;
		}
	}
	
	@Override
	public Query getQuery() {
		
		return new Query(DatabaseType.DATABASE_TYPE_MYSQL);
	}

	@Override
	public Connection connect(String ip, int port, String instance, String user_id, String password) {
		
		Connection connection = null;
		String url = "jdbc:mysql://" +ip +":" +String.valueOf(port) +"/" +instance;
		try {

			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user_id, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}

	@Override
	public String getOperator(String abstracted_operator) {

		Operator operator = Operator.valueOf(abstracted_operator);
		
		return operator.getOperator();
	}
}
