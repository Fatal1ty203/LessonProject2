package lessons.lesson41_synchronization.ex1_provider_consumer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Сделать общий список товаров
        //Сделать поставщиков, работающих в параллельном потоке
        //Сделать покупателей, работающих в параллельном потоке


        //общий список товаров
        List<Integer> products = new ArrayList<>();

        Provider provider1 = new Provider(products, 0);
        Provider provider2 = new Provider(products,10);

        Consumer consumer1 = new Consumer(products);
        Consumer consumer2 = new Consumer(products);

        provider1.start();
        provider2.start();

        consumer1.start();
        consumer2.start();


    }
}

//Поставщик
class Provider extends Thread {
    List<Integer> products;
    int productId;

    public Provider(List<Integer> products, int startProductId) {
        this.products = products;
        productId = startProductId;

    }

    //поставляет товар в список
    public void provide() {

        System.out.println("Поставищик "+getName()+" поставил товар " + productId);
        products.add(productId);
        productId++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //Каждый поставщик будет поставлять 5 товаров
        for (int i = 0; i < 5; i++) {
            provide();
        }
    }
}

//Покупатель (потребитель)
class Consumer extends Thread {
    List<Integer> products;

    public Consumer(List<Integer> products) {
        this.products = products;
    }


    //покупатель покупает товар
    public boolean consume() {
        if (!products.isEmpty()) {
            Integer product = products.remove(0);
            System.out.println("Потребитель "+getName()+" купил товар " + product);
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        //Каждый потребитель будет потреблять 5 товаров
        System.out.println("Поставищк старт");
        for (int i = 0; i < 5;) {
            synchronized (products) {
                if (consume()) {
                    i++;
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Поставищк стоп");



    }

}






