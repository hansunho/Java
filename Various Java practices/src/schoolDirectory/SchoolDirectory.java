// remove and iterator functions are taken and modified from ArrayList lab, MyArray1.java,and MyArray2.java. 
//Also  CourseDirectory.java, CourseDirectory.out, and  CourseComparable.java from class are used to help my code
//// 
 
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html  for definitions
package schoolDirectory;

import java.util.Iterator;
import java.util.NoSuchElementException;

import schoolDirectory.Entry;
import schoolDirectory.Student;
import schoolDirectory.Faculty;

public class SchoolDirectory {

	private int maxSize;
	private int currentSize;
	private Entry[] entryArray;

	SchoolDirectory() {
		maxSize = 4; // initial maximum
		currentSize = 0;
		entryArray = new Entry[maxSize];
	}

	public void add(Entry person) {
		// check if room in array, and double array size if needed
		if (currentSize == maxSize) {
			maxSize = 2 * maxSize;
			Entry[] temp = new Entry[maxSize];
			for (int i = 0; i < currentSize; i++)
				temp[i] = entryArray[i];
			entryArray = temp; // update entryArray to the new, larger array
		}

		// add person to array, maintaining alphabetical order
		int i = currentSize;
		while (i > 0 && person.comesBefore(entryArray[i - 1])) {
			entryArray[i] = entryArray[i - 1];
			i--;
		}
		entryArray[i] = person;
		currentSize++;
	}

	public void print() {
		System.out.println("Directory Listing");
		for (int i = 0; i < currentSize; i++)
			System.out.print(entryArray[i]);
		System.out.println("End of Listing");
	}

	public Entry lookup(String first, String second) {
		int lo = 0;
		int hi = currentSize;
		int mid = (hi + lo) / 2;
		while (lo < hi) {
			if (entryArray[mid].equals(first, second))
				return entryArray[mid];
			if (entryArray[mid].comesBefore(first, second))
				lo = mid + 1;
			else
				hi = mid;
			mid = (hi + lo) / 2;
		}
		return null; // return a null entry if person not found
	}

	// Removes an entry with given first and last names from entryArray.only
	// delete one item per each call to remove.
	public void remove(String firstname, String lastname) {
		// check if the directory is empty, if not go on with removing entry
		if (currentSize > 0) {
			for (int i = 0; i < currentSize - 1; i++) {
				{// If an entry with matching first and last names are found,
					// shift
					// all elements in myArray back one that are past the given
					// index to delete that entry.
					if (entryArray[i].getFirstName().equals(firstname)
							&& entryArray[i].getLastName().equals(lastname)) {
						for (i = i; i < currentSize - 1; i++)
							entryArray[i] = entryArray[i + 1];
						// After an item is removed, break. so it doesn't delete
						// another item with the
						// same first and last names.
						break;
					}
				}
			}
			// Set the previous last entry of entryArray to null
			entryArray[currentSize - 1] = null;
			// Decrement the number of entries stored in entryArray.
			currentSize--;
		}
		// if no entry is in directory throw an exception
		else
			throw new IllegalStateException();
	}

	// Taken and modified from MyArray2.java from lab
	// iterator to cycle through all entries with valid email address (not
	// "none" and containing no greater than 23 characters)
	// by default, cycle through all courses
	public Iterator<Entry> iterator() {
		return new LocalIterator();
	}

	private class LocalIterator implements Iterator<Entry> {

		private int lastReturned; // last index returned by iterator

		// removeCounter sets to 0 when next() is called. This is used to make
		// sure remove() is not called more than once per each next() call.
		private int removeCounter;

		// Create an iterator
		public LocalIterator() {
			// initialize lastReturned
			lastReturned = -1;
			// remove is not allowed before calling next() at least once first.
			removeCounter = -1;
		}

		// looks through the array and returns true if there is at least one
		// entry with valid email address(not "none" and containing no greater
		// than 23 characters). return false otherwise.
		public boolean hasNext() {
			int startIndex = lastReturned + 1;
			// look through the whole array
			while (startIndex < currentSize) {
				if (entryArray[startIndex].geteMail().compareTo("none") != 0
						&& entryArray[startIndex].geteMail().length() <= 23)
					return true;
				else
					startIndex++;
			}
			// if no valid entry is found, return false
			return false;
		}

