package hw.homework_wildcards.taskTwo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        List<TicTocAccount> list = new ArrayList<>(List.of(new TicTocAccount("user1", "123"), new TicTocAccount("user2", "123")));

        List<FaceBookAccount> list2 = new ArrayList<FaceBookAccount>(List.of(new FaceBookAccount("user1", "123"), new FaceBookAccount("user2", "123")));

        for(int i = 0; i < 7; i++){
            list.forEach(acc-> acc.createVideo());
            list2.forEach(acc-> acc.createPost());
        }

        System.out.println("Before ban");
        ServiceNetwork.accountPrint(list);
        ServiceNetwork.accountPrint(list2);

        ServiceNetwork.accountBan(list);
        ServiceNetwork.accountBan(list2);

        System.out.println("After ban");
        ServiceNetwork.accountPrint(list);
        ServiceNetwork.accountPrint(list2);
    }
}
