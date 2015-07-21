package amolang_AbstractedQuery.Analyzer;

public class Node<T> {

	private T data;
	private Node<T> left_node;
	private Node<T> right_node;
	
	public Node() {
		
		data = null;
		left_node = null;
		right_node = null;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public void setLeft_node(Node<T> left_node) {
		this.left_node = left_node;
	}
	
	public Node<T> getLeft_node() {
		return left_node;
	}
	
	public void setRight_node(Node<T> right_node) {
		this.right_node = right_node;
	}
	
	public Node<T> getRight_node() {
		return right_node;
	}
}
