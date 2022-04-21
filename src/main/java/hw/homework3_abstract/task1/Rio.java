package hw.homework3_abstract.task1;

public final class Rio extends AutoCar{


    @Override
    public void setSpeed(int speed) {
        if (speed < 200 && speed > 0) {
            super.setSpeed(speed);
        }else if (speed > 200){
            super.setSpeed(200);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " " + getName();
    }

    public Rio() {
        this.setMaxGear(5);
        setName("Rio");
    }


}
