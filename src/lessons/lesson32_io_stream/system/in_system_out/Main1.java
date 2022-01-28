package lessons.lesson32_io_stream.system.in_system_out;

import java.io.IOException;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) throws IOException {
        //System.out и System.in На самом деле объекты байтовых потоков
//        System.out.println("Enter a symbol");
//        int read = System.in.read();
//        System.out.println("you entered: "+(char)read);

        //Чтение с консоли BufferedReader-ом
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Enter some text");
//        String text = br.readLine();
//        System.out.println("you entered text: "+text);


        //Сканнер на самом деле считывает токенами - элементы текса, разделенный друг от друга символом-разделителем
        Scanner scn = new Scanner(System.in);
        //по дефолту разделем явялется пробел, но его можно изменить:
        //scn.useDelimiter(";|\n"); //разделитель может быть точка с запятой или ентер
        System.out.println("enter two words:");
        String firstWord = scn.next();
        String secondWord = scn.next();
        System.out.printf("first: %s, second: %s%n", firstWord, secondWord);


        //Чтение файла сканнером. Также сканнер может считывать файлы
//        String path = "src/lessons/lesson32_io_stream/system/in_system_out/testFile.txt";
//        Scanner scn2 = new Scanner(new File(path));
//        while(scn2.hasNextLine()){
//            System.out.println(scn2.nextLine());
//        }
    }



}
