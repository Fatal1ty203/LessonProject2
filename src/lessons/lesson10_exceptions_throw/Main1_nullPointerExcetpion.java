package lessons.lesson10_exceptions_throw;

public class Main1_nullPointerExcetpion {
    public static void main(String[] args) {
        //NPE (Null pointer exceptin) Возникает когда мы обращаемся к полю или методу у null объекта (у несуществующего объекта)
//        Fruit fruit=null;
//        //System.out.println(fruit.name);
//        fruit.print();


        //Пример null со String
        String str = null; //строки это тоже объекты, следвоательно для них null это тоже дефолтное значение
        System.out.println(str.equals("one"));

    }
}

class Fruit{
    String name;


    public void print()
    {
        System.out.println("hello");
    }
}
