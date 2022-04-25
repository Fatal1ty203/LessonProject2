import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {
    @Id //говорим, что поле id будет айдишником
    @GeneratedValue(strategy = GenerationType.IDENTITY) //автоинкремент
    private int id;
    private String name;
    private int price;
    private int rating;


    public Laptop(String name, int price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
}
