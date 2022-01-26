package lessons.lesson32_io_stream.byte_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main2_copy_picture {
    public static void main(String[] args) {
        //Скопируем картинку structure.jpg
        String sourcePath = "src/lessons/lesson32_io_stream/structure.jpg";
        String destPath = "src/lessons/lesson32_io_stream/structure_copy.jpg";
        try(FileInputStream fis = new FileInputStream(sourcePath);
            FileOutputStream fos = new FileOutputStream(destPath)){
            int len = fis.available(); //вовзращает кол-во доступных для чтения байт
            for (int i = 0; i < len; i++) {
                int code = fis.read();
                fos.write(code);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
