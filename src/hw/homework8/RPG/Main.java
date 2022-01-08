package hw.homework8.RPG;


import hw.homework8.RPG.Character.Class.Character;
import hw.homework8.RPG.Character.Class.ChekPoint.ChekPoint;
import hw.homework8.RPG.Character.Class.FightService.Fight;
import hw.homework8.RPG.Character.Class.Heals.Senjin;
import hw.homework8.RPG.Character.Class.Heals.Velen;
import hw.homework8.RPG.Character.Class.Mages.Antonidas;
import hw.homework8.RPG.Character.Class.Mages.JainaProudmoore;
import hw.homework8.RPG.Character.Class.Warriors.ThunderHellscream;
import hw.homework8.RPG.Character.Class.Warriors.VarianWrynn;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Senjin senjin = new Senjin(60,30);
        Velen velen = new Velen(100,70);
        Antonidas antonidas = new Antonidas(20,100);
        JainaProudmoore jainaProudmoore = new JainaProudmoore(40,60);
        VarianWrynn varianWrynn = new VarianWrynn(100,30);
        ThunderHellscream thunderHellscream = new ThunderHellscream(100,70);

        List<Character> characters = new ArrayList<>();
        characters.add(senjin);
        characters.add(velen);
        characters.add(antonidas);
        characters.add(jainaProudmoore);
        characters.add(varianWrynn);
        characters.add(thunderHellscream);
        characters = ChekPoint.loads(characters);
        Fight fight = new Fight();
        fight.fight(characters.get(5), fight.target(characters));



        ChekPoint.saves(characters);
    }
}
