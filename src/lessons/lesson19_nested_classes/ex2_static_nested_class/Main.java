package lessons.lesson19_nested_classes.ex2_static_nested_class;

public class Main {
    public static void main(String[] args) {
        //ОБЪЕКТ STATIC NESTED(INNER) КЛАССА МОЖНО СОЗДАТЬ БЕЗ ОБЪЕКТА OUTER КЛАССА
        //НО ИЗ-ЗА ЭТОГО (ИЗ-ЗА ТОГО, ЧТО КЛАСС STATIC) ВНУТРИ НЕГО НЕЛЬЗЯ ОБРАЩАТЬСЯ К НЕСТАТИЧЕСКИМ ПОЛЯМ OUTER КЛАССА
        Car.GearBox gearBox = new Car.GearBox(true, 3);



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


    //STATIC NESTED(INNER) CLASS:
    static class GearBox{
        boolean type; //automatic or mechanic
        int currentGear;

        public GearBox(boolean type, int currentGear) {
            this.type = type;
            this.currentGear = currentGear;
        }

        //данный метод расчитывает скорость движения автомобиля на сонове текущей передачи
        public void calcSpeed(){
            //error:
            // speed = currentGear*50; //ВНУТРИ STATIC NESTED(INNER) CLASS НЕЛЬЗЯ ОБРАЩАТЬСЯ К НЕ STATIC АТРИБУТАМ OUTER CLASS
        }


    }


}


