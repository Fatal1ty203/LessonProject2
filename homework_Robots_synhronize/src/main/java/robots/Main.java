package robots;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Robot robot = new Robot("Robot1");

        MyController myController = new MyController(robot,1);
        MyController myController2 = new MyController(robot,2);
        MyController myController3 = new MyController(robot,3);
        myController.start();
        myController2.start();
        myController3.start();

        myController.join();
        myController2.join();
        myController3.join();

        System.out.printf("Робот прошел %d шагов", robot.way);
    }
}
