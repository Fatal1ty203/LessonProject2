package hw.homework_lyamda;

public class Book {
    private String nameAuthor;
    private int price;

    public Book(String nameAuthor, int price) {
        this.nameAuthor = nameAuthor;
        this.price = price;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "nameAuthor='" + nameAuthor + '\'' +
                ", price=" + price +
                '}';
    }
}
