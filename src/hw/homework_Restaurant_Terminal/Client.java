package hw.homework_Restaurant_Terminal;

import java.util.Objects;

public class Client {
    private String name;
    private double balance;
    private int number;
    private static int ID;
    private boolean pay;

    public Client(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.number = createNumber();
        this.pay = false;
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

    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
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
