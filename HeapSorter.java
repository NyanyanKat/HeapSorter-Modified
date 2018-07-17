// CECS 328 - Project 2
// Jimmy Chan
// Andrew Duong

public class HeapSorter <T> {
	
	// Declare heapSize;
	private int heapSize;
	
	@SuppressWarnings("unused")
	// Method to return the node for parent
	private int parent(int i) {
		return i/2;
	}
	
	// Method to return the node for left child
	private int leftChild(int i) {
		return 2*i;
	}
	
	// Method to return the node for right child
	private int rightChild(int i) {
		return 2*i+1;
	}
	
	
	// Method to construct max heap of the generic type array
	private <T extends Comparable <T>> void buildMaxHeap(T A[]) {
		
		// Set heapSize equal to the array length based on 0 based indexing
		heapSize = A.length - 1;
		
		// Starting with half point of the array, maxHeapify the array until i = 0
		for (int i = (A.length-1)/2; i >= 0; i--) {
			maxHeapify(A, i);
		}
	}
	
	
	// Method to check the largest value contained within the nodes in the generic type array
	private <T extends Comparable <T>> void maxHeapify(T A[], int i) {
		
		// Set l = left child node, r = right child node, and largest = largest node
		int l = leftChild(i);
		int r = rightChild(i);
		int largest;
		
		// Check for the largest value contained between the left child and i
		if (l <= heapSize && A[l].compareTo(A[i]) > 0)
			largest = l;
		else largest = i;
		
		// Check for the largest value contained between the right child and largest
		if (r <= heapSize && A[r].compareTo(A[largest]) > 0)
			largest = r;
		
		// If largest is not equal to i, swap A[i] and A[largest] and then recursively call maxHeapify using largest as the new i
		if (largest != i) {
			T temp5 = A[i];
			A[i] = A[largest];
			A[largest] = temp5;
			maxHeapify(A, largest);
		}
	}
	
	
	// Method to return the sorted generic type array
	public <T extends Comparable <T>> void heapsort(T A[]) {
		
		// Print the original array
		System.out.print("Unsorted list: ");
		printArray(A);
		
		// construct max heap
		buildMaxHeap(A);
		
		// loop through the array, swap A[0] with A[i], reducing heapSize by 1 each time and then construct max heap
		for (int i = A.length-1; i >= 1; i--) {
			T temp = A[0];
			A[0] = A[i];
			A[i] = temp;
			heapSize = heapSize - 1;
			maxHeapify(A, 0);
		}
		
		// Print the sorted array
		System.out.print("Sorted list: ");
		printArray(A);
		System.out.println();
	}
	
	
	// Method for outputting each element in the array
	public <T extends Comparable <T>> void printArray(T A[]) {
		int n = A.length;
		for (int i = 0; i < n; i++) {
			System.out.print(A[i]);
			if (i < n-1) System.out.print(", ");
		}
		System.out.println();
	}
}