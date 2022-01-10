package lessons.lesson28_reflection.ex1;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Создать класс Fruit с private полями name, price и вывести на консоль с помощью reflection названия всех полей
//        Class clazz = Fruit.class;
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields(); //возвращает массив полей из класса
        Arrays.stream(declaredFields).forEach(field-> System.out.println(field.getName()+" "+field.getType().getName()));

    }
}


class Person{
    String name;
    String surname;
    String fatherName;
}


class Fruit{

    private String name;
    private int price;
}

