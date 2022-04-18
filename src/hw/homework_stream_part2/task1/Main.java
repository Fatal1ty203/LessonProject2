package hw.homework_stream_part2.task1;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Book> bookStream = List.of(new Book("Ницше","По ту сторону добра и зла "),
                new Book("Ницше", "Так говорил Заратустра"),
                new Book("Путин", "Гарик потный"),
                new Book("Сакс", "Человек, которы принял жену за шляпу"),
                new Book("Бёрджесс", "Однорукий аплодисмент"),
                new Book("Эппель", "Шампиньон моей жизни"));
        Scanner scn = new Scanner(System.in);

        int input = 0;
        while (input!=2){
            System.out.println("1. Найти книги автора: \n" +
                    "2.Выход");
            input= scn.nextInt();
            scn.nextLine();
            if (input==1){
                String authorName = scn.nextLine();
                List<String> stringList = bookStream.stream()
                        .filter(val -> val.getAuthorName().equalsIgnoreCase(authorName))
                        .map(Book::getBookName)
                        .collect(Collectors.toList());
                System.out.println(stringList);
            }
        }

    }
}
