package hw.homework_stream_part2.task10;

public class Book {
    private String name;
    private String authorName;
    private int price;

    public Book(String name, String authorName, int price) {
        this.name = name;
        this.authorName = authorName;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", authorName='" + authorName + '\'' +
                ", price=" + price +
                '}';
    }
}
