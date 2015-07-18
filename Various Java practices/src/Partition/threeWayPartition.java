package Partition;
//Test2 #2
//i looked at the dutch flag program for Pictoral Loop Invariants Lab and got the general idea of this program

import java.util.Random;

public class threeWayPartition {

	public static void main(String[] args) {

		Random r = new Random();
		int[] integers = new int[20];

		// Testing #1
		// generate an int[] of size 20 with a uniformly distributed int random
		// numbers between -100 and 100
		for (int i = 0; i < integers.length; i++) {
			integers[i] = r.nextInt() % 100;
		}
		// print the original randomly generated array
		System.out.println("Testing #1: 20 items baseInt = 50");
		System.out.println("original order of ararylist");
		for (int i : integers) {
			System.out.print(i + ", ");
		}
		System.out.println("");
		// partition the randomly generated array
		threeWayPartition(integers, 50);

		// print the partitioned array
		System.out.println("partitioned order of ararylist");
		for (int i : integers) {
			System.out.print(i + ", ");
		}
		System.out.println("");

		System.out.println("");

		// Testing #2
		// generate an int[] of size 20 with a uniformly distributed int random
		// numbers between -100 and 100
		for (int i = 0; i < integers.length; i++) {
			integers[i] = r.nextInt() % 100;
		}
		// print the original randomly generated array
		System.out.println("Testing #2: 20 items baseInt = 30");
		System.out.println("original order of ararylist");
		for (int i : integers) {
			System.out.print(i + ", ");
		}
		System.out.println("");
		// partition the randomly generated array
		threeWayPartition(integers, 30);

		// print the partitioned array
		System.out.println("partitioned order of ararylist");
		for (int i : integers) {
			System.out.print(i + ", ");
		}
		System.out.println("");

		System.out.println("");

		// Testing #3 no small element
		System.out.println("Testing #3: 27 items baseInt = -10000");
		int[] array = { -1441, -525, 36, 2567, 114, 251, 1, 2, 3, 4, 15, 12,
				-4, -5, 105, 100, 103, 107, 110, 116, 120, 222, 224, -223, 251,
				-2312, 1166, 0 };
		System.out.print("Before: ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + ", ");
		System.out.println("");

		threeWayPartition(array, -10000);
		System.out.print("After: ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + ", ");
		System.out.println("");
		System.out.println("");

		// Testing #4 no large element
		System.out.println("Testing #4: 27 items baseInt = 10000");
		int[] array1 = { -1441, -525, 36, 2567, 114, 251, 1, 2, 3, 4, 15, 12,
				-4, -5, 105, 100, 103, 107, 110, 116, 120, 222, 224, -223, 251,
				-2312, 1166, 0 };
		System.out.print("Before: ");
		for (int i = 0; i < array1.length; i++)
			System.out.print(array1[i] + ", ");
		System.out.println("");

		threeWayPartition(array1, 10000);
		System.out.print("After: ");
		for (int i = 0; i < array1.length; i++)
			System.out.print(array1[i] + ", ");
		System.out.println("");
		System.out.println("");
		System.out.println("");

		// Testing #5 when elements that are exactly 10 less than and greater
		// than baseInt are included in the array
		System.out.println("Testing #5: 13 items baseInt = 50");
		int[] array2 ={ 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 30 };
		;
		System.out.print("Before: ");
		for (int i = 0; i < array2.length; i++)
			System.out.print(array2[i] + ", ");
		System.out.println("");

		threeWayPartition(array2, 50);
		System.out.print("After: ");
		for (int i = 0; i < array2.length; i++)
			System.out.print(array2[i] + ", ");
		System.out.println("");

	}

	private static void threeWayPartition(int[] a, int baseInt) {
		int un = a.length - 1;
		int lastSmall = a.length - 1;
		int firstBig = a.length;
		int temp;
		// continute to loop until mid<left
		while (un >= 0) {
			// System.out.println(un);

			// if a[un] is in between baseInt+10 and baseInt-10 inclusive. Swap
			// a[un--] and a[lastSmall--] so that a[un] is added to the middle
			// section and a[lastSmall] is still included in the the
			// "<baseInt-10" section.
			if (baseInt + 10 >= a[un] && baseInt - 10 <= a[un]) {
				temp = a[un];
				a[un--] = a[lastSmall];
				a[lastSmall--] = temp;
			}

			// if a[un] is bigger than baseInt+10
			else if (baseInt + 10 < a[un]) {
				// first swap a[un] and a[lastSmall] and decrease un by 1 to
				// increase the "<baseInt-10" section, so the original
				// a[lastSmall] is still included in the "<baseInt-10" section.
				temp = a[un];
				a[un--] = a[lastSmall];
				a[lastSmall] = temp;

				// secondly, swap a[firstBig-1] and a[lastSmall] to put the
				// original a[un] (greater than baseInt+10, now a[lastSmall]) in
				// the
				// ">baseInt+10" section. decrement both firstBig and lastSmall
				// to increase the ">baseInt+10" section and decrease the
				// "<baseInt-10" section.
				temp = a[--firstBig];
				a[firstBig] = a[lastSmall];
				a[lastSmall--] = temp;

			}
			// if a[un] is smaller than baseInt-10 just decrement un by 1.
			else if (baseInt - 10 > a[un])
				un--;
		}

		// for testing
		// System.out.println("lastSmall index:" + lastSmall+ "value: "+ a[lastSmall]);
	// System.out.println("firstBig index:" + firstBig+ " value: "+ a[firstBig]);
	}

}