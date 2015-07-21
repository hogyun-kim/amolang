package amolang_AbstractedQuery.Analyzer;

public interface Tree<T> {

	public abstract void addRootNode(Node<T> node);
	public abstract void addLeftNode(Node<T> node);
	public abstract void addRightNode(Node<T> node);
	public abstract void addNode(Node<T> node);
	public abstract Node<T> getRoot();
}
