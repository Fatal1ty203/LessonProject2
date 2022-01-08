package hw.homework3_abstract.task1;

abstract class Car {
    private int minGear, maxGear,currentGear, speed;
    private String name;

    public Car() {
    }

    public Car(int minGear, int maxGear) {
        this.minGear = minGear;
        this.maxGear = maxGear;
    }

    public abstract void gas();
    public abstract void breaK();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinGear() {
        return minGear;
    }

    public void setMinGear(int minGear) {
        if (minGear >= 0) {
            this.minGear = minGear;
        }else System.out.println("Такой передачи не может быть");
    }

    public int getMaxGear() {
        return maxGear;
    }

    public void setMaxGear(int maxGear) {
        this.maxGear = maxGear;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public int getSpeed() {
        if (speed > 0) {
            return speed;
        } else {
            return 0;
        }
    }

    public boolean isActualGear(int gear){
        if (gear >= 0 && gear <= getMaxGear()){
            return true;
        }else return false;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setCurrentGear(int currentGear) {
        if (currentGear <= getMaxGear()) {
            this.currentGear = currentGear;
        }else this.currentGear = getMaxGear();
    }





}
