package hw.homework_stream_part2.task10;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> list = List.of(new Book("b1","a1",100),new Book("b2", "a2", 70));
        List<Book> list2 = List.of(new Book("b3","a3", 80), new Book("b4","a4",120));
        List<Library> libraries = List.of(new Library(list), new Library(list2));

    }
}
