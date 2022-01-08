package lessons.lesson4_inheritance_training;

public class Main {
    public static void main(String[] args) {
        //Есть разные фигуры: прямоугольник, треугольник, круг, нужно определитЬ, пройдет ли какая-либо фигуры через прямоугольное отверстие
//        double d = 2;
//        int a = (int)d; //принудительная конвератция из double в int
//        System.out.println(a);//2

        //ПРимер: приоритет конвертации
//        double d = 2.5;
//        int a = (int)(d*2); //d*2 надо взять в скобки, чтобы конвертация к int происходила после умножения, а не до умножения
//        System.out.println(a);//2
        Otversie otv = new Otversie(4,5);
        Circle circle = new Circle(2);
        Rectangle rec = new Rectangle(2,3);
        Triangle tr = new Triangle(2,3,4);

        if (otv.length >= circle.getLength() && otv.width >= circle.getWidth()){
            System.out.println("+");
        }else {
            System.out.println("-");
        }

        if (otv.length >= rec.getLength() && otv.width >= rec.getWidth()){
            System.out.println("+");
        }else {
            System.out.println("-");
        }

        if (otv.length >= tr.getLength() && otv.width >= tr.getWidth()){
            System.out.println("+");
        }else {
            System.out.println("-");
        }

        //Вариант 2, через метод с параметром в типе Figura (в типе родительского класса)
        //Любой объект-наслденик можно записать в переменную родительского типа
        //Пример:
//        Figura f = rec;
//        f = tr;
//        f = circle;
        if(otv.isPass(circle)){
            System.out.println("+");
        }else{
            System.out.println("-");
        }
        if(otv.isPass(rec)){
            System.out.println("+");
        }else{
            System.out.println("-");
        }
        if(otv.isPass(tr)){
            System.out.println("+");
        }else{
            System.out.println("-");
        }








    }
}

class Otversie{
    int length;
    int width;

    public Otversie(int length, int width) {
        this.length = length;
        this.width = width;
    }

    //проходит ли фигура figura через отверсите или нет
    public boolean isPass(Figura figura){
        return length >= figura.getLength() && width >= figura.getWidth();
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

class Circle extends Figura{
    int r;

    public Circle(int r) {
        this.r = r;
    }
    public int getLength(){
        return r*2;
    }
    public int getWidth(){
        return r*2;
    }

}

class Triangle extends Figura{
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
        return c;
    }
}


class Rectangle extends Figura{
    int a,b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getLength(){
        return a;
    }
    public int getWidth(){
        return b;
    }
}

