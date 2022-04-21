package hw.homework_stream_part2.task9;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Deposit> depositList;

    public Bank(String name, List<Deposit> depositList) {
        this.name = name;
        this.depositList = depositList;
    }

    public String getName() {
        return name;
    }

    public List<Deposit> getDepositList() {
        return depositList;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", depositList=" + depositList +
                '}';
    }
}
