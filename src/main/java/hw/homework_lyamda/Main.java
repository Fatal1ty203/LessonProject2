package hw.homework_lyamda;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Rabbit1", 1700);
        Book book2 = new Book("Rabbit2", 1200);
        Book book3 = new Book("Rabbit3", 1200);
        Book book4 = new Book("Rabbit1", 1500);

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        Ibook ibook = (val,val1) -> {
            return val.getNameAuthor().equals(val1);
        };

        Ibook ibook1 = (val,val1) -> {
            return val.getPrice() == Integer.parseInt(val1);
        };

        Ibook ibook2 = (val, val1) -> {
            return val.getPrice() < Integer.parseInt(val1);
        };

        System.out.println(library.searchBook(ibook,"Rabbit1"));
        System.out.println(library.searchBook(ibook1, "1200"));
        System.out.println(library.searchBook(ibook2, "1600"));

    }
}
