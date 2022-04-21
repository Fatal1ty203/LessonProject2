package lessons.lesson16_files2_save_load_data.ex2_cars_database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataBase {

    String filePath = "C:\\Users\\DELL\\OneDrive\\Рабочий стол\\hz-main\\" +
            "LessonProject\\src\\lessons.lesson16_files2_save_load_data\\ex2_cars_database\\db.txt";
    public void startMenu(){
        List<Car> cars = readToFile(filePath);
        Scanner scn = new Scanner(System.in);
        int input = 0;
        while(input!=3){
            System.out.println("1. Print");
            System.out.println("2. Buy");
            System.out.println("3. Exit");
            input = scn.nextInt();
            switch (input){
                case 1 -> {
                    for (Car car : cars) {
                        System.out.println(car);
                    }
                }
                case 2 -> {
                    System.out.println("Enter mark");
                    String mark = scn.next();
                    System.out.println("Enter model");
                    String model = scn.next();
                    int index = cars.indexOf(new Car(mark, model));
                    cars.get(index).count--;
                }
                case 3-> writeToFile(filePath, cars);


            }
        }
    }

    public  void writeToFile(String path, List<Car> cars) {


        //Записываем в файл список
        PrintWriter pw=null;
        try {
            pw = new PrintWriter(path);
            for (Car car : cars) {
                StringBuilder sb = new StringBuilder();
                pw.println(sb.append(car.mark).append(";")
                        .append(car.model).append(";")
                        .append(car.count));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(pw!=null) pw.close();
        }
    }

    public  List<Car> readToFile(String path) {

        //Записываем в файл список
        List<Car> cars = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = null;
            while((line = br.readLine()) != null){
                String[] arr = line.split(";"); //делим строчку из файла по символу точка с запятой
                String mark = arr[0];
                String model = arr[1];
                int count = Integer.parseInt(arr[2]);
                cars.add(new Car(mark,model, count));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cars;
    }
}
