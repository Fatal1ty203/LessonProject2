package hw.homework9.pie;

import java.util.ArrayList;
import java.util.List;

public class Pie {
    private String name;
    private List<PieFilling> list;

    public Pie(String name) {
        this.name = name;
        this.list = new ArrayList<>();
    }

    public void addPieFilling(String name, double weight){
        list.add(new PieFilling(name,weight));
    }

    public List<PieFilling> getFilling(){
        return list;
    }

    private static class PieFilling {
        private String name;
        private double weight;

        public PieFilling(String name, double weight) {
            this.name = name;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "наименование = '" + name + '\'' +
                    ", вес = " + weight + "гр." + "\n";
        }
    }

    @Override
    public String toString() {
        return "Пирог: '"  + name + '\'' + ", ингредиенты: " + "\n" + list;
    }
}
