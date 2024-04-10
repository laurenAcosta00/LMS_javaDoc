import static org.junit.jupiter.api.Assertions.*;

/**
 * Lauren Acosta, CEN 3024C, 3/5/2024
 * BookTest Class to test the functionality of the Book class, verifies the correctness of the toString() method in the Book class.
 */
class BookTest {

    //create an object to be tested
    Book book;

    /**
     * Set up the test environment before each test method is executed.
     * Initializes the Book object with test data.
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        // Initialization of the Book object with test data
        book = new Book("1234567890", "Twilight", "Stephanie Meyer", "fiction", "checked out", "2024-04-15");
    }

    /**
     * Test the toString() method of the Book class.
     * Verifies that the string representation of the book matches the expected value.
     */
    @org.junit.jupiter.api.Test
    void testToString() {
        String expected = "Book{title='Twilight', author='Stephanie Meyer', genre='fiction', barcode='1234567890', status='checked out', dueDate='2024-04-15'}";
        // assert equals will compare two values and display a message if they are not equal
        assertEquals(expected, book.toString(), "Error: String representation of the book doesn't match the expected value");
    }
}

