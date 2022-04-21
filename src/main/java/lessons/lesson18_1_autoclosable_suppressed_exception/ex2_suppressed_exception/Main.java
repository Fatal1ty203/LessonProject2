package lessons.lesson18_1_autoclosable_suppressed_exception.ex2_suppressed_exception;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //СОЗДАТЬ ПОДАВЛЕННОЕ (SUPPRESSED) ИСКЛЮЧЕНИЕ И ВЫВЕСТИ ОСНОВНОЕ ИСКЛЮЧЕНИЕ ВМЕСТЕ С ПОДАВЛЕННЫМИ
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
            throw new RuntimeException("exception inside try"); //ОСНОВНОЕ ИСКЛЮЧЕНИЕ ПОСЛЕ КОТОРОГО СРАБОТАЕТ ПОДАВЛЕННОЕ В МЕТОДЕ CLOSE
        }catch (Exception e){

            System.out.println(e); //ВЫВЕДЕТ ТОЛЬКО ОСНОВНОЕ ИСКЛЮЧЕНИЕ
            //ПОЭТОМУ ДОПОЛНИТЕЛЬНО САМИ ВЫВОДИМ ВСЕ ПОДАВЛЕННЫЕ (ОДНО У НАС ОДНО)
            for (Throwable throwable : e.getSuppressed()) {
                System.out.println("suppressed: "+throwable.toString());
            }
            //ВТОРОЙ ВАРИАНТ (ВЫВЕДЕТ ВООБЩЕ ВСЕ ИСКЛЮЧЕНИЯ РАЗОМ)
//            e.printStackTrace();
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
        if(1>0) throw new RuntimeException("exception inside close"); //БУДЕТ ПОДАВЛЕННЫМ,ТАК КАК ДО НЕГО СРАБОТАЛО ИСКЛЮЧЕНИЕ В БЛОКЕ TRY
        System.out.println("close");
        PrintWriter pw = new PrintWriter("src/lesson18_autoclosable/strings.txt");
        pw.println(list.toString());
        pw.close();
    }
}