package payers;

abstract class Player {
    String[][] myField;
    String[][] enemyField;

    String name;
    String symbol;

    public Player(String[][] myField, String name, String[][] enemyField) {
        this.myField = myField;
        this.name = name;
        this.symbol = "#";
        this.enemyField = enemyField;
    }

    public abstract void makeStep();
}
