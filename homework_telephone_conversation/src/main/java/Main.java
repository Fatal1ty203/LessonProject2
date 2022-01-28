import task.abonent.Abonent;
import task.tellService.TellService;

public class Main {
    public static void main(String[] args) {
        Abonent a1 = Abonent.createAbonent("Нео", 2351);
        Abonent a2 = Abonent.createAbonent("Морфиус", 4444555);

        TellService.tell(a2,a1);
    }
}
