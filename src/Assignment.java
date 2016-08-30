
public class Assignment {

	public static void main(String[] args) {
		
		//testing the append last n at the beginning method...
		
		LinkedList list = new LinkedList();
		LinkedList list2 = new LinkedList();
		LinkedList list3 = new LinkedList();
		LinkedList list4 = new LinkedList();
		
		list.insertAtHead(3);
		list.insertAtHead(1);
		list.insertAtHead(5);
		list.insertAtHead(7);
		list.insertAtHead(8);
		list.insertAtHead(2);
		list.insertAtHead(12);
		list.insertAtHead(1);
		
		list2.insertAtHead(11);
		
		list3.insertAtHead(2);
		list3.insertAtHead(-1);
		list3.insertAtHead(5);
		list3.insertAtHead(3);
		list3.insertAtHead(11);
		list3.insertAtHead(-1);
		list3.insertAtHead(12);
		list3.insertAtHead(12);
		list3.insertAtHead(12);
		
		list4.insertAtHead(2);
		list4.insertAtHead(-12);
		
		System.out.println(list);
		System.out.println(list2);
		System.out.println(list3);
		System.out.println(list4);
		
		// append the beggining of the list with the last n elements, see if keeping the length is helpful
		
		list.appendLastNToStart(4);
		list2.appendLastNToStart(2);
		list3.appendLastNToStart(9);
		list4.appendLastNToStart(0);
		
		System.out.println(list);
		System.out.println(list2);
		System.out.println(list3);
		System.out.println(list4);
		
		// testing the reverse linkedList method ...
		
		LinkedList list5 = new LinkedList();
		
		list5.insertAtHead(9);
		list5.insertAtHead(8);
		list5.insertAtHead(7);
		list5.insertAtHead(6);
		list5.insertAtHead(5);
		list5.insertAtHead(4);
		list5.insertAtHead(3);
		list5.insertAtHead(2);
		list5.insertAtHead(1);
		
		list5.reverse();
		
		System.out.println(list5);
		
		//testing finding kth from the end ...
		
		LinkedList list6 = new LinkedList();
		
		list6.insertAtHead(90);
		list6.insertAtHead(80);
		list6.insertAtHead(70);
		list6.insertAtHead(60);
		list6.insertAtHead(50);
		list6.insertAtHead(40);
		list6.insertAtHead(30);
		list6.insertAtHead(20);
		list6.insertAtHead(10);
		
		System.out.println(list6);
		System.out.println(list6.findKthFromEnd(9));
		System.out.println(list6.findKthFromEnd(1));
		System.out.println(list6.findKthFromEnd(6));
		System.out.println(list6.findKthFromEnd(0));
		
		//testing removeDupes ...
		
		LinkedList list7 = new LinkedList();
		
		list7.insertAtHead(200);
		list7.insertAtHead(90);
		list7.insertAtHead(90);
		list7.insertAtHead(70);
		list7.insertAtHead(20);
		list7.insertAtHead(20);
		list7.insertAtHead(20);
		list7.insertAtHead(50);
		list7.insertAtHead(40);
		list7.insertAtHead(70);
		list7.insertAtHead(20);
		list7.insertAtHead(50);
		list7.insertAtHead(10);
		
		System.out.println(list7);
		System.out.println(list7.removeDupes());
		
		//testing remove given item ... essentially you get a linked list starting at a node and you remove said node
		
		LinkedList list8 = new LinkedList();
		
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		one.setNextNode(two);
		two.setNextNode(three);
		three.setNextNode(four);
		four.setNextNode(five);
		
		list8.insertAtHead(0);
		list8.getHead().setNextNode(one);
		list8.getHead().getNextNode().setNextNode(two);
		list8.getHead().getNextNode().getNextNode().setNextNode(three);
		list8.getHead().getNextNode().getNextNode().getNextNode().setNextNode(four);
		list8.getHead().getNextNode().getNextNode().getNextNode().getNextNode().setNextNode(five);
		
		System.out.println(list8);
		
//		System.out.println(list8.removeNode(one));
//		System.out.println(list8.removeNode(two));
//		System.out.println(list8.removeNode(three));
//		System.out.println(list8.removeNode(four));
		System.out.println(list8.removeNode(five));
		
		//finally, we identify a circular linkedList using the tail element (not used anywhere else purposefully)...
		
		LinkedList list9 = new LinkedList();
		LinkedList list10 = new LinkedList();
		
		list9.setTail(1);
		list9.setTail(2);
		list9.setTail(3);
		list9.setTail(4);
		list9.setTail(5);
		
		System.out.println(list9.isCircular());
		
		list10 = list9;
		list10.getTail().setNextNode(list10.getHead());
		
		System.out.println(list9.isCircular());
		
	}

}
