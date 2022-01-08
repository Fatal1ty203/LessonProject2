package hw.homework.task2;

public class Character {
    int health;
    String name;
    int counter;

    public Character(String name) {
        this.name = name;
        this.health = 100;
    }

    public int shot(){
        int rnd = (int)(Math.random()*2);
        if(rnd == 1) {
            counter++;
            return 10;
        }
        counter=0;
        return 0;
    }

    public int shot(int n){
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += shot();
        }
        return sum;
    }



    public void print(){
        System.out.println("Стреляет игрок: " + name + " #");
    }

    @Override
    public String toString() {
        return "Здоровье игрока: " + name + " равно: " + health;
    }
}
