import java.util.Arrays;

public class SinglyLinkedList {
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
	public SinglyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	public SinglyLinkedList(int[] arr) {
		for(int num : arr) {
			insertAtLast(num);
		}
	}
	public int[] toArray() {
		int[] arr = new int[this.getSize()];
		for(int i = 0;i<arr.length;i++) {
			arr[i] = this.getValue(i);
		}
		return arr;
	}
	public void insertAtFirst(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		if(head == null) {
			tail = newNode;
		}
		size++;
	}
	public void insertAtLast(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
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
			while(temp.next!=null && temp.next.data!=data) {
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
			head = head.next;
			size--;
		}
		else {
			Node temp = head;
			for(int i = 0;i<index-1;i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
			if(index == size-1) {
				tail = temp;
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
	public void reverse() {
		Node prev = null;
		Node current = head;
		Node next = null;
		while(current!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}
	@Override
	public String toString() {
		Node temp = head;
		StringBuilder s = new StringBuilder();
		s.append("[");
		while(temp!=null) {
			s.append(temp.data);
			temp = temp.next;
			if(temp!=null) {
				s.append(", ");
			}
		}
		s.append("]");
		return String.valueOf(s);
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		SinglyLinkedList list = new SinglyLinkedList (arr);
		list.insertAtLast(23);
		list.insertAtLast(31);
		list.insertAtLast(45);
		list.insertAtLast(89);
		
		int[] arr1 = list.toArray();
		System.out.println(Arrays.toString(arr1));
		SinglyLinkedList list2 = new SinglyLinkedList (arr1);
		System.out.println(list2);
		
//		list.insertAtLast(55);
//		list.insertAtFirst(34);
//		list.insert(67);
//		list.insertByIndex(3, 72);
//		System.out.println(list);
////		list.delete(72);
////		list.deleteByIndex(0);
////		list.deleteAtFirst();
////		list.deleteAtLast();
//		System.out.println(list);
		
		//list.delete(55);
		//list.deleteByIndex(0);
		//list.deleteAtFirst();
		//list.deleteAtLast();
		
		//System.out.println(list.getValue(2));
		//System.out.println(list.getIndex(67));
		//System.out.println(list.getFirst());
		//System.out.println(list.getLast());
		//System.out.println("Size : "+list.getSize());
		
		//list.updateFirst(29);
		//list.updateLast(74);
		//list.updateByIndex(1, 23);
	}
}