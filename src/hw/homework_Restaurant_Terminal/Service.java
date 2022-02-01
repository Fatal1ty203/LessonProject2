package hw.homework_Restaurant_Terminal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {
    private Map<Client, List<Dish>> orders = new HashMap<>();

    public void addDish(Client client, Dish dish){
        if (getClient(client)==null) {
            try {
                throw new ClientNullException("Такого клиента не существует");
            } catch (ClientNullException e) {
                e.printStackTrace();
            }
        }else if (getDish(dish)==null){
            try {
                throw new DishisNullException("Такого блюда не существует");
            } catch (DishisNullException e) {
                e.printStackTrace();
            }
        }else {
            orders.get(client).add(dish);
        }
    }

    private Client getClient(Client client){
        if (orders.get(client).equals(client)) return (Client) orders.get(client);
        else return null;
    }

    private Dish getDish(Dish dish){
        if (orders.get(dish).equals(dish)) return dish;
        else return null;
    }
}
