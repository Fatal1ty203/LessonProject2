package lessons.lesson6_getters_setters_incapsulation;

public class Main {
    public static void main(String[] args) {
        Fruit f = new Fruit("apple", 100);
        //прямой доступ к полям должен быть закрыт для предотварщения подобных некорректных значений:
//        f.price = -100;
//        f.name = "z"

        //парльно получать доступ через геттеры и сеттеры
        System.out.println(f.getName()+" "+f.getPrice());
        //f.setPrice(-100); //получим ошибку, потому что в сеттерах есть проверка на некорректное значение
        //f.setName("z"); //получим ошибку, потому что в сеттерах есть проверка на некорректное значение
        f.setPrice(120); //ок
        System.out.println(f.getName()+" "+f.getPrice());
    }
}
//Класс Fruit инкапсулирует поля name, price
class Fruit{
    private String name;
    private int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    //геттеры:
    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    //сеттеры
    public void setName(String name){
        if(name.length() > 3) {
            this.name = name;
        }else{
            throw new RuntimeException("Значение названия фрукта не может быть короче 3-х символов");
        }
    }


    public void setPrice(int price){
        if(price>0) {
            this.price = price;
        }
        else{
            throw new RuntimeException("Цена фрукта не может быть отрицальеной");
        }
    }




}
