package lessons.lesson21_generics;

public class Main1_my_container {
    public static void main(String[] args) {
        //ДЖЕНЕРИКИ (ОБОБЩЕННЫЕ КЛАССЫ) - классы с полями, чей тип данных заранее не известен

        //Как создать свойк класс с одним полем, тип которого можно задавать в мейне (при создании объекта)
        MyCotainer<Integer> myCotainer1 = new MyCotainer<>(10);
        System.out.println(myCotainer1.getMyValue());
        myCotainer1.setMyValue(20);
        System.out.println(myCotainer1.getMyValue()*2);

        MyCotainer<String> myCotainer2 = new MyCotainer<>("one");
        System.out.println(myCotainer2.getMyValue());
        myCotainer2.setMyValue("two");
        System.out.println(myCotainer2.getMyValue());




    }

}
class MyCotainer<T>{
    T myValue;

    public MyCotainer(T myValue) {
        this.myValue = myValue;
    }

    public T getMyValue() {
        return myValue;
    }

    public void setMyValue(T myValue) {
        this.myValue = myValue;
    }
}
