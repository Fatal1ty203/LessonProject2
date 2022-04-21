package hw.homework_stream_part2.task9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Deposit> sberDeposit = List.of(new Deposit(10,0.06),new Deposit(5,0.1));
        List<Deposit> vtbDeposit = List.of(new Deposit(12,0.07),new Deposit(8, 0.12));
        List<Bank> banks = List.of(new Bank("Sber",sberDeposit),new Bank("VTB",vtbDeposit));

        banks.stream().map(Bank::getDepositList).forEach(System.out::println);

        banks.stream().map(Bank::getDepositList)
                .flatMap(Collection::stream)
                .max(Comparator.comparing(val -> val.getPercent() * val.getTerm()))
                .ifPresent(System.out::println);

    }
}
