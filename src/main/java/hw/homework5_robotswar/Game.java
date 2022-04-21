package hw.homework5_robotswar;

import java.util.Scanner;

public class Game extends Movement{
    String[][] board = new String[7][7];
    final static String EMPTY = "|  |";
    final static String A = "| A |";
    final static String B = "| B |";
    final static String E = "| E |";

    public  Game(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                board[i][j] = EMPTY;
            }
        }
    }

    public void startGame() {
        board[((int)Math.random()*3)][((int)Math.random()*3)] = E;
        Scanner scn = new Scanner(System.in);
        Player player1;
        Player player2;
        String input;
        player1 = new RobotA(A, board, A);
        player2 = new RobotB(B,board,B);
        firstMove(player1);
        firstMove(player2);
        print();
        Player currPlayer = player1;
        Player oppositePlayer = player2;

        while(true) {
            Player tmp = currPlayer;
            currPlayer = oppositePlayer;
            oppositePlayer = tmp;
            System.out.println("Ход игрока: " + oppositePlayer.name);
            System.out.println(
                    "w. Идти вверх\n" +
                    "s. Идти вниз\n"+
                    "a. Идти влево\n" +
                    "d. Идти вправо\n");
            input = scn.nextLine();
            if (input.equalsIgnoreCase("d")){
                oppositePlayer.goRight(oppositePlayer);
                print();
            }
            if (input.equalsIgnoreCase("a")){
                oppositePlayer.goLeft(oppositePlayer);
                print();
            }
            if (input.equalsIgnoreCase("w")){
                oppositePlayer.goTop(oppositePlayer);
                print();
            }
            if (input.equalsIgnoreCase("s")){
                oppositePlayer.goDown(oppositePlayer);
                print();
            }
        }
    }


    public  void print(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }


}
