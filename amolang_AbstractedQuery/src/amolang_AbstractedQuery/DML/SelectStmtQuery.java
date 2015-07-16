package amolang_AbstractedQuery.DML;

import amolang_AbstractedQuery.ExpressionType.ExprType;

/**
 * @author KC
 *
 */
public class SelectStmtQuery extends WhereStmtQuery {

	public SelectStmtQuery select() {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			query += "select ";
		}
		
		return this;
	}
	
	public SelectStmtQuery select(String column_identifier_or_function,
			String alias) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(" ")) {
				query += "," +column_identifier_or_function +" as " +alias +" ";
			}
			else {
				query += "select " +column_identifier_or_function +" as " +alias +" ";
			}
		}
		
		return this;
	}
	
	public SelectStmtQuery select(String... column_identifier_or_functions) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += "select ";
			for(String column_identifier_or_function : column_identifier_or_functions) {
				query += column_identifier_or_function +",";
			}
			
			int pos = query.lastIndexOf(",");
			query = query.substring(0, pos) + " ";
		}
		
		return this;
	}
	
	public SelectStmtQuery select(ExprType expr_type_or_function, String alias) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(" ")) {
				
				query += ",";
				this.add(expr_type_or_function);
				query += " as " +alias +" ";
			}
			else {
				query += "select ";
				this.add(expr_type_or_function);
				query += " as " +alias +" ";
			}
		}
		
		return this;
	}
	
	public SelectStmtQuery from(String table_identifier) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				int pos = query.lastIndexOf(";");
				query = query.substring(0, pos) + ",";
				
				query += table_identifier +";";
			}
			else {
				query += "from " +table_identifier +";";
			}
			
		}
		
		return this;
	}
	
	public SelectStmtQuery from(SelectStmtQuery select_query) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				int pos = query.lastIndexOf(";");
				query = query.substring(0, pos) + ",";
				
				query += "(";
				this.add(select_query);
				query += ");";
			}
			else {
				query += "from (";
				this.add(select_query);
				query += ");";
			}			
		}
		
		return this;
	}
	
	public SelectStmtQuery from(String table_identifier, String alias) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				int pos = query.lastIndexOf(";");
				query = query.substring(0, pos) + ",";
				
				query += table_identifier +" as " +alias +";";
			}
			else {
				query += "from " +table_identifier +" as " +alias +";";
			}			
		}
		
		return this;
	}
	
	public SelectStmtQuery from(SelectStmtQuery select_query, String alias) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				int pos = query.lastIndexOf(";");
				query = query.substring(0, pos) + ",";
				
				query += "(";
				this.add(select_query);
				query += ") as " +alias +";";
			}
			else {
				query += "from (";
				this.add(select_query);
				query += ") as " +alias +";";
			}			
		}
		
		return this;
	}

	public SelectStmtQuery orderby(String s_t, String... column_identfiers) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				int pos = query.lastIndexOf(";");
				query = query.substring(0, pos) + " ";
				
				query += "order by ";
				for(String column_identfier : column_identfiers) {
					query += column_identfier +",";
				}
				
				int pos1 = query.lastIndexOf(",");
				query = query.substring(0, pos1) + " ";
				query += s_t +";";
			}
			else {
				query += " order by ";
				for(String column_identfier : column_identfiers) {
					query += column_identfier +",";
				}
				
				int pos = query.lastIndexOf(",");
				query = query.substring(0, pos) + " ";
				query += s_t +";";
			}		
		}
		
		return this;
	}

	public SelectStmtQuery orderby(String... column_identfiers) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				int pos = query.lastIndexOf(";");
				query = query.substring(0, pos) + " ";
				
				query += "order by ";
				for(String column_identfier : column_identfiers) {
					query += column_identfier +",";
				}
				
				int pos1 = query.lastIndexOf(",");
				query = query.substring(0, pos1) + ";";
			}
			else {
				query += " order by ";
				for(String column_identfier : column_identfiers) {
					query += column_identfier +",";
				}
				
				int pos = query.lastIndexOf(",");
				query = query.substring(0, pos) + ";";
			}		
		}
		
		return this;
	}
	
	public SelectStmtQuery limit(int constant_integer_type) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				int pos = query.lastIndexOf(";");
				query = query.substring(0, pos) + " ";
				
				query += "limit " +constant_integer_type +";";
			}
			else {
				query += " limit " +constant_integer_type +";";
			}		
		}
		
		return this;
	}
	
	public SelectStmtQuery inner_join(String table_identifier_first, String column_identfier_first,
			String table_identifier_second, String column_identfier_second) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				int pos = query.lastIndexOf(";");
				query = query.substring(0, pos) + " ";
				
				query += table_identifier_first +" inner join " +table_identifier_second +" on " +table_identifier_first +"."
						+column_identfier_first +" = " +table_identifier_second +"." +column_identfier_second +";";
			}
			else {
				query += table_identifier_first +" inner join " +table_identifier_second +" on " +table_identifier_first +"."
						+column_identfier_first +" = " +table_identifier_second +"." +column_identfier_second +";";
			}		
		}
		
		return this;
	}
	
	public SelectStmtQuery left_join(String table_identifier_first, String column_identfier_first,
			String table_identifier_second, String column_identfier_second) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				int pos = query.lastIndexOf(";");
				query = query.substring(0, pos) + " ";
				
				query += table_identifier_first +" left join " +table_identifier_second +" on " +table_identifier_first +"."
						+column_identfier_first +" = " +table_identifier_second +"." +column_identfier_second +";";
			}
			else {
				query += table_identifier_first +" left join " +table_identifier_second +" on " +table_identifier_first +"."
						+column_identfier_first +" = " +table_identifier_second +"." +column_identfier_second +";";
			}		
		}
		
		return this;
	}
	
	public SelectStmtQuery right_join(String table_identifier_first, String column_identfier_first,
			String table_identifier_second, String column_identfier_second) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				int pos = query.lastIndexOf(";");
				query = query.substring(0, pos) + " ";
				
				query += table_identifier_first +" right join " +table_identifier_second +" on " +table_identifier_first +"."
						+column_identfier_first +" = " +table_identifier_second +"." +column_identfier_second +";";
			}
			else {
				query += table_identifier_first +" right join " +table_identifier_second +" on " +table_identifier_first +"."
						+column_identfier_first +" = " +table_identifier_second +"." +column_identfier_second +";";
			}		
		}
		
		return this;
	}
	
	public SelectStmtQuery full_join(String table_identifier_first, String column_identfier_first,
			String table_identifier_second, String column_identfier_second) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				int pos = query.lastIndexOf(";");
				query = query.substring(0, pos) + " ";
				
				query += table_identifier_first +" full join " +table_identifier_second +" on " +table_identifier_first +"."
						+column_identfier_first +" = " +table_identifier_second +"." +column_identfier_second +";";
			}
			else {
				query += table_identifier_first +" full join " +table_identifier_second +" on " +table_identifier_first +"."
						+column_identfier_first +" = " +table_identifier_second +"." +column_identfier_second +";";
			}		
		}
		
		return this;
	}
	
	public SelectStmtQuery union(SelectStmtQuery select_query_first, SelectStmtQuery select_query_second) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(select_query_first.getQuery().endsWith(";")) {
				int pos = select_query_first.getQuery().lastIndexOf(";");
				query = select_query_first.getQuery().substring(0, pos) + " ";
				
				query += "union ";
				this.add(select_query_second);
			}
			else {
				this.add(select_query_first);
				query += " union ";
				this.add(select_query_second);
			}
		}
		
		return this;
	}
	
	public SelectStmtQuery union_all(SelectStmtQuery select_query_first, SelectStmtQuery select_query_second) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(select_query_first.getQuery().endsWith(";")) {
				int pos = select_query_first.getQuery().lastIndexOf(";");
				query = select_query_first.getQuery().substring(0, pos) + " ";
				
				query += "union all ";
				this.add(select_query_second);
			}
			else {
				this.add(select_query_first);
				query += " union all ";
				this.add(select_query_second);
			}
		}
		
		return this;
	}
	
	public SelectStmtQuery into(String table_identifier) {
		
		//TODO mysqlÀº Áö¿ø¾ÈµÊ
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
		}
		
		return this;
	}
	
	public SelectStmtQuery group_by(String column_identfier) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				int pos = query.lastIndexOf(";");
				query = query.substring(0, pos) + " ";
				
				query += "group by " +column_identfier +";";
			}
			else {
				query += " group by " +column_identfier +";";
			}
		}
		
		return this;	
	}
	
	public SelectStmtQuery having(ExprType expr_type_or_function) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				int pos = query.lastIndexOf(";");
				query = query.substring(0, pos) + " ";
				
				query += "having ";
				this.add(expr_type_or_function);
				query += ";";
			}
			else {
				query += " having ";
				this.add(expr_type_or_function);
				query += ";";
			}
		}
		
		return this;
	}
	
	public SelectStmtQuery having(String function) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(query.endsWith(";")) {
				int pos = query.lastIndexOf(";");
				query = query.substring(0, pos) + " ";
				
				query += "having " +function +";";
			}
			else {
				query += " having " +function +";";
			}
		}
		
		return this;
	}
}
