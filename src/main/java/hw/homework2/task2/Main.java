package hw.homework2.task2;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Company> companies = new ArrayList<>();
        companies.add(new Apple("Sidorov", 5));
        companies.add(new Finex("Petrov", 5000, 680, 30, 2000));
        companies.add(new Finam("Polin",200,5000));

        Apple.addModel(companies,"Iphone");
        Apple.addModel(companies,"Iphone - XR");
        Apple.addModel(companies,"Iphone - XR.Lite");

        companies.forEach(System.out::println);
        Finex.saleInt(companies, 76);
        System.out.println("Продали ----------------->");
        companies.forEach(System.out::println);



//        Apple apple = new Apple("Sidorov",5);
//        apple.addModel("XR");
//        System.out.println(apple);
//        apple.addWorker();
//        System.out.println(apple);
//
//        Finex finex = new Finex("Petrov", 80000,670,50,20000);
//        System.out.println(finex);
//        finex.addWorker();
//        finex.saleN(4);
//        System.out.println(finex);
//        finex.saleN(40);
//        finex.fireWorker(50);
//        System.out.println(finex);
//
//        Finam finam = new Finam("asdasd", 6500,1000);
//        finam.increaseCommission(50);
//        System.out.println(finam);
//        finam.decrease(20);
//        System.out.println(finam);

    }
}
