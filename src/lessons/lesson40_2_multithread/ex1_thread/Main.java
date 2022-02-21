package lessons.lesson40_2_multithread.ex1_thread;

public class Main {
    public static void main(String[] args) {
        //Вывести числа  двух разных потоках одновременно (первый поток выводит числа от 1 до 10, второй - от 100 до 110)
        //Сделать с помощью класса Thread
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        myThread1.start(); //запускаем метод run в параллельном режиме
        myThread2.start();
    }
}
class MyThread2 extends Thread{
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



class MyThread1 extends Thread{
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
