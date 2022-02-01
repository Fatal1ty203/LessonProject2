package hw.homework_Restaurant_Terminal;

public class Client {
    private String name;
    private int number;
    private double balance;
    private static int ID;

    public Client(String name, int number, double balance) {
        this.name = name;
        this.number = createNumber();
        this.balance = balance;
    }

    private static int createNumber(){
        return ++ID;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
