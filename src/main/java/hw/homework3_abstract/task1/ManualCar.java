package hw.homework3_abstract.task1;

import java.util.Scanner;

abstract class ManualCar extends Car{
    Scanner scan = new Scanner(System.in);

    public ManualCar(){
        this.setMaxGear(6);
    }

    @Override
    public void gas() {
        System.out.println("Газ. Введите передачу: ");
        int currentGear = scan.nextInt();
        if (isActualGear(currentGear)) {
            setCurrentGear(currentGear);
        }else System.out.println("Вы ввели не корректную передачу");
        if (getSpeed() == 0){
            setSpeed(5 + (5 * getCurrentGear()));
        }else setSpeed(getSpeed() * getCurrentGear());
        System.out.println(toString());
    }

    @Override
    public void breaK() {
        System.out.println("Торможение. Введите передачу:");
        int currentGear = scan.nextInt();
        if (getCurrentGear() >= currentGear){
            setCurrentGear(currentGear);
        }else {
            System.out.println("Передача не может быть выше при торможении ");
        }
        if (getSpeed() > 0){
            setSpeed(getSpeed() / 2);
        }else {
            setSpeed(0);
            System.out.println("Машина остановилась");
        }
        System.out.println(toString());
    }


    @Override
    public void setCurrentGear(int currentGear) {
        if (currentGear <= getCurrentGear() + 1) {
            super.setCurrentGear(currentGear);
        } else if (currentGear == getCurrentGear() + 2) {
            System.out.println("WARNING: Опасно переключать скорость не по порядку");
            super.setCurrentGear(currentGear);
        } else if (currentGear >= getCurrentGear() + 3) {
            super.setCurrentGear(0);
            System.out.println("Машина заглохла");
        }
    }


    @Override
    public String toString() {
        return "Текущая передача: " + getCurrentGear() +
                " Текущая скорость: " + getSpeed() +
                " Максимальная передача: " + getMaxGear() + " " + getName();
    }
}
