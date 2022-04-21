package lessons.lesson47_java_sql;

import java.sql.*;

public class Main1_executeQuery {
    public static void main(String[] args) {
        //Сделать sql из домашки на фильмы через java
        //jdbc driver
//        try(Connection connection = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/homework_film", "root", "")){
//            Statement stmt = connection.createStatement(); //создаем объект, через который мы выполняем sql Запросы
//            ResultSet rs = stmt.executeQuery("select id, film_name, rating from film");
//
//            while(rs.next()){
//                System.out.println(rs.getInt("id") + " " + rs.getString("film_name") + " " + rs.getInt("rating"));
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        //Вывести всех режиссеров и их фильмы:
        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/homework_film", "root", "")){
            Statement stmt = connection.createStatement(); //создаем объект, через который мы выполняем sql Запросы
            ResultSet rs = stmt.executeQuery("select f.film_name, f.rating, d.name, d.second_name from film f \n" +
                    "join film_and_director fd on f.id = fd.film_id \n" +
                    "join director d on d.id = fd.film_director_id");

            while (rs.next()){
                System.out.println(rs.getString("film_name")
                        +" "+rs.getInt("rating") +" "+ rs.getString("second_name"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
