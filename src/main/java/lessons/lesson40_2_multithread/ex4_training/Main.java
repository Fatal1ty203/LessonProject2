package lessons.lesson40_2_multithread.ex4_training;

public class Main {
    public static void main(String[] args) {
        //Создать класс Gun (оружение) с полями name - наименование оружия,
        // cartridgeCount - количество патрон,
        // скорость стрельбы (интервал времени в миллисекундах, через который выполняется следующий выстрел).
        //Создать в классе методы:
        //public void makeShot() - который выводит на консоль текст "Сделан выстрел из оружия [название].
        // Осталось [количество] патрон".
        //public void strikeAllCartrides() - выстреливает все патроны из обоймы с помощью метода makeShot.
        //В мейне создать два оружия, выстрелы из которых должны осуществляться одновременно и начинаться одновременно. Выстрелы из оружия реализовать в двух порожденных потоках.


        Gun gun1 = new Gun("gun1", 10, 200);
        Gun gun2 = new Gun("gun2", 5, 400);

        new Thread(gun1::makeAllShots).start();
        new Thread(()->gun2.makeAllShots()).start();
    }
}

class Gun {
    String name;
    int bulletCount;
    int delay;

    public Gun(String name, int bulletCount, int delay) {
        this.name = name;
        this.bulletCount = bulletCount;
        this.delay = delay;
    }

    public void makeAllShots(){
        while(bulletCount-- > 0) {
            System.out.printf("Сделан выстрел из оружия %s. Осталось %d патрон%n", name, bulletCount);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
