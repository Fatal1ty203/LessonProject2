package lessons.lesson20_interfaces_inheritance_default_methods;

public class Main {
    public static void main(String[] args) {
        //Создать базовый интерфейс IMove управления транспортным средством (ТС) с методами вперед, влево, вправо
        //Создать интерфейс IFly управления летательными средствами
        //Поскольку любое летательное ТС умеет двигаться влево, вправо, вперед, IFly должен наследоваться от IMove
        //ИНТЕРФЕЙСЫ МОГУТ ИМЕТЬ ДЕФОЛТНЫЕ МЕТОДЫ
        //Создать два деволтных методы: checkSystem() - делает проверку работы системы ТС
        //startEngine - запускат двигетяль ТС
        //В классе car попробовать переопределить startEngine
        Car car = new Car();
        car.startEngine();
        car.checkSystem();

        Plane plane = new Plane();
        plane.startEngine();
        plane.checkSystem();
    }
}

class Car implements IMove{

    @Override
    public void goLeft() {
        System.out.println("car goes left");
    }

    @Override
    public void goRight() {
        System.out.println("car goes right");
    }

    @Override
    public void goForward() {
        System.out.println("car goes forward");
    }

    //ДЕВОЛТНЫЕ МЕТОДЫ МОЖНО ПЕРЕОПРЕДЕЛИТ (ПРИЧЕМ ТОЛЬКО ЗАМЕНИТь, НО НЕ ДОПОЛНИТЬ)
    @Override
    public void startEngine() {
        //super().startEngine(); //работать не будет
        System.out.println("Переопределенная версия startEngie");
    }
}


class Plane implements IFly{

    @Override
    public void goLeft() {
        System.out.println("plane go left");
    }

    @Override
    public void goRight() {
        System.out.println("plane go right");
    }

    @Override
    public void goForward() {
        System.out.println("plane go forward");
    }

    @Override
    public void goUp() {
        System.out.println("plane go up");
    }

    @Override
    public void goDown() {
        System.out.println("plane go down");
    }
}

interface IMove{
    String color="green"; //static final

    void goLeft();
    void goRight();
    void goForward();

    default void checkSystem(){
        System.out.println("Проверка работы системы:");
        goLeft();
        goRight();
        goForward();
    }

    default void startEngine(){
        System.out.println("Запуск двигателя");
    }
}

interface IFly extends IMove{
    void goUp();
    void goDown();
}
