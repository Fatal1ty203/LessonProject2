package lessons.lesson15_files.ex1_wirter;

import java.io.FileWriter;

public class Main_FileWriter {
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
            FileWriter fw = new FileWriter(absoluteFilePath);
            fw.write("one two\n");
            fw.write("three\n");
            fw.write("five six");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }


}
