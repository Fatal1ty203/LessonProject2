package lessons.lesson21_queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main1_basic {
    public static void main(String[] args) {
        //Принцип работы стека: FIFO (first input - first output/кто первый зашел, тот первый вышел)

        Queue<Integer> deque = new ArrayDeque<>();
        deque.add(10);
        deque.add(20);
        deque.add(30);
        deque.add(40);

        System.out.println(deque.peek()); //просто возвращает первый элемент очереди (не удаляет


        while(!deque.isEmpty()){
            System.out.println(deque.poll()); //получает и удалет первый элемент очереди
        }


    }
}
