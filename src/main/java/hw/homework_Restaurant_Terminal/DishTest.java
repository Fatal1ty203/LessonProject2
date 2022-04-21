package hw.homework_Restaurant_Terminal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DishTest {
    Dish dish = new Dish("Burger", 50);

    @Test
    void getPrice() {
        double expected = 50.0099999;
        Assertions.assertEquals(expected,dish.getPrice(),0.01);
    }
}