/**
 * Lauren Acosta, CEN 3024C, 3/5/2024
 * class name: BookCatalogTest
 * The overall purpose of the BookCatalogTest class is to perform unit tests on the functionalities provided by the BookCatalog class.
 * This class contains a series of test methods, each targeting a specific functionality or behavior of the BookCatalog class.
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Javadoc comments for the BookCatalogTest class.
 */
class BookCatalogTest {

    private BookCatalog catalog;

    /**
     * Javadoc comments for the setUp method.
     */
    @BeforeEach
    void setUp() {

        catalog = new BookCatalog();
        catalog.addBooksFromFile("LMS_in.txt"); // Replace "books.txt" with the actual file path
    }

    /**
     * Javadoc comments for the testAddBooksFromFile method.
     * Verifies that the addBooksFromFile method of the BookCatalog class successfully adds books to the catalog from a file.
     */
    @Test
    void testAddBooksFromFile() {

        // Get the initial number of books in the catalog
        int initialSize = catalog.getTotalBooks();

        // Call the addBooksFromFile method to add books from a file
        catalog.addBooksFromFile("LMS_in.txt");

        // Get the final number of books in the catalog after adding books from the file
        int finalSize = catalog.getTotalBooks();

        // Ensures final number of books is greater than the initial number,
        // indicating that books were successfully added to the catalog
        assertTrue(finalSize > initialSize, "Error: final size is not greater than initial size.");
    }

    /**
     * Javadoc comments for the testRemoveBookByBarcode method.
     * Ensures that removeBookByBarcode method of the BookCatalog class correctly removes a book from the catalog based on its barcode.
     */
    @Test
    void testRemoveBookByBarcode() {

        int initialSize = catalog.getTotalBooks();

        // Remove a book by barcode
        assertTrue(catalog.removeBookByBarcode("4076838149"), "error Failed to remove book by barcode");

        // Ensures that the size has decreased after removal
        assertTrue(catalog.getTotalBooks() < initialSize, "error Size did not decrease after book removal");

        // Tries removing a non-existent book
        assertFalse(catalog.removeBookByBarcode("5673245691"), "removed non-existent book");
    }

    /**
     * Javadoc comments for the testRemoveBookByTitle method.
     * Validates the functionality of the removeBookByTitle method in the BookCatalog class by removing a book from the catalog based on its title.
     */
    @Test
    void testRemoveBookByTitle() {

        int initialSize = catalog.getTotalBooks();

        // Remove a book by title
        assertTrue(catalog.removeBookByTitle("Twilight"), "Error: Failed to remove book with title 'Twilight'");

        // Ensure the size has decreased after removal
        assertTrue(catalog.getTotalBooks() < initialSize, "Error: Size did not decrease after book removal");

        // Try removing a non-existent book
        assertFalse(catalog.removeBookByTitle("The Catcher in the Rye"), "Successfully removed non-existent book with title 'The Catcher in the Rye'");
    }

    /**
     * Javadoc comments for the testCheckOutBook method.
     * Tests the checkOutBook method of the BookCatalog class, which checks out a book from the catalog.
     */
    @Test
    void testCheckOutBook() {
        // Check out a book
        catalog.checkOutBook("Twilight");
        Book twilight = catalog.findBookByTitle("Twilight");

        // Ensure the book is found
        assertNotNull(twilight, "Book 'Twilight' not found");

        // Ensure the book's status is 'checked out'
        assertEquals("checked out", twilight.getStatus(), "Book 'Twilight' status is not 'checked out'");

        // Ensure the book's due date is not null
        assertNotNull(twilight.getDueDate(), "Book 'Twilight' due date is null after checkout");

    }

    /**
     * Javadoc comments for the testCheckInBook method.
     * Tests the checkInBook method of the BookCatalog class, which checks in a book to the catalog.
     */
    @Test
    void testCheckInBook() {
        boolean checkedIn = catalog.checkInBook("Twilight");
        assertTrue(checkedIn, "The book should be successfully checked in"); // Now it should return true as the book was successfully checked in
        Book checkedInBook = catalog.getBookByTitle("Twilight");
        // Ensure due date is null after check-in
        assertNull(checkedInBook.getDueDate(), "The due date of the checked-in book should be null");
    }
}
