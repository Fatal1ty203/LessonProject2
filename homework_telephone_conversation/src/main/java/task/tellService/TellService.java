package task.tellService;

import task.abonent.Abonent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class TellService {
    static Scanner scn = new Scanner(System.in);
    static Logger logger = LoggerFactory.getLogger(TellService.class);

    public static void tell(Abonent abonent, Abonent abonent2){
        int input = 0;
        logger.info(abonent2.getName() + " звонит абоненту: " + abonent.getName());
        System.out.println("1. ответить на звонк\n" +
                "2. сбросить вызов");
        input = scn.nextInt();
        scn.nextLine();
        logger.debug("Было нажато: " + input); ;
        if (input==1) {
            logger.info(abonent.getName() + " принимает звонок от абонента " + abonent2.getName());
            voice(abonent2,abonent);
        }
        else {
            logger.warn(abonent.getName() + " отклонин вызов от абонент " + abonent2.getName());
            System.out.println("Ведите сообщение для пользователя: ");
            String message = scn.nextLine();
            scn.next();
            logger.info("Абонент: " + abonent2.getName() + " Оставил сообщение: " + message + " абоненту " + abonent.getName());
        }
    }

    private static void voice(Abonent abonent, Abonent abonent2){

        Abonent a1 = abonent;
        Abonent a2 = abonent2;

        String message = "aaa";
        while (message.length() > 0){
            System.out.print(a1.getName() + ": ");
            message = scn.nextLine();
            System.out.print(a1.getName() + ": " + message);
            logger.debug(a1 + ": " + message);
            Abonent tmp = a1;
            a1 = a2;
            a2 = tmp;
        }
    }
}
