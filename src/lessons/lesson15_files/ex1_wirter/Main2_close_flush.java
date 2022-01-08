package lessons.lesson15_files.ex1_wirter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main2_close_flush {
    public static void main(String[] args) {
        //МЕТОДЫ CLOSE, FLUSH
        // Записать данные в файл в два этапа:
        //сначала с 0 до 3000
        //потом выдвить их в файл и продолжить запись с 3000 до 6000 и закрыть поток
        String absoluteFilePath = "C:\\Users\\DELL\\OneDrive\\Рабочий стол\\hz-main\\LessonProject\\src\\lessons.lesson15_files\\data.txt";
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(absoluteFilePath);
            for (int i = 0; i < 3000; i++) {
                pw.println(i);
            }
            pw.flush(); //выдвливает данные из памяти PrintWriter в файл, но не завершает поток (stream)
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {

            for (int i = 3000; i < 6000; i++) {
                pw.println(i);
            }
            //close выдвливает данные из памяти PrintWriter в файл и завершает поток (stream),
            // после этого объектом pw воспользовать не получится, только создать новый
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
