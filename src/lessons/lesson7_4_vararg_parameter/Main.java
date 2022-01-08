package lessons.lesson7_4_vararg_parameter;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Var arg параметр позволяет передать переменной значение параметров вместо такого способа:
//        Basktet basktet = new Basktet(new Fruit[]{new Fruit("apple")});
//        Basktet basktet1 = new Basktet(new Fruit[]{new Fruit("apple"), new Fruit("orange")});


        //таким способом:
        Basktet basktet = new Basktet(new Fruit("apple"));
        Basktet basktet1 = new Basktet(new Fruit("apple"), new Fruit("orange"));
        Basktet basktet3 = new Basktet(new Fruit("apple"), new Fruit("orange"), new Fruit("cherry"));


        basktet.print();;
        System.out.println();
        basktet1.print();;
        System.out.println();
        basktet3.print();;

    }
}

class Fruit{
    String name;

    public Fruit(String name) {
        this.name = name;
    }
}
class Basktet{
    ArrayList<Fruit> list = new ArrayList<>();
    //arr - var arg параметр, параметр переменной длины
    public Basktet(Fruit... arr){
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
    }

    public void print(){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).name);
        }
    }
}
