package lessons.lesson26_hashMap_with_objects.ex2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        //Сделать несколько подписок под ключом

        HashMap<Account, List<Subscribe>> map = new HashMap<>();
        List<Subscribe> subscribList = new ArrayList<>();
        subscribList.add(new Subscribe("Netflix", 20));
        subscribList.add(new Subscribe("Youtube", 120));
        subscribList.add(new Subscribe("Kinopoisk", 220));



        //Предположим, мы хоти узнать подписку юзера
        //Юзер вводит свой логин пароль с консоли
        String userLogin = "user1";
        String userPassword = "123";
        Account userAccount = new Account(userLogin, userPassword);
        //если мап еще не содержит ключа, то создаем ключ с пустыми списком в виде значения
        if(!map.containsKey(userAccount)) {
            map.put(userAccount, new ArrayList<>());
        }
        //теперь получаем список по ключу (map.get(userAccount)) и в этот список добавляем подписку (add(subscribList.get(0)))
        map.get(userAccount).add(subscribList.get(0));




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

