package hw.homework_stream.tast6;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> bookList = List.of(new Book("Так говорил Заратустра",100,10000)
                ,new Book("По ту сторону добра и зла", 70,5000)
                ,new Book("Гарик потный",30, 100)
                ,new Book("Человек, которы принял жену за шляпу", 50, 999)
                ,new Book("Однорукий аплодисмент", 80, 800)
                ,new Book("Шампиньон моей жизни", 20,6000));

        System.out.println("Цена ниже 80");
        bookList.stream()
                .filter(val->val.getPrice()<80)
                .forEach(System.out::println);

        System.out.println("бестселлеры");
        bookList.stream()
                .filter(val->val.isBestSeller())
                .forEach(System.out::println);
    }
}
