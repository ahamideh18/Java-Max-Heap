public class MaxHeap {
	private Integer[] heap;     //Stores heap elements
	private int size; 			//Max size of heap
	private int sizeHeap;       //Number of elements in the heap

	//---------------------------------------------Constructors--------------------------------------------
	public MaxHeap(int n) {
		this.heap=new Integer[n]; //The heap array is allocated a memory size of n
		this.size=n; //The maximum size of the heap is allocated as n
		this.sizeHeap=0; //The heap is empty therefore its actual size is set to 0
	}

	public MaxHeap(Integer[] someArray) { 
		this.size=someArray.length; //The maximum size of the heap is set to the length of the array
		heap=new Integer[this.size]; //Creating a new array to store the elements of the heap
		for (int i=0;i<this.size;i++) { //Looping through the input array
			this.insert(someArray[i]); //Calling the insert function to place heap elements in the correct place
		}
	}

	//-------------------------------------insert() and helper methods----------------------------------
	//THETA(1) for best case and THETA(logN) in worst and average case
	
	public void insert(int n) {
		if (this.sizeHeap+1>this.size) { // Creating a larger heap if it is already filled
			Integer[] copy=new Integer[this.size*2];
			for(int i=0;i<this.size;i++) {
				copy[i]=heap[i]; // copying every element in the old heap to the new resized heap
			}
			copy[this.size]=n; // The new element, n, is inserted into the new heap at the end of the array
			this.size=copy.length; // The new memory allocated for the heap array is the length of the array
			this.heap=copy; // The original heap is overwritten as the the copy heap
		}
		heap[sizeHeap++]=n; //The element is placed at the available index
		percolateUp(sizeHeap-1); //If the heap conditions are violated, the added element is percolated to the right spot
	}
	
	private void percolateUp(int i) {
        int currInt=heap[i];
        while(currInt>heap[(i-1)/2]&&i>0){ //If the element being percolated is not the first element in the list and it is larger than its parent 
            heap[i]=heap[(i-1)/2]; //If the condition above is met, the larger element is swapped with the smaller element
            i=(i-1)/2; //Index of the parent node is equal to (i-1)/2
        }
        heap[i]=currInt;
    }
	//----------------------------------deleteMax() and helper methods---------------------------------------
	//THETA(1) for best case and THETA(logN) in worst and average case
	
	private int deleteMax() { 
		int maxVal=heap[0]; //In the array representation of a maxHeap the first element is always the largest element
		heap[0]=heap[sizeHeap-1]; //In deletion, the element deleted is replaced with the last element in the heap
		sizeHeap--; //The size of the heap is decreased by 1 when an element is deleted
		
		int i=0,childInd, temp=heap[i]; //We need to check the conditions for the heap and percolate the root down if it violates any conditions
		while(2*i+1<sizeHeap){ //While the program is not on the last level of the heap binary tree
			childInd=lgChild(i); //The parent is only compared to its largest child
			if(temp<heap[childInd]){ //If the first element in the heap is larger then it's largest child
				heap[i]=heap[childInd]; //Switch their spots
			}
			else {
				break; //Otherwise the heap satisfies all conditions and no changes are made
			}
			
			i=childInd;
		}
		heap[i]=temp; 
		return maxVal; //return maxVal
	}
	
	private int lgChild(int i) {  //This method finds the largest child in a subtree
		int leftChild=2*i+1;  //The left child in an array representation of a heap binary tree is (2*i)+1
		int rightChild=2*i+2; //The right child in an array representation of a heap binary tree is (2*i)+2
		return (heap[rightChild]>heap[leftChild]?rightChild:leftChild); //Return the larger value of either child
	}

	//----------------------------------------------heapsort()---------------------------------------
	/*Heapsort implements a simple algoriths which calls for the deleteMax() function. Since deleteMax()
	 * always returns the largest element in the heap, this element is then added to an array which 
	 * consequently will be sorted in a descending order*/
	//THETA(NlogN) in worst and average case in order to delete max n-times and build the heap
	
	public static void heapsort(Integer[] arrayToSort) {
		Integer[] array=arrayToSort; //The input field is assigned to a variable for easier manipulation
        MaxHeap newSortedHeap=new MaxHeap(array);  //A new heap is constructed using the input array   
        for (int i=1;i<=array.length;i++) {  //the initial value for i is 1 in order to not have index error    
            array[i-1]=newSortedHeap.deleteMax(); //The elements of the array are overwritten by the next largest element
        }
	}
	
	//-----------------------------------------------toString()------------------------------------------
	public String toString() {
		String out="";  //New string output
		out=Integer.toString(heap[0]); //The first element in the array is added to the output without a comma before it 
		for (int i=1;i<this.sizeHeap;i++) { //The remaining elements are added to the string in their respective positions
			out+=", " +heap[i];
		}
		return out; //Return out
    }  

	//-----------------------------------------------Getter methods------------------------------------------
	public int getSize() {
		return sizeHeap; //Get the number of elements in the heap
	}

	public int getCapacity() {
		return size; //Get the memory spots allocated for the heap; maximum number of elements allowed in the heap 
	}
}
