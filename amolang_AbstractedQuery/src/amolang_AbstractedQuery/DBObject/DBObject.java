package amolang_AbstractedQuery.DBObject;

import amolang_AbstractedQuery.AbstractedQuery.AbstractedQuery;
import amolang_AbstractedQuery.ColumnType.ColumnType;
import amolang_AbstractedQuery.ExprType.ExprType;
import amolang_AbstractedQuery.Query.Query;



public abstract class DBObject {

	private Query query;
	
	public DBObject() {
		query = getQuery();
	}
	
	public abstract Query getQuery();
	public abstract void connect(String ip, int port, String instance, String user_id, String password);
	//TODO excuteQuery()
	//TODO close()
	public abstract String getOperator(String abstracted_operator);
	
	public String getSql() {
		
		return this.query.getSql();
	}	
	
	//DDLQuery
	public DBObject create_db(String database_identifier) {
		
		this.query.create_db(database_identifier);
		
		return this;
	}
	public DBObject create_table(String table_identifier, ColumnType... column_types) {
		
		this.query.create_table(table_identifier);
		
		return this;
	}
	public DBObject create_view(String view_identifier, AbstractedQuery select_query) {
		
		this.query.create_view(view_identifier, select_query);
		
		return this;
	}
	public DBObject drop_table(String table_identifier) {
		
		this.query.drop_table(table_identifier);
		
		return this;
	}
	public DBObject drop_view(String view_identifier) {
		
		this.query.drop_view(view_identifier);
		
		return this;
	}
	//여기서부터 alter_table 하위 메소드
	public DBObject alter_table(String table_identifier) {
		
		this.query.alter_table(table_identifier);
		
		return this;
	}
	public DBObject add_column(ColumnType column_type) {
		
		this.query.add_column(column_type);
		
		return this;
	}
	public DBObject drop_column(String column_identifier) {
		
		this.query.drop_column(column_identifier);
		
		return this;
	}
	public DBObject add_primarykey(String... column_identifiers) {
		
		this.query.add_primarykey(column_identifiers);
		
		return this;
	}
	public DBObject drop_primarykey() {
		
		this.query.drop_primarykey();
		
		return this;
	}
	public DBObject add_foreignkey(String index_identifier, String column_identifier_first, String table_identifier, String column_identifier_second) {
		
		this.query.add_foreignkey(index_identifier, column_identifier_first, table_identifier, column_identifier_second);
		
		return this;
	}
	public DBObject drop_foreignkey(String index_identifier) {
		
		this.query.drop_foreignkey(index_identifier);
		
		return this;
	}
	public DBObject add_index(String index_identifier, String index_type, String... column_identifiers) {
		
		this.query.add_index(index_identifier, index_type, column_identifiers);
		
		return this;
	}
	public DBObject drop_index(String index_identifier) {
		
		this.query.drop_index(index_identifier);
		
		return this;
	}
	public DBObject change_column(String column_identifier, ColumnType column_type) {
		
		this.query.change_column(column_identifier, column_type);
		
		return this;
	}
	
	public DBObject add_auto_increment(ColumnType column_type) {
		
		this.query.add_auto_increment(column_type);
		
		return this;
	}
	
	public DBObject handshake_auto_increment(int constant_integer_type) {
		
		this.query.handshake_auto_increment(constant_integer_type);
		
		return this;
	}

