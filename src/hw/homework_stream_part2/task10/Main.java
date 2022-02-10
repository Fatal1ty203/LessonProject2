package hw.homework_stream_part2.task10;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Book> list = List.of(new Book("b1","a1",100),new Book("b2", "a2", 70));
        List<Book> list2 = List.of(new Book("b3","a3", 80), new Book("b4","a1",120));
        List<Library> libraries = List.of(new Library(list), new Library(list2));

        Scanner scn = new Scanner(System.in);

        int input = 0;

        while (input!=5){
            System.out.println("1. Вывести все книги из библиотеки (выводится полная информация)\n" +
                    "2. Вывести все книги одного автора (пользователь вводит автора с консоли)\n" +
                    "3. Найти самую дорогую книгу и вывести информацию о ней на консоль\n" +
                    "4. Вывести книги, чья цена не дороже 100\n" +
                    "5. Выход");
            input = scn.nextInt();
            scn.nextLine();
            if (input == 1){
                libraries.stream()
                        .flatMap(val -> val.getList().stream())
                        .forEach(System.out::println);
            }else if (input == 2){

                String authorName = scn.nextLine();
                libraries.stream()
                        .flatMap(val -> val.getList().stream())
                        .filter(val -> val.getAuthorName().equalsIgnoreCase(authorName))
                        .forEach(System.out::println);
            }else if (input == 3){
                libraries.stream()
                        .flatMap(val -> val.getList().stream())
                        .max(Comparator.comparing(Book::getPrice))
                        .ifPresent(System.out::println);
            }else if (input == 4){
                libraries.stream()
                        .flatMap(val -> val.getList().stream())
                        .filter(val -> val.getPrice()>100)
                        .forEach(System.out::println);
            }
        }
    }
}
