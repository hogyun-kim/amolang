package amolang_AbstractedQuery.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DatabaseManager {
	
	public enum Database { 
		
		oracle(0), mysql(1);
		
		private int index;
		
		Database(int index) {
			this.index = index;
		}
		
		public int getIndex() {
			return index;
		}
	};	
	
	protected static Database db;
	protected String query = "";
	
	private static void setDatabase(String database) {
		db = Database.valueOf(database);
	}	
	
	public static Connection getConnection(String database, String url,
			String user, String password) {
		
		Connection con = null;
		String[] driver_name = { "oracle.jdbc.driver.OracleDriver",
								 "com.mysql.jdbc.Driver"};
		
		//드라이버 로딩
		try {
			
			if(database.equals("oracle")) {
				
				Class.forName(driver_name[Database.oracle.getIndex()]);
			}
			else if(database.equals("mysql")) {

				Class.forName(driver_name[Database.mysql.getIndex()]);
			}
			else {
				//TODO
			}
			
			DatabaseManager.setDatabase(database);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		}
		
		
		//database 연결
		try {
			
			con = DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("데이터베이스 연결 실패");
		}
		
		return con;
	}
	
	public static String use(String database_identifier) {
		
		if(db == Database.valueOf("oracle")) {
			
			return null;
		}
		else if(db == Database.valueOf("mysql")) {
			
			return "USE " +database_identifier +";";
		}
		else {
			
			return "error";
		}
	}
}
