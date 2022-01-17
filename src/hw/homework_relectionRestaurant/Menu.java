package hw.homework_relectionRestaurant;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private static String clazzName = null;
    private static String methodName = null;
    private static Class<?> clazz1 = null;
    private static Method method = null;
    private static Object obj = null;
    private ReflectionService rf = new ReflectionService();
    private Scanner scn = new Scanner(System.in);

    public void start(){
        int input = 0;
        while (input != 5){
            System.out.println("1. Создать заказ (пользователь вводит свое имя)\n" +
                    "2. Добавить заказ клиенту (пользователь вводит свое имя и желаемое блюдо)\n" +
                    "3. Расчитать клиента (выводится чек и заказ удаляется из системы)\n" +
                    "4. Вывести всех нерасчитанных клиентов (выводятся имя и номер клиентов, которые еще не рассчитались)");
            input = scn.nextInt();
            if (input == 1){
                clazzName = "hw.homework_relectionRestaurant.MenuService";
                clazz1 = rf.getClazz(clazzName);
                methodName = "createOrder";
                method = rf.getMethod(clazz1,methodName);
                obj = rf.getObject(clazz1);
                rf.methodResult(method,obj);
            } else if (input == 2){
                methodName = "addDish";
                System.out.println("Пожалуйста введите имя клиента");
                String name = scn.next();
                try {
                    method = clazz1.getDeclaredMethod(methodName,String.class);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                try {
                    Object result = method.invoke(obj,name);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }else if (input == 3){
                System.out.println("Введите имя клиента, которого хотите рассчитать: ");
                String name = scn.next();
                methodName = "getReceipt";
                try {
                    method = clazz1.getDeclaredMethod(methodName, String.class);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                Object menu = null;
                try {
                    menu = method.invoke(obj, name);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
//                System.out.println(menu);
            }else if (input == 4){
                methodName = "getPaid";
                method = rf.getMethod(clazz1, methodName);
                System.out.println(rf.methodResult(method,obj));
            }
        }
    }

}
