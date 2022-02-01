package hw.homework_serialization.task2;

import java.io.Serializable;

public class Player implements Serializable {
    String name;
    int points;
    static final double serialVersionUID = 1l;

    public Player(String name, int points) {
        this.name = name;
        this.points = points;
    }

    @Override
    public String toString() {
        return "Игрок: " +
                "Имя: '" + name + '\'' +
                ", очки: " + points + "\n";
    }
}
