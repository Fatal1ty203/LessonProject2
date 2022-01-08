package lessons.lesson12_finally;

public class Main {
    public static void main(String[] args) {
        String action = null;
        try{
            int a = 2;
            int b = 0;
            System.out.println(a/b);
        }catch (Exception e){
            e.printStackTrace();
            if(action.equals("mult")){
                System.out.println("multiplication was stopped");
            }
            else if(action.equals("divide")){
                System.out.println("divistion was stopped");
            }

        }finally {
            System.out.println("finally"); //сработает даже если в catch произойдет необработанное исключение
        }
        System.out.println("the end of the program"); //не сработает,  если в catch произойдет необработанное исключение
    }
}
