package DesignPattern.iterator;

public class IteratorDemo {
    public static void main(String[] args) {

        Book book1 = new Book("Harry Potter");
        Book book2 = new Book("Spider-Man");
        Book book3 = new Book("Ali-baba");

        BookSelf bookSelf = new BookSelf();

        bookSelf.addBook(book1);
        bookSelf.addBook(book2);
        bookSelf.addBook(book3);

        Itr<Book> bookItr = bookSelf.getIterator();

        while(bookItr.hasNext()){
            Book b = bookItr.next();
            System.out.println(b.getTitle());
        }
    }
}