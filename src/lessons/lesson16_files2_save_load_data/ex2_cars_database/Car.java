package lessons.lesson16_files2_save_load_data.ex2_cars_database;

import java.util.Objects;

public class Car {
    String mark;
    String model;
    int count;

    public Car(String mark, String model, int count) {
        this(mark, model);
        this.count = count;
    }
    public Car(String mark, String model) {
        this.mark = mark;
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(mark, car.mark) &&
                Objects.equals(model, car.model);
    }


    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", count=" + count +
                '}';
    }
}
