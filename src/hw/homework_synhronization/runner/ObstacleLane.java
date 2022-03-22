package hw.homework_synhronization.runner;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ObstacleLane extends Thread {
    List<Runner> runners;

    public ObstacleLane(List<Runner> runners) {
        this.runners = runners;
    }

    @Override
    public void run() {
        boolean graduated = false;
        int rnd;
        int count = 0;
        Runner runner = runners.remove(0);
        while (!graduated) {
                    try {
                        TimeUnit.SECONDS.sleep(1); // заставляем уснуть на 1 секунду
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (runners) { // синхранизируем только функционал
                    runner.run(); // бежит 1 метр
                    count++; // прибавляем ход
                    if (count == 5) { // на каждом 5м ходу дается 50% возможно буста к бегу на 2 хода
                        rnd = new Random().nextInt(2); // 50% вероятность буста, так как числа будут от 0 до 1
                        if (rnd == 1) {
                            System.out.print("ПОЛУЧАЕТ БУСТ ");
                            runner.run(); // если выпадает, получает буст и пробегает еще метр
                        } else {
                            count = 0; // если нет, обнуляем ходы
                        }
                    } else if (count == 6) { // второй ход буста
                        runner.run();
                        count = 0;
                    }
                } // выходим из синхранизируемого блока
            System.out.printf("%s пробежал %dм.\n", runner.name, runner.distance);
            if (runner != null && runner.distance >= 20) {
                System.out.printf("%s пробежал все %dм. и закончил бег\n", runner.name, runner.distance);
                graduated = true;
            }

        }
    }


}
