package Problems.libraryManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibrarySystem {
    private static LibrarySystem instance;
    private Map<String , Book> catalog;
    private Map<String , Member> memberMap;
    private int MAX_DURATION_FOR_BOOKS = 5;

    private LibrarySystem(){
        this.catalog = new HashMap<>();
        this.memberMap = new HashMap<>();
    }

    public synchronized static LibrarySystem getInstance(){
        if(instance == null){
            instance = new LibrarySystem();
        }

        return instance;
    }

    public void registerMember(Member member){
        this.memberMap.put(member.getMemberId(), member);
    }

    public void registerBook(Book book){
        this.catalog.put(book.getIsbn(), book);
    }


    public synchronized void borrowBook(String memberId, String isbn){
        Member member = memberMap.get(memberId);
        Book book = catalog.get(isbn);

        if(member == null || book == null){
            System.out.println("Memmber or Book not available");
            return;
        }

        if(book.isAvailable() == false){
            System.out.println("Book is not available");
            return;
        }

        if(member.getBorrowedBooks().size() >= MAX_DURATION_FOR_BOOKS){
            System.out.println("Member " + member.getName() + " has reached the maximum number of borrowed books.");
        }

        book.setAvailable(false);
        member.borrowBook(book);
        System.out.println("Book borrowed: " + book.getTitle() + " by "+ member.getName());
    }

    public synchronized void returnBooks(String memberId, String bookId) {
        Member member = this.memberMap.get(memberId);
        Book book = this.catalog.get(bookId);

        if(member != null && book != null){
            member.returnBooks(book);
            book.setAvailable(true);
            System.out.println("Book returned: "+ book.getTitle() + " by " + member.getName());
        }else{
            System.out.println("Book or Member not found");
        }
    }


    public List<Book> searchBooks(String keyword){
        List<Book> searchedBooks = new ArrayList<>();
        for(Map.Entry<String,Book> bookEntry: catalog.entrySet() ){
            String author = bookEntry.getValue().getAuthor();
            String title = bookEntry.getValue().getTitle();
            if(author.contains(keyword) || title.contains(keyword)){
                searchedBooks.add(bookEntry.getValue());
            }
        }

        return searchedBooks;
    }


}