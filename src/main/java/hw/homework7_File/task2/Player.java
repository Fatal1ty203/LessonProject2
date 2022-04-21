package hw.homework7_File.task2;

public class Player {
    String name;
    int points;

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
