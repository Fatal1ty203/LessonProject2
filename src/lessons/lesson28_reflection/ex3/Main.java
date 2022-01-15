package lessons.lesson28_reflection.ex3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        //Получить представление класса через Class.forName("полное_название_класса")
        //Создать объект, используя конструктор с параметрами.
        //Используя средства reflection, вывести на консоль значение цены, используя метод getPrice.
        //Используя средства reflection, изменить значение поля через метод setPrice
        //Используя средства reflection, получить значение private поля price, не используя getPrice (для доступа к private полю - field.setAccessable(true)),
        // изменить его и вывести изменное поле через getPrice или напрямую.



        Class<Tovar> clazz = (Class<Tovar>) Class.forName("lessons.lesson28_reflection.ex3.Tovar");
        Constructor<Tovar> constructor = clazz.getDeclaredConstructor(String.class, int.class);
        Tovar apple = constructor.newInstance("Apple", 100);
        System.out.println(apple);

        Method getPrice = clazz.getDeclaredMethod("getPrice");
        Object price = getPrice.invoke(apple);
        System.out.println(price);

        //получить значение Price
        Field priceField = clazz.getDeclaredField("price");
        priceField.setAccessible(true);
        priceField.set(apple, 200);
        System.out.println(priceField.get(apple));


    }
}


