package lessons.lesson32_io_stream.system.in_system_out;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main2 {
    public static void main(String[] args) throws IOException {
        //Вывести на консоль любой текст через BufferedWriter
        BufferedWriter br = new BufferedWriter(new PrintWriter(System.out));
        String text = "Kakoito text";
        br.write(text);
        br.flush();
    }
}
