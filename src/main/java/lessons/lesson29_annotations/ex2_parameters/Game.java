package lessons.lesson29_annotations.ex2_parameters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Game {


    public void menu(Method load, Method save) throws InvocationTargetException, IllegalAccessException {


        load.invoke(this);
        System.out.println("1. Введите имя первого игрока");
        System.out.println("1. Введите имя первого игрока");
        System.out.println("3. Начать игру");
        System.out.println("4. Выход");
        int input = 0;

        if(input==4){
            save.invoke(this);
        }
    }


    @ServiceLoad(order = 1)
    public void loadFromFile(){
        System.out.println("loaded");
    }

    @ServiceLoad(order = 2)
    public void saveToFile(){
        System.out.println("saved");
    }
}
