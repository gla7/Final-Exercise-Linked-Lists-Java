
public class Node {// here we also demonstrate how to make nodes for doubly linked lists, but will not use them for sorting in the linked list object
	
	private int data;
	private Node nextNode;
	
	public int getData () {
		return this.data;
	}
	
	public Node getNextNode () {
		return this.nextNode;
	}
	
	public void setData (int data) {
		this.data = data;
	}
	
	public void setNextNode (Node nextNode) {
		this.nextNode = nextNode;
	}
	
	public Node (int data) {
		this.data = data;
	}
	
	public String toString() {
		return "Data: " + this.data;
	}
	
}
