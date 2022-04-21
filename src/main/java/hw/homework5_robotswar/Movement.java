package hw.homework5_robotswar;

import java.util.Scanner;

abstract class Movement {
    String cl = "Ячейка занята";

    public void goTop(Player player) {
        player.pair.search(player);
        player.pair.delete(player);
        int i = player.pair.getInput(player, (player.pair.getIndex1()-1));
        int j = player.pair.getInput(player, player.pair.getIndex2());
        if (player.field[i][j].equals(Game.EMPTY)){
            player.field[i][j] = player.symbol;
        } else System.out.println(cl);
    }

    public void goLeft(Player player){
        player.pair.search(player);
        player.pair.delete(player);
        int i = player.pair.getInput(player, player.pair.getIndex1());
        int j = player.pair.getInput(player, player.pair.getIndex2()-1);
        if (player.field[i][j].equalsIgnoreCase(Game.EMPTY)){
            player.field[i][j] = player.symbol;
        }else System.out.println(cl);
    }

    public void goRight(Player player){
        player.pair.search(player);
        int i = player.pair.getInput(player,player.pair.getIndex1());
        int j = player.pair.getInput(player, player.pair.getIndex2()+1);
        if (player.field[i][j].equalsIgnoreCase(Game.EMPTY)) {
            player.pair.delete(player);
            player.field[i][j] = player.symbol;
        } else System.out.println(cl);
    }

    public void goDown(Player player){
        player.pair.search(player);
        player.pair.delete(player);
        int i = player.pair.getInput(player, player.pair.getIndex1() + 1);
        int j = player.pair.getInput(player, player.pair.getIndex2());
        if (player.field[i][j].equalsIgnoreCase(Game.EMPTY)){
            player.field[i][j] = player.symbol;
        }else System.out.println(cl);
    }


    public void firstMove(Player player) {
        System.out.println("Первый ход робота: " + player.name);
        System.out.println("Enter row");
        int row = new Scanner(System.in).nextInt();
        System.out.println("Enter col");
        int col = new Scanner(System.in).nextInt();
        player.field[row][col] = player.symbol;
    }
}

class Pair{

    int index1 = 0;
    int index2 = 0;

    public int getIndex1() {
        return index1;
    }

    public int getIndex2() {
        return index2;
    }

    public void search(Player player) {
        for (int i = 0; i < player.field.length; i++) {
            for (int j = 0; j < player.field.length; j++) {
                if (player.field[i][j].equals(player.symbol)) {
                    index1 = i;
                    index2 = j;
                }
            }
        }
    }

    public void delete(Player player){
        player.field[getIndex1()][getIndex2()] = Game.EMPTY;
    }

    public int getInput(Player player, int i){
        if (i <= player.field.length-1 && i >= 0){
            System.out.println("Первый " +i);
                return i;
            }
            else if (i > player.field.length){
            System.out.println("Второй " + (player.field.length-1));
                return (player.field.length-1);
        } else
            System.out.println("Третий " +0);
                return 0;
        }

}

