package lessons.lesson9_interfaces;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Figura circle = new Circle("circle", 2);
//        IFigure iFigure = (IFigure)circle;
//        IFigureColor iFigureColor = (IFigureColor)iFigure;

        List<IFigure> list = new ArrayList<>();

        list.add(new Circle("circle", 2));
        list.add(new Triangle("triangle", 2,3,5));
        for(IFigure f : list){
            Figura figura = (Figura)f;
            System.out.println(figura.figureName);
            System.out.println(f.getSquare());
            if(f instanceof IFigureColor){
                IFigureColor figureColor = (IFigureColor) f;
                //System.out.println(figureColor.getColor());
                figureColor.printColor();
            }

        }
        //System.out.println(Circle.color); //так можно вызывать константу из интерфейса

    }
}
interface IFigureColor{
    //поля можно создавать только если они будут константы и static (общие)
    public final static String color="GREEN";
    String getColor();

    //интерфейсы могут также содержать деволтные методы
    public default void printColor(){
        System.out.println(getColor());
    }
}

interface IFigure{
    int getLength();
    int getWidth();
    int getSquare();
}

class Figura{
    String figureName;
    public Figura(String figureName) {
        this.figureName = figureName;
    }
}

class Circle extends Figura implements IFigure, IFigureColor{
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


    @Override
    public String getColor() {
        return "green";
    }
}

class Triangle extends Figura implements IFigure{
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

