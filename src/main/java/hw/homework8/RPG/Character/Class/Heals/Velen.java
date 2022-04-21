package hw.homework8.RPG.Character.Class.Heals;

public class Velen extends Heal {

    public Velen(int physicalProtection, int magicProtection) {
        super(physicalProtection, magicProtection);
    }



    @Override
    public String getName() {
        return "Velen";
    }
}
