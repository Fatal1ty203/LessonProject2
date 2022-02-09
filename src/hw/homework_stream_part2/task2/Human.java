package hw.homework_stream_part2.task2;

public class Human {
    private String name;
    private Passport passport;

    public Human(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public Passport getPassport() {
        return passport;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", passport=" + passport +
                '}';
    }
}
