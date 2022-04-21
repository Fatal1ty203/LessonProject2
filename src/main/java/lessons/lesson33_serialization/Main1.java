package lessons.lesson33_serialization;

import java.io.*;

public class Main1 {
    public static void main(String[] args) {
        //Запишем (сериализуем) объект фрукта в файл
//        Fruit fruit1 = new Fruit("apple", 100);
//        try(ObjectOutputStream oos = new ObjectOutputStream(
//                new FileOutputStream("src/lessons/lesson33_serialization/test.txt"))){
//            oos.writeObject(fruit1);
//        }catch (Exception e){
//            e.printStackTrace();
//        }


        //считаем (десериализуем) объект фрукта из файла
        Fruit fruit1=null;
        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("src/lessons/lesson33_serialization/test.txt"))){
            fruit1 = (Fruit) ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(fruit1!=null) System.out.println(fruit1);
    }
}

class Fruit implements Serializable {
    String name;
    int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
