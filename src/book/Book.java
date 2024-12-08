
package book;

/**
 *Book Class(P.4,Task 1)
 * 
 * @author Michael Fraschetti
 */
public class Book {
    // Data members
    private String title;
    private String author;
    private double price;
    private String publisher;
    private String isbn;

    // Default constructor
    public Book() {
        this.title = "Untitled";
        this.author = "Unknown";
        this.price = 0.0;
        this.publisher = "Not specified";
        this.isbn = "000-0-00-000000-0";
    }

    // Constructor with  title
    public Book(String title) {
        this();
        this.title = toTitleCase(title);
    }

    // Constructor with all data members
    public Book(String title, String author, double price, String publisher, String isbn) {
        this.title = toTitleCase(title);
        this.author = toTitleCase(author);
        this.price = price;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    // Copy constructor
    public Book(Book other) {
        this.title = other.title;
        this.author = other.author;
        this.price = other.price;
        this.publisher = other.publisher;
        this.isbn = other.isbn;
    }

    // ISBN status
    public int checkIsbnStatus() {
        if (isbn.matches("\\d-\\d{2}-\\d{6}-\\d") || isbn.matches("\\d{3}-\\d-\\d{2}-\\d{6}-\\d")) {
            return 0; // ISBN10
        } else if (isbn.matches("978-\\d-\\d{2}-\\d{6}-\\d") || isbn.matches("978-\\d{1,5}-\\d{1,7}-\\d{1,7}-\\d")) {
            return 1; 
        }
        return -1; 
    }

    // converting text to title case
    private String toTitleCase(String text) {
        String[] words = text.toLowerCase().split(" ");
        StringBuilder titleCase = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                titleCase.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            }
        }
        return titleCase.toString().trim();
    }

    // toString method
    public String toString() {
        return "Title      : " + title + "\n" +
               "Author     : " + author + "\n" +
               "Price      : " + price + "\n" +
               "Publisher  : " + publisher + "\n" +
               "ISBN       : " + isbn;
    }

    // Equals method
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return isbn.equals(book.isbn);
    }

    // Clone method
    public Book clone() {
        return new Book(this);
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = toTitleCase(title); }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = toTitleCase(author); }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    

// Main method to test
    public static void main(String[] args) {
        // Test the Book class
        Book book = new Book("How To Speak Chinese", "Your Name", 9.99, "To be confirmed", "123456789-0");
        System.out.println(book);

        // Test checkIsbnStatus
        System.out.println("ISBN Status: " + book.checkIsbnStatus());
    }
}
    
    

