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

public class Person {
    @Id //говорим, что поле id будет айдишником
    @GeneratedValue(strategy = GenerationType.IDENTITY) //автоинкремент
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String surname;

    public Person(int id, @NonNull String name, @NonNull String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @OneToOne(mappedBy = "person") //mappedBy всегда пишется на стороне главной таблицы
    private Passport passport;

    @OneToOne(mappedBy = "person") //mappedBy всегда пишется на стороне главной таблицы
    private Car car;




}
