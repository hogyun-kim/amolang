package amolang_AbstractedQuery.ColumnType;

public class ColumnType {

	private String column_identifier;
	private String data_type;
	private boolean not_null;
	private String _default; //문자열일 경우 ''로 묶어서 입력
	
	public ColumnType create_column(String column_identifier,
			String data_type, boolean not_null, String _default) {
		
		this.column_identifier = column_identifier;
		this.data_type = data_type;
		this.not_null = not_null;
		this._default = _default;
		
		return this;
	}
	
	public String getColumn_identifier() {
		
		return column_identifier;
	}
	
	public String getData_type() {
		
		return data_type;
	}
	
	public boolean getNot_null() {
		
		return not_null;
	}
	
	public String getDefault() {
		
		return _default;
	}
}
