package lessons.lesson19_nested_classes.ex4_training;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.gasPower = 51;
        System.out.println(car.increaseSpeed());




    }
}

class Car{
    int gasPower;
    Abs abs;
    public Car(){
        abs = new Abs();
    }

    //увеличение скорости автомобиля через систему констроля скорости
    public int increaseSpeed(){
        return abs.calcStartSpeed();
    }

    private int calcPower(){
        return gasPower*100;
    }
    //Система контроля страта (чтобы не было заноса)
    //Занос приосходит в том случае, если педаль газа (gasPower) была нажата больше, чем на 50%
    class Abs{

        public int calcStartSpeed(){
            //если педаль была нажата больше чем на 50%, то делим скорость н а2
            if(gasPower>50){
                return calcPower()/2;
            }
            //иначе просто возвращаем скоростЬ, соответствующую нажатой педали газа
            return calcPower();
        }
    }
}
