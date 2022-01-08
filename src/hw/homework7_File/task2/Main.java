package hw.homework7_File.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void writeToFile(String path,List<Player> players, int winners){
        int is = 0;
        try(PrintWriter pw = new PrintWriter(path)) {
            for (Player player : players){
                if (is != winners) {
                    pw.println(player.name + ";" + player.points);
                    is++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<Player> readToFile(String path){
        List<Player> players = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = null;
            while ((line = br.readLine()) != null){
                String[] arr =line.split(";");
                String playerName = arr[0];
                int playerPoints = Integer.parseInt(arr[1]);
                players.add(new Player(playerName,playerPoints));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }



    public static void main(String[] args) {
        List<Player> players = List.of(
                new Player("Player1", (int)(Math.random()*10)), new Player("Player2", (int)(Math.random()*10)),
                new Player("Player3", (int)(Math.random()*10)), new Player("Player4", (int) (Math.random()*10)),
                new Player("Player5", (int)(Math.random()*10)), new Player("Player6",(int) (Math.random()*10)),
                new Player("Player7", (int)(Math.random()*10)), new Player("Player8", (int)(Math.random()*10)));


        String path = "C:\\Users\\DELL\\OneDrive\\Рабочий стол\\hz-main\\LessonProject\\src\\hw.homework7_File\\task2\\round1";
        String path2 = "C:\\Users\\DELL\\OneDrive\\Рабочий стол\\hz-main\\LessonProject\\src\\hw.homework7_File\\task2\\round2";
        String path3 = "C:\\Users\\DELL\\OneDrive\\Рабочий стол\\hz-main\\LessonProject\\src\\hw.homework7_File\\task2\\round3";
        String path4 = "C:\\Users\\DELL\\OneDrive\\Рабочий стол\\hz-main\\LessonProject\\src\\hw.homework7_File\\task2\\round4";

        writeToFile(path,players,8);
        writeToFile(path2,readToFile(path),4);
        writeToFile(path3,readToFile(path2), 2);
        writeToFile(path4,readToFile(path3),1);
    }
}
