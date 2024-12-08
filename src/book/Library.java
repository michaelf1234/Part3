
package book;
import java.util.ArrayList;

/**
 *Library Class (P.4, Task 2)
 * 
 * @author Michael Fraschetti
 */
public class Library {
    // Data members
    private ArrayList<Book> books;

    // Default constructor
    public Library() {
        books = new ArrayList<>();
        books.add(new Book("Book1", "Author1", 10.0, "Publisher1", "1-11-111111-1"));
    books.add(new Book("Book2", "Author2", 20.0, "Publisher2", "1-11-111112-2"));
    books.add(new Book("Book3", "Author3", 30.0, "Publisher3", "1-11-111113-3"));
    books.add(new Book("Book4", "Author4", 40.0, "Publisher4", "1-11-111114-4"));
    books.add(new Book("Book5", "Author5", 50.0, "Publisher5", "1-11-111115-5"));
    }

    // Constructor with arraylist
    public Library(ArrayList<Book> books) {
        this.books = new ArrayList<>(books);
    }

    // Copy constructor
    public Library(Library other) {
        this.books = new ArrayList<>(other.books);
    }

    // Method to search for books by keyword
    public ArrayList<Book> searchBook(String keyword) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    // toString method
    public String toString() {
        StringBuilder libraryDetails = new StringBuilder("Library Collection:\n");
        for (Book book : books) {
            libraryDetails.append(book.toString()).append("\n\n");
        }
        return libraryDetails.toString();
    }

    // Equals method
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Library library = (Library) obj;
        return books.equals(library.books);
    }

    // Getters and Setters
    public ArrayList<Book> getBooks() { return books; }
    public void setBooks(ArrayList<Book> books) { this.books = books; }
    
    // Main method to test Library class
    public static void main(String[] args) {
        Library library = new Library();
        System.out.println(library);

        // Test searchBook
        System.out.println("Search Results for 'Java':");
        ArrayList<Book> searchResults = library.searchBook("Java");
        for (Book book : searchResults) {
            System.out.println(book);
        }
    }
}
