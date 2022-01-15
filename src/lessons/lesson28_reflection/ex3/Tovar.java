package lessons.lesson28_reflection.ex3;

public class Tovar{
    private String name;
    private int price;


    public Tovar() {
    }

    public Tovar(String name, int price) {
        this(name);
        this.price = price;
    }

    private Tovar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String
    toString() {
        return "Tovar{" +
                "name='" + name + '\'' +
                ", age=" + price +
                '}';
    }
}