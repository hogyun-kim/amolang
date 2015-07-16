package amolang_AbstractedQuery.test;

import amolang_AbstractedQuery.DML.DMLQuery;
import amolang_AbstractedQuery.DML.SelectStmtQuery;
import amolang_AbstractedQuery.Database.DatabaseManager;
import amolang_AbstractedQuery.ExpressionType.MultipleExprType;

public class test {

	public static void main(String[] args) {
		
		DatabaseManager.getConnection("mysql", "", "", "");
		
		SelectStmtQuery sq = new SelectStmtQuery();
		MultipleExprType et = new MultipleExprType();
		
		DMLQuery s = sq.select("*").from("test").where(et.equal("id", "1"));
		
		System.out.println(s.getQuery());
		
		s = sq.select("name").from("test2").where(et.greater("name", "2"));
		
		System.out.println(s.getQuery());
	}

}
