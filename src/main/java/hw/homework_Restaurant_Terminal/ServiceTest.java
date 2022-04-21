package hw.homework_Restaurant_Terminal;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    Service service = new Service();
    Client client = new Client("c1",200);
    Dish dish = new Dish("d1", 50);

    @BeforeEach
    void clearStaticId(){
        Client.clearStaticId();
    }

    @Test
    void testAddNewClient() {
        service.addClient(client);
        int expected = 1;
        int actual = service.getCounterClients();
        Assertions.assertEquals(expected,actual);
        Assertions.assertEquals(expected,client.getNumber());
    }

    @Test
    void testClientNullException(){
        Assertions.assertThrows(ClientNullException.class, ()-> service.addDish(client,dish));
    }

    @Test
    void testDishisNullException(){
        service.addClient(client);
        Assertions.assertThrows(DishisNullException.class,()-> service.addDish(client,null));
    }

    @Test
    void testGetTotalPrice_regular_price() {
        service.addClient(client);
        service.addDish(client,dish);
        Assertions.assertEquals(1,service.getCounterClients());
        Assertions.assertEquals(50,service.getTotalPrice(client));
    }

    @Test
    void testMakeBillSubjectNotEnoughClientBalanceException() {
        service.addClient(client);
        Dish dish = new Dish("d1",210);
        service.addDish(client,dish);
        Assertions.assertThrows(NotEnoughClientBalanceException.class, ()-> service.makeBill(client));
    }

    @Test
    void testMakeBill_Regular(){
        service.addClient(client);
        service.addDish(client,dish);
        System.out.println(service.makeBill(client));
        System.out.println(service.getClientForID(1).getBalance());
        Assertions.assertEquals(150,service.getClientForID(1).getBalance(),0.1);
        Assertions.assertEquals(true,service.getClientForID(1).isPay());
    }

    @Test
    void testGetClient_True(){
        service.addClient(client);
        Assertions.assertEquals(true,service.getClient("c1"));
    }

    @Test
    void testGetClient_False(){
        Assertions.assertEquals(false,service.getClient("c1"));
    }

    @Test
    void testGetClient_ID(){
        service.addClient(client);
        service.addDish(client,dish);
        System.out.println(service.getClientForID(1).getName());
    }

    @Test
    void testGetClientForIDReturnNULL(){
        Assertions.assertEquals(null,service.getClientForID(2));
    }

    @Test
    void testGetClientList_Regular_return_false(){
        service.addClient(client);
        service.addDish(client,dish);
        Assertions.assertEquals(false,service.getClientList().get(0).isPay());
    }
    @Test
    void testGetClientList_Regular_return_true_AND_addDish_return_false(){
        service.addClient(client);
        service.addDish(client,dish);
        service.makeBill(client);
        Assertions.assertEquals(true,service.getClientList().get(0).isPay());
        service.addDish(client,dish);
        Assertions.assertEquals(false,service.getClientForID(1).isPay());
    }

}