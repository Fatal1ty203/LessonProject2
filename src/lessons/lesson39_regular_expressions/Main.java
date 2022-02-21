package lessons.lesson39_regular_expressions;

import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //Проверить, что юзер ввел строку hello
        System.out.println("task 1");
//        String str = "hello1"; // юзер ввел с консоли hello
//        System.out.println(str.matches("hello")); //true
        //В базовом варианте регулярное выражение работает как equals
        //Но в отличие от equals в регулярке можно задать несколько вариантов написания строки
        System.out.println("task 2");
        //- проверить, что пользователь ввел строку hello, в конце которой может быть восклицательный знак или вопросительный
        //[!?] - проверяем ОДИН символ на то, что он может быть как !, так и ?
//        System.out.println("hello!".matches("hello[!?]")); //true
//        System.out.println("hello?".matches("hello[!?]")); //true
//        System.out.println("hello".matches("hello[!?]")); //false

        System.out.println("task 3");
        //проверить, что юзер ввел hello
        //первая буква может быть как большой, так и маленькой, а в конце может быть воскл знак или вопр знак
//        System.out.println("hello!".matches("[Hh]ello[?!]")); //true
//        System.out.println("Hello?".matches("[Hh]ello[?!]")); //true
//        System.out.println("Hello".matches("[Hh]ello[?!]")); //false
//        System.out.println("ello".matches("[Hh]ello[?!]")); //false

        System.out.println("task 4");
        //- проверить, что пользователь ввел строку hello, в конце которой может быть от одного до трех восклицательных знаков
//        System.out.println("hello!".matches("hello!{1,3}")); //true
//        System.out.println("hello!!".matches("hello!{1,3}")); //true
//        System.out.println("hello!!!".matches("hello!{1,3}")); //true
//        System.out.println("hello!!!!".matches("hello!{1,3}")); //false
//        System.out.println("hello".matches("hello!{1,3}")); //fakse
        System.out.println("task 5");
        //- проверить, что пользователь ввел строку hello, в конце которой может быть от одного до трех символов o!
        //КРУГЛЫМИ СКОБКАМИ МОЖНО ГРУППИРОВАТЬ СИМВОЛЫ, КОТОРЫЕ ДОЛЖНЫ ПОВТОРЯТЬСЯ
//        System.out.println("hello!".matches("hell(o!){1,3}")); //true
//        System.out.println("hello!o!".matches("hell(o!){1,3}")); //true
//        System.out.println("hello!o!o!".matches("hell(o!){1,3}")); //true
//        System.out.println("hello!o!o!o!".matches("hell(o!){1,3}")); //false
//        System.out.println("hello".matches("hell(o!){1,3}")); //false
//        System.out.println("hell".matches("hell(o!){1,3}")); //false

        System.out.println("task 6");
        //- проверить, что юзер ввел число, без прочих символов
        //{1,} - от одного до бесконечности
//        System.out.println("12345".matches("[0123456789]{1,}")); //true
//        System.out.println("12".matches("[0123456789]{1,}")); //true
//        System.out.println("12345345345".matches("[0123456789]{1,}")); //true
//        System.out.println("1234в5345345".matches("[0123456789]{1,}")); //false
//        System.out.println("в".matches("[0123456789],}{1"));//false

        System.out.println("task7");
        //проверить, что юзер ввел число из трех цифр
//        System.out.println("123".matches("[0123456789]{3}")); //true
//        System.out.println("1234".matches("[0123456789]{3}")); //false
//        System.out.println("12".matches("[0123456789]{3}")); //false
//        System.out.println("abd".matches("[0123456789]{3}")); //false

        System.out.println("task8");
//        //Переделаем последние три задачи, указав диапазоны повторений через литералы
//        //кол-во чисел от 1 до бесконечности:
//        //вместо {1,} пишем +
//        System.out.println("123".matches("[0123456789]+")); //true
//        //кол-во чисел 0 до бесконечности:
//        //вместо {0,} пишем *
//        System.out.println("123".matches("[0123456789]*")); //true
//        System.out.println("".matches("[0123456789]*")); //true
//        //кол-во чисел 0 или 1:
//        //вместо {0,1} пишем ?
//        System.out.println("5".matches("[0123456789]?")); //true
//        System.out.println("".matches("[0123456789]*")); //true

//        System.out.println("task 9");
//        //Проверить, что в строке нет ни одного числа
//        System.out.println("abd".matches("[^0123456789]*")); //true
//        System.out.println("".matches("[^0123456789]*")); //true
//        System.out.println("5s".matches("[^0123456789]*")); //false

        System.out.println("task 10");
        //проверить, что строка состоит из больших или маленьких символов англ или русского языка или пробелов
//        System.out.println("пример world".matches("[a-zA-Zа-яА-Я ]+")); //true
//        System.out.println("пример 1world".matches("[a-zA-Zа-яА-Я ]+")); //false

        System.out.println("task 11 ПЕРЕСЕЧЕНИЯ");
//        System.out.println("def".matches("[a-z&&[def]]+")); //true
//        System.out.println("defa".matches("[a-z&&[def]]+")); //false

        System.out.println("task 12");
        //Проверить, что строка сосоит только из англ букв большоих или маленьких или чисел или нижнего подчеркивания
        //Вместо [a-zA-Z0-9_] пишем \w
//        System.out.println("hEllo123".matches("[a-zA-Z0-9]+")); //true
//        System.out.println("hEllo123".matches("\\w+")); //true
//        System.out.println("тест".matches("\\w+")); //false

        System.out.println("task 13");
        //проверитЬ, что строка состоит только из цифр
        //Вместо [0-9] пишем \d
//        System.out.println("123123".matches("[0-9]+"));//true
//        System.out.println("123123".matches("\\d+")); //true
//        System.out.println("12d3123".matches("\\d+")); //false



        System.out.println("task 14");
        //проверить, что никнейм содержит минимум любые три символа
        // .(точка) - любой символ (абсолютно любой символ)
//        System.out.println("sdf123".matches(".{3,}")); //true
//        System.out.println("#2&5".matches(".{3,}")); //true
//        System.out.println("&2".matches(".{3,}")); //false


        System.out.println("task15");
        //проверить, что в конце предлоежния стоит точка, а само предложение сосоит из буквенынх англ символов
        //символ точки надо экранировать
//        System.out.println("hello.".matches("\\w+\\.")); //true
//        System.out.println("hello".matches("\\w+\\.")); //false


        System.out.println("task 16");
        //Проверить, что строка содержит один из реальных емейлов: google, yandex, yahoo
//        System.out.println("abc@gmail.com".matches("\\w+@(gmail|yandex|yahoo)\\.(com|ru)")); //true
//        System.out.println("abc@yandex.ru".matches("\\w+@(gmail|yandex|yahoo)\\.(com|ru)")); //true
//        System.out.println("abc@test.com".matches("\\w+@(gmail|yandex|yahoo)\\.(com|ru)")); //false
//        System.out.println("*#^&$@yandex.ru".matches("\\w+@(gmail|yandex|yahoo)\\.(com|ru)")); //false


        System.out.println("task 17");
        //Найти все email в тексте
        String text = "hello, my email is: abc@gmail.com, what is your email?\n It's abc@yandex.ru";
        Pattern pattern = Pattern.compile("\\w+@(gmail|yandex|yahoo)\\.(com|ru)");
        Matcher matcher = pattern.matcher(text);
        //find возвращает true, если нашел email
        //group возвращает значение email
        while(matcher.find()){
            String email = matcher.group();
            System.out.println(email);
        }


    }
}
