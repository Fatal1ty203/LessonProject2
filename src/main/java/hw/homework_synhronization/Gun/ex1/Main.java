package hw.homework_synhronization.Gun.ex1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Gun gun = new Gun("Пушка", 10);
        Gun gun1 = new Gun("GUN", 10);
        List<Gun> guns = new ArrayList<>();
        guns.add(gun);
        guns.add(gun1);
        MyController myController = new MyController(guns);
        MyController myController1 = new MyController(guns);
        Thread thread = new Thread(myController);
        Thread thread1 = new Thread(myController1);
       thread.start();
       thread1.start();


    }
}
