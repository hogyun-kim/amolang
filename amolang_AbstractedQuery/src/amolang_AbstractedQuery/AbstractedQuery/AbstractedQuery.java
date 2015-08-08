package amolang_AbstractedQuery.AbstractedQuery;

import java.sql.SQLException;
import java.sql.Timestamp;

import amolang_AbstractedQuery.ColumnType.ColumnType;
import amolang_AbstractedQuery.DBObject.DBObject;
import amolang_AbstractedQuery.DBObject.DBObjectMysql;
import amolang_AbstractedQuery.DBObject.DBObjectOracle;
import amolang_AbstractedQuery.DBObject.DatabaseType;
import amolang_AbstractedQuery.ExprType.ExprType;

public class AbstractedQuery implements Connection, PreparedStatement, Query, ResultSet {

	private DBObject dbobject;
	
	public AbstractedQuery(DatabaseType database_type) {
		
		this.dbobject = getDBObject(database_type);	
	}
	
	public AbstractedQuery(DatabaseType database_type, String url, String port, String instance, String user_id, String password) throws ClassNotFoundException, SQLException {
		
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
	
	public String getSql() {
		
		return this.dbobject.getSql();
	}
	
	public void close() throws SQLException {
		
		resultset_close();
		pstmt_close();
		conn_close();
	}

	@Override
	public void connect(DatabaseType database_type, String url, String port, String instance, String user_id, String password) throws ClassNotFoundException, SQLException {
		
		dbobject = getDBObject(database_type);
		dbobject.connect(url, port, instance, user_id, password);
	}
	
	@Override
	public void conn_close() throws SQLException {
		
		dbobject.conn_close();
	}
	
	@Override
	public void excuteUpdate() throws SQLException {
		
		dbobject.excuteUpdate();
	}

	@Override
	public void excuteQuery() throws SQLException {
		
		dbobject.excuteQuery();
	}
	
	@Override
	public void pstmt_close() throws SQLException {
		
		dbobject.pstmt_close();
	}
	
	@Override
	public void setSqlString(int something_index, String something) throws SQLException {
		
		dbobject.setSqlString(something_index, something);
	}
	
	@Override
	public void setSqlInt(int something_index, int something) throws SQLException {
		
		dbobject.setSqlInt(something_index, something);
	}
	
	@Override
	public void setSqlBoolean(int something_index, boolean something) throws SQLException {
		
		dbobject.setSqlBoolean(something_index, something);
	}
	
	@Override
	public void setSqlTimestamp(int something_index, Timestamp something) throws SQLException {
		
		dbobject.setSqlTimestamp(something_index, something);
	}
	
	//DDLQuery
	@Override
	public AbstractedQuery create_db(String database_identifier) {
		
		this.dbobject.create_db(database_identifier);
		
		return this;
	}
	
	@Override
	public AbstractedQuery create_table(String table_identifier, ColumnType... column_types) {
		
		this.dbobject.create_table(table_identifier);
		
		return this;
	}
	
	@Override
	public AbstractedQuery create_view(String view_identifier, AbstractedQuery select_query) {
		
		this.dbobject.create_view(view_identifier, select_query);
		
		return this;
	}
	
	@Override
	public AbstractedQuery drop_table(String table_identifier) {
		
		this.dbobject.drop_table(table_identifier);
		
		return this;
	}
	
	@Override
	public AbstractedQuery drop_view(String view_identifier) {
		
		this.dbobject.drop_view(view_identifier);
		
		return this;
	}
	
	//���⼭���� alter_table ���� �޼ҵ�
	@Override
	public AbstractedQuery alter_table(String table_identifier) {
		
		this.dbobject.alter_table(table_identifier);
		
		return this;
	}
	
	@Override
	public AbstractedQuery add_column(ColumnType column_type) {
		
		this.dbobject.add_column(column_type);
		
		return this;
	}
	
	@Override
	public AbstractedQuery drop_column(String column_identifier) {
		
		this.dbobject.drop_column(column_identifier);
		
		return this;
	}
	
	@Override
	public AbstractedQuery add_primarykey(String... column_identifiers) {
		
		this.dbobject.add_primarykey(column_identifiers);
		
		return this;
	}
	
	@Override
	public AbstractedQuery drop_primarykey() {
		
		this.dbobject.drop_primarykey();
		
		return this;
	}
	
	@Override
	public AbstractedQuery add_foreignkey(String index_identifier, String column_identifier_first, String table_identifier, String column_identifier_second) {
		
		this.dbobject.add_foreignkey(index_identifier, column_identifier_first, table_identifier, column_identifier_second);
		
		return this;
	}
	
	@Override
	public AbstractedQuery drop_foreignkey(String index_identifier) {
		
		this.dbobject.drop_foreignkey(index_identifier);
		
		return this;
	}
	
	@Override
	public AbstractedQuery add_index(String index_identifier, String index_type, String... column_identifiers) {
		
		this.dbobject.add_index(index_identifier, index_type, column_identifiers);
		
		return this;
	}
	
	@Override
	public AbstractedQuery drop_index(String index_identifier) {
		
		this.dbobject.drop_index(index_identifier);
		
		return this;
	}
	
	@Override
	public AbstractedQuery change_column(String column_identifier, ColumnType column_type) {
		
		this.dbobject.change_column(column_identifier, column_type);
		
		return this;
	}
	
	@Override
	public AbstractedQuery add_auto_increment(ColumnType column_type) {
		
		this.dbobject.add_auto_increment(column_type);
		
		return this;
	}
	
	@Override
	public AbstractedQuery handshake_auto_increment(int constant_integer_type) {
		
		this.dbobject.handshake_auto_increment(constant_integer_type);
		
		return this;
	}

	//DMLQuery
		//SelectStmtQuery
		@Override
		public AbstractedQuery select() {
			
			this.dbobject.select();
			
			return this;
		}
		
		@Override
		public AbstractedQuery select(String column_identifier_or_function, String alias) {
			
			this.dbobject.select(column_identifier_or_function, alias);
			
			return this;
		}
		
		@Override
		public AbstractedQuery select(String... column_identifier_or_functions) {
			
			this.dbobject.select(column_identifier_or_functions);
			
			return this;
		}
		
		@Override
		public AbstractedQuery select(ExprType expr_type_or_function, String alias) {
			
			this.dbobject.select(expr_type_or_function, alias);
			
			return this;
		}
		
		@Override
		public AbstractedQuery from(String table_identifier) {
			
			this.dbobject.from(table_identifier);
			
			return this;
		}
		
		@Override
		public AbstractedQuery from(AbstractedQuery select_query) {
			
			this.dbobject.from(select_query);
			
			return this;
		}
		
		@Override
		public AbstractedQuery from(String table_identifier, String alias) {
			
			this.dbobject.from(table_identifier, alias);
			
			return this;
		}
		
		@Override
		public AbstractedQuery from(AbstractedQuery select_query, String alias) {
			
			this.dbobject.from(select_query, alias);
			
			return this;
		}
		
		@Override
		public AbstractedQuery orderby(String asc_or_desc, String... column_identfiers) {
			
			this.dbobject.orderby(asc_or_desc, column_identfiers);
			
			return this;
		}
		
		@Override
		public AbstractedQuery orderby(String... column_identfiers) {
			
			this.dbobject.orderby(column_identfiers);
			
			return this;
		}
		
		@Override
		public AbstractedQuery limit(int constant_integer_type) {
			
			this.dbobject.limit(constant_integer_type);
			
			return this;
		}
		
		@Override
		public AbstractedQuery inner_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second) {
			
			this.dbobject.inner_join(table_identifier_first, column_identfier_first, table_identifier_second, column_identfier_second);
			
			return this;
		}
		
