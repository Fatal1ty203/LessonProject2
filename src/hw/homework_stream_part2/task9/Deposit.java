package hw.homework_stream_part2.task9;

public class Deposit {
    private int term;
    private double percent;

    public Deposit(int term, double percent) {
        this.term = term;
        this.percent = percent;
    }

    public int getTerm() {
        return term;
    }

    public double getPercent() {
        return percent;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "term=" + term +
                ", percent=" + percent +
                '}';
    }
}
