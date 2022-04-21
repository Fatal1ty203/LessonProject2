package hw.homework_stream_part2.task8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Book> books = List.of(new Book("b1",100),new Book("b2",150),new Book("b3",400),
                new Book("b4", 20), new Book("b5", 80));
        Optional<Book> max = books.stream()
                .max(Comparator.comparing(Book::getPrice));
        System.out.println(max);
    }
}
