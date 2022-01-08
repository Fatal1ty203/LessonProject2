package lessons.lesson16_files2_save_load_data.ex1_how_to_save_load;

public class Tovar {
    String name;
    int price;

    public Tovar(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tovar{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
