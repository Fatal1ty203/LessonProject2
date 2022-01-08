package hw.homework3_abstract.task1;

abstract class AutoCar extends Car {


    @Override
    public void setCurrentGear(int currentGear) {
        if (currentGear <= getMaxGear() && currentGear > 0){
            super.setCurrentGear(currentGear);
        }else if (currentGear <= 0) {
            super.setCurrentGear(0);
        }

    }



    @Override
    public void gas() {
        setCurrentGear(getCurrentGear()+1);
        if (getSpeed() == 0){
            setSpeed(4 + (3 * getCurrentGear()));
        }else setSpeed(getSpeed() * getCurrentGear());
    }

    @Override
    public void breaK() {
        setCurrentGear(getCurrentGear()-1);
        if (getSpeed() <= 0){
            setSpeed(0);
            System.out.println("Машина остановилась");
        }else setSpeed(getSpeed() / 2);
    }


    @Override
    public String toString() {
        return "Текущая передача: " + getCurrentGear() +
                " Текущая скорость: " + getSpeed() +
                " Максимальная передача: " + getMaxGear();
    }

}
