package hw.homework3_abstract.task1;

public final class Mustang extends ManualCar {
    public Mustang(){
        this.setMaxGear(5);
        setName("Mustang");
    }

    @Override
    public void setSpeed(int speed) {
        if (speed < 280 && speed > 0) {
            super.setSpeed(speed);
        }else if (speed > 280){
            super.setSpeed(280);
        }
    }


}
