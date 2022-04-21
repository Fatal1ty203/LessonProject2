package lessons.lesson18_1_autoclosable_suppressed_exception.ex1_our_own_resource;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //В блок try с ресурсами можно поместить любой объект, реализующий интрфейс AutoCloseable
        //именно этот интерфейс содержит метод close, который вызвается автоматически при выходе из блока try с ресурсами
        //
        //1 Пример:
        //Создать класс MyList, который является оберткой обычного списка и содержит в качестве поля реальный список в типе String
        //Наш класс будет добавлять этому списку метод close из интерфейса AutoCloseable
        //Реализовать метод close так, чтобы он записывал все строки из списка в файл
        //
        //В мейне реализовать консольное меню и проверить работу метода (использовать try с ресурсами с нашим объектом)

        //ПРИМЕР ВЫВОДА ЭЛЕМЕНТОВ СПИСКА ЧЕРЕЗ TOSTRING (КЛАСС ARRAY LIST ПЕРЕОПРЕДЕЛЯЕМ МЕТОД TOSTRING, ПОЭТОМУ ЕГО МОЖНО ИСПОЛЬЗОАВТЬ)
//        ArrayList<String> list = new ArrayList<>();
//        list.add("one");
//        list.add("two");
//        System.out.println(list.toString());
//
//        MyList myList = new MyList();
//        myList.add("one");
//        myList.add("two");
//        System.out.println(myList); //toString вызовется автоматически

        //СДЕЛАТЬ КЛАСС MYLIST РЕСУРСОМ, ЧТОБЫ ЕГО МОЖНО БЫЛО ИСПОЛЬЗОВАТЬ В TRY С РЕСУРСАМИ
        //СДЕЛАТЬ ТАК, ЧТОБЫ ЭЛЕМЕНТЫ СПИСКА MYLIST АВТОМАТИЧЕСКИ СОХРАНЯЛИСЬ В ФАЙЛЕ ПРИ ВЫЗОВЕ МЕТОДА CLOSE У РЕСУРСА
        try(MyList myList = new MyList()){
            int input = 0;
            while(input!=3){
                System.out.println("1. Add string");
                System.out.println("2. Print elements");
                System.out.println("3. Exit");
                Scanner scn = new Scanner(System.in);
                input = scn.nextInt();
                switch (input){
                    case 1 -> {
                        System.out.println("Enter string");
                        myList.add(scn.next());
                    }
                    case 2 ->{
                        System.out.println(myList);
                    }
                }
            }
            throw new RuntimeException("exception inside try");
        }catch (Exception e){
//            e.printStackTrace();
            System.out.println(e);
            for (Throwable throwable : e.getSuppressed()) {
                System.out.println("suppressed: "+throwable.toString());
            }
        }

    }
}


class MyList implements AutoCloseable{
    List<String> list = new ArrayList<>();

    public void add(String val){
        list.add(val);
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public void close() throws Exception {
        if(1>0) throw new RuntimeException("exception inside close");
        System.out.println("close");
        PrintWriter pw = new PrintWriter("src/lesson18_autoclosable/strings.txt");
        pw.println(list.toString());
        pw.close();
    }
}