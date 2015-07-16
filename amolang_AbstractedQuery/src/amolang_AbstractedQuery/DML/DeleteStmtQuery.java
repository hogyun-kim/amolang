package amolang_AbstractedQuery.DML;

public class DeleteStmtQuery extends WhereStmtQuery {

	public DeleteStmtQuery delete() {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			query += "delete ";
		}
		
		return this;
	}
	
	public DeleteStmtQuery from(String table_identifier) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			query += "from " +table_identifier +";";
		}
		
		return this;
	}
}
