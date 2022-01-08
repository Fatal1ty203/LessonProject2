package lessons.lesson7_2_static;

public class Main {
    public static void main(String[] args) {

        Rectangle.print();

        Rectangle rectangle = new Rectangle(2, 3, "green");
        Rectangle rectangle2 = new Rectangle(22, 23, "red");

        Rectangle.a = 10;
        Rectangle.b = 20;

        System.out.println("first rectangle");
        System.out.println(rectangle.getSquare());
        rectangle.print();

        System.out.println("second rectangle");
        System.out.println(rectangle2.getSquare());
        rectangle2.print();

        System.out.println(Math.sqrt(9));
        System.out.println(Math.PI);
        System.out.println(Math.E);
        System.out.println(Math.pow(2, 3)); //2 в степень 3

    }
}


class Rectangle {
    static int a, b; //использовать static Для всех полей не получится, так как они становятся общими для всех объектов и теряют уникальность
    String color;

    public Rectangle(int a, int b, String color) {
        this.a = a;
        this.b = b;
        this.color = color;
    }

    public int getSquare() {
        return a * b;
    }

    public static void print() {
        //System.out.println(a + " " + b + " " + color); //в static метдах нельзя использовать объектные поля (не статические) потому для них паять
        //выделяется только внутри созданного объекта
    }
}
