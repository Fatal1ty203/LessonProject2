package lessons.lesson5_tic_tac_toe;

import java.util.Scanner;

public class Game {
    String[][] board = new String[3][3];
    final static String EMPTY = "|_|";
    final static String X = "|X|";
    final static String O = "|O|";

    public String getEMPTY() {
        return EMPTY;
    }

    public Game(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = EMPTY;
            }
        }
    }






    public boolean isWinner(String symbol){
        return isWinnerByHorizontal(symbol) || isWinnerByVertical(symbol) || isWinnerByDiagonal(symbol) || isDraw(symbol);

    }

    public boolean isDraw(String symbol) {
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals(Game.O) || board[i][j].equals(Game.X)) {
                    sum++;
                }
            }
        }

        if (sum == 9){
            System.out.println("Победила дружба");
            return true;
        }else {
            return false;
        }
    }

//    for (int i = 0; i < board.length; i++) {
//        int sum = 0;
//        for (int j = 0; j < board.length; j++) {
//            if(board[i][j].equals(symbol)){
//                sum++;
//            }
//        }
//        if(sum == 3) return true;
//    }
//        return false;
//}

    public boolean isWinnerByDiagonal(String symbol){
        if (board[0][0].equals(symbol) && board[1][1].equals(symbol) && board[2][2].equals(symbol)) {
            return true;
        }if (board[2][0].equals(symbol) && board[1][1].equals(symbol) && board[0][2].equals(symbol)) {
            return true;
        }else return false;
    }

    public boolean isWinnerByVertical(String symbol){
        if (board[0][0].equals(symbol) && board[1][0].equals(symbol) && board[2][0].equals(symbol)){
            return true;
        }if (board[0][1].equals(symbol) && board[1][1].equals(symbol) && board[2][1].equals(symbol)){
            return true;
        }
        if (board[0][2].equals(symbol) && board[1][2].equals(symbol) && board[2][2].equals(symbol)){
            return true;
        }else return false;
    }



    public boolean isWinnerByHorizontal(String symbol){
        for (int i = 0; i < board.length; i++) {
            int sum = 0;
            for (int j = 0; j < board.length; j++) {
                if(board[i][j].equals(symbol)){
                    sum++;
                }
            }
            if(sum == 3) return true;
        }
        return false;
    }
    public void startGame(){
        Scanner scn = new Scanner(System.in);
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer");
        System.out.println("3. Computer vs Computer");
        System.out.println("4. Human vc ComputerKiller");
        int mode = scn.nextByte();

        //GOOD OPTION:
        Player player1;
        Player player2;
        if(mode == 1){
            player1 = new HumanPlayer("Player1", board, X);
            player2 = new HumanPlayer("Player2", board, O);
        }
        else if(mode == 2){
            player1 = new HumanPlayer("Player1", board, X);
            player2 = new ComputerPlayer("Player2", board, O);
        }
        else if (mode == 3){
            player1 = new ComputerPlayer("Player1", board, X);
            player2 = new ComputerPlayer("Player2", board, O);
        }else {
            player1 = new HumanPlayer("Player1",board, X);
            player2 = new ComputerKiller("Player2", board, O);
        }

        Player currPlayer = player1;
        Player oppisitePlayer = player2;


        while(!isWinner(oppisitePlayer.symbol) ){
            print();
            System.out.println("hod igroka "+currPlayer.name);
            currPlayer.makeStep();
            Player tmp = currPlayer;
            currPlayer = oppisitePlayer;
            oppisitePlayer = tmp;
            if (isWinner(oppisitePlayer.symbol)){
                System.out.println("Победил игрок: " + oppisitePlayer.name);
                print();
            }else if (!isWinner(oppisitePlayer.symbol) && isWinner(oppisitePlayer.symbol)){
                System.out.println("победила дружба");
                print();
            }

        }





//BAD OPTION:
//        int turn = 0;
//        if(mode == 1){
//            while(true) {
//                print();
//                if (turn % 2 == 0) {
//                    System.out.println("Hod igroka 1");
//                } else {
//                    System.out.println("Hod igroka 2");
//                }
//                System.out.println("Enter row");
//                int row = scn.nextByte();
//                System.out.println("Enter col");
//                int col = scn.nextByte();
//                if (turn % 2 == 0) {
//                    board[row][col] = X;
//                } else {
//                    board[row][col] = O;
//                }
//                turn++;
//            }
//
//        }else if(mode == 2){
//            while(true) {
//                print();
//                if (turn % 2 == 0) {
//                    System.out.println("Hod igroka 1");
//                } else {
//                    System.out.println("Hod computera");
//                }
//                int row;
//                int col;
//                if (turn % 2 == 0) {
//                    System.out.println("Enter row");
//                    row = scn.nextByte();
//                    System.out.println("Enter col");
//                    col = scn.nextByte();
//                }else{
//                    row = (int)(Math.random()*3);
//                    col = (int)(Math.random()*3);
//                }
//                if (turn % 2 == 0) {
//                    board[row][col] = X;
//                } else {
//                    board[row][col] = O;
//                }
//                turn++;
//            }
//
//        }

    }

    public void print(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

}
