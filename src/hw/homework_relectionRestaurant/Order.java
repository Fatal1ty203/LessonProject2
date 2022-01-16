package hw.homework_relectionRestaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Dish> dished = new ArrayList<>();
    private int fullCost = 0;

    public void addDish(String dishName, int price){
        dished.add(new Dish(dishName,price));
        fullCost += price;
    }

    public List<Dish> getDished() {
        return dished;
    }

    public int getFullCost() {
        return fullCost;
    }

    @Override
    public String toString() {
        return "Заказ: " + dished;
    }
}
