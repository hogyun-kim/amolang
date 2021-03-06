package amolang_AbstractedQuery.DBObject;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import amolang_AbstractedQuery.DBQuery.DBQuery;

public class DBObjectMysql extends DBObject {
	
	private static final String driverName = "com.mysql.jdbc.Driver";
	Connection connection;
	PreparedStatement preparedstatement;
	ResultSet resultset;
	
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
	public DBQuery getQuery() {
		
		return new DBQuery(DatabaseType.DATABASE_TYPE_MYSQL);
	}

	@Override
	public void connect(String ip, String port, String instance, String user_id, String password) throws SQLException, ClassNotFoundException {
		
		String url = "jdbc:mysql://" +ip +":" +String.valueOf(port) +"/" +instance;

		Class.forName(driverName);
		connection = DriverManager.getConnection(url, user_id, password);
	}

	@Override
	public String getOperator(String abstracted_operator) {

		Operator operator = Operator.valueOf(abstracted_operator);
		
		return operator.getOperator();
	}
	
	@Override
	public void excuteUpdate() throws SQLException {
		
		preparedstatement = connection.prepareStatement(getSql());
		preparedstatement.executeUpdate();
	}

	@Override
	public void excuteQuery() throws SQLException {

		preparedstatement = connection.prepareStatement(getSql());
		resultset = preparedstatement.executeQuery();
	}

	@Override
	public void setSqlString(int something_index, String something) throws SQLException {

		preparedstatement.setString(something_index, something);
	}

	@Override
	public void setSqlInt(int something_index, int something) throws SQLException {

		preparedstatement.setInt(something_index, something);
	}

	@Override
	public void setSqlBoolean(int something_index, boolean something) throws SQLException {

		preparedstatement.setBoolean(something_index, something);
	}

	@Override
	public void setSqlTimestamp(int something_index, Timestamp something) throws SQLException {

		preparedstatement.setTimestamp(something_index, something);
	}

	@Override
	public void conn_close() throws SQLException {
		
		if(connection != null)
			connection.close();
	}

	@Override
	public void pstmt_close() throws SQLException {

		if(preparedstatement != null)
			preparedstatement.close();
	}

	@Override
	public boolean next() throws SQLException {

		return resultset.next();
	}

	@Override
	public String getString(int columnIndex) throws SQLException {

		return resultset.getString(columnIndex);
	}

	@Override
	public int getInt(int columnIndex) throws SQLException {

		return resultset.getInt(columnIndex);
	}

	@Override
	public boolean getBoolean(int columnIndex) throws SQLException {

		return resultset.getBoolean(columnIndex);
	}

	@Override
	public Timestamp getTimestamp(int columnIndex) throws SQLException {

		return resultset.getTimestamp(columnIndex);
	}

	@Override
	public void resultset_close() throws SQLException {

		if(resultset != null)
			resultset.close();
	}
}
