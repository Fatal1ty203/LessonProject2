package lessons.lesson13_string_operations;

import java.util.ArrayList;
import java.util.List;

public class Main_string_builder {
    public static void main(String[] args) {
        String str1="hello";
        String str2="world";
        str1 = str1+str2;
        System.out.println(str1);

        //Как сложить строки через StringBUilder
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        sb.append(" ");
        sb.append("world").append("!").append("!");
        System.out.println(sb.toString());

        //Пример StringBUilder на примере toString:
//        University university = new University();
//        System.out.println(university.toString());


        //REVERSE - разворот строки
        StringBuilder sb2 = new StringBuilder("hello world");
        StringBuilder reverse = sb2.reverse();
        System.out.println(reverse);
    }
}


class University{
    String name;
    List<String> student = new ArrayList<>();

    public University(){
        for (int i = 0; i < 1000_000; i++) {
            student.add("studnet"+i);
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");

        for (int i = 0; i < student.size(); i++) {
            sb.append("st number ").append(i).append(": ").append(student.get(i)).append("\n");

        }
        return sb.toString();
    }

//    @Override
//    public String toString() {
//        String res = name+"\n";
//        for (int i = 0; i < student.size(); i++) {
//            res+="st number "+i+": "+student.get(i)+"\n";
//        }
//        return res;
//    }

}