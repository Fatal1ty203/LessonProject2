package lessons.lesson43_thread_training.ex1_car;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       //Гонка машинок.
        //Каждая машинка имеет свою скорость передвижения, которая выражается в методе sleep
        //Чем больше слип, тем меньше скорость
        //Побеждает та машинка, которая прошла расстояние 5 м

        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        Car car1 = new Car("car1", 2, list);
        Car car2 = new Car("car2", 1, list);
        Car car3 = new Car("car3", 1, list);
        Car car4 = new Car("car4", 1, list);
        Car car5 = new Car("car5", 1, list);
        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();

        car1.join();
        car2.join();
        Stream.iterate(0, i->i+1)
                .limit(list.size())
                .forEach(i-> System.out.printf("%d. %s\n", i+1, list.get(i)));




    }
}
class Car extends Thread{
    String name;
    int distance; //пройденное расстояние
    int speed;
    List<String> winners;

    public Car(String name, int speed, List<String> winners) {
        this.name = name;
        this.speed = speed;
        this.winners = winners;
    }

    @Override
    public void run() {
        while (distance!=5){
            distance++;
            System.out.printf("%s прошла дистанцию %d\n", name, distance);
            try {
                TimeUnit.SECONDS.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%s доехала до финиша\n", name);
        winners.add(name);

    }
}