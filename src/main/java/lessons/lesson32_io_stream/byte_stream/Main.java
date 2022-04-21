package lessons.lesson32_io_stream.byte_stream;

import java.io.File;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) {

        //В кондировке windows1251 (кириллицей / cp1251) ровно 255 символов, что означает, что любой символ занимает 1 байт
        //Создали файл data2.txt с содержимым пh в кодировке cp1251 и попробуем его считать, вывелось ?h (2 символа)
        //Потом измениил кодировку файла на UTF8, и выволесь ??h (3 символа), потому что в UTF8 русские символы занимают 2 байта

        try(FileInputStream fis = new FileInputStream("src/lessons/lesson32_io_stream/byte_stream/data2.txt")){
            int code = 0;
            while((code=fis.read())!=-1){
                char ch = (char)code;
                System.out.println(code+" "+ch);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
