package lessons.lesson20_iterator.ex2_iterator_pattern;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Создать свой итератор книг по библиотеке книг
        //Создать класс Library в котором есть список книг и сделать итератор по нему


        Library library = new Library();
        library.add(new Book("book1", "author1"));
        library.add(new Book("book2", "author1"));
        library.add(new Book("book3", "author2"));

//        for (int i = 0; i < library.books.size(); i++) {
//            System.out.println(library.books.get(i));
//        }

        //Выведем все книги через итератор
        //Способ 1. Через цикл for each
//        for(Book book : library){
//            System.out.println(book);
//        }
        //Способ 2
        Iterator<Book> iterator = library.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}

class Library implements Iterable<Book>{
    List<Book> books = new ArrayList<>();
    public void add(Book book){
        books.add(book);
    }


    @Override
    public Iterator<Book> iterator() {
        return new MyIterator();
    }

    //inner class
    private class MyIterator implements Iterator<Book>{
        int bookIndex = 0;
        @Override
        public boolean hasNext() {
            return bookIndex < books.size();
        }

        @Override
        public Book next() {
            return books.get(bookIndex++);
        }
    }
}

class Book{
    String name;
    String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }


}

