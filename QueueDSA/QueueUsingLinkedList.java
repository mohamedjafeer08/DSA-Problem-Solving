public class QueueUsingLinkedList {
	private Node front;
	private Node rear;
	private int size;
	private class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public QueueUsingLinkedList () {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}
	public void offer(int data) {
		Node newNode = new Node(data);
		if(front == null) {
			front = newNode;
			front = newNode;
		}
		else {
			newNode.next = rear;
			rear = newNode;
		}
		size++;
	}
	public int poll() {
		if(front == null) {
			return -1;
		}
		else {
			int temp = front.data;
			front = front.next;
			size--;
			return temp;
		}
	
	}
	public int peek() {
		if(front == null) {
			return -1;
		}
		else {
			return front.data;
		}
	}
	public boolean isEmpty() {
		if(front == null) {
			return true;
		}
		else {
			return false;
		}
	}
	public int getSize() {
		return this.size;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node temp = front;
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
		QueueUsingLinkedList queue = new QueueUsingLinkedList ();
		queue.offer(56);
		queue.offer(98);
		queue.offer(90);
		queue.offer(23);
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue);
	}
}
