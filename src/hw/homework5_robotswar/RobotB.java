package hw.homework5_robotswar;

public class RobotB extends Player {
    public RobotB(String name, String[][] field, String symbol) {
        super(name, field, symbol);
    }

    @Override
    public void goLeft(Player player) {
        super.goLeft(player);
        pair.search(player);
        pair.delete(player);
        player.field[pair.getIndex1()][pair.getIndex2()-1] = player.symbol;
    }

    @Override
    public void goDown(Player player) {
        super.goDown(player);
        pair.search(player);
        pair.delete(player);
        player.field[pair.getIndex1()+1][pair.getIndex2()] = player.symbol;
    }

    @Override
    public void goRight(Player player) {
        player.pair.search(player);
        player.pair.delete(player);
        int i = player.pair.getInput(player, (player.pair.getIndex1()));
        int j = player.pair.getInput(player, (player.pair.getIndex2() +2));
        if (player.field[i][j].equals(Game.EMPTY)){
            player.field[i][j] = player.symbol;
        }else System.out.println(cl);

    }

    public void goTop(Player player) {
        player.pair.search(player);
        player.pair.delete(player);
        int i = player.pair.getInput(player, (player.pair.getIndex1()-2));
        int j = player.pair.getInput(player, player.pair.getIndex2());
        if (player.field[i][j].equals(Game.EMPTY)){
            player.field[i][j] = player.symbol;
        } else System.out.println(cl);
    }
}
