package hw.homework2.task1;

public class Mammoth extends Animal{
    public Mammoth(String name, int age, int weight, int speed, String say){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.speed = speed;
        this.say = say;
    }

    public String getSay(){
        return name + " говорит: " + say;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return super.toString() + ", Говорит = " + say + ", Класс - Млекопитающие";
    }
}
