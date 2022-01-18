package lessons.lesson29_annotations.ex2_parameters;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception{
        //Создать класс UserRecords (таблица рекордов пользователя).
        // Данный класс хранит историю побед игроков в какой-нибудь игре.
        // Создать класс Game, реализовать простую игру.
        // Например, компьютер загадывает число, два пользователя пытаются его отгадать.
        // Побеждает пользователь, чье число было ближе всего к загаданному.
        //
        //Создать в классе Game консольное меню:
        //1. Ввести имя первого игрока
        //2. Ввести имя второго игрока
        //3. Начать игру
        //4. Показать таблицу победителей
        //5. Выход
        //
        //При запуске игры программа должна загружать из файла (в котором хранится таблица рекордов) таблицу рекордов,
        // при завершении - сохранять в файл новые данные. Файл хранит данные в виде:
        //user1 победил игрока user2
        //user3 победил игрока user5
        //
        //Создать аннотацию ServiceOrder, которой необходимо пометить сервисные методы игры (загрука таблицы из файла,
        // запуск игры, сохранение таблицы в файл). Методы должны работать в определенной последовательности,
        // поэтому необходимо создать в аннотации ServiceOrder параметр order со значением по умолчанию 0.
        //В мейне с помощью reflection запустить методы в порядке возрастания.

        File file = new File("C:\\Users\\DELL\\OneDrive\\Рабочий стол\\hz-main\\LessonProject2\\src\\lessons\\lesson29_annotations\\ex1_basic\\CalculatorTest.java");
        File folder = new File("C:\\Users\\DELL\\OneDrive\\Рабочий стол\\hz-main\\LessonProject2\\src\\lessons\\lesson29_annotations\\e2_parameters");
        Date date = new Date(file.lastModified());
        //System.out.println(date);
        Files.move(Paths.get("C:\\Users\\DELL\\OneDrive\\Рабочий стол\\hz-main\\LessonProject2\\src\\lessons\\lesson29_annotations\\ex1_basic\\CalculatorTest.java"),
                Paths.get("C:\\Users\\DELL\\OneDrive\\Рабочий стол\\hz-main\\LessonProject2\\src\\lessons\\lesson29_annotations\\ex2_parameters\\test.txt"));



        Method load = null;
        Method save = null;

        Game game = new Game();
        Class<? extends Game> clazz = game.getClass();
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            if(declaredMethod.isAnnotationPresent(ServiceLoad.class)){
                ServiceLoad annotation = declaredMethod.getAnnotation(ServiceLoad.class);
                int order = annotation.order();
                if(order == 1) load = declaredMethod;
                else if(order == 2) save = declaredMethod;
            }
        }

       game.menu(load, save);


    }

}
