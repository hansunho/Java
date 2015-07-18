package library;
/**
 * simulates the type LibraryBook
 *
 * @author hansunho
 *
 */
public abstract class LibraryBook extends Book implements Comparable <Book>{
    protected String callNumber;

    /**Constructor of a Library book
     *
     * @param writer
     * @param name
     * @param isbn
     * @param callnum
     */
    public LibraryBook(String writer, String name, String isbn, String callnum)
    {
        super(writer, name, isbn);
        callNumber = callnum;
    }
    
    /** Gets call number of book
     *
     * @return Returns call number of book
     */
    public String getCallNumber() {
        return callNumber;
    }

    /**Sets Call Number of the book
     *
     * @param callNumber, call number of book to be set
     */
    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    /** Checkout a book and sets its dueDate and stores its bookHolder (to be implemented in subclasses)
     *
     * @param dueDate Due date to be set
     * @param bookHolder Person who checks out book
     */
    public abstract void checkout(String dueDate, String bookHolder);
    
    /** Allows for return of book (to be implemented in subclasses)
     *  
     */
    public abstract void returned();
    
    /** Determines the circulation status of the book
     *
     * @return Returns circulation status of the book
     */
    public abstract String circulationStatus();
    
    
    /**
     * Checks whether two books are the same by checking their ISBN number
     *
     * @param o
     *            A book to be compared
     * @return 0 if ISBN numbers of books are equal < 0 if ISBN number of this
     *         comes before ISBN number of o > 0 otherwise
     */
    public int compareTo(LibraryBook book)
    {
        return callNumber.compareTo(book.getCallNumber());
    }
    
    /** Provides neatly formatted printing of the information regarding the book
     *
     * @return Returns Information regarding book
     */
    public String toString(){
    return super.toString()+"\ncall number= " + callNumber;
}
}
