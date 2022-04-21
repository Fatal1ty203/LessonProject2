package lessons.lesson38_1_nio2.ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        //почитать про uri
        //чем отличается от url?
        Path path = Paths.get("src/lessons/lesson38_nio2/data.txt");

        //пример на запись:
        //writeExample(path);

        //пример на чтение
        readExample(path);






    }
    public static void readExample(Path path) throws IOException {
        System.out.println("Считаем строки в список");
        List<String> list = Files.readAllLines(path, Charset.forName("UTF8"));
        System.out.println(list);
        System.out.println("Считаем строки в строку");
        String s = Files.readString(path);
        System.out.println(s);
        System.out.println("Считаем с помощью readLine");
        BufferedReader br = Files.newBufferedReader(path);

        while(br.ready()){
            System.out.println(br.readLine());
        }
    }

    public static void writeExample(Path path) throws IOException {
        System.out.println("Запишем в файл список строк");
        List<String> list = List.of("one", "two three", "four");
        Files.write(path, list);
        //Files.write(path, list, StandardCharsets.UTF_8); //Можно указать кодировку считываемого файла
        Files.write(path, list, Charset.forName("UTF8")); //Можно указать кодировку считываемого файла

        System.out.println("Запишем в файл строку");
        Files.writeString(path, "hello world!");

        System.out.println("Классика: записать в файл данные через BufferedWriter");
        BufferedWriter bw = Files.newBufferedWriter(path);
        bw.write("hello");
        bw.newLine();
        bw.write("world");
        bw.close();


        //Опции записи
//        Files.writeString(path, "hello options", StandardOpenOption.APPEND); //append - позволяет дозаписать в файл новые данные
        //Files.writeString(path, "hello options", StandardOpenOption.WRITE); //write - перезаписывает старые данные на новые, ЕСЛИ ФАЙЛ СУЩЕСТВУЕТ
//        Files.writeString(path, "hello options", StandardOpenOption.CREATE); //CREATE - создает файл, если нет или перезаписывает старые данные в существующем файле
        //Files.writeString(path, "hello options", StandardOpenOption.CREATE_NEW); //CREATE_NEW - создает файл, если еще его нет, иначе будет ошибка FIleAlreadyExists или перезаписывает старые данные
//        Files.writeString(path, "hello options", StandardOpenOption.DELETE_ON_CLOSE); //DELETE_ON_CLOSE - удалит файл после использования
        Files.writeString(path, "hello options", StandardOpenOption.WRITE, StandardOpenOption.CREATE); //можно комбинировать
    }
}
