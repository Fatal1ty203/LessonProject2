package hw.homework_relectionRestaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Dish> dished = new ArrayList<>();

    public void addDish(String dishName, int price){
        dished.add(new Dish(dishName,price));
    }

    public List<Dish> getDished() {
        return dished;
    }


    @Override
    public String toString() {
        return "Заказ: " + dished;
    }
}
