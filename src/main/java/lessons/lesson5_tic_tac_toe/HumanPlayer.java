package lessons.lesson5_tic_tac_toe;

import java.util.Scanner;

public class HumanPlayer  extends Player{
    Scanner scn = new Scanner(System.in);

    public HumanPlayer(String name, String[][] field, String symbol) {
        super(name, field, symbol);
    }

    @Override
    public void makeStep() {
        while(true) {
            System.out.println("Enter row");
            int row = getInput(scn);
            System.out.println("Enter col");
            int col = getInput(scn);
            if (field[row][col].equals(Game.EMPTY)) {
                field[row][col] = symbol;
                break;
            }else{
                System.out.println("Ячейка уже занята");
            }

        }
    }

    public static String[][] isClosed(String[][] hz){

        String[][] np = hz;
        while (true)
        if (hz.equals(Game.EMPTY)){
            break;
        }else {
            System.out.println("Вы вводите координаты занятой ячейки");
        }
        return np;
    }

    public static int getInput(Scanner scn){
        int input = 0;
        while (true){
            input = scn.nextInt();
            if (input >= 0 && input <3){
                return input;
            }
            System.out.println("Введите координаты от 0 до 2: ");
        }
    }

}
