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
public class Passport {
    @Id //говорим, что поле id будет айдишником
    @GeneratedValue(strategy = GenerationType.IDENTITY) //автоинкремент
    private int id;
    @NonNull private int seria;
    @NonNull private int number;
    @NonNull private int age;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "person_id") //создаем колонку - внений ключ с названием person_id
    private Person person;


}
