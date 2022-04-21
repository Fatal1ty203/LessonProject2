package hw.homework.task1;

public class Rectangle {


    int a,b;

    public Rectangle() {
    }

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public void print(){
        System.out.println(toString());
    }
}


class ColorRectangle extends Rectangle{
    String color;

    public ColorRectangle() {
        super();
    }

    public ColorRectangle(int a,int b, String color){
        super(a,b);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + ", цвет: " + color;
    }

    public void print(){
        System.out.println(toString());
    }

}

class RectangleC extends ColorRectangle{
    int c;

    public RectangleC(){
        super();
    }

    public RectangleC(int a,int b, String color, int c){
        super(a, b, color);
        this.c = c;
    }

    public String toString(){
        return super.toString() + ", c = " + c;
    }

    public void print(){
        System.out.println(toString());
    }
}

