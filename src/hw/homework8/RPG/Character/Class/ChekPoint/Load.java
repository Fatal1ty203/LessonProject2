package hw.homework8.RPG.Character.Class.ChekPoint;

import hw.homework8.RPG.Character.Class.Character;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Load{
    public static String path = "C:\\Users\\DELL\\OneDrive\\Рабочий стол\\hz-main\\LessonProject\\src\\hw.homework8\\RPG\\Character\\Class\\ChekPoint.characterds.txt";

    public static void load(List<Character> charactersList){

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = null;
            while ((line = br.readLine()) != null){
                String[] st = line.split(";");
                int id = Integer.parseInt(st[0]);
                int lvl = Integer.parseInt(st[1]);
                int heath = Integer.parseInt(st[2]);
                for (Character chara : charactersList){
                    if (id == chara.getId()){
                        chara.setLvl(lvl);
                        chara.setHealth(heath);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
