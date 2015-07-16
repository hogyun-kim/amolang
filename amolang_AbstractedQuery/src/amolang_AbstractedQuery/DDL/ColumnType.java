package amolang_AbstractedQuery.DDL;

import amolang_AbstractedQuery.Database.DatabaseManager;
import amolang_AbstractedQuery.ExpressionType.ExprType;

public class ColumnType extends DatabaseManager {

	private String datatype;
	private boolean notnull;
	private CreateIndexType unique;
	private PrimaryKeyType primarykey;
	private ForeignKeyType foreignkey;
	private ExprType check; 
	private String _default;
	private boolean auto_increment;
	
	public ColumnType create_column(String datatype, boolean notnull, CreateIndexType unique,
			PrimaryKeyType primarykey, ForeignKeyType foreignkey, ExprType check,
			String _default, boolean auto_increment) {
		
		ColumnType c_t = new ColumnType();
		
		c_t.datatype = datatype;
		c_t.notnull = notnull;
		c_t.unique = unique;
		c_t.primarykey = primarykey;
		c_t.foreignkey = foreignkey;
		c_t.check = check;
		c_t._default = _default;
		c_t.auto_increment = auto_increment;
		
		return c_t;
	}
	
	public String getDatatype() {
		if(db == Database.valueOf("oracle")) {
			return null;
		}
		else if(db == Database.valueOf("mysql")) {
			
			return datatype;
		}
		else {
			return "error";
		}
	}
	
	public String getNotnull() {
		
		if(db == Database.valueOf("oracle")) {
			return null;
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(notnull == true)
				return "NOT NULL";
			else
				return "NULL";
		}
		else {
			return "error";
		}
	}
	
	public String getUnique() {
		
		if(unique == null)
			return null;
		else
			return unique.getQuery();
	}
	
	public String getPrimarykey() {
		
		if(primarykey == null)
			return null;
		else
			return primarykey.getQuery();
	}
	
	public String getForeignkey() {
		
		if(foreignkey == null)
			return null;
		else
			return foreignkey.getQuery();
	}
	
	public String getCheck() {
		
		if(db == Database.valueOf("oracle")) {
			return null;
		}
		else if(db == Database.valueOf("mysql")) {
			return "";
		}	
		else {
			return "error";
		}
	}
	
	public String getDefault() {
		
		if(db == Database.valueOf("oracle")) {
			return null;
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(_default != null)
				return "DEFAULT " +_default;
			else
				return "";
		}
		else {
			return "error";
		}
	}
	
	public String getAuto_increment() {
		
		if(db == Database.valueOf("oracle")) {
			return null;
		}
		else if(db == Database.valueOf("mysql")) {
			
			if(auto_increment == true)
				return "AUTO_INCREMENT";
			else
				return "";
		}
		else {
			return "error";
		}
	}
}
