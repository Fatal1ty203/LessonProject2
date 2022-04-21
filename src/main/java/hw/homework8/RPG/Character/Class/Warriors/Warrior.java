package hw.homework8.RPG.Character.Class.Warriors;


import hw.homework8.RPG.Character.Class.Character;

public class Warrior extends Character {
    private String basicName = "Рассекающий удар";
    private String specialName = "Кровавый фарш";

    public Warrior(int physicalProtection, int magicProtection) {
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

        System.out.println(character.getHealth());
        character.setHealth(character.getHealth() -(character.getPhysicalProtection()- (getDamage()*3)));
        System.out.println(getSpecialName() + ", Здоровье игрока " + character.getName() + " " + character.getHealth());
        setCooldownAP(3);
        updateLevel();
    }

    public String getBasicName() {
        return basicName;
    }

    public String getSpecialName() {
        return specialName;
    }

    @Override
    protected void updateLevel() {
        super.updateLevel();
    }

}
