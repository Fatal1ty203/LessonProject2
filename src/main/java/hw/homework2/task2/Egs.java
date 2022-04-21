package hw.homework2.task2;

import java.util.ArrayList;
import java.util.List;

public class Egs extends Company {
    private List<String> rate;

    public Egs(String lastNameDirector, int workers, int subscribers) {
        super(lastNameDirector, workers);
        this.rate = new ArrayList<>();
    }

    public boolean addRate(String name){
        return rate.add(name);
    }


}
