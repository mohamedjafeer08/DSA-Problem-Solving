public class CircularLinkedList {
	private Node head;
	private Node tail;
	private int size;
  private class Node{
	  int data;
	  Node next;
	  public Node(int data) {
		  this.data = data;
		  next = null;
	  }
  }
	public CircularLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void insertAtFirst(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
			tail.next = head;
		}
		else {
			newNode.next = head;
			head = newNode;
			tail.next = head;
		}
		size++;
	}
	public void insertAtLast(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
			tail.next = head;
		}
		else {
			tail.next = newNode;
			tail = newNode;
			tail.next = head;
		}
		size++;
	}
	public void insertByIndex(int index, int data) {
		if(index<0 || index>size) return;
		else if(index==0) insertAtFirst(data);
		else if(index==size) insertAtLast(data);
		else {
			Node newNode = new Node(data);
			Node temp = head;
			for(int i = 0;i<index-1;i++) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode; 
			size++;
		}
	}
	public void insert(int data) {
		insertAtLast(data);
	}
	public void deleteAtFirst() {
		if(head != null) {
			head = head.next;
			tail.next = head;
			size--;
		}
	}
	public void deleteAtLast() {
		deleteByIndex(size-1);
	}
	public void delete(int data) {
		if(head == null) return;
		else if(head.data==data) {
			deleteAtFirst();
		}
		else if(tail.data==data) {
			deleteByIndex(size-1);
		}
		else {
			Node temp = head;
			while((temp.next!=head && temp.next.data!=data)){
				temp = temp.next;
			}
			if(temp.next!=null) {
				temp.next = temp.next.next;
				size--;
			}
		}
	}
	public void deleteByIndex(int index) {
		if(index<0 || index>=size || head == null) return;
		else if(index==0) {
			deleteAtFirst();
		}
		else {
			Node temp = head;
			for(int i = 0;i<index-1;i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
			if(index == size-1) {
				tail = temp;
				tail.next = head;
			}
			size--;
		}
	}
	public int getSize() {
		return size;
	}
	public int getFirst() {
		return head.data;
	}
	public int getLast() {
		return tail.data;
	}
	public int getValue(int index) {
		if(index<0 || index>=size || head == null) return-1;
		else if(index==0) return head.data;
		else if(index == size-1) return tail.data;
		else {
			Node temp = head;
			for(int i = 0;i<index-1;i++) {
				temp = temp.next;
			}
			return temp.next.data;
		}
	}
	public int getIndex(int data) {
		if(head.data == data) return 0;
		else if(tail.data == data) return size-1;
		else {
			Node temp = head.next;
			int index = 1;
			while(temp!=null) {
				if(temp.data==data) {
					return index;
				}
				temp = temp.next;
				index++;
			}
			return -1;
		}
	}
	public void updateFirst(int data) {
		head.data = data;
	}
	public void updateLast(int data) {
		tail.data = data;
	}
	public void updateByIndex(int index, int data) {
		if(index<0 || index>=size || head == null) return;
		else if(index == 0) updateFirst(data);
		else if(index == size-1) updateLast(data);
		else {
			Node temp = head;
			for(int i = 0;i<index-1;i++) {
				temp = temp.next;
			}
			temp.next.data = data;
		}
	}
	public boolean contains(int data) {
		if(head.data == data) return true;
		else if(tail.data == data) return true;
		else {
			Node temp = head.next;
			while(temp!=null) {
				if(temp.data==data) {
					return true;
				}
				temp = temp.next;
			}
			return false;
		}
	}
	@Override
	public String toString() {
		Node temp = head;
		StringBuilder s = new StringBuilder();
		s.append("[");
		do{
			s.append(temp.data);
			temp = temp.next;
			if(temp!=head) {
				s.append(", ");
			}
		}while(temp!=head);
		s.append("]"); 
		return String.valueOf(s);
	}
	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		list.insertAtFirst(45);
		list.insertAtLast(56);
		list.insertAtLast(78);
		list.insertByIndex(1, 21);
		list.insert(90);
		System.out.println(list);
//		list.deleteAtFirst();
//		list.deleteAtLast();
//		list.deleteByIndex(4);
//		list.delete(90);
		System.out.println(list);
	}
}
