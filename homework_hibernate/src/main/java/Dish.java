import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String category;
    boolean vega;
    double calories;

    public Dish(String name, String category, boolean vega, double calories) {
        this.name = name;
        this.category = category;
        this.vega = vega;
        this.calories = calories;
    }

}
