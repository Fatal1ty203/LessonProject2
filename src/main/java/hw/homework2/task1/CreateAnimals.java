package hw.homework2.task1;

import java.util.ArrayList;
import java.util.List;

public class CreateAnimals {
    public static List<Animal> create(){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Reptile("Молодая черепашка)", 50,20,3));
        animals.add(new Reptile("Самая старая черепашка, по имени Наташка))",175,24,4));
        animals.add(new Reptile("frog",12,12,17));
        animals.add(new Mammoth("Dog", 5,8,23,"Gav-Gav-Gav"));
        animals.add(new Mammoth("Cat",3,5,0,"Myau-Myau-Myau"));
        animals.add(new Mammoth("Cow",1,70,6,"Mu-Mu-Mu"));
        return animals;
    }
}
