package robots;

import java.util.concurrent.TimeUnit;

public class Robot {
    String name;
    int way;

    public Robot(String name) {
        this.name = name;
    }

    public void goForward(int step){
        System.out.printf("Робот идет вперед на %d шагов\n",step);

        for (int i = 1; i != step+1;){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Робот прошел вперед на %d шаг\n", i++);

        }
        way += step;
    }

    public void goLeft(int step){
        System.out.printf("Робот идет влево на %d шагов \n", step);

        for (int i = 1; i != step+1;){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Робот прошел влево на %d шаг \n", i++);
        }
        way += step;
    }

    public void goRight(int step){
        System.out.printf("Робот идет вправо на %d шагов \n", step);

        for (int i = 1; i != step+1;){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Робот прошел вправо на %d шагов\n", i++);
        }
        way += step;
    }

}
