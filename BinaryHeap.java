public class BinaryHeap {
	
	int size = 0; 
	int [] arr = new int [10];
	
	
	public void add (int priority){
		if (arr.length == size){
			grow_heap();
		}

		arr[size++] = priority;  
		int index = size-1; 
		
		while(arr[index]<arr[parent(index)]&& index>0){
			swap(index, parent(index));
			index = parent(index); 
			
		}	

	}
	
	int parent(int index){
		return (index-1)/2; 
	}
	
	int leftchild(int index){
		return (index*2)+1; 
	}
	
	int rightchild(int index){
		return (index*2)+2; 
	}
	
	private boolean hasLeftChild(int index) {
		
		return leftchild(index)< size;
	
	}

	private boolean hasRightChild(int index) {
		return rightchild(index)< size; 
		
	}
	
	private void grow_heap(){
		int [] new_arr = new int [arr.length*2]; 
		System.arraycopy(arr, 0, new_arr, 0, arr.length);
		arr = new_arr; 
	}
	
	public void swap(int index1, int index2){
		//put index1 inside index2
		int temp = arr[index1]; 
		arr[index1] = arr[index2]; 
		arr[index2] = temp; 
		
		
	}
	public void printHeap(){
		for(int i = 0; i <size; i++){
			
			System.out.print(arr[i]);
			System.out.print(" ");
		}
		System.out.println(size); 
	}
	
	public int remove(){

		int removed = arr[0]; 
		arr[0] = arr[--size]; 
		int index = 0; 
		
		bubbleDown(index);
			
		return removed; 
	}
	
	public void bubbleDown(int index){
		
		
	        while (hasLeftChild(index) && arr[leftchild(index)]< arr[index]) {
	            // which of my children is smaller?
	            int smallerChild = leftchild(index);
	            
	            // bubble with the smaller child, if I have a smaller child
	            if (hasRightChild(index)&& arr[rightchild(index)]<(arr[leftchild(index)])) {
	                smallerChild = rightchild(index);
	            } 
	            
	            if (arr[index]>(arr[smallerChild])) {
	                swap(index, smallerChild);
	                index = smallerChild; 
	            } 	            
	            
	        }  
	    }


}
