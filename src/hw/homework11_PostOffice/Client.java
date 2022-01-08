package hw.homework11_PostOffice;

import java.util.Objects;

public class Client {
    private String name;
    private Address address;

    public Client(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) &&
                Objects.equals(address, client.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                '}';
    }
}
