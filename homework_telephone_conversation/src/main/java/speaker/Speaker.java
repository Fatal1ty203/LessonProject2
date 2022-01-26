package speaker;

import abonent.Abonent;
import com.sun.tools.javac.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tellService.TellService;

import java.util.Scanner;

public class Speaker {
    static Logger logger = LoggerFactory.getLogger(Speaker.class);
    String name;
    String message;
    int number;
    static Scanner scn = new Scanner(System.in);


    public void tell(Abonent abonent, Abonent abonent2){

    }

    public static void messages(Abonent abonent, String message){
      Speaker sp = new Speaker(abonent.getName(), message, abonent.getNumber());
      logger.info("Вы пропустили звонок");
      logger.info(sp.name + " оставил вам сообщение: " + sp.message + " номер абонента: " + sp.number);
    }

    private Speaker(String name, String message, int number) {
        this.name = name;
        this.message = message;
        this.number = number;
    }
}
