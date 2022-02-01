package hw.homework_Restaurant_Terminal;

import java.util.Objects;

public class Client {
    private String name;
    private double balance;
    private int number;
    private static int ID;

    public Client(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.number = createNumber();
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    private static int createNumber(){
        return ++ID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return number == client.number && name.equalsIgnoreCase(client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance, number);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
