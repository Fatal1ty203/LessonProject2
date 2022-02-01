package hw.homework_Restaurant_Terminal;

import java.util.*;

public class Service {
    private Map<Client, List<Dish>> orders = new HashMap<>();
    private int counterClients = 0;

    public void addClient(String name, double balance){
        orders.put(new Client(name,balance),null);
        counterClients++;
    }

    public void addClient(Client client){
        orders.put(client,null);
        counterClients++;
    }

    public void addDish(Client client, Dish dish) {
        if (getClient(client) == null) {
            throw new ClientNullException("Такого клиента нет");
        } else if (dish == null) {
                throw new DishisNullException("Вы передаете не существующее блюдо");
        } else {
            for (Map.Entry<Client,List<Dish>> map : orders.entrySet()){
                if (map.getKey().equals(client)){
                    if (map.getValue()==null){
                        map.setValue(new LinkedList<>());
                        map.getValue().add(dish);
                    }else {
                        map.getValue().add(dish);
                    }
                }
            }
        }
    }

    public double getTotalPrice(Client client) {
        double result = 0;
        if (getClient(client) == null) {
            return 0;
        } else {
            for (Dish dish : getDishList(client)){
                result += dish.getPrice();
            }
        }
        return result;
    }

    private List<Dish> getDishList(Client client){
        List<Dish> dishes = null;
        for (Map.Entry<Client, List<Dish>> map : orders.entrySet()) {
            if (map.getKey().equals(client)) {
                dishes = map.getValue();
            }
        }
        return dishes;
    }

    public String makeBill(Client client){
        Client client1 = getClient(client);
        client1.setBalance(client.getBalance() - getTotalPrice(client));
        String s = "";
        if (client1.getBalance()<0){
                throw new NotEnoughClientBalanceException("Недостаток средств, будешь мыть полы!");
        }else {
            for (Dish dish : getDishList(client)){
                s += dish + "\n";
            }
            s += "Итого: " + getTotalPrice(client) + "\n";
            s +="Имя клиента: " + client1.getName();
        }
        return s;
    }

    private Client getClient(Client client) {
        Client client1 = null;
        for (Map.Entry<Client,List<Dish>> map : orders.entrySet()){
            if (map.getKey().equals(client))return map.getKey();
        }
        return client1;
    }

    public Client getClientForName(String name){
        for (Map.Entry<Client, List<Dish>> map : orders.entrySet()){
            if (map.getKey().getName().equalsIgnoreCase(name)) return map.getKey();
        }
        return null;
    }

    public Client getClientForID(int id){
        for (Map.Entry<Client, List<Dish>> map : orders.entrySet()){
            if (map.getKey().getNumber() == id) return map.getKey();
        }
        return null;
    }

    public boolean getClient(String name){
        for (Map.Entry<Client, List<Dish>> map : orders.entrySet()){
            if (map.getKey().getName().contains(name)) return true;
        }
        return false;
    }

    private Dish getDish(Dish dish) {
        if (orders.get(dish).equals(dish)) return dish;
        else return null;
    }

    public int getCounterClients() {
        return counterClients;
    }
}
