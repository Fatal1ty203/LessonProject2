package lessons.lesson2_overload_constructor;

public class Main {
    public static void main(String[] args) {
        //Перегруженные (overload) конструторы можно связывать по цепочке, чтобы избегать дублированного кода
        //Пример в классе Phone
        Phone phone1 = new Phone("phone1", 10);
        System.out.println();
        Phone phone2 = new Phone("phone1", 10, "green");
        System.out.println();
        Phone phone3 = new Phone("phone1", 10, "green", 100);


    }
}


