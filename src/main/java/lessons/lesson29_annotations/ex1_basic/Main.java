package lessons.lesson29_annotations.ex1_basic;

import lessons.lesson28_reflection.ex2_calculator.Calculator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        //- Создать класс CalculatorTest с методами сложения, разницы и создать сервисный метод start,
        // который запускает консольное меню калькулятора.
        // Пометить данный метод аннотацией ServiceMethod.
        // В мейне запустить метод средствами reflection.
        //Сервисный метод - это метод, который запускает основной фукнционал программы( например, метод start() ).

        Calculator calc = new Calculator();
        Class<? extends Calculator> clazz = calc.getClass();
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            if(declaredMethod.isAnnotationPresent(ServiceMethod.class)){
                declaredMethod.invoke(calc);
            }
        }
    }
}
