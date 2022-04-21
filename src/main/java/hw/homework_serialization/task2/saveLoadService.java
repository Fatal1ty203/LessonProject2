package hw.homework_serialization.task2;

import java.io.*;
import java.util.List;

public class saveLoadService {
    public static void save(String path, PlayersList players){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
                oos.writeObject(players.players);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void loadAndSOUT(String path, int winner){
        Player players = null;
        List<Player> playersLists = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){

            playersLists = (List<Player>) ois.readObject();

            for (int i = 0; i <= winner-1;){
                System.out.println(playersLists.get(i));
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
