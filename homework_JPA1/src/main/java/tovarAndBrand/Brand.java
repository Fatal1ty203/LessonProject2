package tovarAndBrand;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String country;

    public Brand(String name, String country) {
        this.name = name;
        this.country = country;
    }

    @OneToMany(mappedBy = "brand")
    List<Tovar> tovarList = new ArrayList<>();
}
