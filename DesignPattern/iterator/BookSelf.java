package DesignPattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class BookSelf implements Container<Book> {

    private List<Book> books;

    BookSelf(){
        books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }


    @Override
    public Itr<Book> getIterator() {
        return new BookIterator();
    }

    private class BookIterator implements Itr<Book>{
        private int index;

        @Override
        public boolean hasNext() {
            return index < books.size();
        }

        @Override
        public Book next() {
            if(this.hasNext()){
                return books.get(index++);
            }

            return null;

        }
    }
}
