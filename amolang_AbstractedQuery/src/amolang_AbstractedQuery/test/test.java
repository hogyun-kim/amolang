package amolang_AbstractedQuery.test;

import java.sql.SQLException;

import amolang_AbstractedQuery.AbstractedQuery.AbstractedQuery;
import amolang_AbstractedQuery.DBObject.DatabaseType;
import amolang_AbstractedQuery.ExprType.ExprType;
import amolang_AbstractedQuery.ExprType.MultipleExprType;
	

public class test {
	 
	public static void main(String[] args) {
		
		AbstractedQuery aq = null;
		ExprType et = new MultipleExprType();
		ExprType et2 = new MultipleExprType();
		
		try {
			aq = new AbstractedQuery(DatabaseType.DATABASE_TYPE_MYSQL, 
					"localhost", "3306", "test", "root", "kcbl0212");
			
			//sql������ ���ڿ��� �ʿ��� ��쿡�� ��������ǥ('')�� ������
			aq.select("*").from("component").from(new AbstractedQuery(DatabaseType.DATABASE_TYPE_MYSQL)
			.select("id", "pid").from("component")
			.where(new MultipleExprType().equal("name", "'" +"amolang" +"'")), "component_parent")
			.where(new MultipleExprType().equal("name", "'" +"hello" +"'")
			.and(new MultipleExprType().equal("component.parent_id", "component_parent.pid")));
			
			System.out.println(aq.getSql());
		/*	
			aq.excuteQuery();
			
			while(aq.next()) {
				
				int num = aq.getInt(1);
				String name = aq.getString(2);
				
				System.out.println(num +", " +name);
			}
			*/
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
