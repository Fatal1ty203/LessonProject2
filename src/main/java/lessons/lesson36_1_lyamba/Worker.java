package lessons.lesson36_1_lyamba;

public class Worker {
    String name;

    public Worker(String name) {
        this.name = name;
    }

    public void getWork(MyExecutor executor, String text){
        System.out.println(name+" начал выполнять задание:");
        executor.execute(text);
    }
}
