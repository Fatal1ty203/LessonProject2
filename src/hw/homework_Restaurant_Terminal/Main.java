package hw.homework_Restaurant_Terminal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Service service = new Service();
        int input = 0;
        while (input != 5){
            System.out.println("1. Добавить блюдо в заказ клиенту (если клиент еще не делал заказ, " +
                    "он вводит только свое имя, баланс и желаемое блюдо. " +
                    "В этом случае нужно создать объект Client с новым уникальным номером. " +
                    "Если клиент уже сделал заказ и хочет добавить в него новое блюдо, " +
                    "он вводит только свой номер и желаемое блюдо)\n" +
                    "2. Посчитать итоговую сумму по заказу клиента (клиент вводит только свой номер)\n" +
                    "3. Расчитать клиента (клиент вводит свой номер, выводится чек и заказ удаляется из системы)\n" +
                    "4. Вывести всех нерасчитанных клиентов (выводятся имя и номер клиентов, которые еще не рассчитались)");
            input = scn.nextInt();
            if (input == 1){
                System.out.println("Введите Ваше имя: ");
                String name = scn.next();
                if (service.getClient(name)){
                    System.out.println("Введите название блюда: ");
                    String nameDish = scn.nextLine();
                    System.out.println("Введите цену блюда: ");
                    double dishPrice = scn.nextDouble();
                    Dish dish = new Dish(nameDish, dishPrice);
                    service.addDish(service.getClientForName(name),dish);
                }else {
                    System.out.println("Введите Ваш баланс: ");
                    double balance = scn.nextDouble();
                    scn.nextLine();
                    Client client = new Client(name,balance);
                    service.addClient(client);
                    System.out.println("Введите название блюда: ");
                    String nameDish = scn.nextLine();
                    System.out.println("Введите цену блюда: ");
                    double dishPrice = scn.nextDouble();
                    Dish dish = new Dish(nameDish,dishPrice);
                    service.addDish(client,dish);
                }
            }else if (input == 2){
                System.out.println("Введите Ваш номер: ");
                int number = scn.nextInt();
                System.out.println(service.getTotalPrice(service.getClientForID(number)));
            }else if (input == 3){
                System.out.println("Введите Ваш номер: ");
                int number = scn.nextInt();
                System.out.println(service.getClientForID(number).getNumber());
                System.out.println(service.makeBill(service.getClientForID(number)));
            }
        }
    }
}
