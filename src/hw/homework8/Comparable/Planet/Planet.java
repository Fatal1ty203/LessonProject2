package hw.homework8.Comparable.Planet;


public class Planet implements Comparable<Planet> {
    String name;
    double diameter;
    Planet(String name, double diameter){
        this.name = name;
        this.diameter = diameter;
    }

//    @Override
//    public int compare(Planet o1, Planet o2) {
//        double difference = o1.diameter - o2.diameter;
//        if (difference == 0) return 0;
//        else if(difference<0) return -1;
//        return 1;
//    }

    @Override
    public String toString() {
        return "Планета: " + name +
                ", Диаметр: " + diameter +
                "\n";
    }

    @Override
    public int compareTo(Planet o) {
        double difference = diameter - o.diameter;
        if (difference == 0) return 0;
        else if(difference<0) return -1;
        return 1;
    }
}


