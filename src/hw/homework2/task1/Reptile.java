package hw.homework2.task1;

import java.util.Comparator;

public class Reptile extends Animal {

    public Reptile(String name, int age, int weight, int speed) {
        this.age = age;
        this.name = name;
        this.weight = weight;
        this.speed = speed;
    }

    @Override
    public String getSay() {
        return "Земноводные не разговариваю, они издают звуки))), " + name;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return super.toString() + ", Класс - Земноводное";
    }

    public static class AgeSort implements Comparator<Reptile>{
        public int compare(Reptile o1, Reptile o2){
            return o1.age - o2.age;
        }
    }

//    public static class PriceSort implements Comparator<Fruit> {
//
//        public int compare(Fruit o1, Fruit o2) {
//            return o1.price - o2.price;
//        }
//    }
}
