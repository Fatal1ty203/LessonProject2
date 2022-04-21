package hw.homework11_set.HashSet;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<UserAccount> userAccounts = new HashSet<>();
        userAccounts.add(new UserAccount("user1",123));
        userAccounts.add(new UserAccount("user2",223));
        userAccounts.add(new UserAccount("user3",323));
        System.out.println(userAccounts);
        userAccounts.add(new UserAccount("user1",111));
        System.out.println(userAccounts);
        userAccounts.add(new UserAccount("user4",234));
        System.out.println(userAccounts);
    }
}
