package hw.homework_synhronization.film;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Torrent extends Thread {
    List<Film> filmList;

    public Torrent(List<Film> filmList) {
        this.filmList = filmList;
    }

    private String addSymbol(int a){
        String c = "";
        for (int i = 0; i < a; i++){
            c +="#";
        }
        return c;
    }

    @Override
    public void run() {
        Film film = null;
        synchronized (filmList) {
            if (filmList.size() != 0) {
                film = filmList.remove(0);
            }
        }
        if (film != null) {
            double d = 0;
            for (int i = 0; i <= film.size; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                d = 100 - i / film.size * 100;
                System.out.printf("фильм %s: %s осталось %d%% \n", film.name, addSymbol(i), (int) d);
            }
        }
    }
}

