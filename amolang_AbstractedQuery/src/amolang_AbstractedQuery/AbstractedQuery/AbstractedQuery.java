package amolang_AbstractedQuery.AbstractedQuery;

import java.sql.Connection;

import amolang_AbstractedQuery.ColumnType.ColumnType;
import amolang_AbstractedQuery.DBObject.DBObject;
import amolang_AbstractedQuery.DBObject.DBObjectMysql;
import amolang_AbstractedQuery.DBObject.DBObjectOracle;
import amolang_AbstractedQuery.DBObject.DatabaseType;
import amolang_AbstractedQuery.ExprType.ExprType;

public class AbstractedQuery {

	private DBObject dbobject;
	private Connection connection;
	
	public AbstractedQuery(DatabaseType database_type) {
		
		this.dbobject = getDBObject(database_type);	
	}
	
	public AbstractedQuery(DatabaseType database_type, String url, int port, String instance, String user_id, String password) {
		
		connect(database_type, url, port, instance, user_id, password);
	}
	
	public DBObject getDBObject(DatabaseType database_type) {
		
		switch(database_type) {
			case DATABASE_TYPE_ORACLE:
				return new DBObjectOracle();
			case DATABASE_TYPE_MYSQL:
				return new DBObjectMysql();
			default:
				return null;
		}
	}
	
	public void connect(DatabaseType database_type, String url, int port, String instance, String user_id, String password) {
		
		dbobject = getDBObject(database_type);
		connection = dbobject.connect(url, port, instance, user_id, password);
	}
	
	public Connection getConnection() {
		
		return connection;
	}
	
	//TODO excuteQuery()
	//TODO close()
	
	public String getSql() {
		
		return this.dbobject.getSql();
	}
	
	//DDLQuery
	public AbstractedQuery create_db(String database_identifier) {
		
		this.dbobject.create_db(database_identifier);
		
		return this;
	}
	public AbstractedQuery create_table(String table_identifier, ColumnType... column_types) {
		
		this.dbobject.create_table(table_identifier);
		
		return this;
	}
	public AbstractedQuery create_view(String view_identifier, AbstractedQuery select_query) {
		
		this.dbobject.create_view(view_identifier, select_query);
		
		return this;
	}
	public AbstractedQuery drop_table(String table_identifier) {
		
		this.dbobject.drop_table(table_identifier);
		
		return this;
	}
	public AbstractedQuery drop_view(String view_identifier) {
		
		this.dbobject.drop_view(view_identifier);
		
		return this;
	}
	//여기서부터 alter_table 하위 메소드
	public AbstractedQuery alter_table(String table_identifier) {
		
		this.dbobject.alter_table(table_identifier);
		
		return this;
	}
	public AbstractedQuery add_column(ColumnType column_type) {
		
		this.dbobject.add_column(column_type);
		
		return this;
	}
	public AbstractedQuery drop_column(String column_identifier) {
		
		this.dbobject.drop_column(column_identifier);
		
		return this;
	}
	public AbstractedQuery add_primarykey(String... column_identifiers) {
		
		this.dbobject.add_primarykey(column_identifiers);
		
		return this;
	}
	public AbstractedQuery drop_primarykey() {
		
		this.dbobject.drop_primarykey();
		
		return this;
	}
	public AbstractedQuery add_foreignkey(String index_identifier, String column_identifier_first, String table_identifier, String column_identifier_second) {
		
		this.dbobject.add_foreignkey(index_identifier, column_identifier_first, table_identifier, column_identifier_second);
		
		return this;
	}
	public AbstractedQuery drop_foreignkey(String index_identifier) {
		
		this.dbobject.drop_foreignkey(index_identifier);
		
		return this;
	}
	public AbstractedQuery add_index(String index_identifier, String index_type, String... column_identifiers) {
		
		this.dbobject.add_index(index_identifier, index_type, column_identifiers);
		
		return this;
	}
	public AbstractedQuery drop_index(String index_identifier) {
		
		this.dbobject.drop_index(index_identifier);
		
		return this;
	}
	public AbstractedQuery change_column(String column_identifier, ColumnType column_type) {
		
		this.dbobject.change_column(column_identifier, column_type);
		
		return this;
	}
	
	public AbstractedQuery add_auto_increment(ColumnType column_type) {
		
		this.dbobject.add_auto_increment(column_type);
		
		return this;
	}
	
	public AbstractedQuery handshake_auto_increment(int constant_integer_type) {
		
		this.dbobject.handshake_auto_increment(constant_integer_type);
		
		return this;
	}