		@Override
		public AbstractedQuery left_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second) {
			
			this.dbobject.left_join(table_identifier_first, column_identfier_first, table_identifier_second, column_identfier_second);
			
			return this;
		}
		
		@Override
		public AbstractedQuery right_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second) {
			
			this.dbobject.right_join(table_identifier_first, column_identfier_first, table_identifier_second, column_identfier_second);
			
			return this;
		}
		
		@Override
		public AbstractedQuery full_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second) {
			
			this.dbobject.full_join(table_identifier_first, column_identfier_first, table_identifier_second, column_identfier_second);
			
			return this;
		}
		
		@Override
		public AbstractedQuery union(AbstractedQuery select_query_first, AbstractedQuery select_query_second) {
			
			this.dbobject.union(select_query_first, select_query_second);
			
			return this;
		}
		
		@Override
		public AbstractedQuery union_all(AbstractedQuery select_query_first, AbstractedQuery select_query_second) {
			
			this.dbobject.union_all(select_query_first, select_query_second);
			
			return this;
		}
		
		@Override
		public AbstractedQuery into(String table_identifier) {
			
			this.dbobject.into(table_identifier);
			
			return this;
		}
		
		@Override
		public AbstractedQuery group_by(String column_identfier) {
			
			this.dbobject.group_by(column_identfier);
			
			return this;
		}
		
		@Override
		public AbstractedQuery having(ExprType expr_type_or_function) {
			
			this.dbobject.having(expr_type_or_function);
			
			return this;
		}
		
		@Override
		public AbstractedQuery having(String function) {
			
			this.dbobject.having(function);
			
			return this;
		}
		
		//UpdateStmtQuery
		@Override
		public AbstractedQuery update(String table_identifier) {
			
			this.dbobject.update(table_identifier);
			
			return this;
		}
		
		@Override
		public AbstractedQuery update(AbstractedQuery select_query) {
			
			this.dbobject.update(select_query);
			
			return this;
		}
		
		@Override
		public AbstractedQuery set(String column_identifier, String constant_type) {
			
			this.dbobject.set(column_identifier, constant_type);
			
			return this;
		}
		
		@Override
		public AbstractedQuery set(String... constant_types) {
			
			this.dbobject.set(constant_types);
			
			return this;
		}
		
		//InsertStmtQuery (UpdateStmtQuery�� set �޼ҵ� 2�� ���� ���)
		@Override
		public AbstractedQuery insert(String table_identifier) {
			
			this.dbobject.insert(table_identifier);
			
			return this;
		}
		
		@Override
		public AbstractedQuery set(AbstractedQuery select_query) {
			
			this.dbobject.set(select_query);
			
			return this;
		}
		
		@Override
		public AbstractedQuery set(AbstractedQuery select_query, String... column_identifiers) {
			
			this.dbobject.set(select_query, column_identifiers);
			
			return this;
		}
		
		//DeleteStmtQuery (from�� SelectStmtQuery �κ� �� ���� ���)
		@Override
		public AbstractedQuery delete() {
			
			this.dbobject.delete();
			
			return this;
		}
		
		//WhereStmtQuery
		@Override
		public AbstractedQuery where(ExprType expr_type) {
			
			this.dbobject.where(expr_type);
			
			return this;
		}
		
		@Override
		public AbstractedQuery where(AbstractedQuery where_query) {
			
			this.dbobject.where(where_query);
			
			return this;
		}
		
		@Override
		public AbstractedQuery between(String identifier_type, String constant_type_first, String constant_type_second) {
			
			this.dbobject.between(identifier_type, constant_type_first, constant_type_second);
			
			return this;
		}
		
		@Override
		public AbstractedQuery not_between(String identifier_type, String constant_type_first, String constant_type_second) {
			
			this.dbobject.not_between(identifier_type, constant_type_first, constant_type_second);
			
			return this;
		}
		
		@Override
		public AbstractedQuery in(String identifier_type, String... constant_types) {
			
			this.dbobject.in(identifier_type, constant_types);
			
			return this;
		}
		
		@Override
		public AbstractedQuery in(String identifier_type, AbstractedQuery select_query) {
			
			this.dbobject.in(identifier_type, select_query);
			
			return this;
		}
		
		@Override
		public AbstractedQuery not_in(String identifier_type, String... constant_types) {
			
			this.dbobject.not_in(identifier_type, constant_types);
			
			return this;
		}
		
		@Override
		public AbstractedQuery not_in(String identifier_type, AbstractedQuery select_query) {
			
			this.dbobject.not_in(identifier_type, select_query);
			
			return this;
		}
		
		@Override
		public AbstractedQuery like(String identifier_type, String constant_type) {
			
			this.dbobject.like(identifier_type, constant_type);
			
			return this;
		}

		@Override
		public boolean next() throws SQLException {

			return dbobject.next();
		}

		@Override
		public String getString(int columnIndex) throws SQLException {

			return dbobject.getString(columnIndex);
		}

		@Override
		public int getInt(int columnIndex) throws SQLException {
			
			return dbobject.getInt(columnIndex);
		}

		@Override
		public boolean getBoolean(int columnIndex) throws SQLException {

			return dbobject.getBoolean(columnIndex);
		}

		@Override
		public Timestamp getTimestamp(int columnIndex) throws SQLException {

			return dbobject.getTimestamp(columnIndex);
		}

		@Override
		public void resultset_close() throws SQLException {
			
			dbobject.resultset_close();
		}	
}
