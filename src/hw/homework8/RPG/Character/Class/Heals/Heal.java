package hw.homework8.RPG.Character.Class.Heals;

import hw.homework8.RPG.Character.Class.Character;

public class Heal extends Character {

    public Heal(int physicalProtection, int magicProtection) {
        super(physicalProtection, magicProtection);
    }

    @Override
    public void basicAtack(Character character) {

        character.setHealth(character.getHealth() - (character.getPhysicalProtection() - getDamage()));
        System.out.println(getBasicName() + ", здоровье игрока " + character.getName() + " " + character.getHealth());
        updateLevel();
        setCooldownAD(1);
    }

    @Override
    public void specialAtack(Character character) {

        character.setHealth(character.getHealth() + 50);
        System.out.println(getSpecialName() + ", Здоровье игрока " + character.getName() + " " + character.getHealth());
        updateLevel();
        setCooldownAP(2);
    }


    public String getSpecialName() {
        String specialName = "Колодец Света";
        return specialName;
    }

    public String getBasicName() {
        String basicName = "Неистовство ветра";
        return basicName;
    }

    @Override
    public void updateLevel() {
        super.updateLevel();
    }
}
