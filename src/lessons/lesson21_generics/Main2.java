package lessons.lesson21_generics;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        //Создать свой аналог ArrayList<T>
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
    }
}

class MyArrayList<T>{
    Object[] arr = new Object[2];
    int size = 0;
    public void add(T t){
        if(size >= arr.length)
            arr = Arrays.copyOf(arr, arr.length*2);
        arr[size++] = t;

    }

    public T get(int index){
        if(index<0 || index> size){
            throw new IndexOutOfBoundsException("no such index "+index);
        }
        return (T)arr[index];
    }

    public boolean contains(T t){
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(t)) return true;
        }
        return false;
    }

}