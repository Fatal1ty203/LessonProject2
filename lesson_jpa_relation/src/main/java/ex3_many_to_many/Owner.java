package ex3_many_to_many;

import ex1_one_to_one.Car;
import ex1_one_to_one.Passport;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor

public class Owner {
    @Id //говорим, что поле id будет айдишником
    @GeneratedValue(strategy = GenerationType.IDENTITY) //автоинкремент
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String surname;

    public Owner(int id, @NonNull String name, @NonNull String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "ownerList") //mappedBy всегда пишется на стороне главной таблицы
    private List<Vehicle> vehicleList = new ArrayList<>();

}
