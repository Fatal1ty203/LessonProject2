package hw.homework8.RPG.Character.Class.Heals;

public class Senjin extends Heal {

    @Override
    public String getName() {
        return "Senjin";
    }

    public Senjin(int physicalProtection, int magicProtection) {
        super(physicalProtection, magicProtection);
    }
}
