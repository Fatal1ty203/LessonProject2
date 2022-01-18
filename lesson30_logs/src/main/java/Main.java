import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        //|_||_||_||_|
        //|_||+||_||_|
        //|_||+||0||_|
        //|_||_||_||_|

        //debug
        //info
        //warn
        //error
        Logger logger = LoggerFactory.getLogger(Main.class);

        Calculator calculator = new Calculator();
        try{
            int a = 2;
            int b = 3;
//            System.out.printf("a = %s%n",a);
//            System.out.printf("b = %s%n",b);
            logger.debug("a = {}",a);
            logger.debug("b = {}",b);
//            System.out.println(calculator.divide(2,3));
            logger.info("a/b = {}", calculator.divide(2,3));

        }catch (Exception e){
//            System.out.println("error: "+e);
            logger.warn("error: {}", e.toString());
        }
        int a = 2;
        int b = 0;
        if(b==0) {
            logger.error("ЧТО ТЫ НАДЕЛАЛ???");
            throw new ArithmeticException("ДЕЛИТЬ НА НОЛЬ НЕЛЬЗЯ! УЧИ МАТЕМАТИКА!");
        }
    }
}

class Calculator{
    Logger logger = LoggerFactory.getLogger(Calculator.class);
    public double divide(double a, double b){
        //b = 0;
//        System.out.printf("inside method: a = %s%n",a);
//        System.out.printf("inside method: b = %s%n",b);
        logger.debug("inside method: a = {}",a);
        logger.debug("inside method: b = {}",b);
        return a/b;
    }
}
