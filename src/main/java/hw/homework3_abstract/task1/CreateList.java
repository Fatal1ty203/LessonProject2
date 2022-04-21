package hw.homework3_abstract.task1;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateList {
    public static List<Car> create(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Almera());
        cars.add(new Charger());
        cars.add(new Rio());
        cars.add(new Mustang());

        return cars;
    }
}

enum BoxType{
    MANUAL, AUTO;
}

class Menu {
    static Scanner scn = new Scanner(System.in);
    public static void Menu() {
        Garage();
    }

    private static void Garage(){

        int input = 0;
        while (input != 3){
            System.out.println("Выберете трансмиссию желаемого авто: \n" +
                    "1. Механика \n" +
                    "2. Автомат \n"+
                    "3. Выход");
            input = scn.nextInt();
            if (input == 1){
                selectCar(BoxType.MANUAL);
            }
            if (input == 2){
                selectCar(BoxType.AUTO);
            }
        }
    }

    private static void selectCar(BoxType boxType){
        List<Car> cardList = CreateList.create();
        List<Car> cr = new ArrayList<>();


        int input = 0;
        while (input !=3){
            int  i =1;
            System.out.println("Выберете автомобиль:");
            for(Car car : cardList){
                if(boxType == BoxType.AUTO) {
                    if (car instanceof AutoCar) {
                        System.out.println(i+". "+car.getName());
                        i++;
                        cr.add(car);
                    }
                }else {
                    if (car instanceof ManualCar) {
                        System.out.println(i+". "+car.getName());
                        i++;
                        cr.add(car);
                    }
                }
            }
            System.out.println(i+". Exit");
            System.out.println("ПЕРВЫЙ ПОДОЗРЕВАЕМЫЙ ");
            input = scn.nextInt();

            if (input == 1){
                controlCar(cr , input);
            }else if (input == 2){
                controlCar(cr,input);
            }

        }

    }


    private static void controlCar(List<Car> car, int i){

        Scanner scn = new Scanner(System.in);
        int iput = 0;

        while (iput != 3){
            System.out.println("1. Газ \n"+
                    "2. Тормоз \n" +
                    "3. Вернуться в гараж");
            System.out.println("ТРЕТИЙ ПОДОЗРЕВАЕМЫЙ ");
            iput = scn.nextInt();
            if (iput == 1){
                car.get(i-1).gas();
            }
            if (iput == 2) {
                car.get(i-1).breaK();
            }
        }
    }

}