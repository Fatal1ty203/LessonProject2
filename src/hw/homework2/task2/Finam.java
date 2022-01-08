package hw.homework2.task2;

public class Finam extends Company {
    private int commission;

    public Finam(String lastNameDirector, int workers, int commission) {
        super(lastNameDirector, workers);
        this.commission = commission;
    }

    public int increaseCommission(int n){
        return commission += n;
    }

    public int decrease(int n){
        return commission -= n;
    }

    @Override
    public String toString() {
        return super.toString() + ", Компания - Finam, " +
                ", Broker's commission = " + commission;
    }
}
