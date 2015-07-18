package library;

/**
 * simulates the type ReferenceBook
 *
 * @author hansunho
 *
 */

public class ReferenceBook extends LibraryBook {

    public String Collection;

    /**
     * Constructor for a ReferenceBook
     *
     * @param auth
     * @param title
     * @param ISBN
     * @param callnumber
     * @param collection
     */
    public ReferenceBook(String auth, String title, String ISBN, String callnumber,
            String collection) {
        super(auth, title, ISBN, callnumber);
        Collection = collection;
    }

    /**
     * Gets Collection status of book
     *
     * @return the grouping of the book
     */
    public String getCollection() {
        return Collection;
    }

    /**
     * Sets collection status of book
     *
     * @param collection
     *            collection type to be set
     */
    public void setCollection(String collection) {
        Collection = collection;
    }

    /**
     * Reference book can not be checked out, so let the user know
     *
     */
    public void checkout(String a, String b) {
        System.out.println("cannot check out a reference book");
    }

    /**
     * Reference book can not be checked out, so it can not be returned either
     *
     */
    public void returned() {
        System.out
                .println("reference book could not have been checked out -- return impossible");
    }

    /**
     * Let user know the circulation status of the book
     *
     * @return Returns "non-circulating reference book" because this type of
     *         book can not be checked out
     */
    public String circulationStatus() {

        return "non-circulating reference book";
    }

    /**
     * Checks whether two books are the same by checking their ISBN number
     *
     * @param o
     *            A book to be compared
     * @return 0 if ISBN numbers of books are equal < 0 if ISBN number of this
     *         comes before ISBN number of o > 0 otherwise
     */
    @Override
    public int compareTo(LibraryBook o) {
        return super.compareTo(o);
    }
    
    
    public String toString() {
        return super.toString() +"\ncirculation status: " + Collection;
    }

	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return 0;
	}


}