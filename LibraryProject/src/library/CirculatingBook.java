

package library;

/**
 * simulates the type CirculatingBook
 *
 * @author kumarcal/HanSunHo
 *
 */
public class CirculatingBook extends LibraryBook {

    /**
     * currentHolder name of person who is holding the book
     */
    String currentHolder;

    /**
     * dueDate date of the book to be returned
     */
    String dueDate;

    /**
     * Constructor for circulating book. set currentHolder and dueDate to null,
     * so they can be set manually.
     *
     * @param writer
     *            author of the book
     * @param name
     *            name of the book
     * @param isbn
     *            ISBN of the book
     * @param callnum
     *            call number of the book
     */
    public CirculatingBook(String writer, String name, String isbn,
            String callnum) {
        super(writer, name, isbn, callnum);

        currentHolder = null;
        dueDate = null;
    }

    /**
     * return CurrentHolder of book
     *
     * @return name of the person who has the book
     */
    public String getCurrentHolder() {
        return currentHolder;
    }

    /**
     * Set CurrentHolder to person checking out book
     *
     * @param currentHolder
     *            name of person checking out book
     */
    public void setCurrentHolder(String currentHolder) {
        this.currentHolder = currentHolder;
    }

    /**
     * returns due date
     *
     * @return date of book to be returned
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * sets dueDate
     *
     * @param dueDate
     *            due date to be set
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    // checkout handles processing when a book is checked out, storing the
    // patron's name and the date the book is due to be returned.

    /**
     * checks out a book and renew its entries
     *
     * @param dueDate
     *            due date of the book
     * @param bookHolder
     *            name of book holder to be set
     */
    @Override
    public void checkout(String bookHolder, String dueDate) {
        setCurrentHolder(bookHolder);
        setDueDate(dueDate);
    }

    /**
     * when book is returned, sets current holder and due date to null.
     *
     */
    @Override
    public void returned() {
        setCurrentHolder(null);
        setDueDate(null);
    }

    /**
     * circulationStatus should return the currentHolder's name and due date, if
     * the book has been checked out; or "book available on shelves" if the book
     * is available.
     */
    @Override
    public String circulationStatus() {

        if (currentHolder == null) {
            return "This book is available on shelves";
        }

        else {
            return "This book is currently checked out"
                    + "\nThe current holder: " + currentHolder
                    + "\nThe dueDate of the book: " + dueDate;
        }
    }

    public String status() {

        if (currentHolder.equals(null)) {
            return "available";
        }

        else {
            return "checked out";
        }
    }

    /**
     * Provides neatly formatted printing of the information regarding the book
     *
     * @return Returns Information regarding book
     */
    public String toString() {
        return super.toString()
                + "\nIf the following are null, then book is on shelf"
                + "\nCurrent Holder: " + currentHolder + "\nDue Date: "
                + dueDate;
    }

	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

