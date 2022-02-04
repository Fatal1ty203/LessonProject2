package Game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

public class Game {
    Logger logger = LoggerFactory.getLogger(Game.class);

    String[][] board = new String[10][10];
    final static String hit = "X";
    final static String ship = "S";
    final static String miss = "0";
    final static String EMPTY = "|_|";

    public void game(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                board[i][j] = EMPTY;
            }
        }
    }

    public void print(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                logger.info(board[i][j]);
            }
        }
    }
}
