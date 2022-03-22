package hw.homework_synhronization.runner;

public class Runner {
    String name;
    int speed;
    int distance;

    public Runner(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public void run(){
        distance = distance + speed;
    }

}
