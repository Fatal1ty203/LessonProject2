package lessons.lesson8_poly_training;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Есть три вида роботов: летающие, которые ходят
        //у каждого робота запустить его метод движения
        List<Robot> list = new ArrayList<>();
        list.add(new SwimInOxidRobot());
        list.add(new WalkBySand());
        list.add(new SwimInWaterRobot());
        list.add(new WalkRocksSand());

        Scanner scn = new Scanner(System.in);
        while(true) {
            System.out.println("Какой категорию роботов выбрать:");
            System.out.println("1. Плавающие");
            System.out.println("2. Шагающие");


//            int input = scn.nextInt();
//            if (input == 1) {
//                int i = 1;
//                List<Robot> tmpList = new ArrayList<>();
//                for (Robot robot : list) {
//                    if (robot instanceof SwimRobot) {
//                        System.out.println(i + " " + robot.toString());
//                        tmpList.add(robot);
//                        i++;
//                    }
//                }
//                input = scn.nextInt();
//                int index = input - 1;
//                System.out.println(tmpList.get(index).getClass());
//                tmpList.get(index).makeAction();
//            } else if (input == 2) {
//                int i = 1;
//                List<Robot> tmpList = new ArrayList<>();
//                for (Robot robot : list) {
//                    if (robot instanceof WalkRobot) {
//                        System.out.println(i + " " + robot.toString());
//                        tmpList.add(robot);
//                        i++;
//                    }
//                }
//                input = scn.nextInt();
//                int index = input - 1;
//                System.out.println(tmpList.get(index).getClass());
//                tmpList.get(index).makeAction();
//            }
//        }

            //option2
            int input = scn.nextInt();
            List<Robot> tmpList = null;
            if (input == 1) {
                tmpList = collectRobots(list, "swim");
            } else if (input == 2) {
                tmpList = collectRobots(list, "walk");
            }
            input = scn.nextInt();
            System.out.println(tmpList.get(input).getClass());
            tmpList.get(input).makeAction();
        }


    }

    public static List<Robot> collectRobots(List<Robot> list, String category){
        List<Robot> tmpList = new ArrayList<>();
        int i = 0;
        for (Robot robot : list) {
            boolean isExist = false;
            if(category.equalsIgnoreCase("swim") && robot instanceof SwimRobot) {
                isExist = true;
            }
            else if(category.equalsIgnoreCase("walk") && robot instanceof WalkRobot) {
                isExist = true;
            }
            if(isExist){
                System.out.println(i + " " + robot.toString());
                tmpList.add(robot);
                i++;
            }

        }
        return tmpList;
    }
}


abstract class Robot{
    abstract void makeAction();
}

abstract class SwimRobot extends  Robot{

}
//плавает по воде
class SwimInWaterRobot extends SwimRobot{

    @Override
    void makeAction() {
        System.out.println("робот плывет воде");
    }

    @Override
    public String toString() {
        return "по воде";
    }
}
//плавает в кислоте
class SwimInOxidRobot extends SwimRobot{

    @Override
    void makeAction() {
        System.out.println("робот плывет в кислоте");
    }

    @Override
    public String toString() {
        return "по кислоте";
    }
}



abstract class WalkRobot extends Robot{


}


class WalkBySand extends WalkRobot{

    @Override
    void makeAction() {
        System.out.println("робот шагает по песку");
    }
    @Override
    public String toString() {
        return "по песку";
    }
}


class WalkRocksSand extends WalkRobot{

    @Override
    void makeAction() {
        System.out.println("робот шагает по камням");
    }
    @Override
    public String toString() {
        return "по камням";
    }
}




