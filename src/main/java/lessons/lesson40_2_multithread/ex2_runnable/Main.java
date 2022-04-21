package lessons.lesson40_2_multithread.ex2_runnable;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Вывести числа  двух разных потоках одновременно (первый поток выводит числа от 1 до 10, второй - от 100 до 110)
        //Сделать с помощью класса Runnable
//        MyRunnable2 myRunnable2 = new MyRunnable2();
//        MyRunnable1 myRunnable1 = new MyRunnable1();
//        Thread th1 = new Thread(myRunnable1);
//        Thread th2 = new Thread(myRunnable2);
//        th1.start();
//        th2.start();


        //или так: через лямбду
        new Thread(()->{
            for (int i = 100; i <= 110; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
}
class MyRunnable1 implements Runnable{
    @Override
    public void run() {
        for (int i = 100; i <= 110; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}



class MyRunnable2 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
