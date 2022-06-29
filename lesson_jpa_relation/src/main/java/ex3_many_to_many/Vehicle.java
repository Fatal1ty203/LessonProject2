package ex3_many_to_many;
import ex1_one_to_one.Person;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor

public class Vehicle {
    @Id //говорим, что поле id будет айдишником
    @GeneratedValue(strategy = GenerationType.IDENTITY) //автоинкремент
    private int id;
    @NonNull private String name;
    @NonNull private int maxSpeed;
    @NonNull private int price;




    @JoinTable(
            name = "owner_vehicle",
            joinColumns = @JoinColumn(name="vehicle_id"), //тут указываем название внешнего ключа, который будет относиться к таблице Vehicle
            inverseJoinColumns = @JoinColumn(name="owner_id") //тут указываем название внешнего ключа, который будет относиться к другой связанной таблице

    )
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //mappedBy всегда пишется на стороне главной таблицы
    private List<Owner> ownerList = new ArrayList<>();


}
