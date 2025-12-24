public class StackUsingArray {
	private int[] stack;
	private int size;
	private int capacity;
	private int index;
	public StackUsingArray() {
		this(11);
	}
	public StackUsingArray(int capacity){
		this.capacity = capacity;
		this.stack = new int[capacity];
		this.size = 0;
		this.index = -1;
	}
	public void stackGrow(){
		this.capacity *= 2;
		int[] newStack = new int[this.capacity];
		for(int i = 0;i<size;i++) {
			newStack[i] = this.stack[i];
		}
		this.stack = newStack;
	}
	public void stackShrink() {
		int[] newStack = new int[this.capacity];
		for(int i = 0;i<size-1;i++) {
			newStack[i] = stack[i];
		}
		this.stack = newStack;
	}
	public void push(int data) {
		if(size==capacity) {
			stackGrow();
		}
		stack[++index] = data;
		size++;
	}
	public int pop() {
		if(size == 0) {
			return -1;
		}else {
			int temp = stack[index--];
			stackShrink();
			size--;
			return temp;
		}
	}
	public int peek() {
		if(size == 0) {
			return -1;
		}
		return stack[index];
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
			sb.append(stack[i]);
			if(i != size-1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return String.valueOf(sb);
	}
	public static void main(String[] args) {
		StackUsingArray stack = new StackUsingArray ();
		stack.push(10);
		stack.push(30);;
		stack.push(98);
		stack.push(68);
		
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		
		System.out.println(stack);
	}
}
