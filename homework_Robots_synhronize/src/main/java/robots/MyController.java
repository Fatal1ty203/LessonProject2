package robots;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

public class MyController  extends Thread{
    Logger logger = LoggerFactory.getLogger(MyController.class);
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
                    logger.info("Робор прошел прямо на " + a + " шагов, поток: " + Thread.currentThread().getName());
                }
                if (a == 2) {
                    robot.goLeft(a);
                    logger.info("Робор прошел влево на " + a + " шагов, поток: " + Thread.currentThread().getName());
                }
                if (a == 3) {
                    robot.goRight(a);
                    logger.info("Робор прошел вправо на " + a + " шагов, поток: " + Thread.currentThread().getName());
                }
            }
        }
    }

