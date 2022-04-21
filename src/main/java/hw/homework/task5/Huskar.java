package hw.homework.task5;

public class Huskar {
    int health, strength, level;

    public Huskar(){

    }

    public Huskar(int health, int strength, int level){
        this.health = health;
        this.strength = strength;
        this.level = level;
    }

    public int attack(){
        return strength * level / 10;
    }

    public void increaseLevel(){
        level++;
        health += 25;
        strength ++;
    }

    public HuskarUltimate transform(){
        return new HuskarUltimate(this.health *2,this.strength * 3,this.level,10);
    }

    public void print(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Huskar:" +
                " health = " + health +
                ", strength = " + strength +
                ", level = " + level ;
    }
}

class HuskarUltimate extends Huskar {

    int mana;

    public HuskarUltimate(int health, int strength, int level, int mana) {
        super(health, strength, level);
        this.mana = mana;
    }

    public int strengthAttack(){
        return attack() * 10;
    }

    public int magicAttack(){
        if (mana >= 5){
            mana -= 5;
            return health * level;
        }else {
            return 0;
        }
    }

    @Override
    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return super.toString()+ ", mana = " + mana;
    }
}