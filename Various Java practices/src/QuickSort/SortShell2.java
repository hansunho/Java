package QuickSort;

	import java.io.*;

	public class SortShell2 {
	// a sorting shell for experiments with the quicksort

	public static void quicksort (int [] a) {
	// method to sort using the quicksort
	    quicksortKernel (a, 0, a.length-1);
	}

	private static void quicksortKernel (int [] a, int first, int last) {
	    int left=first+1;
	    int right=last;
	    int temp;

	    while (right >= left) {
	        // search left to find large array item
	        while ((right >= left) && (a[first] >= a[right]))
	            right--;
	        // search right to find small array item
	        while ((right >= left) && (a[first] <= a[left]))
	            left++;
	        // swap small left item and large right item, if needed
	        if (right > left) {
	            temp = a[left];
	            a[left] = a[right];
	            a[right] = temp;
	        }
	    }
	    // put a[first] in its place
	    temp = a[first];
	    a[first] = a[right];
	    a[right] = temp;

	    // recursively apply algorithm to a[first]..a[right-1] 
	    // and a[right+1]..a[last], provided these segments contain >= 2 items
	    if (first < right-1)
	        quicksortKernel (a, first, right-1);
	    if (right+1 < last)
	        quicksortKernel (a, right+1, last);   
	}

	public static void main (String [] args) 
	    throws Exception {
/*
	    // declarations: two arrays and I/O;
	    int size = 12;
	    int [] c = new int [size];
	    int [] d = new int [size];
	    InputStreamReader istream  = new InputStreamReader(System.in);
	    BufferedReader in = new BufferedReader(istream);
	    PrintWriter out = new PrintWriter(System.out, true);
	    String line;

	    // initial arrays to same values by reading and copying
	    out.println ("Please enter " + size + " integer values to sort,"
	                 + " with each number on a separate line");
	    for (int i = 0; i < size; i++) {
	        line = in.readLine();
	        c[i] = new Integer(line).intValue();
	        d[i] = c[i];
	    }
*/
		
		
		 int [] c =  {1,2,3,44,5,6,7,8,9,10,66,22,2};
	    // sort and print first ar		ray
	    quicksort (c);
	    System.out.println ("Result of Quicksort:");
	    for (int i = 0; i < 10; i++) 
	        System.out.print(c[i] + "\t");
	    System.out.println();

	} // main
	} // SortShell2


