package hw.homework_copyImage.BufRead;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MyCopyBufService {
    public static void copyBuf(String sourcePath, String destPath){
        try(BufferedReader bf = new BufferedReader(new FileReader(sourcePath));
            PrintWriter pw = new PrintWriter(destPath)){
            int code =0;
            while ((code = bf.read())!=-1){
                char ch = (char) code;
                pw.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
