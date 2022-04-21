package hw.homework_synhronization.Gun.ex1;

import java.util.concurrent.TimeUnit;

public class Gun {
    String name;
    int cartridgeCount;

    public Gun(String name, int cartridgeCount) {
        this.name = name;
        this.cartridgeCount = cartridgeCount;
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
