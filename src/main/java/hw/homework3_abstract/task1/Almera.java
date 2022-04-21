package hw.homework3_abstract.task1;

public final class Almera extends AutoCar{

    public Almera() {
        this.setMaxGear(5);
        this.setName("Almera");
    }

    @Override
    public void setSpeed(int speed) {
        if (speed < 230 && speed > 0) {
            super.setSpeed(speed);
        }else if (speed > 230){
            super.setSpeed(230);
        }
    }

    @Override
    public String toString() {
        return super.toString()+ " " + getName();
    }
}
