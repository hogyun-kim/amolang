package amolang_AbstractedQuery.ExpressionType;

public class MultipleExprType extends ExprType {

	public MultipleExprType equal(ExprType expr_type_first, ExprType expr_type_second) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += "(";
			this.add(expr_type_first);
			query += ") = (";
			this.add(expr_type_second);
			query += ")";			
		}		
		
		return this;
	}
	
	public MultipleExprType equal(String identifier_type_first, String identifier_type_second) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += identifier_type_first +" = '" +identifier_type_second +"'";			
		}		
		
		return this;
	}
	
	public MultipleExprType not_equal(ExprType expr_type_first, ExprType expr_type_second) {

		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += "(";
			this.add(expr_type_first);
			query += ") != (";
			this.add(expr_type_second);
			query += ")";			
		}
		
		return this;
	}
	
	public MultipleExprType not_equal(String identifier_type_first, String identifier_type_second) {

		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += identifier_type_first +" != '" +identifier_type_second +"'";			
		}
		
		return this;
	}
	
	public MultipleExprType greater(ExprType expr_type_first, ExprType expr_type_second) {

		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += "(";
			this.add(expr_type_first);
			query += ") < (";
			this.add(expr_type_second);
			query += ")";			
		}		
		
		return this;
	}
	
	public MultipleExprType greater(String identifier_type_first, String identifier_type_second) {

		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += identifier_type_first +" < '" +identifier_type_second +"'";		
		}
		
		return this;
	}
	
	public MultipleExprType less(ExprType expr_type_first, ExprType expr_type_second) {

		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += "(";
			this.add(expr_type_first);
			query += ") > (";
			this.add(expr_type_second);
			query += ")";			
		}
		
		return this;
	}
	
	public MultipleExprType less(String identifier_type_first, String identifier_type_second) {

		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += identifier_type_first +" > '" +identifier_type_second +"'";		
		}
		
		return this;
	}
	
	public MultipleExprType greater_equal(ExprType expr_type_first, ExprType expr_type_second) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += "(";
			this.add(expr_type_first);
			query += ") <= (";
			this.add(expr_type_second);
			query += ")";			
		}
		
		return this;
	}
	
	public MultipleExprType greater_equal(String identifier_type_first, String identifier_type_second) {

		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += identifier_type_first +" <= '" +identifier_type_second +"'";			
		}
		
		return this;
	}
	
	public MultipleExprType less_equal(ExprType expr_type_first, ExprType expr_type_second) {
		
		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += "(";
			this.add(expr_type_first);
			query += ") >= (";
			this.add(expr_type_second);
			query += ")";			
		}
		
		return this;
	}
	
	public MultipleExprType less_equal(String identifier_type_first, String identifier_type_second) {

		if(db == Database.valueOf("oracle")) {
			
		}
		else if(db == Database.valueOf("mysql")) {
			
			query += identifier_type_first +" >= '" +identifier_type_second +"'";
			
		}
		
		return this;
	}

}
