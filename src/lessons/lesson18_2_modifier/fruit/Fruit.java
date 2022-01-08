package lessons.lesson18_2_modifier.fruit;

public class Fruit {
    public String name; //доступен везде
    protected int price; //доступен в рамках своего пакета (fruit) и во всех наследниках (даже если наследники находятся в другом пакете)
    String color; //имеет модфификатор default, доступен в рамках своего пакета (fruit)
    private double weight; //доступен только внутри класса
}
