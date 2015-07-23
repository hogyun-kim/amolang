package amolang_AbstractedQuery.test;

import java.sql.SQLException;

import amolang_AbstractedQuery.AbstractedQuery.AbstractedQuery;
import amolang_AbstractedQuery.DBObject.DatabaseType;
	

public class test {
	 
	public static void main(String[] args) {
		
		AbstractedQuery aq = null;
		
		try {
			aq = new AbstractedQuery(DatabaseType.DATABASE_TYPE_MYSQL, 
					"localhost", 3306, "test", "root", "kcbl0212");
			
			aq.select("*").from("test");
			
			System.out.println(aq.getSql());
			
			aq.excuteQuery();
			
			while(aq.next()) {
				
				int num = aq.getInt(1);
				String name = aq.getString(2);
				
				System.out.println(num +", " +name);
			}
			
			aq.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
