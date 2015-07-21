package amolang_AbstractedQuery.ExprType;

import amolang_AbstractedQuery.Analyzer.Node;

public class MultipleExprType extends ExprType {

	@Override
	public ExprType equal(ExprType expr_type_first, ExprType expr_type_second) {

		Node<Object> root = new Node<Object>();
		
		operator = AbstractedOperator.EQUAL;
		root.setData(operator);
		
		analyzer.addNode(root);
		analyzer.addNode(expr_type_first.getAnalyzer().getRoot());
		analyzer.addNode(expr_type_second.getAnalyzer().getRoot());
		
		return this;
	}

	@Override
	public ExprType equal(String identifier_type_first,
			String identifier_type_second) {

		Node<Object> root = new Node<Object>();
		Node<Object> left_node = new Node<Object>();
		Node<Object> right_node = new Node<Object>();
		
		operator = AbstractedOperator.EQUAL;
		root.setData(operator);
		left_node.setData(identifier_type_first);
		right_node.setData(identifier_type_second);
		
		analyzer.addNode(root);
		analyzer.addNode(left_node);
		analyzer.addNode(right_node);
		
		return this;
	}

	@Override
	public ExprType not_equal(ExprType expr_type_first,
			ExprType expr_type_second) {

		Node<Object> root = new Node<Object>();
		
		operator = AbstractedOperator.NOT_EQUAL;
		root.setData(operator);
		
		analyzer.addNode(root);
		analyzer.addNode(expr_type_first.getAnalyzer().getRoot());
		analyzer.addNode(expr_type_second.getAnalyzer().getRoot());
		
		return this;
	}

	@Override
	public ExprType not_equal(String identifier_type_first,
			String identifier_type_second) {

		Node<Object> root = new Node<Object>();
		Node<Object> left_node = new Node<Object>();
		Node<Object> right_node = new Node<Object>();
		
		operator = AbstractedOperator.NOT_EQUAL;
		root.setData(operator);
		left_node.setData(identifier_type_first);
		right_node.setData(identifier_type_second);
		
		analyzer.addNode(root);
		analyzer.addNode(left_node);
		analyzer.addNode(right_node);
		
		return this;
	}

	@Override
	public ExprType greater(ExprType expr_type_first, ExprType expr_type_second) {

		Node<Object> root = new Node<Object>();
		
		operator = AbstractedOperator.GREATER;
		root.setData(operator);
		
		analyzer.addNode(root);
		analyzer.addNode(expr_type_first.getAnalyzer().getRoot());
		analyzer.addNode(expr_type_second.getAnalyzer().getRoot());
		
		return this;
	}

	@Override
	public ExprType greater(String identifier_type_first,
			String identifier_type_second) {

		Node<Object> root = new Node<Object>();
		Node<Object> left_node = new Node<Object>();
		Node<Object> right_node = new Node<Object>();
		
		operator = AbstractedOperator.GREATER;
		root.setData(operator);
		left_node.setData(identifier_type_first);
		right_node.setData(identifier_type_second);
		
		analyzer.addNode(root);
		analyzer.addNode(left_node);
		analyzer.addNode(right_node);
		
		return this;
	}

	@Override
	public ExprType less(ExprType expr_type_first, ExprType expr_type_second) {

		Node<Object> root = new Node<Object>();
		
		operator = AbstractedOperator.LESS;
		root.setData(operator);
		
		analyzer.addNode(root);
		analyzer.addNode(expr_type_first.getAnalyzer().getRoot());
		analyzer.addNode(expr_type_second.getAnalyzer().getRoot());
		
		return this;
	}

	@Override
	public ExprType less(String identifier_type_first,
			String identifier_type_second) {

		Node<Object> root = new Node<Object>();
		Node<Object> left_node = new Node<Object>();
		Node<Object> right_node = new Node<Object>();
		
		operator = AbstractedOperator.LESS;
		root.setData(operator);
		left_node.setData(identifier_type_first);
		right_node.setData(identifier_type_second);
		
		analyzer.addNode(root);
		analyzer.addNode(left_node);
		analyzer.addNode(right_node);
		
		return this;
	}

	@Override
	public ExprType greater_equal(ExprType expr_type_first,
			ExprType expr_type_second) {

		Node<Object> root = new Node<Object>();
		
		operator = AbstractedOperator.GREATER_EQUAL;
		root.setData(operator);
		
		analyzer.addNode(root);
		analyzer.addNode(expr_type_first.getAnalyzer().getRoot());
		analyzer.addNode(expr_type_second.getAnalyzer().getRoot());
		
		return this;
	}

	@Override
	public ExprType greater_equal(String identifier_type_first,
			String identifier_type_second) {

		Node<Object> root = new Node<Object>();
		Node<Object> left_node = new Node<Object>();
		Node<Object> right_node = new Node<Object>();
		
		operator = AbstractedOperator.GREATER_EQUAL;
		root.setData(operator);
		left_node.setData(identifier_type_first);
		right_node.setData(identifier_type_second);
		
		analyzer.addNode(root);
		analyzer.addNode(left_node);
		analyzer.addNode(right_node);
		
		return this;
	}

	@Override
	public ExprType less_equal(ExprType expr_type_first,
			ExprType expr_type_second) {

		Node<Object> root = new Node<Object>();
		
		operator = AbstractedOperator.LESS_EQUAL;
		root.setData(operator);
		
		analyzer.addNode(root);
		analyzer.addNode(expr_type_first.getAnalyzer().getRoot());
		analyzer.addNode(expr_type_second.getAnalyzer().getRoot());
		
		return this;
	}

	@Override
	public ExprType less_equal(String identifier_type_first,
			String identifier_type_second) {

		Node<Object> root = new Node<Object>();
		Node<Object> left_node = new Node<Object>();
		Node<Object> right_node = new Node<Object>();
		
		operator = AbstractedOperator.LESS_EQUAL;
		root.setData(operator);
		left_node.setData(identifier_type_first);
		right_node.setData(identifier_type_second);
		
		analyzer.addNode(root);
		analyzer.addNode(left_node);
		analyzer.addNode(right_node);
		
		return this;
	}

}
