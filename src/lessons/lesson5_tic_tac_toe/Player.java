package lessons.lesson5_tic_tac_toe;

abstract class Player {

    String name;
    String[][] field;
    String symbol;

    public Player(String name, String[][] field, String symbol) {
        this.name = name;
        this.field = field;
        this.symbol = symbol;
    }

    public abstract void makeStep();
}
