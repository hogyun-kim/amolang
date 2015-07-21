package amolang_AbstractedQuery.DBObject;

import amolang_AbstractedQuery.Query.Query;

public class DBObjectMysql extends DBObject {
	
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
	public void connect(String ip, int port, String instance, String user_id,
			String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getOperator(String abstracted_operator) {

		Operator operator = Operator.valueOf(abstracted_operator);
		
		return operator.getOperator();
	}
}
