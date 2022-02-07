package hw.homework_lyamda;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> bookList = new ArrayList<>();

    public void addBook(Book book){
        bookList.add(book);
    }

    public List<Book> searchBook(Ibook book, String key){
        List<Book> list = new ArrayList<>();

        for (Book book1 : bookList){
            if (book.searchBook(book1,key)){
                list.add(book1);
            }
        }
        return list;
    }
}
