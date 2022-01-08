package hw.homework11_set.TreeSet.Gun;


public class Gun implements Comparable<Gun>{
    private String nameGun;
    private int damage;


    public Gun(String nameGan, int damage) {
        this.damage = damage;
        this.nameGun = nameGan;
    }

    public String getNameGun() {
        return nameGun;
    }

    @Override
    public int compareTo(Gun o) {
            return damage - o.damage;
    }

    @Override
    public String toString() {
        return "Gun: '" + nameGun + '\'' +
                " - damage=" + damage + "\n";
    }
}
