/**
 * Lauren Acosta, CEN 3024C, 4/10/2024
 * The Book class represents individual books within the library management system
 * and plays a crucial role in managing the attributes and behaviors of each book.
 */
public class Book {

    private String barcode;
    private String author;
    private String genre;
    private String title;
    private String status;
    private String due_date;

    /**
     * Constructs a new Book object with the provided attributes.
     *
     * @param barcode  the barcode of the book
     * @param title    the title of the book
     * @param author   the author of the book
     * @param genre    the genre of the book
     * @param status   the status of the book (e.g., "available" or "checked out")
     * @param due_date the due date of the book (if checked out)
     */
    public Book(String barcode, String title, String author, String genre, String status, String due_date) {
        this.barcode = barcode;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.status = "available"; // Initialize status to "available"
        this.due_date = due_date;
    }

    /**
     * Retrieves the barcode of the book.
     *
     * @return the barcode of the book
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * Retrieves the title of the book.
     *
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Retrieves the author of the book.
     *
     * @return the author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Retrieves the genre of the book.
     *
     * @return the genre of the book
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Retrieves the status of the book (e.g., "available" or "checked out").
     *
     * @return the status of the book
     */
    public String getStatus() {
        return status;
    }

    /**
     * Retrieves the due date of the book (if checked out).
     *
     * @return the due date of the book
     */
    public String getDueDate() {
        return due_date;
    }

    /**
     * Sets the barcode of the book.
     *
     * @param barcode the barcode to set
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    /**
     * Sets the title of the book.
     *
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the author of the book.
     *
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Sets the genre of the book.
     *
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Sets the status of the book (e.g., "available" or "checked out").
     *
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Sets the due date of the book (if checked out).
     *
     * @param dueDate the due date to set
     */
    public void setDueDate(String dueDate) {
        this.due_date = dueDate;
    }

    /**
     * Provides a string representation of a Book object.
     *
     * @return a string containing the attributes of the book along with their corresponding values
     */
    @Override
    public String toString() {
        return "Book{" +
                "title='" + barcode + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", barcode='" + title + '\'' +
                ", status='" + status + '\'' +
                ", dueDate='" + due_date + '\'' +
                '}';
    }
}
