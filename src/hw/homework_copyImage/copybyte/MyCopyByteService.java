package hw.homework_copyImage.copybyte;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyCopyByteService {
    public static void copyByte(String sourcePath, String destPath){
        try(FileInputStream fis = new FileInputStream(sourcePath);
            FileOutputStream fos = new FileOutputStream(destPath)){
            int len = fis.available();
            for (int i = 0; i < len; i++){
                int code = fis.read();
                fos.write(code);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
