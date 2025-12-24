public class StackUsingLinkedList {
	private Node top;
	private int size;
	private class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public StackUsingLinkedList () {
		this.top = null;
		this.size = 0;
	}
	public void push(int data) {
		Node newNode = new Node(data);
		if(top == null) {
			top = newNode;
		}
		else {
			newNode.next = top;
			top = newNode;
		}
		size++;
	}
	public int pop() {
		int temp = top.data;
		top = top.next;
		size--;
		return temp;
	}
	public int peek() {
		return top.data;
	}
	public boolean isEmpty() {
		if(top == null) {
			return true;
		}
		else {
			return false;
		}
	}
	public int getSize() {
		return size;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node temp = top;
		while(temp!=null) {
			sb.append(temp.data);
			temp = temp.next;
			if(temp!=null) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return String.valueOf(sb);
	}
	public static void main(String[] args) {
		StackUsingLinkedList stack = new StackUsingLinkedList ();
		for(int i = 1;i<=20;i++) {
			stack.push(i);
		}
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty());
		System.out.println(stack.getSize());
		System.out.println(stack);
	}
	
}
