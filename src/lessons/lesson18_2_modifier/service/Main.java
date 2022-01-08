package lessons.lesson18_2_modifier.service;

import lessons.lesson18_2_modifier.fruit.Fruit;

public class Main {
    public static void main(String[] args) {
        Fruit f = new Fruit();
        System.out.println(f.name);
//        System.out.println(f.price); //error, protected modifier
//        System.out.println(f.color); //error, default modifier
//        System.out.println(f.weight); //error, private modifier
    }
}

class Lemon extends Fruit{

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name); //ok, public
        sb.append(price); //ok, protected доступно в наследнике в любом месте
//        sb.append(color); //error, default modifier
//        sb.append(weight); //error, private modifier
        return sb.toString();

    }
}
