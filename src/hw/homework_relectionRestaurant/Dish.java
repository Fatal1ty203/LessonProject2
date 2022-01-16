package hw.homework_relectionRestaurant;

public class Dish {
    private String nameDish;
    private int price;

    public Dish(String nameDish, int price) {
        this.nameDish = nameDish;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{'Наименование: '" + nameDish + '\'' +
                ", Цена = " + price +
                '}' + "\n";
    }
}
