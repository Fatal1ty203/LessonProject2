package lessons.lesson5_tic_tac_toe;

public class ComputerKiller extends Player{

    public ComputerKiller(String name, String[][] field, String symbol) {
        super(name, field, symbol);
    }

    @Override
    public void makeStep() {
        while (true) {
            int rnd = (int) (Math.random() * 2);
            System.out.println("Рандом равен: "+ rnd);
            if (rnd == 1){
                int row = (int) (Math.random() * 3);
                int col = (int) (Math.random() * 3);
                if (field[row][col].equals(Game.EMPTY)){
                    field[row][col] = symbol;
                    System.out.println("Ходит");
                    break;
                }
            }else if (rnd == 0){
                while (true){
                    int rnd1 = (int) (Math.random() * 3);
                    int rnd2 = (int) (Math.random() * 3);
                    if (field[rnd1][rnd2].equals(Game.X)){
                        field[rnd1][rnd2] = Game.EMPTY;
                        System.out.println("Удаляет");
                        break;
                    }
                }
                break;
            }
        }
    }

}
