package lessons.lesson3_inheritance.ex3_override_constructors;

public class Main {
    public static void main(String[] args) {
        //Добавить конструкторы
        ColorRectangle colorRectangle = new ColorRectangle(2, 3, "green");
        System.out.println(colorRectangle);
        System.out.println(colorRectangle.getSquare());

        ColorVolumeRectangle colorVolumeRectangle = new ColorVolumeRectangle(5,7,"red",80);
        System.out.println(colorVolumeRectangle);
        System.out.println(colorVolumeRectangle.getSquare());




    }
}

class Rectangle{
    int a,b;

    public Rectangle() {

    }
    public Rectangle(int a, int b){
        this.a = a;
        this.b =b;
    }


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

    public ColorRectangle() {
        super();
    }
    public ColorRectangle(int a, int b, String color) {
        super(a, b); //вызываем родительский конструктор, super должна быть первой операцией
        this.color = color;
    }



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

    public ColorVolumeRectangle(int a, int b, String color, int c){
        super(a, b, color);
        this.c = c;
    }
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




