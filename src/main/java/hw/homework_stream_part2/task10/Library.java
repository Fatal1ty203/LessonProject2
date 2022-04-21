package hw.homework_stream_part2.task10;

import java.util.List;

public class Library {
    private List<Book> list;

    public Library(List<Book> list) {
        this.list = list;
    }

    public List<Book> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Library{" +
                "list=" + list +
                '}';
    }
}
