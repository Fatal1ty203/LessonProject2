package hw.homework_synhronization.Lift;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<People> peopleList = new ArrayList<>();

        peopleList.add(new People("p1",5,true));
        peopleList.add(new People("p2",11,true));
        peopleList.add(new People("p3",7,false));
        peopleList.add(new People("p4",4,true));
        peopleList.add(new People("p5",10,true));
        peopleList.add(new People("p6",1,true));
        peopleList.add(new People("p7",8,false));
        peopleList.add(new People("p8",9,true));
        peopleList.add(new People("p9",1,true));
        peopleList.add(new People("p10",2,false));

        Lift lift1 = new Lift(1,13,peopleList);
        Lift lift2 = new Lift(2,13,peopleList);
        lift1.start();
        lift2.start();

        lift1.join();
        lift2.join();
        peopleList.stream()
                .filter(val -> !val.button)
                .forEach(pepl -> System.out.printf("%s забыл нажать кнопку\n", pepl.name));

        peopleList.stream()
                .filter(pipl -> pipl.floor == 1)
                .forEach(pipl -> System.out.printf("%s уже был на первом этаже\n", pipl.name));
    }
}

class People {
    String name;
    int floor;
    boolean button;

    public People(String name, int floor, boolean button) {
        this.name = name;
        this.floor = floor;
        this.button = button;
    }

}

class Lift extends Thread{
    int number;
    int floor;
    List<People> peopleList;

    public Lift(int number, int floor, List<People> peopleList) {
        this.number = number;
        this.floor = floor;
        this.peopleList = peopleList;
    }

    @Override
    public void run() {
        boolean finish = false;

        while (!finish){
            System.out.println("Лифт на этаже " + floor);
            for (int i = 0; i < peopleList.size(); i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                People people = null;
                synchronized (peopleList) {
                    if (peopleList.get(i).button && peopleList.get(i).floor != 1) {
                        people = peopleList.remove(i);
                    }else {
                        finish = true;
                    }
                }

                if (people!=null && people.floor != 1){
                    System.out.printf("Лифт №%d отвез на первый этаж пасажира %s\n", number, people.name);

                }
            }
        }
    }
}