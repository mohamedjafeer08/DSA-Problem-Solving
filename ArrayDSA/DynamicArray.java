public class DynamicArray{
	private int[] arr;
	private int capacity;
	private int size;

	public DynamicArray(){
		this(10);
	}
	
	public DynamicArray(int capacity){
		this.capacity = capacity;
		arr = new int[capacity];
		size = 0;
	}
	
	public boolean insert(int element){
		if(size>=capacity){
			resize();
		}
		arr[size] = element;
		size++;
		return true;
	}

	public boolean insert(int index, int element){
		if(size>=capacity){
			resize();
		}
		if(index > size || index < 0){
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
			if(arr[i] == value) {
				delete(i);
				bool = true;
			}
		}
		return bool;
	}

	public int get(int index){
		if(index >= size || index < 0){
			System.out.println("Get Failed : Invalid Index");
			return -1;
		}
		return arr[index];
	}

	public boolean set(int index, int value){
		if(index >= size || index < 0){
			System.out.println("Set Failed : Invalid Index");
			return false;
		}
		arr[index] = value;
		return true;
	}

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

	public void resize(){
		capacity = 2 * capacity;
		int[] newArr = new int[capacity];
		for(int i = 0;i<size;i++){
			newArr[i] = arr[i];
		}
		arr = newArr;
	}
	public int getSize(){
		return this.size;
	}

	public int getCapacity(){
		return this.capacity;
	}


	public static void main(String[] args){
		DynamicArray arr = new DynamicArray();
		arr.insert(0, 23);
		arr.insert(56);
		arr.insert(78);
		arr.insert(78);
		arr.insert(78);
		System.out.println("Length Of Array : "+arr.getSize());
		System.out.println("Capacity Of Array : "+arr.getCapacity());
		arr.display();
	}
}
