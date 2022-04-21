package hw.homework_synhronization.robots;

public class MyController  extends Thread{
    Robot robot;
    int a;

    public MyController(Robot robot, int a) {
        this.robot = robot;
        this.a = a;
    }

    @Override
    public void run() {
        synchronized (robot) {
                if (a == 1) {
                    robot.goForward(a);
                }
                if (a == 2) {
                    robot.goLeft(a);
                }
                if (a == 3) {
                    robot.goRight(a);
                }
            }
        }
    }

