package ArrayListIterator;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> {
	private E myArray[];
	private int numStored; // the number of items actually stored in myArray

	/***
	 * the default constructor
	 */
	public MyArrayList() {
		// initially, the internal array has room for 10 items,
		// but no items have actually been inserted
		myArray = (E[]) new Object[10];
		numStored = 0;
	}

	public void print() {
		for (int i = 0; i < myArray.length; i++)
			System.out.println(myArray[i]);

	}

	public void add(E e) {
		// check if myArray must be expanded
		if (numStored == myArray.length) {
			E newArray[] = (E[]) new Object[myArray.length * 2];
			for (int i = 0; i < numStored; i++)
				newArray[i] = myArray[i];
			myArray = newArray;
		}

		// insert the given element into myArray
		myArray[numStored] = e;
		numStored++;
	}

	// #3 this add an element e at index.
	public void add(int index, E e) {
		// check if myArray must be expanded
		if (numStored == myArray.length) {
			E newArray[] = (E[]) new Object[myArray.length * 2];
			for (int i = 0; i < numStored; i++)
				newArray[i] = myArray[i];
			myArray = newArray;
		}
		// shift all elements up past index in the array.
		for (int i = numStored; i > index; i--) {
			myArray[i] = myArray[i - 1];

		}

		// insert the given element into myArray
		myArray[index] = e;
		//Increment the number of elements stored in myArray.
		numStored++;

	}
	
	///#7
	//Removes an element at the given index from myArray. 
	public void remove(int index) {
		for (int i = index; i < numStored - 1; i++) {
			//shift all elements in myArray back one that are past the given index.
			myArray[i] = myArray[i + 1];

		}
		//Set the previous last element of myArray to null
		myArray[numStored - 1] = null;
		//Decrement the number of elements stored in myArray.
		numStored--;

	}

	//#8
	// ITERATOR CLASS
	// Taken and modified from MyArray2.java from lab
	public Iterator<E> iterator() {
		return new LocalIterator();
	}

	private class LocalIterator implements Iterator<E> {
		public int count;
	
		//Create an iterator
		public LocalIterator() {
			//Initially count = 0
			count = 0;
		}

		//return false if count has past the array length or we reach a null element which indicates the end of the array.
		public boolean hasNext() {
			return (count < myArray.length && myArray[count] != null);

		}

		
		public E next() {
			// If count equals array length throw a exception because we have iterated too far.
			if (count == myArray.length) {
				throw new NoSuchElementException();
			}
			
			//Otherwise return the array element at index count and then increment count
			System.out.println("count: " + count);
			return (E) myArray[count++]; // ++ fix added according to Forum
		}

		//removes an element the index of count and then shifts every element past count back one.
		public void remove() {

			for (int i = count - 1; i < numStored - 1; i++) {
				//System.out.println("the count: " + count);
				myArray[i] = myArray[i + 1];
				

			}
			//Set previous last element to null.
			myArray[numStored - 1] = null;
			numStored--;
			//Decrement count in order to compensate for the removed element
			count--;
			
			//System.out.println("count: " + count);
		}

		//Resets the count to 0 if we need to rerun the iterator on the array.
		public void reset() {
			count = 0;
		}

	}

	// other public methods follow, BUT
	// no other fields are declared outside of individual methods
	// — except perhaps for the extra credit part at the very end of this lab

	public static void main(String[] argv) {
		
		//TESTING

		MyArrayList<Integer> list = new MyArrayList<Integer>();

		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		
		//list.remove(0);
		

		Iterator<Integer> it = list.iterator();
//delete everything in the array
		while (it.hasNext()) {
			
			
			System.out.println(it.next());
			it.remove();
			list.print();
			System.out.println("\n");
			
			
			
			
		}	
		System.out.println("last\n");
		list.print();
		  //list.print();
	}
}
