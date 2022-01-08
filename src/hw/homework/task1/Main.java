package hw.homework.task1;

public class Main {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle();
        rectangle.a = 5;
        rectangle.b = 6;
        rectangle.print();

        ColorRectangle colorRectangle = new ColorRectangle(5,7, "red");
        colorRectangle.print();


        RectangleC rectangleC = new RectangleC();
        rectangleC.a = 6;
        rectangleC.b = 8;
        rectangleC.color = "blue";
        rectangleC.c = 14;
        rectangleC.print();
    }
}
