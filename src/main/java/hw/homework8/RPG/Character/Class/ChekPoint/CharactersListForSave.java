package hw.homework8.RPG.Character.Class.ChekPoint;

import hw.homework8.RPG.Character.Class.Character;

import java.io.Serializable;
import java.util.LinkedList;

public class CharactersListForSave implements Serializable {
    LinkedList<Character> characters = new LinkedList<>();
    static final double serialVersionUID = 1l;

    public LinkedList<Character> getCharacters() {
        return characters;
    }
}
