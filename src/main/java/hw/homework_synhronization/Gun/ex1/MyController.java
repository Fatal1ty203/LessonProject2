package hw.homework_synhronization.Gun.ex1;

import java.util.List;

public class MyController implements Runnable {
    List<Gun> guns;

    public MyController(List<Gun> guns) {
        this.guns = guns;
    }

    @Override
    public void run() {
        boolean is = true;

        Gun gun;
        synchronized (guns) {
            gun = guns.remove(0);
        }
        if (gun != null) {
            gun.strikeAllCartrides();
        }
        is = false;


    }
}
