package lessons.lesson43_thread_training.ex2_lift;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Есть многоквартирный дом
        //Есть в нем 2 лифта
        //Надо всех жителей дома перевезти на первый этаж


        List<People> peoples = new ArrayList<>();
        peoples.add(new People("p1", 10));
        peoples.add(new People("p2", 5));
        peoples.add(new People("p6", 1));
        peoples.add(new People("p3", 4));
        peoples.add(new People("p4", 12));
        peoples.add(new People("p5", 8));

        peoples.add(new People("p7", 1));
        peoples.add(new People("p8", 1));

        Lift lift1 = new Lift(1, peoples);
        Lift lift2 = new Lift(2, peoples);
        lift1.start();
        lift2.start();



    }
}
class Lift extends Thread{
    int number; //номер лифта
    List<People> peoples;

    public Lift(int number, List<People> peoples) {
        this.number = number;
        this.peoples = peoples;
    }

    @Override
    public void run() {
        boolean finish = false;
        while (!finish){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            People people=null;
            synchronized (peoples) {
                if(peoples.size()!=0) {
                    people = peoples.remove(0);
                }else{
                    finish = true;
                }
            }
            if (people!=null && people.floor != 1){
                System.out.printf("Лифт №%d отвез на первый этаж пасажира %s\n", number, people.name);
            }

        }
    }
}


class People{
    String name;
    int floor;

    public People(String name, int floor) {
        this.name = name;
        this.floor = floor;
    }
}





