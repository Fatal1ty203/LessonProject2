package hw.homework_synhronization.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Runner runner = new Runner("Бегун1",1);
        Runner runner2 = new Runner("Бегун2", 1);
        List<Runner> runners = new ArrayList<>();
        runners.add(runner);
//        runners.add(runner2);

        ObstacleLane obl = new ObstacleLane(runners);
        ObstacleLane obl2 = new ObstacleLane(runners);
        obl.start();
        obl2.start();

        //TODO: заглянуть в класс ObstacleLane



    }
}
