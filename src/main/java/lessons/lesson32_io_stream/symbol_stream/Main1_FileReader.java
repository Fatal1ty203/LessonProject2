package lessons.lesson32_io_stream.symbol_stream;

import java.io.*;

public class Main1_FileReader {
    public static void main(String[] args) {

        try(BufferedWriter bw2 = new BufferedWriter(new PrintWriter("src/lessons/lesson32_io_stream/data.txt"))){
            bw2.write("one");
            bw2.newLine(); //ставим ентер
            bw2.write("two");
        }catch (Exception e){
            e.printStackTrace();
        }


        //запись
        try(FileReader fileReader = new FileReader("src/lessons/lesson32_io_stream/data.txt")){
            int code = 0;
            while((code=fileReader.read())!=-1){
                char symbol = (char)code;
                System.out.print(symbol);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


//        BufferedWriter bw1 = new BufferedWriter(new FileWriter(""));

    }
}
