package lessons.lesson3_inheritance.ex2_equals_torString;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        Реализуем equals и toString.
//        ColorRectangle colorRectangle = new ColorRectangle();
//        colorRectangle.a = 2;
//        colorRectangle.b = 3;
//        colorRectangle.color = "green";
//        System.out.println(colorRectangle);
//
//        System.out.println(colorRectangle.getSquare());
//
//        ColorVolumeRectangle colorVolumeRectangle = new ColorVolumeRectangle();
//        colorVolumeRectangle.a = 5;
//        colorVolumeRectangle.b = 7;
//        colorVolumeRectangle.color = "red";
//        colorVolumeRectangle.c = 80;
//        System.out.println(colorVolumeRectangle);
//        System.out.println(colorVolumeRectangle.getSquare());

        String s = "Привет";
        String s2 = "hello";

        ///п р и в е т h e l l o

        List<String> list = List.of(s, s2);


//        List<String> result = dosome(list);
//        System.out.println(result);


    }


}

class Rectangle{
    int a,b;

    public int getSquare(){
        return a*b;
    }

    @Override
    public String toString() {
        return "a = "+a+", b = "+b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return a == rectangle.a &&
                b == rectangle.b;
    }


}

class ColorRectangle extends Rectangle{
    String color;

    @Override
    public String toString() {
        return super.toString()+", color = "+color;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColorRectangle colorRec = (ColorRectangle) o;
        return super.equals(colorRec) && color.equals(colorRec.color);
    }


}

class ColorVolumeRectangle extends ColorRectangle{
    int c;
    @Override
    public String toString() {
        return super.toString()+", c = "+c;
    }

    //a*b*4 + a*c*2
    public int getSquare(){
        return super.getSquare() * 4 + a*c*2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColorVolumeRectangle colorVolRect = (ColorVolumeRectangle) o;
        return super.equals(colorVolRect) && c == colorVolRect.c;
    }


}




