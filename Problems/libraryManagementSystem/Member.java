package Problems.libraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private String contactInfo;
    private List<Book> borrowedBooks;

    Member(String id, String name, String contactInfo){
        this.memberId = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book){
        this.borrowedBooks.add(book);
    }

    public void returnBooks(Book book){
        this.borrowedBooks.remove(book);
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public String getContactInfo() {
        return contactInfo;
    }
}