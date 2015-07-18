package BinarySearch;
import java.util.NoSuchElementException;

//I read consequently got help from reading the reading on Pictoral loop invariants for lab on October 28.
public class binarysearch {

	// Return the array index where item is found in the array a[]
	public static int binarySearch(int[] a, int item) {
		int left = -1;
		int right = a.length;
		int middle = (left + right + 1) / 2; /* round up */

		// loop as long as left smaller than right and a[middle] != item, so
		// either it loops until there is no unprocessed item or it has found
		// the
		// item in the array.
		while (left < right - 1) {

			/*
			 * if a[middle] = item, binary search is over. return middle
			 */
			if (a[middle] == item)
				return middle;

			/*
			 * if middle is smaller than item, change left = middle . In order
			 * to maintain the loop invariant so left is the last processed
			 * small item in the array.
			 */
			else if (a[middle] < item)
				left = middle;
			/*
			 * if middle is bigger than item, change right = middle . In order
			 * to maintain the loop invariant so right is the first processed
			 * big item in the array.
			 */
			else
				right = middle;
			middle = (left + right + 1) / 2;

		}

		// if there is no such item in the array,return the index of where that
		// item would be placed if it were to be inserted.
		return middle;
	}

	public static void main(String[] argv) {

		int[] integers = { -24, -15, -13, -4, -3, 2, 5, 7, 106 };
		System.out.print("arary: ");
		for (int i : integers) {
			System.out.print(i + ", ");
		}
		System.out.println("");
		System.out.print("index of 107 in the array: ");
		System.out.println(binarySearch(integers, 107));

	}
}
