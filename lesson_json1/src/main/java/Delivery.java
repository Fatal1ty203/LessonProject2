import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    String address; //адрес доставки
    Tovar tovar; //доставляемый товар
    @JsonIgnore
    int tips; //чаевые


}
