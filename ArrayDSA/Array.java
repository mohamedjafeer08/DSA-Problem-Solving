public class Array{
	private int[] arr;
	private int capacity;
	private int size;
	
	public Array(int capacity){
		this.capacity = capacity;
		arr = new int[capacity];
		size = 0;
	}

	// Insert Time Complexity --> O(1)
	
	public boolean insert(int element){                                   
		if(size>=capacity){
			System.out.println("Insert Failed : Array is Full");
			return false;
		}
		arr[size] = element;
		size++;
		return true;
	}
	
	// Insert Specific Index Time Complexity --> O(N)

	public boolean insert(int index, int element){							
		if(index > size || index < 0 || size>=capacity){
			System.out.println("Insert Failed : Invalid Index Or Array is Full");
			return false;
		}
		for(int i = size;i>index;i--){
			arr[i] = arr[i-1];
		}
		arr[index] = element;
		size++;
		return true;
	}

	// Delete Time Complexity --> O(N)

	public boolean delete(int index){
		if(index >= size || index < 0){
			System.out.println("Delete Failed : Invalid Index");
			return false;
		}
		for(int i = index;i<size-1;i++){
			arr[i] = arr[i+1];
		}
		size--;
		return true;
	}
	public boolean remove(int value) {
		boolean bool = false;
		for(int i = 0;i<size;i++) {
			if(this.arr[i] == value) {
				delete(i);
				bool = true;
			}
		}
		return bool;
	}

	// Get Time Complexity --> O(1)

	public int get(int index){
		if(index >= size || index < 0){
			System.out.println("Get Failed : Invalid Index");
			return -1;
		}
		return arr[index];
	}

	// Set Time Complexity --> O(1)

	public boolean set(int index, int value){
		if(index >= size || index < 0){
			System.out.println("Set Failed : Invalid Index");
			return false;
		}
		arr[index] = value;
		return true;
	}

	// Linear Search Time Complexity --> O(N);
	public int search(int target){
		for(int i = 0;i<size;i++){
			if(arr[i]==target) return i;
		}
		return -1;
	}

	public void display(){
		System.out.print("[");
		for(int i = 0;i<size;i++){
			System.out.print(arr[i]);
			if(i!=size-1){
				System.out.print(", ");
			}
		}
		System.out.print("]");
		System.out.println();
	}

	// Get Size Time Complexity --> O(1)

	public int getSize(){
		return this.size;
	}

	// Get Capacity Time Complexity --> O(1)

	public int getCapacity(){
		return this.capacity;
	}

	public static void main(String[] args){
		Array arr = new Array(10);
		arr.insert(0, 23);
		arr.insert(1, 44);
		arr.insert(2, 56);
		arr.insert(0, 78);
		arr.insert(85);
		arr.insert(44);
		arr.display();
		arr.remove(44);
		arr.display();

	}
}
