package hw.homework8.RPG;


import hw.homework8.RPG.Character.Class.Character;
import hw.homework8.RPG.Character.Class.ChekPoint.CharactersListForSave;
import hw.homework8.RPG.Character.Class.ChekPoint.ChekPoint;
import hw.homework8.RPG.Character.Class.FightService.Fight;
import hw.homework8.RPG.Character.Class.Heals.Senjin;
import hw.homework8.RPG.Character.Class.Heals.Velen;
import hw.homework8.RPG.Character.Class.Mages.Antonidas;
import hw.homework8.RPG.Character.Class.Mages.JainaProudmoore;
import hw.homework8.RPG.Character.Class.Warriors.ThunderHellscream;
import hw.homework8.RPG.Character.Class.Warriors.VarianWrynn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Senjin senjin = new Senjin(60,30);
        Velen velen = new Velen(100,70);
        Antonidas antonidas = new Antonidas(20,100);
        JainaProudmoore jainaProudmoore = new JainaProudmoore(40,60);
        VarianWrynn varianWrynn = new VarianWrynn(100,30);
        ThunderHellscream thunderHellscream = new ThunderHellscream(100,70);

        CharactersListForSave characters = new CharactersListForSave();
        List<Character> characterList;
        characterList = ChekPoint.load();
        characters.getCharacters().add(senjin);
        characters.getCharacters().add(velen);
        characters.getCharacters().add(antonidas);
        characters.getCharacters().add(jainaProudmoore);
        characters.getCharacters().add(varianWrynn);
        characters.getCharacters().add(thunderHellscream);
        Fight fight = new Fight();
        System.out.println(characterList.get(1).getName());
        System.out.println(characterList.get(1).getHealth());
        fight.fight(characters.getCharacters().get(5), fight.target(characterList));

        ChekPoint.saves(characterList);
    }
}
