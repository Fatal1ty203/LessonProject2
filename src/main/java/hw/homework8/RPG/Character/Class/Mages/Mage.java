package hw.homework8.RPG.Character.Class.Mages;


import hw.homework8.RPG.Character.Class.Character;

public class Mage extends Character {

    public Mage(int physicalProtection, int magicProtection) {
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

        character.setHealth(character.getHealth()- (character.getMagicProtection() - 50));
        System.out.println(getSpecialName() + ", Здоровье игрока " + character.getName() + " " + character.getHealth());
        updateLevel();
        setCooldownAP(3);
    }

    public String getSpecialName() {
        String specialName = "Ледяная хватка";
        return specialName;
    }

    public String getBasicName() {
        String basicName = "Ледяное копье";
        return basicName;
    }

    @Override
    protected void updateLevel() {
        super.updateLevel();
    }

}
