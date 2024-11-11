package Problems.libraryManagementSystem;

import java.util.List;

public class LibrarySystemDemo {
    public static void main(String[] args) {
        LibrarySystem librarySystem = LibrarySystem.getInstance();

        // register member
        Member member = new Member("M001", "mukul", "98989898");
        librarySystem.registerMember(member);

        // register books
        librarySystem.registerBook(new Book("#234", "Harry putter", "Balbir Singh", "2054", true));
        librarySystem.registerBook(new Book("#0809", "Rich Dad Poor Dad", "Robert", "2054", true));


        // search books
        List<Book> searchedBook =  librarySystem.searchBooks("Harry");
        System.out.println("Searched Result:");
        for(Book book: searchedBook){
            System.out.println("Book: "+book.getTitle() + " by " + book.getAuthor());
        }

        // borrow books
        librarySystem.borrowBook("M001", searchedBook.get(0).getIsbn());


        // return books
        librarySystem.returnBooks("M001", searchedBook.get(0).getIsbn());

    }

}