package hw.homework8.RPG.Character.Class.ChekPoint;

import hw.homework8.RPG.Character.Class.Character;

import java.io.*;
import java.util.List;

public class ChekPoint {
    private static String path = "C:\\Users\\DELL\\OneDrive\\Рабочий стол\\hz-main\\LessonProject\\src\\hw.homework8\\RPG\\Character\\Class\\ChekPoint.characterds.txt";


    public static void saves(List<Character> characters){
        try(PrintWriter pw = new PrintWriter(path)) {
            for (Character character : characters){
                pw.println(character.getId()+ ";" + character.getLvl() + ";" + character.getHealth());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<Character> loads(List<Character> charactersList) {
        List<Character> characters = charactersList;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] st = line.split(";");
                int id = Integer.parseInt(st[0]);
                int lvl = Integer.parseInt(st[1]);
                int heath = Integer.parseInt(st[2]);
                for (Character chara : characters) {
                    if (id == chara.getId()) {
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
        return characters;
    }
}

