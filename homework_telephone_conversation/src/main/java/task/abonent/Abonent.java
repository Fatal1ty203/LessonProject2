package task.abonent;

public class Abonent {
    private String name;
    private int number;

    private Abonent(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public static Abonent createAbonent(String name, int number){
        return new Abonent(name,number);
    }

    @Override
    public String toString() {
        return "Abonent{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
