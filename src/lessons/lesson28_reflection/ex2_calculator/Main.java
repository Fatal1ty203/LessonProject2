package lessons.lesson28_reflection.ex2_calculator;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        String className = "lessons.lesson28_reflection.ex2_calculator.CalculatorTest";
        String className2 = "lessons.lesson28_reflection.ex2_calculator.Calculator2";
        String methodName = "sum";
        String methodName2 = "minus";
        int a = 2;
        int b = 3;


        //получаем объект с информацией о нужном класе
        Class<?> clazz = Class.forName(className2);
        //получаем желаемый метод из данного класса
        Method declaredMethod = clazz.getDeclaredMethod(methodName2, int.class, int.class);
        //создаем объект этого класса
        Object obj = clazz.getDeclaredConstructor().newInstance();

        Object result = declaredMethod.invoke(obj, a, b);
        System.out.println(result);


    }
}
