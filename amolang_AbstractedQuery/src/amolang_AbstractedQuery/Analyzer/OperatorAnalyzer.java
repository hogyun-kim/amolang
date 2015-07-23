package amolang_AbstractedQuery.Analyzer;

import amolang_AbstractedQuery.DBObject.DBObject;
import amolang_AbstractedQuery.ExprType.AbstractedOperator;
import amolang_AbstractedQuery.ExprType.ExprType;

public class OperatorAnalyzer implements Tree<Object> {

	private Node<Object> root;
	
	public OperatorAnalyzer() {
		
		root = null;
	}
	
	public String analysis(DBObject dbobject, ExprType expr_type) {

		String expression = "";
		Node<Object> root = expr_type.getAnalyzer().getRoot();
		
		if(root == null) {
			
			expression += "";
			
			return expression;
		}
		
		if(root.getLeft_node() != null) 
			expression += "(" +Traversal(dbobject, root.getLeft_node()) +" ";
		
		if(root.getData().getClass() == AbstractedOperator.class) 
			expression += dbobject.getOperator(((AbstractedOperator) root.getData()).name());
		else
			expression += root.getData().toString();
		
		if(root.getRight_node() != null)
			expression += " " +Traversal(dbobject, root.getRight_node()) +")";

		return expression;
	}
	
	public String Traversal(DBObject dbobject, Node<Object> node) {
			
		String expression = "";
		
		if(node == null) {
			
			expression += "";
			
			return expression;
		}
		
		if(node.getLeft_node() != null) 
			expression += "(" +Traversal(dbobject, node.getLeft_node()) +" ";
		
		if(node.getData().getClass() == AbstractedOperator.class) 
			expression += dbobject.getOperator(((AbstractedOperator) node.getData()).name());
		else
			expression += node.getData().toString();
		
		if(node.getRight_node() != null)
			expression += " " +Traversal(dbobject, node.getRight_node()) +")";
		
		return expression;
	}

	@Override
	public Node<Object> getRoot() {
		return root;
	}

	@Override
	public void addRootNode(Node<Object> node) {
	
		root = node;
	}

	@Override
	public void addLeftNode(Node<Object> node) {

		root.setLeft_node(node);
	}

	@Override
	public void addRightNode(Node<Object> node) {

		root.setRight_node(node);
	}

	@Override
	public void addNode(Node<Object> node) {

		Node<Object> temp_node = node;
		
		if(root == null) {
			addRootNode(temp_node);
			return;
		}
		else if(root.getLeft_node() == null) {
			addLeftNode(temp_node);
			return;
		}
		else if(root.getRight_node() == null) {
			addRightNode(temp_node);
		}	
	}

}
