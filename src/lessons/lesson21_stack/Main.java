package lessons.lesson21_stack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        //Принцип работы стека: FILO (first input - last output/кто первый зашел, то последний вышел)
        //Принцип стопки грязных тарелок (тарелка снизу стокпи будет помыта последней)
        Stack<String> stack = new Stack<>();
        stack.add("one");
        stack.add("two");
        stack.add("three");
        stack.add("four");

        System.out.println(stack.peek()); //возвращает последний элемент стэка (без удаления)

        //пока стэк не пустой
        while(!stack.isEmpty()){
            System.out.println(stack.pop()); //удаляет и возвращает последний элемент стэка
        }

    //вариант 2
//        for (int i = 0; i < stack.size(); i++) {
//            System.out.println(stack.get(i));
//        }

    }





}
