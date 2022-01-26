package hw.homework_copyImage.Main;

import hw.homework_copyImage.BufRead.MyCopyBufService;
import hw.homework_copyImage.copybyte.MyCopyByteService;

public class Main {
    public static void main(String[] args) {
        String sourcePath = "src/hw/homework_copyImage/images/img.png";
        String destPath = "src/hw/homework_copyImage/copy_folder/img_copy.png";
        String destPath2 = "src/hw/homework_copyImage/copy_folder/img_copy2.png";
        MyCopyByteService.copyByte(sourcePath,destPath);
        MyCopyBufService.copyBuf(sourcePath,destPath2);
    }
}
