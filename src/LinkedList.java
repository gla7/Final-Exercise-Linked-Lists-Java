
public class LinkedList {
	private Node head;
	private Node tail;
	
	public Node getHead () {
		return this.head;
	}
	
	public Node getTail () {
		return this.tail;
	}
	
	public void insertAtHead (int data) {
		Node newNode = new Node(data);
		newNode.setNextNode(this.head);
		this.head = newNode;
	}
	
	public void setTail (int data) {
		Node newTail = new Node(data);
		if (this.head == null) {
			this.head = newTail;
			this.tail = newTail;
		}
		if (this.tail != null) {
			this.tail.setNextNode(newTail);
			this.tail = newTail;
		}
	}
	
	public int length () {
		int length = 0;
		Node current = this.head;
		while (current != null) {
			current = current.getNextNode();
			length++;
		}
		return length;
	}

	public String toString() {
		String result = "{";
		Node current = this.head;
		
		while (current != null) {
			result = result + current.toString() + ", ";
			current = current.getNextNode();
		}
		result = result + "END}";
		return result;
	}
	
	public void deleteFromHead () {
		this.head = this.head.getNextNode();
	}
	
	public Node find (int searchingForThis) {
		Node current = this.head;
		while (current != null) {
			if (current.getData() == searchingForThis) {
				return current;
			}
			current = current.getNextNode();
		}
		return null;
	}
	
	public void insertNewElement (int data) {
		Node newNode = new Node(data);
		Node current = this.head;
		if (current == null) {
			this.insertAtHead(data);
		}
		while (current != null) {
			if (this.head == current) {
				if (current.getData() > newNode.getData()) {
					this.insertAtHead(data);
					break;
				} else if (current.getNextNode() == null) {
					current.setNextNode(newNode);
					break;
				} else if (current.getNextNode().getData() > newNode.getData()) {
					newNode.setNextNode(current.getNextNode());
					current.setNextNode(newNode);
					break;
				}
			} else {
				if (current.getNextNode() == null) {
					current.setNextNode(newNode);
					break;
				} else if (current.getNextNode().getData() > newNode.getData()) {
					newNode.setNextNode(current.getNextNode());
					current.setNextNode(newNode);
					break;
				}
			}
			current = current.getNextNode();
		}
	}
	
	public void appendLastNToStart (int n) {// first exercise is to append the last n nodes of a list to the beginning with this method
		int length = this.length();
		if (n > length) {
			System.out.println("NOT POSSIBLE BRAH");
		} else {
			int stepsToAdvance = length - n;
			Node toStart = this.head;
			Node current = this.head;
			Node last = this.head;
			for (int i = 1; i <= stepsToAdvance; i++) {
				toStart = toStart.getNextNode();
			}
			for (int j = 1; j <= length - 1; j++) {
				last = last.getNextNode();
			}
			this.head = toStart;
			for (int k = 1; k <= stepsToAdvance; k++) {
				last.setNextNode(current);
				last = last.getNextNode();
				current = current.getNextNode();
				if (k == stepsToAdvance) {
					last.setNextNode(null);
				}
			}
			Node currentNew = this.head;
			while (currentNew != null) {
				currentNew = currentNew.getNextNode();
			}
		}
	}
	
	public void reverse () {// a method to reverse the linked list, of complexity O(n)
		Node current = this.head.getNextNode();
		int counter = 0;
		Node formerHead = this.head;
		while (current != null) {
			int temp = current.getData();
			this.insertAtHead(temp);
			if (counter == 0) {
				formerHead.setNextNode(null);
			}
			current = current.getNextNode();
			counter++;
		}
	}
	
	public Node findKthFromEnd (int k) {// a method to find the kth from the end of complexity O(n)
		int length = this.length();
		int fromBeginning = length - k - 1;
		int counter = 0;
		Node current = this.head;
		while (current != null) {
			if (counter == fromBeginning) {
				break;
			}
			current = current.getNextNode();
			counter++;
		}
		return current;
	}
	
	public LinkedList removeDupes () {// this algorithm removes dupes from a linked list, and has time complexity of 1 + (n-1)*(4 + 4*(n-1 + n-2 + ... + 2 + 1)) ~ O(n^2)
		Node current = this.head;
		while (current.getNextNode() != null) {
			Node checker = current.getNextNode();
			Node prevToChecker = current;
			while(checker != null) {
				if (checker.getData() == current.getData()) {
					prevToChecker.setNextNode(checker.getNextNode());
					checker = checker.getNextNode();
				} else {
					prevToChecker = checker;
					checker = checker.getNextNode();
				}
			}
			current = current.getNextNode();
		}
		return this;
	}
	
	public LinkedList removeNode (Node n) {// this remove given node method has time complexity of O(n)
		Node current = this.head;
		Node previousNode = null;
		while (current != null) {
			if (current == this.head) {
				if (current == n) {
					Node newNextNode = current.getNextNode().getNextNode();
					this.insertAtHead(current.getNextNode().getData());
					this.head.setNextNode(newNextNode);
					break;
				}
			} else {
				if (current == n) {
					previousNode.setNextNode(current.getNextNode());
					break;
				}
			}
			previousNode = current;
			current = current.getNextNode();
		}
		return this;
		// an alternative clever method is this:
//		public void deleteNode(Node n) {
//			if (n != null && n.getNextNode() != null) {
//				n.setData(n.getNextNode().getData()); // copy the data over to n
//				n.setNextNode(n.getNextNode().getNextNode()); // next node of n is deleted now
//			}
//		}
	}
	
	public Boolean isCircular () {// this algorithm identifies the linkedList as circular, and assumes use of head and tail
		if (this.tail.getNextNode() == this.head) {
			return true;
		}
		return false;
	}
 }
