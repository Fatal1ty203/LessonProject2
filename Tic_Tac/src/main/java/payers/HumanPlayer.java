package payers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.KeyListener;
import java.util.Scanner;

public class HumanPlayer extends Player{
    Scanner scn = new Scanner(System.in);
    Logger log = LoggerFactory.getLogger(HumanPlayer.class);
    
    public HumanPlayer(String[][] myField, String name, String[][] enemyField) {
        super(myField, name, enemyField);
    }

    @Override
    public void makeStep() {
        log.info("");
//        KeyListener keyListener =
    }
}
