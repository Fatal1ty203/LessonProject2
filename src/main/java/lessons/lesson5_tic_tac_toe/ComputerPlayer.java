package lessons.lesson5_tic_tac_toe;

public class ComputerPlayer extends  Player{

    public ComputerPlayer(String name, String[][] field, String symbol) {
        super(name, field, symbol);
    }

    @Override
    public void makeStep() {
        while (true) {
            try {
                Thread.sleep(1700);
            } catch (Exception e) {

            }
            int row = (int) (Math.random() * 3);
            int col = (int) (Math.random() * 3);
            if (field[row][col].equals(Game.EMPTY)) {
                field[row][col] = symbol;
                break;
            }
        }
    }
}