	//DMLQuery
		//SelectStmtQuery
		public AbstractedQuery select() {
			
			this.dbobject.select();
			
			return this;
		}
		public AbstractedQuery select(String column_identifier_or_function, String alias) {
			
			this.dbobject.select(column_identifier_or_function, alias);
			
			return this;
		}
		public AbstractedQuery select(String... column_identifier_or_functions) {
			
			this.dbobject.select(column_identifier_or_functions);
			
			return this;
		}
		public AbstractedQuery select(ExprType expr_type_or_function, String alias) {
			
			this.dbobject.select(expr_type_or_function, alias);
			
			return this;
		}
		public AbstractedQuery from(String table_identifier) {
			
			this.dbobject.from(table_identifier);
			
			return this;
		}
		public AbstractedQuery from(AbstractedQuery select_query) {
			
			this.dbobject.from(select_query);
			
			return this;
		}
		public AbstractedQuery from(String table_identifier, String alias) {
			
			this.dbobject.from(table_identifier, alias);
			
			return this;
		}
		public AbstractedQuery from(AbstractedQuery select_query, String alias) {
			
			this.dbobject.from(select_query, alias);
			
			return this;
		}
		public AbstractedQuery orderby(String asc_or_desc, String... column_identfiers) {
			
			this.dbobject.orderby(asc_or_desc, column_identfiers);
			
			return this;
		}
		public AbstractedQuery orderby(String... column_identfiers) {
			
			this.dbobject.orderby(column_identfiers);
			
			return this;
		}
		public AbstractedQuery limit(int constant_integer_type) {
			
			this.dbobject.limit(constant_integer_type);
			
			return this;
		}
		public AbstractedQuery inner_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second) {
			
			this.dbobject.inner_join(table_identifier_first, column_identfier_first, table_identifier_second, column_identfier_second);
			
			return this;
		}
		public AbstractedQuery left_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second) {
			
			this.dbobject.left_join(table_identifier_first, column_identfier_first, table_identifier_second, column_identfier_second);
			
			return this;
		}
		public AbstractedQuery right_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second) {
			
			this.dbobject.right_join(table_identifier_first, column_identfier_first, table_identifier_second, column_identfier_second);
			
			return this;
		}
		public AbstractedQuery full_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second) {
			
			this.dbobject.full_join(table_identifier_first, column_identfier_first, table_identifier_second, column_identfier_second);
			
			return this;
		}
		public AbstractedQuery union(AbstractedQuery select_query_first, AbstractedQuery select_query_second) {
			
			this.dbobject.union(select_query_first, select_query_second);
			
			return this;
		}
		public AbstractedQuery union_all(AbstractedQuery select_query_first, AbstractedQuery select_query_second) {
			
			this.dbobject.union_all(select_query_first, select_query_second);
			
			return this;
		}
		public AbstractedQuery into(String table_identifier) {
			
			this.dbobject.into(table_identifier);
			
			return this;
		}
		public AbstractedQuery group_by(String column_identfier) {
			
			this.dbobject.group_by(column_identfier);
			
			return this;
		}
		public AbstractedQuery having(ExprType expr_type_or_function) {
			
			this.dbobject.having(expr_type_or_function);
			
			return this;
		}
		public AbstractedQuery having(String function) {
			
			this.dbobject.having(function);
			
			return this;
		}
		
		//UpdateStmtQuery
		public AbstractedQuery update(String table_identifier) {
			
			this.dbobject.update(table_identifier);
			
			return this;
		}
		public AbstractedQuery update(AbstractedQuery select_query) {
			
			this.dbobject.update(select_query);
			
			return this;
		}
		public AbstractedQuery set(String column_identifier, String constant_type) {
			
			this.dbobject.set(column_identifier, constant_type);
			
			return this;
		}
		public AbstractedQuery set(String... constant_types) {
			
			this.dbobject.set(constant_types);
			
			return this;
		}
		
		//InsertStmtQuery (UpdateStmtQuery의 set 메소드 2개 같이 사용)
		public AbstractedQuery insert(String table_identifier) {
			
			this.dbobject.insert(table_identifier);
			
			return this;
		}
		public AbstractedQuery set(AbstractedQuery select_query) {
			
			this.dbobject.set(select_query);
			
			return this;
		}
		public AbstractedQuery set(AbstractedQuery select_query, String... column_identifiers) {
			
			this.dbobject.set(select_query, column_identifiers);
			
			return this;
		}
		
		//DeleteStmtQuery (from은 SelectStmtQuery 부분 걸 같이 사용)
		public AbstractedQuery delete() {
			
			this.dbobject.delete();
			
			return this;
		}
		
		//WhereStmtQuery
		public AbstractedQuery where(ExprType expr_type) {
			
			this.dbobject.where(expr_type);
			
			return this;
		}
		public AbstractedQuery where(AbstractedQuery where_query) {
			
			this.dbobject.where(where_query);
			
			return this;
		}
		public AbstractedQuery between(String identifier_type, String constant_type_first, String constant_type_second) {
			
			this.dbobject.between(identifier_type, constant_type_first, constant_type_second);
			
			return this;
		}
		public AbstractedQuery not_between(String identifier_type, String constant_type_first, String constant_type_second) {
			
			this.dbobject.not_between(identifier_type, constant_type_first, constant_type_second);
			
			return this;
		}
		public AbstractedQuery in(String identifier_type, String... constant_types) {
			
			this.dbobject.in(identifier_type, constant_types);
			
			return this;
		}
		public AbstractedQuery in(String identifier_type, AbstractedQuery select_query) {
			
			this.dbobject.in(identifier_type, select_query);
			
			return this;
		}
		public AbstractedQuery not_in(String identifier_type, String... constant_types) {
			
			this.dbobject.not_in(identifier_type, constant_types);
			
			return this;
		}
		public AbstractedQuery not_in(String identifier_type, AbstractedQuery select_query) {
			
			this.dbobject.not_in(identifier_type, select_query);
			
			return this;
		}
		public AbstractedQuery like(String identifier_type, String constant_type) {
			
			this.dbobject.like(identifier_type, constant_type);
			
			return this;
		}	
}
