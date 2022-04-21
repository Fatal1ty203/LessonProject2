package hw.homework_relectionRestaurant;

import java.util.Objects;

public class Client {
    private int clientNumber = 0;
    private String name;
    private int fullCost = 0;
    boolean paid = false;

    public Client( String name) {
        this.clientNumber = generateClientNumber();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Клиент: {" +
                "Номер клиента-" + clientNumber +
                ", имя-'" + name + '\'' +
                '}';
    }

    private int generateClientNumber(){
        clientNumber++;
        return clientNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name);
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setFullCost(int fullCost) {
        this.fullCost = fullCost;
    }

    public int getFullCost() {
        return fullCost;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
