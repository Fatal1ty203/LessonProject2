package hw.homework7_File.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static String path = "C:\\Users\\DELL\\OneDrive\\Рабочий стол\\hz-main\\LessonProject\\src\\hw.homework7_File\\task1\\randomInt.txt";

    public static void writeToFile(String path) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 6; i++){
            integers.add((int)(Math.random()*10));
        }

        //Записываем в файл список
        try {
            PrintWriter pw = new PrintWriter(path);
            for (Integer in : integers) {
                pw.println(in);
            }
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int[] readToFile(String path) {
        List<Integer> list = new ArrayList<>();

        //Записываем в файл список

        try(BufferedReader br = new BufferedReader(new FileReader(path)))
        {
//            arr = br.lines().mapToInt(Integer::parseInt).toArray();
            String line = null;
            while((line = br.readLine())!=null){
                list.add(Integer.parseInt(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        writeToFile(path);
        int sum = 0;



        int[] integers = readToFile(path);
        int min = integers[0];
        int max = integers[0];
        for (Integer integer : integers){
            sum += integer;
            if (integer > max){
                max = integer;
            } else if (integer < min){
                min = integer;
            }
            System.out.println(integer);
        }
        System.out.println("MAX "+max);
        System.out.println("MIN "+min);
        System.out.println("SUM "+sum);
    }
}
