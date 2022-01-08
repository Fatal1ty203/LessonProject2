package lessons.lesson5_polymorfizm_training;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Нужно найти сумму пермиетров прямоугольников и наследников прямоугольника
        //Нужно найти сумму периметров только прямоугольников
        ArrayList<Figura> list = new ArrayList<>();
        list.add(new Circle(2));
        list.add(new Rectangle(2,3));
        list.add(new Rectangle(3,4));
        list.add(new Square(10));
        list.add(new Triangle(2,3,5));
        int sumAll = 0;
        int sumRecs = 0;
        //# Пример ПОЛИМОРФИЗМА
//        for(Figura f : list) {
//            System.out.println(f.getWidth());
//        }

        for(Figura f : list){
            printWidth(f);
        }
        //# Пример ПОЛИМОРФИЗМА
        for(Figura f : list){
            System.out.println(f);
            if(f instanceof Rectangle){
                sumAll+=f.getLength()+f.getWidth();
            }
            if(f.getClass() == Rectangle.class){
                sumRecs+=f.getLength()+f.getWidth();
            }

            System.out.println(f.toString());
        }
        System.out.println("sum of rectangles and squares perimeter = "+sumAll);
        System.out.println("sum of rectangles only perimeter = "+sumRecs);
    }

    public static void printWidth(Figura f){
        System.out.println(f.getWidth());
    }
}

class Figura{

    public int getLength() {
        return 0;
    }

    public int getWidth(){
        return 0;
    }
}

class Circle extends Figura {
    int r;


    public Circle(int r) {
        this.r = r;
    }
    public int getLength(){
        return r*2;
    }
    public int getWidth(){
        System.out.println("circle get width");
        return r*2;
    }

}

class Triangle extends Figura {
    int a,b,c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int getLength() {
        return (int)(0.5*a*c);

    }

    @Override
    public int getWidth() {
        System.out.println("Triangle get width");
        return c;
    }
}


class Rectangle extends Figura {
    int a,b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getLength(){
        return a;
    }
    public int getWidth(){
        System.out.println("Rectangle get width");
        return b;
    }
}


class Square extends Rectangle{

    public Square(int a) {
        super(a, a);
    }
}