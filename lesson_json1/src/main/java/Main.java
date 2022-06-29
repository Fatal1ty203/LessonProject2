import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.baeldung.com/jackson-object-mapper-tutorial
        //КЛАСС ДОЛЖЕН ИМЕТЬ ОБЯЗАТЕЛЬНО ДЕФОЛТНЫЙ КОНСТРУКТОР, ИНАЧЕ НЕ ПОЛУЧИТСЯ СКОНВЕРТИТЬ JSON В ОБЪЕКТ
        //В КЛАССЕ ПОЛЯ ОБЯЗАТЕЛЬНО ДОЛЖНЫ БЫТЬ PUBLIC, ЛИБО ИМЕТЬ ГЕТТЕРЫ И СЕТТЕРЫ, ИНАЧЕ НЕ ПОЛУЧИТСЯ СКОНВЕРТИРОВАТЬ ОБЪЕКТ В JSON

        ObjectMapper objectMapper = new ObjectMapper();
        //Сконвертировать объект в json
        Tovar tovar = new Tovar(1, "tovar1", 1000);
        //вывод в консоль
        //objectMapper.writeValue(System.out, tovar);
        String json = objectMapper.writeValueAsString(tovar);
        System.out.println(json);

        //2. сконвертировать json строку в объект
        String json2 = "{\"id\":1,\"name\":\"tovar1\",\"price\":1000}";
        Tovar tovar2 = objectMapper.readValue(json2, Tovar.class);
        System.out.println(tovar2);


        //3. Создать список товаров и сконвертировать его в json
        List<Tovar> list = List.of(tovar, tovar2);
        json = objectMapper.writeValueAsString(list);
        System.out.println(json);

        //4. Сконвертировать json в объект списка
        json = "[{\"id\":1,\"name\":\"tovar1\",\"price\":1000},{\"id\":1,\"name\":\"tovar1\",\"price\":1000}]";
        ArrayList<Tovar> arrayList = objectMapper.readValue(json, ArrayList.class);
        System.out.println("список: "+arrayList);

        //5. Сконветировать объект доставки в json
        Delivery delivery = new Delivery("address1", tovar, 100);
        json = objectMapper.writeValueAsString(delivery);
        System.out.println(json);

    }
}
