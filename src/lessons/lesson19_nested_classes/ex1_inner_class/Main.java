package lessons.lesson19_nested_classes.ex1_inner_class;

public class Main {
    public static void main(String[] args) {
        //КАК СОЗДАТЬ ОБЪЕКТ INNER CLASS:

        //Вариант 1:
//        Car car = new Car("car1");
//        Car.GearBox gearBox = car.new GearBox(true, 2); //ОБЪЕКТ INNER КЛАССА МОЖНО СОЗДАТЬ ТОЛЬКО ЕСЛИ СУЩЕСТВУЕТ ОБЪЕКТ OUTER КЛАССА
//        car.gearBox = gearBox;

        //Вариант 2:
        Car car = new Car("car1", true, 2);


    }
}


class Car{
    String name;
    int speed; //текущая скорость двжиения автомобиля
    GearBox gearBox;

    public Car(String name) {
        this.name = name;

    }


    public Car(String name, boolean gearBoxType, int currentGear) {
        this.name = name;
        this.gearBox = new GearBox(gearBoxType, currentGear);

    }



    //INNER CLASS:
    class GearBox{
        boolean type; //automatic or mechanic
        int currentGear;

        public GearBox(boolean type, int currentGear) {
            this.type = type;
            this.currentGear = currentGear;
        }

        //данный метод расчитывает скорость движения автомобиля на сонове текущей передачи
        public void calcSpeed(){
            speed = currentGear*50; //ВНУТРИ INNER CLASS МОЖНО ОБРАЩАТЬСЯ К АТРИБУТАМ OUTER CLASS
        }


    }


}


