package hw.homework2.task2;

import java.util.ArrayList;
import java.util.List;

public class Apple extends Company{
    private List<String> model;

    public Apple(String lastNameDirector, int workers) {
        super(lastNameDirector, workers);
        this.model = new ArrayList<>();
    }

    public static void addModel(List<Company> companies, String name) {
        for (Company f : companies) {
            if (f.getClass() == Apple.class) {
                ((Apple) f).addM(name);
            }
        }
    }

    public boolean addM(String name){
       return model.add(name);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", phone model = " + model ;
    }
}
