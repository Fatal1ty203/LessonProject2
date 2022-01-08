package hw.homework3_abstract.task1;

public final class Charger extends ManualCar {
    public Charger(){
        this.setMaxGear(6);
        this.setName("Charger");

    }

    @Override
    public void setSpeed(int speed) {
        if (speed < 260 && speed > 0) {
            super.setSpeed(speed);
        }else if (speed > 260){
            super.setSpeed(260);
        }
    }


    @Override
    public void gas() {
        super.gas();
        setSpeed(getSpeed() * 2);
    }

    @Override
    public void breaK() {
        super.breaK();
        setSpeed(getSpeed() / 2);
    }
}
