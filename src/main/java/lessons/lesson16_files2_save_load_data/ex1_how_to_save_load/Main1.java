package lessons.lesson16_files2_save_load_data.ex1_how_to_save_load;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main1 {

    public static void writeToFile(String path) {
        List<Tovar> tovars = List.of(new Tovar("tovar1", 100), new Tovar("tovar2", 150));

        //Записываем в файл список
        try {
            PrintWriter pw = new PrintWriter(path);
            for (Tovar tovar : tovars) {
                pw.println(tovar.name + ";" + tovar.price);
            }
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Tovar> readToFile(String path) {
        List<Tovar> tovars = new ArrayList<>();

        //Записываем в файл список

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = null;
            while((line = br.readLine()) != null){
                String[] arr = line.split(";"); //делим строчку из файла по символу точка с запятой
                String tovarName = arr[0];
                int tovarPrice = Integer.parseInt(arr[1]);
                tovars.add(new Tovar(tovarName, tovarPrice));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tovars;
    }

    public static void main(String[] args) {
        //Создать csv файл, хранящий товары на складе в формате
        //tovarName1;price1
        //tovarName2;price2
        //Причем, между символом точка с запятой могут встречаться лишние пробелы.
        //Считать данные из файла и сохранить все товары в список List<Tovar>, перед этим удалив все лишние пробелы по краям строк.

        String path = "C:\\Users\\DELL\\OneDrive\\Рабочий стол\\hz-main\\LessonProject\\src\\lessons.lesson16_files2_save_load_data\\tovars.txt";
        //writeToFile(path);
        List<Tovar> tovars = readToFile(path);
        for(Tovar t : tovars){
            System.out.println(t);
        }


        //+ Создайте базу данных автомобильного магазина на основе файла.
        //Создайте класс Car со свойствами:
        //марка
        //модель
        //количество
        //
        //Создайте меню просмотра автомобилей на складе в виде таблицы со столбцами: Марка, Модель, Количество.
        //Добавьте возможность увеличивать, уменьшать количество автомобилей на складе и добавлять новые автомобили у пользователя через консольное меню.
        //
        //Например, есть следующие автомобили:
        //название марка кол-во
        //audi          q7          3
        //bmw           x5          2
        //
        //Пользователь увеличивает кол-во bmw x5 на 1 и файл должен стать:
        //audi          q7          3
        //bmw           x5          3
        //
        //Или например польозватель добавляет новые автомобиль bwm x6 в количестве 5-и штук и файл становится:
        //audi          q7
    }
}
