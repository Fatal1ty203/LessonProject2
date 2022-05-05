package ex2_one_to_many;

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


public class User {
    @Id //говорим, что поле id будет айдишником
    @GeneratedValue(strategy = GenerationType.IDENTITY) //автоинкремент
    private int id;
    @NonNull
    private String name;

    public User(@NonNull String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "user") //mappedBy всегда пишется на стороне главной таблицы
    private List<Account> accountList = new ArrayList<>();





}
