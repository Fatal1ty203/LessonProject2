package lessons.lesson15_files.ex1_wirter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main_PrintWriter {
    public static void main(String[] args) {
        //Записать в файл строки:
        //one two
        //three
        //five six

        //\ - экранирующий символ, делает из синтаксического символа обычный текстовый
        //Вывести цитату в кавычках
        //System.out.println("Цитата: \"some citata\"");
        //Вывести на консоль сам экранирующий символ (для этого нужно его самого заэкранировать)
        //System.out.println("\\hello");
        //backward slash \
        //forward slash /
//
        String absoluteFilePath  = "C:\\Users\\DELL\\OneDrive\\Рабочий стол\\hz-main\\LessonProject\\src\\lessons.lesson15_files\\data.txt";
        //String filePath  = "C:/Users/data.txt";
        try {
            PrintWriter pw = new PrintWriter(absoluteFilePath);
            pw.println("one two");
            pw.println("three");
            pw.println("five six");
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }


}
