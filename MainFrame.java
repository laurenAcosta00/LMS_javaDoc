import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Lauren Acosta, CEN 3024C, 4/10/2024
 * The MainFrame class creates the user interface (GUI) window of the library management system (LMS) application.
 * It's the primary interface through which users can interact with the system, such as loading books from a file,
 * displaying information about books in the database, removing books by barcode or title, and checking books in and out.
 */
public class MainFrame extends JFrame {

    // parameters for establishing a connection to MySQL database from Java application
    private static final String URL = "jdbc:mysql://localhost:3306/l_m_s";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Lucca068!";
    private Connection connection;

    //instance variables for GUI components and objects
    private JTextField fileNameField;
    private JTextArea databaseTextArea;
    private BookCatalog catalog;

    private JTextField barcodeField;
    private JButton removeByBarcodeButton;
    private JTextField titleField;
    private JButton removeByTitleButton;

    private JTextField checkOutTitleField;
    private JButton checkOutButton;
    private JTextField checkInTitleField;
    private JButton checkInButton;

    /**
     * Constructs a new MainFrame object.
     * Initializes the GUI window and sets up the database connection.
     */
    public MainFrame() {
        setTitle("Library Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Initialize book catalog
        catalog = new BookCatalog();

        // Initialize GUI components
        // ...
    }

    // Database-related methods

    /**
     * Loads book information from a MySQL database and updates the BookCatalog accordingly.
     * Retrieves data from the "books" table, creates Book objects, and adds them to the catalog.
     */
    private void loadBooksFromDatabase() {
        // ...
    }

    /**
     * Removes a book from both the MySQL database and the BookCatalog based on its barcode.
     * Executes a SQL DELETE query to remove the book entry from the "books" table where the barcode matches the provided parameter.
     *
     * @param barcode The barcode of the book to be removed.
     */
    private void removeBookByBarcode(String barcode) {
        // ...
    }

    /**
     * Removes a book from both the MySQL database and the BookCatalog based on its title.
     * Executes a SQL DELETE query to remove the book entry from the "books" table where the title matches the provided parameter.
     *
     * @param title The title of the book to be removed.
     */
    private void removeBookByTitle(String title) {
        // ...
    }

    /**
     * Updates the status of a book in the MySQL database to "checked out" and sets the due date to four weeks from the current date.
     * Executes an SQL UPDATE query to modify the "status" and "dueDate" columns in the "books" table where the title matches the provided parameter.
     *
     * @param title The title of the book to be checked out.
     */
    private void checkOutBook(String title) {
        // ...
    }

    /**
     * Updates the status of a book in the MySQL database to "checked in" and sets the due date to NULL.
     * Executes an SQL UPDATE query to modify the "status" and "dueDate" columns in the "books" table where the title matches the provided parameter.
     *
     * @param title The title of the book to be checked in.
     */
    private void checkInBook(String title) {
        // ...
    }

    /**
     * Updates the text area in the GUI with information about all the books stored in the catalog.
     * Iterates through all the books in the catalog, retrieves their information, and appends each book's details to a StringBuilder object.
     */
    private void updateDatabaseTextArea() {
        // ...
    }

    // Main method

    /**
     * The main method creates a new MainFrame object and makes it visible.
     * This method is the entry point of the program.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
