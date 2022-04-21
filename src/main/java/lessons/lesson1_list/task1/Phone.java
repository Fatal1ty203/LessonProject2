package lessons.lesson1_list.task1;

public class Phone {
    String name;
    int memory;
    String color;
    int price;

    public Phone(String name, int memory, String color, int price){
        this.name = name;
        this.memory = memory;
        this.color = color;
        this.price = price;
    }

    public Phone(String name, int memory, String color) {
        this.name = name;
        this.memory = memory;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Phone: " +
                "Название= '" + name + '\'' +
                ", Оперативная память= " + memory + " Гб" +
                ", Цвет= '" + color + '\'' +
                ", Цена= " + price + " Руб." +
                '}';
    }

    @Override
    public boolean equals(Object o){
        Phone phone = (Phone) o;

        return name.equals(phone.name)
                && memory == (phone.memory)
                && color.equals(phone.color);
    }
}
