package hw.homework2.task1;

public class Animal {
    int age, speed, weight;
    String name, say;

    public int getAge(){
        return age;
    }

     public int getSpeed(){
         return speed;
     }

     public int getWeight(){
         return weight;
     }

     public String getSay(){
         return null;
     }

    @Override
    public String toString() {
        return "Животное: " + name +
                ", Возраст = " + age +
                ", Скорость передвижения = " + speed +
                ", Вес = " + weight;
    }
}
