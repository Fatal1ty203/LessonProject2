package hw.homework_serialization.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlayersList players = new PlayersList();
        players.players = List.of(
                new Player("Player1", (int)(Math.random()*10)), new Player("Player2", (int)(Math.random()*10)),
                new Player("Player3", (int)(Math.random()*10)), new Player("Player4", (int) (Math.random()*10)),
                new Player("Player5", (int)(Math.random()*10)), new Player("Player6",(int) (Math.random()*10)),
                new Player("Player7", (int)(Math.random()*10)), new Player("Player8", (int)(Math.random()*10)));


        String path = "src/hw/homework_serialization/task2/round1.txt";
        String path2 = "src/hw/homework_serialization/task2/round2.txt";
        String path3 = "src/hw/homework_serialization/task2/round3.txt";
        String path4 = "src/hw/homework_serialization/task2/round4.txt";

        saveLoadService sls = new saveLoadService();
        saveLoadService.save(path, players);
        sls.loadAndSOUT(path, 2);
    }

}
