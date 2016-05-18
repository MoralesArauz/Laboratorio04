package cr.ac.cr.ucr.ecci.ci1221.teamName.util.collections.tree;
import cr.ac.cr.ucr.ecci.ci1221.teamName.util.collections.list.LinkedList;

public interface Node<T> {
	void addChild(Node<T> child);
	void addChildAt(int index, Node<T> child);
	void removeChildren();
	Node<T> removeChildAt(int index);
	T getData();
	void setData(T data);
	Node<T> getParent();
	void setParent(Node<T> parent);
	LinkedList<Node<T>> getChildren();
	void setChildren(LinkedList<Node<T>> children);
	Node<T> getChildAt(int index);

}
