package Problems.libraryManagementSystem;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String publicationYear;
    private boolean isAvailable;

    Book(String isbn, String title, String author, String publicationYear, boolean isAvailable){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
