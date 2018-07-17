// CECS 328 - Project 2
// Jimmy Chan
// Andrew Duong


public class HeapSorterTester <T> {
	public static int removeDuplicates(int arr[], int n)
    {
        // Return, if array is empty
        // or contains a single element
        if (n==0 || n==1)
            return n;
      
        int[] temp = new int[n];
         
        // Start traversing elements
        int j = 0;
        for (int i=0; i<n-1; i++)
            // If current element is not equal
            // to next element then store that
            // current element
            if (arr[i] != arr[i+1])
                temp[j++] = arr[i];
         
        // Store the last element as whether
        // it is unique or repeated, it hasn't
        // stored previously
        temp[j++] = arr[n-1];   
         
        // Modify original array
        for (int i=0; i<j; i++)
            arr[i] = temp[i];
      
        return j;
    }
	
	public static <T extends Comparable <T>> void main(String[] args) {
		// Test Cases for string, integer, char, and double
		String test[] = {"apple", "bpplz", "appld", "applead", "cear", "aear"};
		Integer test2[] = {5, 3, 6, 4, 8, 9, 13, 10, 19};
		Character test3[] = {'a', 'z', 'b', 'g', 'f', 'k', 'm', 'l', 'u', 'h'};
		Double test4[] = {5.91, 5.1, 5.9, 11.23, 34.232, 14.927, 10.02};
		
		// Declare a new heapSorter object
		HeapSorter<T> a = new HeapSorter<T>();
		
		// Sort the string list with heapsort
		a.heapsort(test);
		
		// Sort the integer list with heapsort
		a.heapsort(test2);
		
		// Sort the char list with heapsort
		a.heapsort(test3);

		// Sort the double list with heapsort
		a.heapsort(test4);
		
		

	     
	        int arr[] = {1, 2, 2, 3, 4, 4, 6, 4, 6};
	        int n = arr.length;
	         
	        n = removeDuplicates(arr, n);
	  
	        // Print updated array
	        for (int i=0; i<n; i++)
	           System.out.print(arr[i]+" ");

}
	
}
