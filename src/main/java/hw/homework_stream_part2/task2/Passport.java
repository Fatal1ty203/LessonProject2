package hw.homework_stream_part2.task2;

import java.util.Random;

public class Passport {
    private int series;
    private int number;
    private String country;

    public Passport(String country) {
        this.series = generateSeries();
        this.number = generateNumber();
        this.country = country;
    }

    public int getSeries() {
        return series;
    }

    public int getNumber() {
        return number;
    }

    public String getCountry() {
        return country;
    }

    private int generateSeries(){
        int rage = 9999;
        Random random = new Random();
        return (1000 + random.nextInt(rage - 1000));
    }

    private int generateNumber(){
        int rage = 99999;
        Random random = new Random();
        return (10000 + random.nextInt(rage - 10000));
    }

    @Override
    public String toString() {
        return "Passport{" +
                "series=" + series +
                ", number=" + number +
                ", country='" + country + '\'' +
                '}';
    }
}
