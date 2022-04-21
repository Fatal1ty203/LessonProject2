package lessons.lesson38_1_nio2.ex2;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Сделать копию файла data.txt
        Path path = Paths.get("src/lessons/lesson38_nio2/data.txt");
        Path pathDest = Paths.get("src/lessons/lesson38_nio2/ex2/data_copy.txt");

        //Удалим, если существует:
        Files.deleteIfExists(pathDest);
        //или так:
//        if(Files.exists(pathDest)){
//            Files.delete(pathDest);
//        }

        //Files.copy(path, pathDest);
        //Сделать копию через InputStream
        //Считаем оригинальный файл через InputStream
        Files.deleteIfExists(pathDest);
        FileInputStream fis = new FileInputStream(path.toString());
        Files.copy(fis, pathDest);
        fis.close();



        //ПЕРЕМЕЩЕНИЕ
        Files.deleteIfExists(pathDest);
        Files.move(path, pathDest);

    }
}