	//DMLQuery
		//SelectStmtQuery
		public DBObject select() {
			
			this.query.select();
			
			return this;
		}
		public DBObject select(String column_identifier_or_function, String alias) {
			
			this.query.select(column_identifier_or_function, alias);
			
			return this;
		}
		public DBObject select(String... column_identifier_or_functions) {
			
			this.query.select(column_identifier_or_functions);
			
			return this;
		}
		public DBObject select(ExprType expr_type_or_function, String alias) {
			
			this.query.select(expr_type_or_function, alias);
			
			return this;
		}
		public DBObject from(String table_identifier) {
			
			this.query.from(table_identifier);
			
			return this;
		}
		public DBObject from(AbstractedQuery select_query) {
			
			this.query.from(select_query);
			
			return this;
		}
		public DBObject from(String table_identifier, String alias) {
			
			this.query.from(table_identifier, alias);
			
			return this;
		}
		public DBObject from(AbstractedQuery select_query, String alias) {
			
			this.query.from(select_query, alias);
			
			return this;
		}
		public DBObject orderby(String asc_or_desc, String... column_identfiers) {
			
			this.query.orderby(asc_or_desc, column_identfiers);
			
			return this;
		}
		public DBObject orderby(String... column_identfiers) {
			
			this.query.orderby(column_identfiers);
			
			return this;
		}
		public DBObject limit(int constant_integer_type) {
			
			this.query.limit(constant_integer_type);
			
			return this;
		}
		public DBObject inner_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second) {
			
			this.query.inner_join(table_identifier_first, column_identfier_first, table_identifier_second, column_identfier_second);
			
			return this;
		}
		public DBObject left_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second) {
			
			this.query.left_join(table_identifier_first, column_identfier_first, table_identifier_second, column_identfier_second);
			
			return this;
		}
		public DBObject right_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second) {
			
			this.query.right_join(table_identifier_first, column_identfier_first, table_identifier_second, column_identfier_second);
			
			return this;
		}
		public DBObject full_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second) {
			
			this.query.full_join(table_identifier_first, column_identfier_first, table_identifier_second, column_identfier_second);
			
			return this;
		}
		public DBObject union(AbstractedQuery select_query_first, AbstractedQuery select_query_second) {
			
			this.query.union(select_query_first, select_query_second);
			
			return this;
		}
		public DBObject union_all(AbstractedQuery select_query_first, AbstractedQuery select_query_second) {
			
			this.query.union_all(select_query_first, select_query_second);
			
			return this;
		}
		public DBObject into(String table_identifier) {
			
			this.query.into(table_identifier);
			
			return this;
		}
		public DBObject group_by(String column_identfier) {
			
			this.query.group_by(column_identfier);
			
			return this;
		}
		public DBObject having(ExprType expr_type_or_function) {
			
			this.query.having(expr_type_or_function);
			
			return this;
		}
		public DBObject having(String function) {
			
			this.query.having(function);
			
			return this;
		}
		
		//UpdateStmtQuery
		public DBObject update(String table_identifier) {
			
			this.query.update(table_identifier);
			
			return this;
		}
		public DBObject update(AbstractedQuery select_query) {
			
			this.query.update(select_query);
			
			return this;
		}
		public DBObject set(String column_identifier, String constant_type) {
			
			this.query.set(column_identifier, constant_type);
			
			return this;
		}
		public DBObject set(String... constant_types) {
			
			this.query.set(constant_types);
			
			return this;
		}
		
		//InsertStmtQuery (UpdateStmtQuery의 set 메소드 2개 같이 사용)
		public DBObject insert(String table_identifier) {
			
			this.query.insert(table_identifier);
			
			return this;
		}
		public DBObject set(AbstractedQuery select_query) {
			
			this.query.set(select_query);
			
			return this;
		}
		public DBObject set(AbstractedQuery select_query, String... column_identifiers) {
			
			this.query.set(select_query, column_identifiers);
			
			return this;
		}
		
		//DeleteStmtQuery (from은 SelectStmtQuery 부분 걸 같이 사용)
		public DBObject delete() {
			
			this.query.delete();
			
			return this;
		}
		
		//WhereStmtQuery
		public DBObject where(ExprType expr_type) {
			
			this.query.where(expr_type);
			
			return this;
		}
		public DBObject where(AbstractedQuery where_query) {
			
			this.query.where(where_query);
			
			return this;
		}
		public DBObject between(String identifier_type, String constant_type_first, String constant_type_second) {
			
			this.query.between(identifier_type, constant_type_first, constant_type_second);
			
			return this;
		}
		public DBObject not_between(String identifier_type, String constant_type_first, String constant_type_second) {
			
			this.query.not_between(identifier_type, constant_type_first, constant_type_second);
			
			return this;
		}
		public DBObject in(String identifier_type, String... constant_types) {
			
			this.query.in(identifier_type, constant_types);
			
			return this;
		}
		public DBObject in(String identifier_type, AbstractedQuery select_query) {
			
			this.query.in(identifier_type, select_query);
			
			return this;
		}
		public DBObject not_in(String identifier_type, String... constant_types) {
			
			this.query.not_in(identifier_type, constant_types);
			
			return this;
		}
		public DBObject not_in(String identifier_type, AbstractedQuery select_query) {
			
			this.query.not_in(identifier_type, select_query);
			
			return this;
		}
		public DBObject like(String identifier_type, String constant_type) {
			
			this.query.like(identifier_type, constant_type);
			
			return this;
		}
}
