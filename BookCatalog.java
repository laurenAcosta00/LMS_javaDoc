import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Lauren Acosta, CEN 3024C, 4/10/2024
 * The BookCatalog class serves as the backbone for managing the library's collection of books,
 * providing essential functionalities such as adding, removing, checking out, and checking in books.
 * This class also calculates a checked-out book's due date and updates the status accordingly.
 */
class BookCatalog {
    private List<Book> books;

    /**
     * Constructs a new BookCatalog object.
     * Initializes an empty list of books.
     */
    public BookCatalog() {
        this.books = new ArrayList<>();
    }

    /**
     * Populates the catalog of books by reading book information from a text file.
     *
     * @param filePath the path to the text file containing book information
     */
    public void addBooksFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] bookInfo = line.split(",");
                String barcode = bookInfo[0];
                String title = bookInfo[1].trim();
                String author = bookInfo[2];
                String genre = bookInfo[3];
                String status = bookInfo[4].trim();
                String due_date = bookInfo[5].trim();

                Book book = new Book(barcode, title, author, genre, status, due_date);
                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes a book from the catalog based on its barcode.
     *
     * @param barcode the barcode of the book to be removed
     * @return true if the book was found and removed successfully, false otherwise
     */
    public boolean removeBookByBarcode(String barcode) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getBarcode().equals(barcode)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Removes a book from the catalog based on its title.
     *
     * @param title the title of the book to be removed
     * @return true if the book was found and removed successfully, false otherwise
     */
    public boolean removeBookByTitle(String title) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equals(title.trim())) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Checks out a book from the catalog.
     *
     * @param title the title of the book to be checked out
     */
    public void checkOutBook(String title) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equalsIgnoreCase(title)) {
                if ("checked out".equals(book.getStatus())) {
                    System.out.println("Error: This book is already checked out.");
                    return;
                }
                LocalDate currentDate = LocalDate.now();
                LocalDate dueDate = currentDate.plusWeeks(4);
                book.setStatus("checked out");
                book.setDueDate(dueDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")));
                System.out.println("Book checked out successfully. Due date: " + book.getDueDate());
                return;
            }
        }
        System.out.println("Error: Book not found.");
    }

    /**
     * Checks in a book to the catalog.
     *
     * @param title the title of the book to be checked in
     * @return true if the book was successfully checked in, false otherwise
     */
    public boolean checkInBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if ("checked in".equals(book.getStatus())) {
                    System.out.println("Error: This book is already checked in.");
                    return false;
                }
                book.setStatus("checked in");
                book.setDueDate(null);
                System.out.println("Book checked in successfully.");
                return true;
            }
        }
        System.out.println("Book checked in successfully.");
        return true;
    }

    /**
     * Displays all books in the catalog.
     */
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    /**
     * Retrieves all books in the catalog.
     *
     * @return a list containing all books in the catalog
     */
    public List<Book> getAllBooks() {
        return books;
    }

    /**
     * Retrieves the total number of books in the catalog.
     *
     * @return the total number of books in the catalog
     */
    public int getTotalBooks() {
        return books.size();
    }

    /**
     * Finds a book in the catalog based on its title.
     *
     * @param title the title of the book to be found
     * @return the book with the matching title, or null if not found
     */
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Retrieves a book from the catalog based on its title.
     *
     * @param title the title of the book to be retrieved
     * @return the book with the matching title, or null if not found
     */
    public Book getBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Adds a book to the catalog.
     *
     * @param book the book to be added to the catalog
     */
    public void addBook(Book book) {
        // Implementation goes here
    }
}
