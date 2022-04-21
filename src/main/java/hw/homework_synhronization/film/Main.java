package hw.homework_synhronization.film;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Film film1 = new Film("Зеленый слоник", 15);
        Film film2 = new Film("Что то про космос", 20);

        List<Film> filmList = new ArrayList<>();
        filmList.add(film1);
        filmList.add(film2);

        Torrent torrent1 = new Torrent(filmList);
        Torrent torrent2 = new Torrent(filmList);

        torrent1.start();
        torrent2.start();
    }
}
