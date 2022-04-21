package hw.homework5_robotswar;

abstract class Player extends Movement {
    String name;
    String[][] field;
    String symbol;
    Pair pair;

    public Player(String name, String[][] field, String symbol){
        this.name = name;
        this.field = field;
        this.symbol = symbol;
        this.pair = new Pair();
    }

}
