package hw.homework_stream.tast6;

public class Book {
    private String name;
    private int price;
    private int countPay;

    public Book(String name, int price, int countPay) {
        this.name = name;
        this.price = price;
        this.countPay = countPay;
    }

    public boolean isBestSeller(){
        return countPay >= 1000;
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

    public int getCountPay() {
        return countPay;
    }

    public void setCountPay(int countPay) {
        this.countPay = countPay;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", countPay=" + countPay +
                '}';
    }
}
