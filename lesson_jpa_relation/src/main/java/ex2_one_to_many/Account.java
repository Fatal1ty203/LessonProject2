package ex2_one_to_many;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor


public class Account {
    @Id //говорим, что поле id будет айдишником
    @GeneratedValue(strategy = GenerationType.IDENTITY) //автоинкремент
    private int id;
    @NonNull
    private String login;
    @NonNull
    private String password;

    public Account(@NonNull String login, @NonNull String password) {
        this.login = login;
        this.password = password;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;





}
