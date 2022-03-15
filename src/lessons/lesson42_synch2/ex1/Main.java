package lessons.lesson42_synch2.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        //Предположим, у нас есть груда кирпичей, из которых нужно построить дом.
        //Дом будут строить два строителя, которых мы можем представить в виде порожденных потоков.
        //Порожденные потоки нужно синхронизировать, чтобы не получилось такой ситуации, что два строителя кладут один и тот же кирпич два раза.
        //Каждый кирпич должен быть уложен (перемещен из кучи кирпичей в стену дома) только один раз.
        //Причем, в груде кирпичей могут попадаться и бракованные, их в стену дома закладывать не нужно.
        List<Brick> brickList = new ArrayList<>();
        List<Brick> houseList = new ArrayList<>();
        Random rnd = new Random();


        for (int i = 0; i < 20; i++) {
            int randomValue = rnd.nextInt(3);
            Brick brick;
            if (randomValue == 0) {
                brick = new Brick(false);
            } else {
                brick = new Brick(true);
            }
            brickList.add(brick);
        }

        Builder builder1 = new Builder(brickList, houseList);
        Builder builder2 = new Builder(brickList, houseList);

        Thread th1 = new Thread(builder1);
        Thread th2 = new Thread(builder2);
        th1.start();
        th2.start();


    }


}

class Builder implements Runnable{
    List<Brick> brickList;
    List<Brick> houseList;

    public Builder(List<Brick> brickList, List<Brick> houseList) {
        this.brickList = brickList;
        this.houseList = houseList;
    }

    @Override
    public void run() {
        boolean finish = false;
        while (!finish) {
            synchronized (brickList) {

                if (brickList.size() > 0) {
                    Brick b = brickList.remove(0); //0
                    if (b.isOk) {
                        houseList.add(b);
                        System.out.println(Thread.currentThread().getName()+" взял кирпич с id = "+b.id);
                    }else{
                        System.out.println(Thread.currentThread().getName()+" выкинул браковынй кирпич с id = "+b.id);
                    }
                } else {
                    finish = true;
                }
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}

class Brick {
    int id;
    boolean isOk; //бракованный или нет
    static int currentId = 0;

    public Brick(boolean isOk) {
        this.isOk = isOk;
        id = currentId++;
    }

    @Override
    public String toString() {
        return "Brick{" +
                "id=" + id +
                ", isOk=" + isOk +
                '}';
    }
}
