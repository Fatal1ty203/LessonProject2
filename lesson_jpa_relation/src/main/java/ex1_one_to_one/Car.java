package ex1_one_to_one;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor

public class Car {
    @Id //говорим, что поле id будет айдишником
    @GeneratedValue(strategy = GenerationType.IDENTITY) //автоинкремент
    private int id;
    @NonNull private String name;
    @NonNull private int maxSpeed;
    @NonNull private int price;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "person_id") //создаем колонку - внений ключ с названием person_id
    private Person person;


}
