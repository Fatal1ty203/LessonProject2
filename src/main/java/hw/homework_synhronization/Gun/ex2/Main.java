package hw.homework_synhronization.Gun.ex2;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        //Более простая версия:
        Gun gun1 = new Gun("gun1", 5);
        Gun gun2 = new Gun("gun2", 3);

        gun1.start();
        gun2.start();



    }
}
class Gun extends Thread{
    String name;
    int cartridgeCount;

    public Gun(String name, int cartridgeCount) {
        this.name = name;
        this.cartridgeCount = cartridgeCount;
    }
    @Override
    public void run() {
        strikeAllCartrides();
    }
    public void makeShot(){
        System.out.println("Сделал выстрел из оружия: " + name + ", осталось " + --cartridgeCount + " патрон");
    }

    public void strikeAllCartrides(){
        while (cartridgeCount!=0){
            makeShot();
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
