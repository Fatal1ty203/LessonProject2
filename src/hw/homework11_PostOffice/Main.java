package hw.homework11_PostOffice;

public class Main {
    public static void main(String[] args) {
        PostOffice postOffice = new PostOffice();
        postOffice.addClient("Vasiliy",new Address("Moscow","Butlerova",150,12));
        postOffice.addParcels(new Address("Moscow","Butlerova",150,12),
                new Post("Telefon",new Address("Moscow","Butlerova",150,12)));
        postOffice.addParcels(new Address("Moscow","Butlerova",150,12),
                new Post("Apple", new Address("Moscow","Butlerova",150,12)));
        postOffice.addParcels(new Address("Moscow123","Butlerova",150,12),
                new Post("Apple", new Address("Moscow","Butlerova",150,12)));
        postOffice.startDeliver();

//        System.out.println(postOffice.getReceivedTheParcel());
    }
}
