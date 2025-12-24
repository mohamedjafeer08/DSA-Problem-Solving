public class DoublyLinkedList {
	private Node head;
	private Node tail;
	private int size;

  private class Node{
	  Node prev;
	  int data;
	  Node next;
	  public Node(int data) {
		  prev = null;
		  this.data = data;
		  next = null;
	  }
  }
	public DoublyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	public DoublyLinkedList(int[] arr) {
		for(int num : arr) {
			insertAtLast(num);
		}
	}
	public int[] toArray() {
		int[] arr = new int[this.getSize()];
		for(int i = 0;i<arr.length;i++) {
			arr[i] = this.getByIndex(i);
		}
		return arr;
	}
	public void insertAtFirst(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
			size++;
		}
		else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
			size++;
		}
	}
	public void insertAtLast(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
			size++;
		}
		else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			size++;
		}
	}
	public int getSize() {
		return size;
	}
	public void insertAtIndex(int index, int data) {
		if(index<0 || index>size) return;
		else if(index==0) insertAtFirst(data);
		else if(index==size) insertAtLast(data);
		else {
			Node newNode = new Node(data);
			Node temp = head;
			for(int i = 1;i<=index-1;i++) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next.prev = newNode;
			temp.next = newNode;
			newNode.prev = temp;
			size++;
		}
	}
	public void add(int data) {
		insertAtLast(data);
	}
	public void deleteAtFirst() {
		head = head.next;
		head.prev = null;
		size--;
	}
	public void deleteAtLast() {
		tail = tail.prev;
		tail.next = null;
		size--;
	}
	public void deleteAtIndex(int index) {
		if(index<0 || index>=size || head == null) return;
		else if(index == 0) deleteAtFirst();
		else if(index == size-1) deleteAtLast();
		else {
			Node temp = head;
			for(int i = 1;i<=index-1;i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
			temp.next.prev = temp;
		}
	}
	public void delete(int data) {
		if(head == null) return;
		else if(head.data == data) deleteAtFirst();
		else if(tail.data == data) deleteAtLast();
		else {
			Node temp = head.next;
			while(temp.data != data) {
				temp = temp.next;
			}
			temp.next.prev= temp.prev;
			temp.prev.next = temp.next;
		}
	}
	public int getFirst() {
		if(head == null) return -1;
		return head.data;
	}
	public int getLast() {
		if(head == null) return -1;
		return tail.data;
	}
	public int getByIndex(int index) {
		if(index<0 || index>=size || head == null) return -1;
		else if(index == 0) return head.data;
		else if(index == size-1) return tail.data;
		else {
			Node temp = head.next;
			for(int i = 1;i<=index - 1;i++) {
				temp = temp.next;
			}
			return temp.data;
		}
	}
	public int getByValue(int data) {
		if(head.data == data) return 0;
		else if(tail.data == data) return size-1;
		else {
			int index = 1;
			Node temp = head.next;
			while(temp.data != data) {
				temp = temp.next;
				index++;
			}
			return index;
		}
	}
	public void update(int index, int data) {
		if(index<0 || index>=size || head == null) return;
		else if(index == 0) head.data = data;
		else if(index == size-1) tail.data = data;
		else {
			Node temp = head.next;
			for(int i = 0;i<index-1;i++) {
				temp = temp.next;
			}
			temp.data = data;
		}
	}

	@Override
	public String toString() {
		StringBuilder  s = new StringBuilder();
		s.append("[");
		Node temp = head;
		while(temp!= null) {
			s.append(temp.data);
			if(temp.next!=null) {
				s.append(", ");
			}
			temp = temp.next;
		}
		s.append("]");
		return String.valueOf(s);
	}
	public static void main(String[] args) {
		int[] arr = {2, 3, 5, 1, 1, 4};
		DoublyLinkedList list = new DoublyLinkedList(arr);
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		int[] arr1 = list.toArray();
		System.out.println(Arrays.toString(arr1));
		
//		System.out.println(list);
//		System.out.println(list.getSize());
//		System.out.println(list.getByIndex(1));
//		list.update(0, 90);
//		System.out.println(list);
//		System.out.println(list.getFirst());
//		System.out.println(list.getLast());
//		System.out.println(list.getSize());
		

		
//		int sum = 0;
//		for(int i = 0;i<list.getSize();i++) {
//			sum += list.getByIndex(i);
//		}
//		System.out.println(sum);
		
//		list.update(4, 25);
		
//		System.out.println(list.getSize());
//		System.out.println(list.getByValue(98));
//		System.out.println(list.getByIndex());
//		System.out.println(list.getLast());
//		System.out.println(list.getFirst());
		
		
//		list.deleteAtFirst();
//		list.deleteAtLast();
//   	list.deleteAtIndex(1);
//		list.delete(83);
	}
}
