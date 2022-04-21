package lessons.lesson33_serialization;

import java.beans.Transient;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        //Есть класс библиотека, в котором хранятся книги в списке
        //Надо сохранить список библиотек в файл
//        Library library = new Library("lib1");
//        library.books.add(new Book("book1", "autrho1"));
//        library.books.add(new Book("book2", "autrho1"));
//        library.books.add(new Book("book3", "autrho2"));
//
//        Library library2 = new Library("lib2");
//        library2.books.add(new Book("book10", "autrho10"));
//        library2.books.add(new Book("book20", "autrho10"));
//        library2.books.add(new Book("book30", "autrho20"));
//
//        List<Library> libraries = List.of(library, library2);
//        try(ObjectOutputStream oos = new ObjectOutputStream(
//                new FileOutputStream("src/lessons/lesson33_serialization/test.txt"))){
//            oos.writeObject(libraries);
//        }catch (Exception e){
//            e.printStackTrace();
//        }





        //считаем список библиотек
        List<Library> libraries=null;
        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("src/lessons/lesson33_serialization/test.txt"))){
            libraries = (List<Library>) ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(libraries!=null) {
            for (Library lib : libraries) {
                System.out.println(lib);
            }
        }


    }
}

class Library implements Serializable {
    List<Book> books = new ArrayList<>();
    static final long serialVersionUID = 1l; //номер версии класса. Нужен, чтобы можно было вносить изменения в класс после сериализации

    public Library(String name) {
        this.name = name;
    }

    public transient String name; //transient говорит, что данное поле не будет сериализовано/десериализовано

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", name='" + name + '\'' +
                '}';
    }
}
class Book implements Serializable{
    String name;
    String author;
    static final long serialVersionUID = 1l;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}