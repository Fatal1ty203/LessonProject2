package hw.homework_MYSQL_cinemaHall.oneTOone;

import java.nio.file.Path;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String full = "select cinema_hall.id, type, price, screen_area" +
                " from cinema_hall, screen" +
                " where screen_id = screen.id";

        String forScreenAre = "select cinema_hall.id, type, price, screen_area" +
                " from cinema_hall, screen" +
                " where screen_area >= 40 and screen_id = screen.id";

        String distance = "select cinema_hall.id, type, price, distance" +
                " from cinema_hall join screen" +
                " on screen_id = screen.id" +
                " where screen_area >= 30 and distance < 7";

        String typeAndPrice = "select cinema_hall.id, type, price" +
                " from cinema_hall join screen" +
                " on screen_id = screen.id" +
                " where type = '3D' and price < 80";

        boolean isExit = false;
        int action = 0;
        Scanner scn = new Scanner(System.in);

        try(Connection connection = DriverManager.getConnection(

                "jdbc:mysql://localhost:3306/homework_kino","root","")){
            Statement stmt = connection.createStatement();
            ResultSet rst = null;
            String standart;
            while (!isExit){

                System.out.println("1. простой вывод\n" +
                        "2. если screen area больше или равно 40\n" +
                        "3. если distance меньше 7\n" +
                        "4. если тип зала 3D\n" +
                        "5. выход");
                action = scn.nextInt();

                if (action == 1){
                    rst = stmt.executeQuery(full);
                }else if (action == 2){
                    rst = stmt.executeQuery(forScreenAre);
                    action = 1;
                } else if (action == 3){
                    rst = stmt.executeQuery(distance);
                    action = 2;
                }else if (action == 4){
                    rst = stmt.executeQuery(typeAndPrice);
                    action = 0;
                }else if (action == 5){
                    isExit = true;
                }

                while (rst.next()){
                    standart = rst.getInt("cinema_hall.id")
                            + " " + rst.getString("type") + " " + rst.getInt("price");
                    if (action == 1) {
                        standart += " " + rst.getString("screen_area");
                    }else if (action == 2) {
                        standart += " " + rst.getString("distance");
                    }
                    System.out.println(standart);
                }

                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
