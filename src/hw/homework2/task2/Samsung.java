package hw.homework2.task2;

import java.util.ArrayList;
import java.util.List;

public class Samsung extends Company{
    private List<String> model;

    public Samsung(String lastNameDirector, int workers) {
        super(lastNameDirector, workers);
        this.model = new ArrayList<>();
    }

    public boolean addModel(String name){
        return model.add(name);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", phone model = " + model;
    }
}
