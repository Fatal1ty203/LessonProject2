package lessons.lesson42_synch2.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Добавить поставщиков, который поставляют 10 кирпичей в список brickList
        //Строители не должны заканчивать работу до тех пор, пока либо есть кирпичи, либо пока поставщики их поставляют
        List<Brick> brickList = new ArrayList<>();
        List<Brick> houseList = new ArrayList<>();
        Random rnd = new Random();
        Nadziratel nadziratel = new Nadziratel();//следит за тем, пора ли заканчить работу строителям с помощью метода isFInish
        Thread thProvider1 = new Thread(new BrickProvider(brickList));
        Thread thProvider2 = new Thread(new BrickProvider(brickList));
        nadziratel.add(thProvider1);
        nadziratel.add(thProvider2);
        thProvider1.start();
        thProvider2.start();

        Thread thBuilder1 = new Thread( new Builder(brickList, houseList,nadziratel), "builder1");
        Thread thBuilder2 = new Thread( new Builder(brickList, houseList,nadziratel), "builder2");
        thBuilder1.start();
        thBuilder2.start();


    }


}

class BrickProvider implements Runnable {
    List<Brick> brickList;



    public BrickProvider(List<Brick> brickList) {
        this.brickList = brickList;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            synchronized (brickList) {
                Brick brick = new Brick(true);
                brickList.add(brick);
                System.out.println(Thread.currentThread().getName() + " поставил кирпич с id = " + brick.id);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}

class Nadziratel{
    //список поставщиков, выполняющих добавление кирпичей
    List<Thread> providerList = new ArrayList<>();

    public void add(Thread providerThread){
        providerList.add(providerThread);
    }


}
class Builder implements Runnable {
    List<Brick> brickList;
    List<Brick> houseList;
    Nadziratel nadziratel;

    public Builder(List<Brick> brickList, List<Brick> houseList, Nadziratel nadziratel) {
        this.brickList = brickList;
        this.houseList = houseList;
        this.nadziratel = nadziratel;
    }

    boolean isFinish(){
        //если еще есть кирпичи для разгрузки, заканчивать рано
        if(brickList.size()>0) return false;
        for (Thread provider : nadziratel.providerList) {
            //если поток еще работает, то заканчивать рано
            if(provider.isAlive()) return false;
        }
        return true;
    }
    @Override
    public void run() {

        while (!isFinish()) {
            //th1

            synchronized (brickList) {

                if (brickList.size() > 0) {
                    Brick b = brickList.remove(0); //0
                    if (b.isOk) {
                        houseList.add(b);
                        System.out.println(Thread.currentThread().getName() + " взял кирпич с id = " + b.id);
                    } else {
                        System.out.println(Thread.currentThread().getName() + " выкинул браковынй кирпич с id = " + b.id);
                    }
                }
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}

class Brick {
    int id;
    boolean isOk; //бракованный или нет
    static int currentId = 0;

    public Brick(boolean isOk) {
        this.isOk = isOk;
        id = currentId++;
    }

    @Override
    public String toString() {
        return "Brick{" +
                "id=" + id +
                ", isOk=" + isOk +
                '}';
    }
}
