package robots;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

import java.util.concurrent.TimeUnit;

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
                    for (int i = 0; i < 3; i++) {
                        robot.goForward(3);
                        try {
                            TimeUnit.MILLISECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


//                    logger.info("Робор прошел прямо на " + a + " шагов, поток: " + Thread.currentThread().getName());
                }
                if (a == 2) {
//                    robot.goLeft(a);
//                    logger.info("Робор прошел влево на " + a + " шагов, поток: " + Thread.currentThread().getName());
                    for (int i = 0; i < 3; i++) {
                        robot.goLeft(3);
                        try {
                            TimeUnit.MILLISECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (a == 3) {
//                    robot.goRight(a);
//                    logger.info("Робор прошел вправо на " + a + " шагов, поток: " + Thread.currentThread().getName());
                    for (int i = 0; i < 3; i++) {
                        robot.goRight(3);
                        try {
                            TimeUnit.MILLISECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

