package lessons.lesson1_list.ex1_rectangle;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Создать класс rectangle с полям a,b, создать констурктор, переопределить equals
        Rectangle rectangle1 = new Rectangle(5,6);
        Rectangle rectangle2 = new Rectangle(5,6);
        System.out.println(rectangle1 == rectangle2); //через 2 знака равно объекты сравниваются по ссылкам
        //поэтому объекты всегда нужно сравнивать по значению их атрибутов (полей класса)
        System.out.println(rectangle1.a == rectangle2.a && rectangle1.b == rectangle2.b);

        //Родительская версия equals (которая в классе Object) сравнивает объекты через == (по ссылке)
        //ПОэтому мы должны переопределить этот метод
        System.out.println("equals: "+rectangle1.equals(rectangle2));
        ArrayList<Rectangle> list= new ArrayList<>();
        list.add(rectangle1);
        list.add(rectangle2);

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a");
        int a = scn.nextByte();
        System.out.println("Enter b");
        int b = scn.nextInt();

        Rectangle search = new Rectangle(a,b);
        //Также методы contains and remove используют equals в своей работе
        if(list.contains(search)) {
            list.remove(search);
        }


        for (int i = 0; i < list.size(); i++) {
            System.out.println("rec = "+list.get(i).a+" "+list.get(i).b);
        }


    }
}


class Rectangle {
    int a,b; //глобальные переменные

    public Rectangle(int a, int b){
        //System.out.println(a); //приоритет отдатеся всегда локальным переменным (перед глобальными), поэтому выведется параметр a, а не поле класса
        this.a = a;
        this.b = b;
        //int x = 0; //локальная переменная

    }

    public boolean equals(Object ob){
        Rectangle rec = (Rectangle)ob;
        return this.a == rec.a && this.b == rec.b;

    }


    public void print(){
        System.out.println(a+" "+b);
    }
}

