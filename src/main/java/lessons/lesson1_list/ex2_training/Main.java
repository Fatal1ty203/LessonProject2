package lessons.lesson1_list.ex2_training;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Реализовать систему авторизации.
        //Нужно создать класс Account c имя, логин, пароль
        //В мейне создать список юзеров и реализовать небольшое меню:
        //1. Войти
        //2. Зарегистрироваться
        //3. Выход

        ArrayList<Account> list = new ArrayList<>();
        list.add(new Account("Leonid", "Leonid123", "LE123"));
        list.add(new Account("Ivan", "Ivan123", "123"));

        //System.out.println("hello\nworld"); //\n - enter
        Scanner scn = new Scanner(System.in);

//        System.out.println("Enter age");
//        int age = scn.nextInt();
//        System.out.println("Enter  text");
//        //String text = scn.next(); //читает текст до встречи пробела
//        //scn.nextLine(); - способ решения проблемы 1
//        //scn = new Scanner(System.in); //сопосб решения проблемы nextLine 2
//        String text = scn.nextLine(); //читает весь текст целиком
//        System.out.println("text = "+text);
        int input = 0;
        boolean isExist1 = false;
        while (input!=3){
            System.out.println("1. Войти\n" +
                    "2. Зарегистрироваться\n" +
                    "3. Выход");
            input = scn.nextInt();
            if(input == 1){
                scn = new Scanner(System.in);
                System.out.println("Enter login");
                String login = scn.nextLine(); //А вообще здесь лучше scn.next(), потому что у него нет такого глюка
                System.out.println("Enter password");
                String password = scn.nextLine();

                boolean isExist = list.contains(new Account(null, login, password));
                if(isExist){
                    System.out.println("Вы вошли в систему");
                    isExist1 = true;
                }else{
                    System.out.println("Неверный логин или пароль");
                }
            }else if(input == 2){
                scn = new Scanner(System.in);
                System.out.println("Enter login");
                String login = scn.nextLine(); //А вообще здесь лучше scn.next(), потому что у него нет такого глюка
                System.out.println("Enter password");
                String password = scn.nextLine();
                System.out.println("Enter name");
                String name = scn.nextLine();
                list.add(new Account(name, login, password));


            }

        }
    }
}

class Account{
    String name, login, password;

    public Account(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        Account account = (Account) o;
        return login.equals(account.login) && password.equals(account.password);
    }

}

