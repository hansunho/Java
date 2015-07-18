package library;

import library.LibraryBook;
import library.ReferenceBook;
import java.util.ArrayList;
import java.util.Collections;

public class Library {
	ArrayList<LibraryBook> bookList;

	Library() {
		bookList = new ArrayList<LibraryBook>();
	}

	/**
	 * adds the given book to the library
	 * 
	 * @param book
	 */
	public void addBook(LibraryBook book) {
		bookList.add(book);
	}

	/**
	 * prints all books in the library
	 */
	public void printLibrary() {
		System.out.println("\nListing of books in the library\n");
		for (LibraryBook book : bookList)
			System.out.println(book + "\n");
		System.out.println("End of book listing\n");
	}

	/**
	 * locates a book in the library
	 * 
	 * @param book
	 *            book being search in the library
	 * @return book object if book is found null otherwise
	 */
	public LibraryBook findBook(LibraryBook book) {
		int index = Collections.binarySearch(bookList, book);

		if (index >= 0)
			return bookList.get(index);
		else
			return null;
	}

	// partition takes an arraylist a type LibraryBook  and int left, and int right and
	// partitions the array so that elements between a[left] and a[right] are
	// ordered. Once partition is done, a[left] should be moved to a place in
	// a[] so that elements left to a[left] has values less than or equal to
	// a[left] and elements to the right of a[left] should have values greater
	// than or equal to a[left]
	public static int partition(ArrayList<LibraryBook> a, int left, int right) {

		int l_spot = left;
		int r_spot = right + 1;

	
		while (r_spot - 1 >= l_spot + 1) {
			// search left to find small  item
			while ((r_spot - 1 >= l_spot + 1)
					&& (a.get(left).getCallNumber().compareTo(a.get(r_spot - 1).getCallNumber()) <= 0))
				r_spot--;

			// search right to find large  item
			while ((r_spot - 1 >= l_spot + 1)
					&& (a.get(left).getCallNumber().compareTo(a.get(l_spot + 1).getCallNumber()) >= 0))
				l_spot++;
			// swap large left item and small right item, if needed
			if (r_spot - 1 > l_spot + 1) {
				Collections.swap(a,l_spot + 1 , r_spot - 1);
			}
			
		}
		// put a[left] in its place so that everything to its left has values
		// less than or equal to a[left] and everything to its right has values
		// greater than or equal to a[left]
		Collections.swap(a,left , r_spot - 1);	
		
		
		return r_spot - 1;

	}

	public static void quicksort(ArrayList<LibraryBook> a) {
		// method to sort using the quicksort
		quicksortKernel(a, 0, a.size() - 1);

	}

	private static void quicksortKernel(ArrayList<LibraryBook> a, int left, int right) {

		int middle = partition(a, left, right);

		// recursively apply algorithm to a[first]..a[right-1]
		// and a[right+1]..a[last], provided these segments contain >= 2 items
		if (left < middle)
			quicksortKernel(a, left, middle - 1);
		if (middle < right)
			quicksortKernel(a, middle + 1, right);

	}

	/**
	 * sort books in the library by call number
	 */
	public void sortLibrary() {
		quicksort(bookList);
		 
	}


	/**
	 * performs processing for checking a book out of the library
	 * 
	 * @param patron
	 *            person checking out book
	 * @param dueDate
	 *            date book is due to be returned
	 * @param callNum
	 *            call number of book
	 */
	public void checkout(String patron, String dueDate, String callNum) {
		LibraryBook searchItem = new CirculatingBook("", "", "", callNum);

		LibraryBook book = findBook(searchItem);

		if (book == null)
			System.out.println("Book " + callNum
					+ " not found -- checkout impossible\n");
		else
			book.checkout(patron, dueDate);

	}

	/**
	 * processes checked-out book that is being returned
	 * 
	 * @param callNum
	 *            call number of book being returned
	 */
	public void returned(String callNum) {

		LibraryBook searchItem = new CirculatingBook("", "", "", callNum);
		LibraryBook book = findBook(searchItem);
		if (book == null)
			System.out.println("Book " + callNum
					+ " not found -- return impossible\n");
		else
			book.returned();
	}

	/**
	 * main testing program
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String args[]) {
/*
		Library lib = new Library();
		// set up library
		lib.addBook(new ReferenceBook("Henry M. Walker",
				"Problems for Computer Solution using BASIC", "0",
				"QA76.73.B3W335", "0"));
		
		lib.addBook(new CirculatingBook(
				"Samuel A. Rebelsky and Philip Barker",
				"ED-MEDIA 2002 : World Conference on Educational Multimedia, Hypermedia & Telecommunications",
				"0", "64.2 25e"));
		lib.addBook(new ReferenceBook("Samuel A. Rebelsky",
				"Experiments in Java", "0", "64.2 R25ex", "0"));			
	
		lib.addBook(new CirculatingBook("John David Stone",
				"Algorithms for functional programming", "in process",
				"forthcoming"));
		
		lib.addBook(new ReferenceBook("Samuel A. Rebelsky",
				"Experiments in Java", "0", "64.2 R25ex", "0"));			
	
		lib.addBook(new CirculatingBook(
				"Henry M. Walker",
				"Computer Science 2:  Principles of Software Engineering, Data Types, and Algorithms",
				"0", "QA76.758.W35"));		
		lib.addBook(new CirculatingBook("Henry M. Walker",
				"The Tao of Computing", "0", "QA76.W1855"));

		lib.addBook(new CirculatingBook("Henry M. Walker",
				"Pascal:  Problem Solving and Structured Program Design",
				"0", "QA76.73.P2W35"));
		
		lib.addBook(new CirculatingBook("Henry M. Walker",
				"The Limits of Computing", "0", "QA76.W185"));
		
		lib.addBook(new CirculatingBook("Henry M. Walker",
				"The Tao of Computing", "0", "QA76.W1855"));

		lib.addBook(new CirculatingBook("Henry M. Walker",
				"Problems for Computer Solution using FORTRAN",
				"0", "QA43.W34"));
		
		lib.addBook(new CirculatingBook("Henry M. Walker",
				"Introduction to Computing and Computer Science with Pascal",
				"0", "QA76.6.W3275"));
		
		lib.addBook(new CirculatingBook("Henry M. Walker",
				"Introduction to Computing and Computer Science with Pascal",
				"0", "QA76.6.W3275"));
		
	
	
		
		// print library
		System.out.println("library before sorting");
	lib.printLibrary();
		// sort books by call number
		lib.quickSortLibrary();
		// print library
		System.out.println("library After sorting");
		lib.printLibrary();
*/
		
	}
}