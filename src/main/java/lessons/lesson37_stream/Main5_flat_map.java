package lessons.lesson37_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main5_flat_map {
    public static void main(String[] args) {
        //- Вывести на консоль двумерный массив типа int
        int[][] data = {
                {2, 6, 5},
                {1, 2, 3},
                {5, 4, 5}
        };
        //проблема: стрим стримов
        //Stream<IntStream> intStreamStream = Arrays.stream(data).map(arr -> Arrays.stream(arr));
        //решение: распаковать intStream (избавиться от внешней оболочки)
//        IntStream intStream = Arrays.stream(data).flatMapToInt(arr -> Arrays.stream(arr));
        Arrays.stream(data).flatMapToInt(arr -> Arrays.stream(arr)).forEach(System.out::println);


        //+ Создать массив библиотек, в каждой из которых есть массив книг. Вывести название каждой книги
        class Book{
            String name;
            String author;

            public Book(String name, String author) {
                this.name = name;
                this.author = author;
            }
        }

        class Library{
//            Book[] arr = {new Book("book1", "author1"),
//                    new Book("book2", "author2"),
//                    new Book("book3", "author1") };
            Book[] arrBook;

            public Library(Book... arrBook) {
                this.arrBook = arrBook;
            }
        }

        Library[] arrLibrary = {new Library(new Book("book1", "author1"), new Book("book2", "author2")),
                new Library( new Book("book2", "author2"), new Book("book3", "author1"))};
        List<String> collect = Arrays.stream(arrLibrary)
                .flatMap(val -> Arrays.stream(val.arrBook))
                .map(val -> val.name)
                .collect(Collectors.toList());
        System.out.println(collect);




    }
}
