package hw.homework_wildcards.taskTwo;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ServiceNetwork {

    public static void accountBan(List<? extends Account> accounts){
        List<? extends Account> ac = accounts;
        for (int i = 0; i < ac.size(); i ++){
            if (ac.get(i).getWarnings() >=5){
                accounts.remove(i);
            }
        }
    }

    public static void accountPrint(List<? extends  Account> accounts){
        Iterator iterator = accounts.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
