public class QueueUsingArray{
	private int capacity;
	private int[] queue;
	private int index;
	private int size;
	public QueueUsingArray() {
		this(17);
	}
	public QueueUsingArray (int capacity) {
		this.capacity = capacity;
		this.queue = new int[capacity];
		this.index = -1;
		this.size = 0;
	}
	public void queueGrow() {
		this.capacity *= 2;
		int[] newQueue = new int[this.capacity];
		for(int i = 0;i<size;i++) {
			newQueue[i] = queue[i];
		}
		queue = newQueue;
	}
	public void queueShrink() {
		int[] newQueue = new int[this.capacity];
		for(int i = 1;i<size;i++) {
			newQueue[i-1] = queue[i];
		}
		queue = newQueue;
	}
	public void offer(int data) {
		if(size==capacity) {
			queueGrow();
		}
		queue[++index] = data;
		size++;
	}
	public int poll() {
		if(size == 0) {
			return -1;
		}
		else {
			int temp = queue[0];
			queueShrink();
			index--;
			size--;
			return temp;
		}
	}
	public int peek() {
		if(size == 0) {
			return -1;
		}
		else {
			return queue[0];
		}
	}
	public boolean isEmpty() {
		if(size == 0) {
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
		for(int i = 0;i<size;i++) {
			sb.append(queue[i]);
			if(i != size-1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return String.valueOf(sb);
	}
	public static void main(String[] args) {
		QueueUsingArrayqueue = new QueueUsingArray();     // Front for First Element
		queue.offer(67);               // Rear For Last Element
		queue.offer(78);               // Enqueue For Insert
		queue.offer(21);               // Dequeue For Delete
		queue.offer(54);
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue);
//		System.out.println(queue.poll());
//		System.out.println(queue.peek());
//		System.out.println(queue);

//		System.out.println(sum);
//		System.out.println(queue);
//		System.out.println(queue.isEmpty());
//		System.out.println(queue.getSize());
//		System.out.println(queue);
	}
	
}