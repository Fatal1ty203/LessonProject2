package hw.homework_relectionRestaurant;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectionService {
    Scanner scn = new Scanner(System.in);

    public Object methodResult(Method method, Object obj){
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

    public Object getObject(Class<?> clazz){
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

    public Method getMethod(Class<?> clazz, String methodName){
//        Method[] methods = clazz.getDeclaredMethods();
//        for (Method method : methods){
//            System.out.println(method.getName());
//        }
        Method method = null;
        try {
             method = clazz.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return method;
    }

    public Class getClazz(String clazzName){
        Class<?> clazz = null;
        try {
            clazz = Class.forName(clazzName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }
}
