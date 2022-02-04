package hw.homework_wildcards.taskTwo;

public class TicTocAccount extends Account{

    public TicTocAccount(String login, String password) {
        super(login, password);
    }

    public void createVideo(){
        if ((int)(Math.random()*2) == 0) makeWarning();
        System.out.println("video is created");
    }
}
