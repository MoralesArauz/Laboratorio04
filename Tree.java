package cr.ac.cr.ucr.ecci.ci1221.teamName.util.collections.tree;
import cr.ac.cr.ucr.ecci.ci1221.teamName.util.collections.list.LinkedList;

public interface Tree<T> {

	boolean isEmpty();
	Node<T> getRoot();
	boolean exists(T key);
	int getNumberOfNodes();
	int getNumberOfDescendants(Node<T> node);
	LinkedList<Node<T>> getPreOrderTraversal();
	LinkedList<Node<T>> getInOrderTraversal();
	LinkedList<Node<T>> getPostOrderTraversal();
	LinkedList<Node<T>> getLongestPathFromRootToAnyLeaf();
	int getMaxDepth();
	LinkedList<LinkedList<Node<T>>> getPathsFromRootToAnyLeaf();

}
