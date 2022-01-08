package lessons.lesson10_exceptions_throw;

public class Main2_multyExceptions {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        int[] arr = new int[5];

        //ВАРИАНТ 3 - САМЫЙ ОПТИМАЛЬНЫЙ (ЛОВИМ ВСЕ ИСКЛЮЧЕНИЯ И ВЫВОДИМ ПОДРОБНУЮ ИНФОМРАЦИЮ)
        try {
            System.out.println(arr[10]);
            System.out.println(a / b);
        }catch (Throwable e){
            e.printStackTrace();
            //System.out.println(e.toString());
        }
        System.out.println("finish");

        //ВАРИАНТ 2. Перечилсение исключений ЧЕРЕЗ ИЛИ
//        try {
//            //System.out.println(arr[10]);
//            System.out.println(a / b);
//        }catch (ArithmeticException | ArrayIndexOutOfBoundsException e){
//            e.printStackTrace();
//            //System.out.println(e.toString());
//        }
//        System.out.println("finish");


        //ВАРИНАТ 1: Можно делать несколкьо catch
//        try {
//            System.out.println(arr[10]);
//            System.out.println(a / b);
//        }catch (ArithmeticException e){
//            System.out.println("На ноль делить нельзя");
//        }
//        catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("Выход за границы массива");
//        }


    }
}
