package hw.homewort_reflection;

import java.lang.invoke.TypeDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectionService {
    private static Scanner scn = new Scanner(System.in);

    public static void run(){
        Class<?> clazz = getClazz();
        System.out.println(methodResult(getMethod(clazz), getObject(clazz)));
    }

    private static Object methodResult(Method method, Object obj){
        Object result = null;
        try {
             result = method.invoke(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static Object getObject(Class<?> clazz){
        Object obj = null;
        try {
            obj = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return obj;
    }

    private static Method getMethod(Class<?> clazz){
        System.out.println("Пожалуйста введите название метода");
        Method declareMethod = null;
        try {
            declareMethod = clazz.getMethod(scn.nextLine());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return declareMethod;
    }

    private static Class<?> getClazz() {
        System.out.println("Пожалуйста введите полное название класса: ");
        String clazzName = scn.nextLine();
        Class<?> clazz = null;
        try {
            clazz = Class.forName(clazzName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

}
