package amolang_AbstractedQuery.DBQuery;

import amolang_AbstractedQuery.AbstractedQuery.AbstractedQuery;
import amolang_AbstractedQuery.ColumnType.ColumnType;
import amolang_AbstractedQuery.DBObject.DatabaseType;
import amolang_AbstractedQuery.DBQuery.DDLQuery.DDLQuery;
import amolang_AbstractedQuery.DBQuery.DDLQuery.DDLQueryMysql;
import amolang_AbstractedQuery.DBQuery.DDLQuery.DDLQueryOracle;
import amolang_AbstractedQuery.DBQuery.DMLQuery.DMLQuery;
import amolang_AbstractedQuery.DBQuery.DMLQuery.DMLQueryMysql;
import amolang_AbstractedQuery.DBQuery.DMLQuery.DMLQueryOracle;
import amolang_AbstractedQuery.ExprType.ExprType;

public class DBQuery {

	private DDLQuery ddlquery;
	private DMLQuery dmlquery;
	
	public DBQuery(DatabaseType database_type) {
		
		this.ddlquery = getDDLQuery(database_type);
		this.dmlquery = getDMLQuery(database_type);		
	}
	
	public DDLQuery getDDLQuery(DatabaseType database_type) {
		
		switch(database_type) {
		case DATABASE_TYPE_ORACLE:
			ddlquery = new DDLQueryOracle();
			break;
		case DATABASE_TYPE_MYSQL:
			ddlquery = new DDLQueryMysql();
			break;
		default:
			ddlquery = null;
		}
		
		ddlquery.handshake();
		
		return ddlquery;
	}
	
	public DMLQuery getDMLQuery(DatabaseType database_type) {
		
		switch(database_type) {
			case DATABASE_TYPE_ORACLE:
				dmlquery = new DMLQueryOracle();
				break;
			case DATABASE_TYPE_MYSQL:
				dmlquery = new DMLQueryMysql();
				break;
			default:
				dmlquery = null;
		}
		
		dmlquery.handshake();
		
		return dmlquery;
	}
	
	public String getDdl_sql() {
		
		dmlquery.handshake();
		
		return ddlquery.getSql();
	}
	
	public String getDml_sql() {
		
		ddlquery.handshake();
		
		return dmlquery.getSql();
	}
	
	public String getSql() {

		String ddl_sql = getDdl_sql();
		String dml_sql = getDml_sql();
	
		if(ddl_sql.equals("") && !dml_sql.equals(""))
			return dml_sql;
		else if(!ddl_sql.equals("") && dml_sql.equals("")) 
			return ddl_sql;
		else
			return null;
	}
	
	public void handshake() {
		
		ddlquery.handshake();
		dmlquery.handshake();
	}
	
	//DDLQuery
	public DBQuery create_db(String database_identifier) {
		
		this.ddlquery.create_db(database_identifier);
		
		return this;
	}
	public DBQuery create_table(String table_identifier, ColumnType... column_types) {
		
		this.ddlquery.create_table(table_identifier);
		
		return this;
	}
	public DBQuery create_view(String view_identifier, AbstractedQuery select_query) {
		
		this.ddlquery.create_view(view_identifier, select_query);
		
		return this;
	}
	public DBQuery drop_table(String table_identifier) {
		
		this.ddlquery.drop_table(table_identifier);
		
		return this;
	}
	public DBQuery drop_view(String view_identifier) {
		
		this.ddlquery.drop_view(view_identifier);
		
		return this;
	}
	//여기서부터 alter_table 하위 메소드
	public DBQuery alter_table(String table_identifier) {
		
		this.ddlquery.alter_table(table_identifier);
		
		return this;
	}
	public DBQuery add_column(ColumnType column_type) {
		
		this.ddlquery.add_column(column_type);
		
		return this;
	}
	public DBQuery drop_column(String column_identifier) {
		
		this.ddlquery.drop_column(column_identifier);
		
		return this;
	}
	public DBQuery add_primarykey(String... column_identifiers) {
		
		this.ddlquery.add_primarykey(column_identifiers);
		
		return this;
	}
	public DBQuery drop_primarykey() {
		
		this.ddlquery.drop_primarykey();
		
		return this;
	}
	public DBQuery add_foreignkey(String index_identifier, String column_identifier_first, String table_identifier, String column_identifier_second) {
		
		this.ddlquery.add_foreignkey(index_identifier, column_identifier_first, table_identifier, column_identifier_second);
		
		return this;
	}
	public DBQuery drop_foreignkey(String index_identifier) {
		
		this.ddlquery.drop_foreignkey(index_identifier);
		
		return this;
	}
	public DBQuery add_index(String index_identifier, String index_type, String... column_identifiers) {
		
		this.ddlquery.add_index(index_identifier, index_type, column_identifiers);
		
		return this;
	}
	public DBQuery drop_index(String index_identifier) {
		
		this.ddlquery.drop_index(index_identifier);
		
		return this;
	}
	public DBQuery change_column(String column_identifier, ColumnType column_type) {
		
		this.ddlquery.change_column(column_identifier, column_type);
		
		return this;
	}
	
	public DBQuery add_auto_increment(ColumnType column_type) {
		
		this.ddlquery.add_auto_increment(column_type);
		
		return this;
	}
	
	public DBQuery handshake_auto_increment(int constant_integer_type) {
		
		this.ddlquery.handshake_auto_increment(constant_integer_type);
		
		return this;
	}

