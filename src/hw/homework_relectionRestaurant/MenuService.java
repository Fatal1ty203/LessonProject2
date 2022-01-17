package hw.homework_relectionRestaurant;

import java.util.*;

public class MenuService {
    private Map<Client, Order> menu = new HashMap<>();
    private Scanner scn = new Scanner(System.in);

    public void createOrder(){
        System.out.println("Как я могу к Вам обращаться?");
        String name = scn.nextLine();
        menu.put(new Client(name), new Order());
        addDish(name);
        getClient(name).setPaid(false);
    }

    public void addDish(String name){
        System.out.println("Пожалуйста введите название блюда: ");
        scn.next();
        String dishName = scn.nextLine();
        System.out.println("Введите цену блюда");
        int price = scn.nextInt();
        menu.get(new Client(name)).addDish(dishName,price);
        getClient(name).paid = false;
    }

    public void getReceipt(String name){
        System.out.println(menu.get(new Client(name)).getDished());
        System.out.println(getClient(name));
        getClient(name).paid = true;
        System.out.println("Итого: " + getFullCost(name));
        deleteOrder(name);
    }

    private void deleteOrder(String name){
        Set<Map.Entry<Client, Order>> clients = menu.entrySet();
        for (Map.Entry<Client,Order> map : clients){
            if (map.getKey().equals(new Client(name))){
                map.setValue(null);
            }
        }
    }

    private Client getClient(String name){
        Client client = null;
        Set<Map.Entry<Client, Order>> clients = menu.entrySet();
        for (Map.Entry<Client,Order> map : clients){
            if (map.getKey().equals(new Client(name))) {
                return map.getKey();
            }
        }
        return client ;
    }

    private int getFullCost(String name){
        int result = 0;
        for (Map.Entry<Client, Order> map : menu.entrySet()){
            for (Dish dish : map.getValue().getDished()){
                result += dish.getPrice();
            }
        }
        return result;
    }

    public Set<Client> getPaid(){
        Set<Map.Entry<Client, Order>> clients = menu.entrySet();
        Set<Client> cl = new HashSet<>();
        for (Map.Entry<Client, Order> map : clients){
            if (!map.getKey().paid){
                cl.add(map.getKey());
            }
        }
        return cl;
    }

    private Map<Client, Order> getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return "Service{" +
                "menu=" + menu +
                '}';
    }
}
