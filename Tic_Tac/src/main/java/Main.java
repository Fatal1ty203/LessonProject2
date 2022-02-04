import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame implements KeyListener {
    public static void main(String[] args)  {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
            }
        });


    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_SPACE) {
            System.out.println("Нажат пробел");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