	//DMLQuery
		//SelectStmtQuery
		public DBQuery select() {
			
			this.dmlquery.select();
			
			return this;
		}
		public DBQuery select(String column_identifier_or_function, String alias) {
			
			this.dmlquery.select(column_identifier_or_function, alias);
			
			return this;
		}
		public DBQuery select(String... column_identifier_or_functions) {
			
			this.dmlquery.select(column_identifier_or_functions);
			
			return this;
		}
		public DBQuery select(ExprType expr_type_or_function, String alias) {
			
			this.dmlquery.select(expr_type_or_function, alias);
			
			return this;
		}
		public DBQuery from(String table_identifier) {
			
			this.dmlquery.from(table_identifier);
			
			return this;
		}
		public DBQuery from(AbstractedQuery select_query) {
			
			this.dmlquery.from(select_query);
			
			return this;
		}
		public DBQuery from(String table_identifier, String alias) {
			
			this.dmlquery.from(table_identifier, alias);
			
			return this;
		}
		public DBQuery from(AbstractedQuery select_query, String alias) {
			
			this.dmlquery.from(select_query, alias);
			
			return this;
		}
		public DBQuery orderby(String asc_or_desc, String... column_identfiers) {
			
			this.dmlquery.orderby(asc_or_desc, column_identfiers);
			
			return this;
		}
		public DBQuery orderby(String... column_identfiers) {
			
			this.dmlquery.orderby(column_identfiers);
			
			return this;
		}
		public DBQuery limit(int constant_integer_type) {
			
			this.dmlquery.limit(constant_integer_type);
			
			return this;
		}
		public DBQuery inner_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second) {
			
			this.dmlquery.inner_join(table_identifier_first, column_identfier_first, table_identifier_second, column_identfier_second);
			
			return this;
		}
		public DBQuery left_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second) {
			
			this.dmlquery.left_join(table_identifier_first, column_identfier_first, table_identifier_second, column_identfier_second);
			
			return this;
		}
		public DBQuery right_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second) {
			
			this.dmlquery.right_join(table_identifier_first, column_identfier_first, table_identifier_second, column_identfier_second);
			
			return this;
		}
		public DBQuery full_join(String table_identifier_first, String column_identfier_first,
				String table_identifier_second, String column_identfier_second) {
			
			this.dmlquery.full_join(table_identifier_first, column_identfier_first, table_identifier_second, column_identfier_second);
			
			return this;
		}
		public DBQuery union(AbstractedQuery select_query_first, AbstractedQuery select_query_second) {
			
			this.dmlquery.union(select_query_first, select_query_second);
			
			return this;
		}
		public DBQuery union_all(AbstractedQuery select_query_first, AbstractedQuery select_query_second) {
			
			this.dmlquery.union_all(select_query_first, select_query_second);
			
			return this;
		}
		public DBQuery into(String table_identifier) {
			
			this.dmlquery.into(table_identifier);
			
			return this;
		}
		public DBQuery group_by(String column_identfier) {
			
			this.dmlquery.group_by(column_identfier);
			
			return this;
		}
		public DBQuery having(ExprType expr_type_or_function) {
			
			this.dmlquery.having(expr_type_or_function);
			
			return this;
		}
		public DBQuery having(String function) {
			
			this.dmlquery.having(function);
			
			return this;
		}
		
		//UpdateStmtQuery
		public DBQuery update(String table_identifier) {
			
			this.dmlquery.update(table_identifier);
			
			return this;
		}
		public DBQuery update(AbstractedQuery select_query) {
			
			this.dmlquery.update(select_query);
			
			return this;
		}
		public DBQuery set(String column_identifier, String constant_type) {
			
			this.dmlquery.set(column_identifier, constant_type);
			
			return this;
		}
		public DBQuery set(String... constant_types) {
			
			this.dmlquery.set(constant_types);
			
			return this;
		}
		
		//InsertStmtQuery (UpdateStmtQuery의 set 메소드 2개 같이 사용)
		public DBQuery insert(String table_identifier) {
			
			this.dmlquery.insert(table_identifier);
			
			return this;
		}
		public DBQuery set(AbstractedQuery select_query) {
			
			this.dmlquery.set(select_query);
			
			return this;
		}
		public DBQuery set(AbstractedQuery select_query, String... column_identifiers) {
			
			this.dmlquery.set(select_query, column_identifiers);
			
			return this;
		}
		
		//DeleteStmtQuery (from은 SelectStmtQuery 부분 걸 같이 사용)
		public DBQuery delete() {
			
			this.dmlquery.delete();
			
			return this;
		}
		
		//WhereStmtQuery
		public DBQuery where(ExprType expr_type) {
			
			this.dmlquery.where(expr_type);
			
			return this;
		}
		public DBQuery where(AbstractedQuery where_query) {
			
			this.dmlquery.where(where_query);
			
			return this;
		}
		public DBQuery between(String identifier_type, String constant_type_first, String constant_type_second) {
			
			this.dmlquery.between(identifier_type, constant_type_first, constant_type_second);
			
			return this;
		}
		public DBQuery not_between(String identifier_type, String constant_type_first, String constant_type_second) {
			
			this.dmlquery.not_between(identifier_type, constant_type_first, constant_type_second);
			
			return this;
		}
		public DBQuery in(String identifier_type, String... constant_types) {
			
			this.dmlquery.in(identifier_type, constant_types);
			
			return this;
		}
		public DBQuery in(String identifier_type, AbstractedQuery select_query) {
			
			this.dmlquery.in(identifier_type, select_query);
			
			return this;
		}
		public DBQuery not_in(String identifier_type, String... constant_types) {
			
			this.dmlquery.not_in(identifier_type, constant_types);
			
			return this;
		}
		public DBQuery not_in(String identifier_type, AbstractedQuery select_query) {
			
			this.dmlquery.not_in(identifier_type, select_query);
			
			return this;
		}
		public DBQuery like(String identifier_type, String constant_type) {
			
			this.dmlquery.like(identifier_type, constant_type);
			
			return this;
		}
}
