package hw.homework_NIO2.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> stringList = List.of("Привет", "Как дела", "Ну пока");
        String s = "Кто сражается с чудовищами, тому следует остерегаться, чтобы самому при этом не стать чудовищем. И если ты долго смотришь в бездну, то бездна тоже смотрит в тебя.";
        int[] in = {8,800,555,35,35};

        Path path = Path.of("src/hw/homework_NIO2/source/file1.txt");
        Path path2 = Path.of("src/hw/homework_NIO2/source/file2.txt");
        Path path3 = Path.of("src/hw/homework_NIO2/source/file3.txt");

        Files.write(path,stringList, StandardOpenOption.CREATE);
        Files.writeString(path2,s, StandardOpenOption.CREATE);
        BufferedWriter bw = Files.newBufferedWriter(path3);

        Arrays.stream(in)
                .mapToObj(String::valueOf)
                .forEach(value -> {
                    try {
                        bw.write(value);
                        bw.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        bw.close();

        List<Path> list = new ArrayList<>();
        Path pathSrc = Path.of("src/hw/homework_NIO2/source");
        Path pathDir = Path.of("src/hw/homework_NIO2/dest");
        finedFiles(pathSrc, list);

        for (Path st : list){
//            File file = new File(String.valueOf(pathDir), st.toString());
            String pSrc = pathSrc.toString() +"\\" + st;
            String pDir = pathDir.toString() +"\\" + "copyOf" + st;
            System.out.println(pSrc +" " + pDir);
            Files.copy(Path.of(pSrc), Path.of(pDir), StandardCopyOption.REPLACE_EXISTING);
        }


        finedFiles(pathDir,list);
        for (Path st : list){
            String pDir = pathDir.toString()+ "\\" + st;
            BufferedReader br = Files.newBufferedReader(Path.of(pDir));
            while (br.ready()){
                System.out.println(br.readLine());
            }
        }



    }


    //Находим все файлы в указанном каталоге

    public static void finedFiles(Path source, List<Path> list){
        File dir = new File(source.toString());
        File[] files = dir.listFiles();

        for (int i = 0; i < files.length; i++){
            if (files[i] != null && files[i].isFile()){ //проверяем, что ячейка массива файлов не пустая и является файлом
                list.add(Path.of(files[i].getName())); // добавляем в список имена файлов из данного каталога

            }
        }
    }
}
