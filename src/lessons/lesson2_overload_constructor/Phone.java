package lessons.lesson2_overload_constructor;

public class Phone {
    public String name;
    int memory;
    String color;
    int price;


    public Phone(String name, int memory){
        System.out.println("constr1");
        this.name = name;
        this.memory = memory;
    }

    public Phone(String name, int memory, String color) {
        this(name, memory);
        System.out.println("constr2");
        this.color = color;
    }

    public Phone(String name, int memory, String color, int price){

        this(name, memory, color); //должна быть первой операцией
        System.out.println("constr3");
//        this.name = name;
//        this.memory = memory;
//        this.color = color;
        this.price = price;
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
