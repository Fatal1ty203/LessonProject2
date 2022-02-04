package TEST;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame implements KeyListener {

    public Main(){
        setSize(500, 500);
        setVisible(true);
        addKeyListener(this);
    }

    public static void main(String[] args) {
        Main f = new Main();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_DOWN){
            System.out.println("Нажата клавиша вниз");
        }else if (e.getKeyCode()==KeyEvent.VK_RIGHT){
            System.out.println("Нажата клавиша вправо");
        }else if (e.getKeyCode()==KeyEvent.VK_UP){
            System.out.println("Нажата клавиша вверх");
        }else if (e.getKeyCode()==KeyEvent.VK_LEFT){
            System.out.println("Нажата клавиша влево");
        }
    }
}
