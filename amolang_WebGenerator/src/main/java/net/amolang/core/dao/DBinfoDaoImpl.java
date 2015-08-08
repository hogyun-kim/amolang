package net.amolang.core.dao;

import java.sql.SQLException;

import amolang_AbstractedQuery.AbstractedQuery.AbstractedQuery;
import net.amolang.core.dao.admindb.AdminDBinfo;
import net.amolang.core.model.DBinfo;

public class DBinfoDaoImpl implements DBinfoDao {
	
	DBinfo dbinfo;
	
	public void setDBinfo(DBinfo dbinfo) {
		this.dbinfo = dbinfo;
	}
	
	@Override
	public DBinfo selectOne(){
		
		try {
			
			AbstractedQuery abstractedquery = new AbstractedQuery(AdminDBinfo.DBTYPE,
					AdminDBinfo.IP, AdminDBinfo.PORT, AdminDBinfo.DBNAME, AdminDBinfo.USERNAME,
					AdminDBinfo.PASSWORD);
			
			abstractedquery.select("*").from("dbinfo");
			
			abstractedquery.excuteQuery();
			
			while(abstractedquery.next()) {
				dbinfo.setDbtype(abstractedquery.getString(1));
				dbinfo.setIp(abstractedquery.getString(2));
				dbinfo.setPort(abstractedquery.getString(3));
				dbinfo.setDbname(abstractedquery.getString(4));
				dbinfo.setUsername(abstractedquery.getString(5));
				dbinfo.setPassword(abstractedquery.getString(6));
			}
			
			abstractedquery.close();

/*			
			 final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			 final String DB_URL = "jdbc:mysql://localhost:3306/test";

			 final String USERNAME = "root";
			 final String PASSWORD = "kcbl0212";
			
			Connection conn = null;
			Statement stmt = null;
			
			try {
				Class.forName(JDBC_DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("\n- MySQL Connection");
			stmt = conn.createStatement();
			
			String sql;
			sql = "SELECT * FROM dbinfo";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				dbinfo.setDbtype(rs.getString(1));
				dbinfo.setIp(rs.getString(2));
				dbinfo.setPort(rs.getString(3));
				dbinfo.setDbname(rs.getString(4));
				dbinfo.setUsername(rs.getString(5));
				dbinfo.setPassword(rs.getString(6));
			}
			rs.close();
			stmt.close();
			conn.close();
			
			
		*/
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dbinfo;
	}

}
