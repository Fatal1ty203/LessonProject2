package lessons.lesson15_files.ex2_reader;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main1_BufferedReader {
    public static void main(String[] args) {
        //Считать данные из файла
        String absoluteFilePath  = "C:\\Users\\DELL\\OneDrive\\Рабочий стол\\hz-main\\LessonProject\\src\\lessons.lesson15_files\\data.txt";

        //через цикл  while
        try {
            BufferedReader br = new BufferedReader(new FileReader(absoluteFilePath));
            String line = null;
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //через цикл do while
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(absoluteFilePath));
//            String line = null;
//            do{
//                line = br.readLine();
//                if(line!=null) {
//                    System.out.println(line);
//                }
//            }while(line!=null);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
