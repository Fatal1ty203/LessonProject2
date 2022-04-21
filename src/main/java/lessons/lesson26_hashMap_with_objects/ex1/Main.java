package lessons.lesson26_hashMap_with_objects.ex1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Создать базу пользователей, где ключом является аккаунт, а значением является Подписка на сервис (какой-нибудь)

        HashMap<Account, Subscribe> map = new HashMap<>();
        List<Subscribe> subscribList = new ArrayList<>();
        subscribList.add(new Subscribe("Netflix", 20));
        subscribList.add(new Subscribe("Youtube", 120));
        subscribList.add(new Subscribe("Kinopoisk", 220));
        map.put(new Account("user1", "123"), subscribList.get(0));
        map.put(new Account("user2", "123"), subscribList.get(0));
        map.put(new Account("user3", "123"), subscribList.get(1));

        //Предположим, мы хоти узнать подписку юзера
        //Юзер вводит свой логин пароль с консоли
        String userLogin = "user1";
        String userPassword = "123";

        Subscribe subscribe = map.get(new Account(userLogin, userPassword));
        System.out.println(subscribe);

    }
}
class Subscribe {
    String type;
    int duration; //срок подписка

    public Subscribe(String type, int duration) {
        this.type = type;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Subscribe{" +
                "type='" + type + '\'' +
                ", duration=" + duration +
                '}';
    }
}

class Account{
    String login;
    String password;

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(login, account.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}

