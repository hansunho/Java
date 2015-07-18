package Partition;
//Test2 #1
// Following code is taken and modified from sorting lab
// http://www.cs.grinnell.edu/~walker/courses/207.fa14/labs/lab-sorting.shtml

import java.util.Random;

public class partition {

	// partition takes an array a type int and int left, and int right and
	// partitions the array so that elements between a[left] and a[right] are
	// ordered. Once partition is done, a[left] should be moved to a place in
	// a[] so that elements left to a[left] has values less than or equal to
	// a[left] and elements to the right of a[left] should have values greater
	// than or equal to a[left]
	public static int partition(String[] a, int left, int right) {

		int l_spot = left;
		int r_spot = right + 1;
		String temp;

		while (r_spot - 1 >= l_spot + 1) {
			// search left to find small array item
			while ((r_spot - 1 >= l_spot + 1) && (a[left].compareTo(a[r_spot - 1]) <=0))
				r_spot--;

			// search right to find large array item
			while ((r_spot - 1 >= l_spot + 1) && (a[left].compareTo(a[l_spot + 1]) >= 0))
				l_spot++;
			// swap large left item and small right item, if needed
			if (r_spot - 1 > l_spot + 1) {
				temp = a[l_spot + 1];
				a[l_spot + 1] = a[r_spot - 1];
				a[r_spot - 1] = temp;
			}
		}
		// put a[first] in its place so that everything to its left has values
		// less than or equal to a[first] and everything to its right has values
		// greater than or equal to a[first]
		temp = a[left];
		a[left] = a[r_spot - 1];
		a[r_spot - 1] = temp;
		return r_spot - 1;

	}
	
	public static void quicksort(String [] a){
		// method to sort using the quicksort
	    quicksortKernel (a, 0, a.length-1);
		
	}
	private static void quicksortKernel (String [] a, int left, int right){

		int middle= partition(a,left,right);
		
		 // recursively apply algorithm to a[first]..a[right-1] 
	    // and a[right+1]..a[last], provided these segments contain >= 2 items
	    if (left < middle)
	        quicksortKernel (a, left, middle-1);
	    if (middle < right)
	        quicksortKernel (a,middle+1, right);   
		
	}

	public static void main(String[] argv) {

		Random r = new Random();
		int[] integers = new int[10];
		for (int i = 0; i < integers.length; i++) {
			integers[i] = r.nextInt() % 100;
		}
		System.out.println("original order of ararylist");
		for (int i : integers) {
			System.out.print(i + ", ");
		}
		System.out.println("");

	//	quicksort(integers);
		System.out.println("partitioned order of ararylist");
		for (int i : integers) {
			System.out.print(i + ", ");
		}
		System.out.println("");

		
		
		
/*
		// Testing #1
		// generate an int[] of size 10 with a uniformly distributed int random
		// numbers between -100 and 100
		for (int i = 0; i < integers.length; i++) {
			integers[i] = r.nextInt() % 100;
		}
		// print the original randomly generated arraylist
		System.out.println("Testing #1: 10 items left:0 right:9");
		System.out.println("original order of ararylist");
		for (int i : integers) {
			System.out.print(i + ", ");
		}
		System.out.println("");
		// partition the randomly generated arraylist
		partition(integers, 0, integers.length - 1);

		// print the partitioned arraylist
		System.out.println("partitioned order of ararylist");
		for (int i : integers) {
			System.out.print(i + ", ");
		}
		System.out.println("");

		System.out.println("");

		// Testing #2
		// generate an int[] of size 10 with a uniformly distributed int random
		// numbers between -100 and 100
		for (int i = 0; i < integers.length; i++) {
			integers[i] = r.nextInt() % 100;
		}

		// print the original randomly generated arraylist
		System.out.println("Testing #2: 10 items left:0 right:9");
		System.out.println("original order of ararylist");
		for (int i : integers) {
			System.out.print(i + ", ");
		}
		System.out.println("");
		// partition the randomly generated arraylist
		partition(integers, 0, integers.length - 1);

		// print the partitioned arraylist
		System.out.println("partitioned order of ararylist");
		for (int i : integers) {
			System.out.print(i + ", ");
		}
		System.out.println("");
		System.out.println("");

		// Testing #3
		// generate an int[] of size 10 with a uniformly distributed int random
		// numbers between -100 and 100
		for (int i = 0; i < integers.length; i++) {
			integers[i] = r.nextInt() % 100;
		}

		// print the original randomly generated arraylist
		System.out.println("Testing #3:10 items left:0 right:4");
		System.out.println("original order of ararylist");
		for (int i : integers) {
			System.out.print(i + ", ");
		}
		System.out.println("");
		// partition the randomly generated arraylist
		partition(integers, 0, 4);

		// print the partitioned arraylist
		System.out.println("partitioned order of ararylist");
		for (int i : integers) {
			System.out.print(i + ", ");
		}
		System.out.println("");
		System.out.println("");
		
		
		// Testing #4
		// print the original randomly generated arraylist
		System.out.println("Testing #4:10 items left:5 right:9");
		System.out.println("original order of ararylist");
		for (int i : integers) {
			System.out.print(i + ", ");
		}
		System.out.println("");
		// partition the randomly generated arraylist
		partition(integers, 5, 9);

		// print the partitioned arraylist
		System.out.println("partitioned order of ararylist");
		for (int i : integers) {
			System.out.print(i + ", ");
		}
		System.out.println("");
		

*/


	}

}
