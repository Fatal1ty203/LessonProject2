package lessons.lesson7_3_abstract_Class.ex1_basic_figure;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Создать абстрактный класс Shape с абстрактными методами getLegth и getWidth и getSquare

        //У абстрактных классов нельзя создавать объекты, так как они содержат абстрактные методы без реализации
        //Figura f = new Figura();


        ArrayList<Figura> list = new ArrayList<>();
        list.add(new Circle("circle", 2));
        list.add(new Rectangle("rectangle", 2,3));
        list.add(new Rectangle("rectangle2", 3,4));
        list.add(new Triangle("triangle", 2,3,5));
        for(Figura f : list){
            f.print();

        }



    }
}

abstract class Figura{
    String figureName;

    public Figura(String figureName) {
        this.figureName = figureName;
    }

    public abstract int getLength();

    public abstract int getWidth();

    public abstract int getSquare();

    public void print(){
        System.out.println(figureName+" "+ getWidth()+" "+getLength()+" "+getSquare());
    }
}

class Circle extends Figura {
    int r;

    public Circle(String figureName, int r) {
        super(figureName);
        this.r = r;
    }


    public int getLength(){
        return r*2;
    }
    public int getWidth(){
        return r*2;
    }

    @Override
    public int getSquare() {
        return r*r;
    }


}

class Triangle extends Figura {
    int a,b,c;

    public Triangle(String figuraName, int a, int b, int c) {
        super(figuraName);
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
        return c;
    }

    @Override
    public int getSquare() {
        return a*b*c;
    }
}


class Rectangle extends Figura {
    int a,b;

    public Rectangle(String figuraName, int a, int b) {
        super(figuraName);
        this.a = a;
        this.b = b;
    }

    public int getLength(){
        return a;
    }
    public int getWidth(){
        return b;
    }

    @Override
    public int getSquare() {
        return a*b;
    }
}
