package hw.homework11_PostOffice;

import java.util.Objects;

public class Address {
    private String town, street;
    private int home, apartment;

    public Address(String town, String street, int home, int apartment) {
        this.town = town;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return home == address.home &&
                apartment == address.apartment &&
                Objects.equals(town, address.town) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(town, street, home, apartment);
    }

    @Override
    public String toString() {
        return "Address{" +
                "town='" + town + '\'' +
                ", street='" + street + '\'' +
                ", home=" + home +
                ", apartment=" + apartment +
                '}';
    }
}
