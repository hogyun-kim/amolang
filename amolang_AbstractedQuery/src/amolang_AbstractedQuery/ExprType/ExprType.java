package amolang_AbstractedQuery.ExprType;

import amolang_AbstractedQuery.Analyzer.Node;
import amolang_AbstractedQuery.Analyzer.OperatorAnalyzer;


public abstract class ExprType {
	
	protected OperatorAnalyzer analyzer;
	protected AbstractedOperator operator;
	
	public ExprType() {
		analyzer = new OperatorAnalyzer();
	}
	
	public OperatorAnalyzer getAnalyzer() {
		return analyzer;
	}
	
	public AbstractedOperator getOperator() {
		return operator;
	}
	
	public ExprType and(ExprType expr_type) {
		
		Node<Object> root = new Node<Object>();
		Node<Object> node = analyzer.getRoot();
		
		root.setData(new String("AND"));
		
		analyzer.addRootNode(root);
		analyzer.addNode(node);
		analyzer.addNode(expr_type.getAnalyzer().getRoot());
		
		return this;
	}
	
	public ExprType and(String identifier_type) {
		
		Node<Object> root = new Node<Object>();
		Node<Object> left_node = analyzer.getRoot();
		Node<Object> right_node = new Node<Object>();
		
		root.setData(new String("AND"));
		right_node.setData(identifier_type);
		
		analyzer.addRootNode(root);
		analyzer.addNode(left_node);
		analyzer.addNode(right_node);
		
		return this;
	}
	
	public ExprType or(ExprType expr_type) {
		
		Node<Object> root = new Node<Object>();
		Node<Object> node = analyzer.getRoot();
		
		root.setData(new String("OR"));
		
		analyzer.addRootNode(root);
		analyzer.addNode(node);
		analyzer.addNode(expr_type.getAnalyzer().getRoot());
		
		return this;
	}
	
	public ExprType or(String identifier_type) {
		
		Node<Object> root = new Node<Object>();
		Node<Object> left_node = analyzer.getRoot();
		Node<Object> right_node = new Node<Object>();
		
		root.setData(new String("OR"));
		right_node.setData(identifier_type);
		
		analyzer.addRootNode(root);
		analyzer.addNode(left_node);
		analyzer.addNode(right_node);
		
		return this;
	}
	
	public abstract ExprType equal(ExprType expr_type_first, ExprType expr_type_second);
	public abstract ExprType equal(String identifier_type_first, String identifier_type_second);
	public abstract ExprType not_equal(ExprType expr_type_first, ExprType expr_type_second);
	public abstract ExprType not_equal(String identifier_type_first, String identifier_type_second);
	public abstract ExprType greater(ExprType expr_type_first, ExprType expr_type_second);
	public abstract ExprType greater(String identifier_type_first, String identifier_type_second);
	public abstract ExprType less(ExprType expr_type_first, ExprType expr_type_second);
	public abstract ExprType less(String identifier_type_first, String identifier_type_second);
	public abstract ExprType greater_equal(ExprType expr_type_first, ExprType expr_type_second);
	public abstract ExprType greater_equal(String identifier_type_first, String identifier_type_second);
	public abstract ExprType less_equal(ExprType expr_type_first, ExprType expr_type_second);
	public abstract ExprType less_equal(String identifier_type_first, String identifier_type_second);
}