		// returns the next valid entry item in the array. If none can be found,
		// throw an exception
		public Entry next() {

			lastReturned++;

			while (lastReturned < currentSize) {
				if (entryArray[lastReturned].geteMail().compareTo("none") != 0
						&& entryArray[lastReturned].geteMail().length() <= 23) {
					// after each call to next(),set removeCounter to 0 so
					// remove function can be called
					removeCounter = 0;
					// return the next item;
					return entryArray[lastReturned];
				}
				lastReturned++;
			}
			// if there is no more valid entry left in the array, throw an
			// exception
			throw new NoSuchElementException();

		}

		// removes current item and then shifts every element back by one.
		public void remove() {

			int index = lastReturned+1;
			// if at least one next() has been called so removeCounter is 0,
			// remove
			// the appropriate element by sliding elements down by one.
			if (removeCounter == 0 &&index>0) {
				for (int i = index - 1; i < currentSize - 1; i++) {

					entryArray[i] = entryArray[i + 1];

				}
				// Set previous last element to null.
				entryArray[currentSize - 1] = null;
				currentSize--;
				removeCounter = 1;
				lastReturned--;
			}

			else
				throw new IllegalStateException(
						"next() needs to be called prior to each call to remove()");

		}
	}

	public static void main(String[] argv) {
		// test of various methods
		// constructors
		SchoolDirectory dir = new SchoolDirectory();
		Student stu1 = new Student("Terry", "Walker",
				"walkert@math.grinnell.edu", 1970, "off-campus");
		Student stu2 = new Student("Barbara", "Ellen",
				"barbara@cs.grinnell.edu", 2002, "12-34-56");
		Student stu3 = new Student("Donna", "Marie", "donna@math.grinnell.edu",
				1998, "3.1415926535");
		Student stu4 = new Student("Shamrock", "The Cat", "none", 3000,
				"varies");
		Student stu5 = new Student("Muffin", "The Cat", "none", 3000, "varies");

		Faculty fac1 = new Faculty("John", "Stone", "stone@math.grinnell.edu",
				"Science 2418", 3181, "Mathematics and Computer Science", 1983);

		Faculty fac2 = new Faculty("Henry", "Walker", "walker@cs.grinnell.edu",
				"Science 2420", 4208, "Mathematics and Computer Science", 1973);

		Faculty fac3 = new Faculty("Janet", "Gibson", "gibson@grinnell.edu",
				"Science 0420", 3168, "Psychology", 1989);

		Faculty fac4 = new Faculty("Samuel", "Rebelsky",
				"rebelsky@cs.grinnell.edu", "Science 2427", 4410,
				"Mathematics and Computer Science", 1997);

		// add entries to directory
		dir.add(stu1);
		dir.add(stu2);
		dir.add(stu3);
		dir.add(stu4);
		dir.add(stu5);
		dir.add(fac1);
		dir.add(fac2);
		dir.add(fac3);
		dir.add(fac4);

		// create an instance of Iterator type Entry for SchoolDirectory dir
		Iterator<Entry> it = dir.iterator();
		Iterator<Entry> iter = dir.iterator();

//		System.out.println("directory before removal");
//		while (iter.hasNext()) {
//			System.out.println(iter.next());
//		}
//
//		// remove all entries from directory
//		while (iter.hasNext()) {
//
//			iter.next();
//			iter.remove();
//
//		}
//		System.out.println("directory After removal");
//		while (iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		
		System.out.println("directory before removal");
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
			
		Iterator<Entry> iter2 = dir.iterator();
		
		 iter2.remove();
		 iter2.next();
		 iter2.next();
		 iter2.next();
		 iter2.next();
		 iter2.next();
		 iter2.remove();
		 
		 Iterator<Entry> iter3 = dir.iterator();
		System.out.println("directory After removal");
		while (iter3.hasNext()) {
			System.out.println(iter3.next());
		}
		
		// System.out
		// .println("Email addresses containing fewer than 24 characters");
		// // Loop until there is no next valid item left in the collection
		// while (it.hasNext()) {
		// System.out.println(it.next());
		// }
		// System.out.println("End of listing");
	}

}
