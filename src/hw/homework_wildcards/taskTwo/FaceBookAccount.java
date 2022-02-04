package hw.homework_wildcards.taskTwo;

public class FaceBookAccount extends Account{

    public FaceBookAccount(String login, String password) {
        super(login, password);
    }

    public void createPost(){
        if ((int)(Math.random()*2)==0) makeWarning();
        System.out.println("post is created");
    }

}
