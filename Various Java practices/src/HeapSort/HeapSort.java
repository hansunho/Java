package HeapSort;

public class HeapSort {
	/** Helper method to print an array */
	public static <AnyType> void printArray(AnyType[] array) {
		System.out.print("[");

		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");

		System.out.println("]");
	}

	/** Transpose entries at i and j in an array */
	public static <AnyType> void swapReferences(AnyType[] array, int i, int j) {
		AnyType tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	/** Heap sort method. Modifies array so that it is in sorted order */
	public static <AnyType extends Comparable<? super AnyType>> void heapSort(
			AnyType[] array) {
		// Build Heap
		for (int i = array.length / 2; i >= 0; i--) {
			percDown(array, i, array.length);
		}

		for (int i = array.length - 1; i > 0; i--) {
			swapReferences(array, 0, i); // deleteMax
			percDown(array, 0, i); // Maintain heap ordering property
		}

	}

	/**
	 * Percolate down method. The object to be percolated is at array[hole], and
	 * the current heap size (number of elements in the heap) is given.
	 */
	public static <AnyType extends Comparable<? super AnyType>> void percDown(
			AnyType[] array, int hole, int size) {

		int child;
		AnyType tmp = array[hole];

		for (; hole * 2 <= size - 1; hole = child) {
			// System.out.println("the current hole is: " + a[hole]);
			child = hole * 2;
			if (child != size - 1
					&& (array[child + 1].compareTo(array[child])) < 0)
				child++;
			if (array[child].compareTo(tmp) < 0)
				array[hole] = array[child];
			else
				break;
		}
		array[hole] = tmp;
	}

	
	
	
	// taken from
	// http://www.algolist.net/Data_structures/Binary_heap/Remove_minimum
	// and modified to keep the max-heap sorted after removing the root
	// param array: any type of an array
	// param currentSize: number of elements in array
	public static <AnyType extends Comparable<? super AnyType>> void removeRecursive(
			AnyType[] array, int currentSize) {
		int size = currentSize;

		if (array[0] == null)
			System.out.println("heap is empty");
		else {
			array[0] = array[size - 1];
			array[size - 1] = null;
			size--;
			if (size > 0) {
				removeHelper(array, 0, size);
			}

		}

	}
//for testing to see if remove method actually recurses.
	static int count = 0;
	
	// param nodeIndex: the index of an array item that is being moved down the
	// heap(item initially moved to the root of the heap.
	// param currentsize: number of elements in the array
	public static <AnyType extends Comparable<? super AnyType>> void removeHelper(
			AnyType[] array, int nodeIndex, int currentsize) {

	
		// lChildIndex = index of the left child of a[nodeIndex] (may or may not
		// be a valid index. ie. lChildIndex>=currentsize
		// rChildIndex = index of the right child of a[nodeIndex] (may or may
		// not be a valid index)
		//size= number of elements in the heap
		int lChildIndex, rChildIndex, maxIndex, size;
		AnyType tmp;
		size = currentsize;

		//assign proper index for the left and right children.(base 0 heap)
		lChildIndex = (nodeIndex * 2) + 1;
		rChildIndex = (nodeIndex * 2) + 2;

		// if right Child doesn't exist
		if (rChildIndex >= size) {
			// and left child also doesn't exist, stop recursion here
			if (lChildIndex >= size)
				return;
			else
				// if there is only left child of the node, retrieve that left
				// child to be compared
				maxIndex = lChildIndex;
		}
		// if both left and right children exist, compare them to find the
		// bigger one
		else {

			// determine the bigger child and store that node in maxIndex
			if (array[lChildIndex].compareTo(array[rChildIndex]) <= 0)
				maxIndex = rChildIndex;
			else
				maxIndex = lChildIndex;

		}
		// compare the moving item(array[nodeIndex]) to the smaller child of the
		// two children
		// if arrry[nodeIndex] is bigger than the big child, swap them and
		// recurse with the new position(minIndex);
			if (array[nodeIndex].compareTo(array[maxIndex]) < 0) {
	
				tmp = array[nodeIndex];
				array[nodeIndex] = array[maxIndex];
				array[maxIndex] = tmp;
				removeHelper(array, maxIndex, size);
			}
			System.out.println("count: "+ ++count);	
	}

	/** Test driver method. */
	public static void main(String[] args) {
		Integer array[] = new Integer[5];

		for (int i = 0; i < array.length; i++)
			array[i] = (int) (100 * Math.random());
		System.out.println("Size of Heap: " + array.length);
		System.out.println("Before heapSort: ");
		printArray(array);

		heapSort(array);
		System.out.println("After heapSort:");
		printArray(array);

		removeRecursive(array, 5);
		System.out.println("After remove:");
		printArray(array);

	}

}
