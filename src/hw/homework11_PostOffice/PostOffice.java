package hw.homework11_PostOffice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PostOffice {
    private HashMap<Address, ArrayList<Post>> parcels;
    private ArrayList<Client> clients;
    private ArrayList<Client> receivedTheParcel = new ArrayList<>();
    private ArrayList<Post> deliveredParcels = new ArrayList<>();
    private ArrayList<Post> noDeliveredParcels = new ArrayList<>();

    public PostOffice() {
        this.parcels = new HashMap<>();
        this.clients = new ArrayList<>();
    }


    public void addClient(String name, Address address){
        Client client = new Client(name,address);
        clients.add(client);
    }

    public void addParcels(Address address, Post post){
        if (!parcels.containsKey(address)){
            parcels.put(address,new ArrayList<>());
        }
        parcels.get(address).add(post);
    }

    public void startDeliver(){
        deliver();
        System.out.println("Посылки: " + getDeliveredParcels() + " были доставлены клиентам: " + getReceivedTheParcel());
        System.out.println("Посылки, которые не были доставелны: " + getNoDeliveredParcels());
    }

    private void deliver(){
        for (Map.Entry<Address,ArrayList<Post>> item : parcels.entrySet()){
            for (Client client : clients){
                if (client.getAddress().equals(item.getKey())){
                    receivedTheParcel.add(client);
//                    clients.remove(client);
//                    parcels.remove(item);

                    deliveredParcels.addAll(item.getValue());
                }else {
                    noDeliveredParcels.addAll(item.getValue());
                }
            }
        }
    }

    public ArrayList<Client> getReceivedTheParcel() {
        return receivedTheParcel;
    }

    public ArrayList<Post> getDeliveredParcels() {
        return deliveredParcels;
    }

    public ArrayList<Post> getNoDeliveredParcels() {
        return noDeliveredParcels;
    }
}
