package hw.homework_stream_part2.task3;

public class Temperature {
    private double averageTemperature;

    public Temperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "averageTemperature=" + averageTemperature +
                '}';
    }
}
