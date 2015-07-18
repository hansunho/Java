package library;
/**
 *  simulates the type Book  
 *
 * @author kumarcal/HanSunHo
 *
 */
public class Book {

    public String author;
    public String title;
    public String ISBN;

    /**Null Constructor for a Book
     *
     */
    public Book() {
        author = "";
        title = "";
        ISBN = "";
    }

    /** Constructor for book
     *
     * @param Author
     * @param Title
     * @param iSBN
     */
    public Book(String Author, String Title, String iSBN) {

        author = Author;
        title = Title;
        ISBN = iSBN;
    }

    /** Get ISBN number of book
     *
     * @return Returns ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /** Sets book's ISBN number
     *
     * @param iSBN
     */
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    /** Gets Author of book
     *
     * @return Returns Author of book
     */
    public String getAuthor() {
        return author;
    }

    /**Sets Author of book
     *
     * @param Author Author of the book
     */
    public void setAuthor(String Author) {
        author = Author;
    }

    /** Gets Title of book
     *
     * @return Returns title of book
     */
    public String getTitle() {
        return title;
    }

    /** Sets Title of book
     *
     * @param Title Title of book to be set
     */
    public void setTitle(String Title) {
        title = Title;
    }

    /** Provides neatly formatted printing of the information regarding the book
     *
     * @return Returns Information regarding book
     */
    public String toString() {

        return "Author: " + author + "\nTitle: " + title + "\nISBN: " + ISBN;
    }
    
}
