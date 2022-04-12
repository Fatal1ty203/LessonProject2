package hw.homeworkDat;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/hw/homeworkDat/in_1.dat");
        Path path2 = Paths.get("src/hw/homeworkDat/in_2.dat");
        Path path5 = Paths.get("src/hw/homeworkDat/in_5.dat");
        Path path3 = Paths.get("src/hw/homeworkDat/in_3.dat");
        Path path4 = Paths.get("src/hw/homeworkDat/in_4.dat");
        List<Path> pathList = new ArrayList<>();
        pathList.add(path);
        pathList.add(path2);
        pathList.add(path3);
        pathList.add(path4);
        pathList.add(path5);
        CulcClass culcClass = new CulcClass(pathList);
        Thread thread1 = new Thread(culcClass);
        Thread thread2 = new Thread(culcClass);
        Thread thread3 = new Thread(culcClass);
        thread1.start();
        thread2.start();
        thread3.start();
    }


}

class CulcClass implements Runnable{
    List<Path> pathList;

    public CulcClass(List<Path> pathList) {
        this.pathList = pathList;
    }

    @Override
    public void run() {
        Path path = null;
            while (!pathList.isEmpty()) {
                try {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (pathList) {
                        if (pathList.size()!=0) {
                            path = pathList.remove(0);
                        }
                    }
                    if (path != null){
                        read(path);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    public static void read(Path path) throws IOException {
        Path pathOut = Path.of("src/hw/homeworkDat/out.dat");
        List<String> s = new LinkedList<>(Arrays
                .stream(Files
                        .readString(path)
                        .split("\n")).toList());
        int actionCode = Integer.parseInt(s.remove(0).strip());
        System.out.println(actionCode);
        String action = null;

        double[] doubleList = s.stream()
                .flatMap(str -> Stream
                        .of(str.split(" ")))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Arrays.stream(doubleList).forEach(System.out::println);

        boolean isExit = false;
        String doubles = " ";
        while (!isExit){
            for (int i = 0; i < doubleList.length; i++){
                doubles += doubleList[i] + "; ";
            }
            if (actionCode==1){
                Double a = Arrays.stream(doubleList).sum();
                System.out.print(doubles + "ТУТ");
                action = "Производится сложение чисел:" + doubles + "ответ: " + a +"\n" ;
                isExit= true;
            }else if (actionCode == 2){
                double multi = Arrays.stream(doubleList)
                        .reduce(1,(a,b) -> a*b);
                action = "Производится умножение чисел:" + doubles + " ответ: " + multi +"\n";
                isExit = true;
            } else if (actionCode == 3){
                double sum2 = Arrays.stream(doubleList)
                        .reduce(1,(a,b) -> (a*2)+(b*2));
                action = "Производится сложение квадратов:" + doubles + " ответ: " + sum2 +"\n";
                System.out.println(sum2);
                isExit = true;
            }
            Files.writeString(pathOut, action, StandardOpenOption.APPEND);
        }
    }
}
