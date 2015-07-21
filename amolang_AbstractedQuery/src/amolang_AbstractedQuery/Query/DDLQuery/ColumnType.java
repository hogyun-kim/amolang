package amolang_AbstractedQuery.Query.DDLQuery;

public class ColumnType {

	private String column_identifier;
	private String data_type;
	private String[] constraints; 
	
	public ColumnType create_column(String column_identifier, String data_type, String... constraints) {
		
		this.column_identifier = column_identifier;
		this.data_type = data_type;
		this.constraints = constraints;
		
		return this;
	}
	
	public String getColumn_identifier() {
		
		return column_identifier;
	}
	
	public String getData_type() {
		
		return data_type;
	}
	
	public String[] getConstraints() {
		
		return constraints;
	}
}
