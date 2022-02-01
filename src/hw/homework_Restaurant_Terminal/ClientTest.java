package hw.homework_Restaurant_Terminal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    Client client = new Client("Vasia", 200);

    @Test
    void getName() {
        Assertions.assertEquals("Vasia",client.getName());
    }

    @Test
    void getBalance() {
        Assertions.assertEquals(200,client.getBalance(),0.05);
    }

    @Test
    void setBalance() {
        double expected = 190;
        client.setBalance(190);
        Assertions.assertEquals(190,client.getBalance());
    }


}