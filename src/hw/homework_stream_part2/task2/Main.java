package hw.homework_stream_part2.task2;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Human> humanList = List.of(new Human("Vasiliy", new Passport("Russia")),
                new Human("Petya", new Passport("USA")),
                new Human("Syn Ho", new Passport("China")),
                new Human("Hin Cho", new Passport("China")),
                new Human("Ibrahim", new Passport("Russia")));


        List<Passport> china = humanList.stream()
                .map(Human::getPassport)
                .filter(val -> val.getCountry().equalsIgnoreCase("china"))
                .toList();
    }
}
