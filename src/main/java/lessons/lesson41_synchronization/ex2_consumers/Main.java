package lessons.lesson41_synchronization.ex2_consumers;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        //Создать список чисел - номера пассажиров
        //Создать двух контроллеров, которые будут проверять, что у пассажиров есть билет
        //Считается, что у пассажира нет билета, если это число 5
        //Каждый контроллер при обнаружении безбилетника выводит на консоль его индекс
        List<Integer> passangers = List.of(10, 6, 5, 3, 5, 2, 10, 7, 5, 7, 5);
        AtomicInteger ai = new AtomicInteger();
        MyController myController1 = new MyController("Контроллер 1", passangers, ai);
        MyController myController2 = new MyController("Контроллер 2", passangers, ai);
        myController1.start();
        myController2.start();
    }
}


class MyController extends Thread {
    List<Integer> passangers;
    AtomicInteger ai;
    public MyController(String name, List<Integer> passangers, AtomicInteger ai) {
        super(name);
        this.passangers = passangers;
        this.ai = ai;
    }

    @Override
    public void run() {
        boolean finish = false;
        while(!finish) {
            synchronized (passangers) {
                if(ai.get() < passangers.size()) {
//                    System.out.println(getName() + " внутри");
                    if (passangers.get(ai.get()) == 5) {
                        System.out.println(getName() + " нашел безбилетника под индексом " + ai.get());
                    }
                }else {
                    finish = true;
                }
                ai.incrementAndGet();


                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
//            System.out.println(getName()+" за пределами");
        }

    }
}