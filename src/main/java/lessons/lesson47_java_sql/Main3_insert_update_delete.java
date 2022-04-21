package lessons.lesson47_java_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main3_insert_update_delete {
    public static void main(String[] args) {
        //Добавить в таблицу film новый фильм
//        try(Connection connection = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/homework_film", "root", "")){
//            PreparedStatement preparedStatement = connection.prepareStatement(
//                            "insert into film (film_name, rating) values(?, ?)");
//            preparedStatement.setString(1, "film6");
//            preparedStatement.setInt(2, 5);
//            int rows = preparedStatement.executeUpdate();
//            if(rows!=0){
//                System.out.println("Фильм добавлен");
//            }else{
//                System.out.println("Не добавлен");
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        //Обновить фильм film6: изменить рейтинг с 5 на 4
//        try(Connection connection = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/homework_film", "root", "")){
//            PreparedStatement preparedStatement = connection.prepareStatement(
//                            "update film set rating = ? where film_name = ?");
//            preparedStatement.setInt(1, 4);
//            preparedStatement.setString(2, "film6");
//
//            int rows = preparedStatement.executeUpdate();
//            if(rows!=0){
//                System.out.println("Фильм обновлен");
//            }else{
//                System.out.println("Не обновлен");
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }


        //Удалить фильм film6
        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/homework_film", "root", "")){
            PreparedStatement preparedStatement = connection.prepareStatement(
                            "delete from film where film_name = ?");

            preparedStatement.setString(1, "film6");

            int rows = preparedStatement.executeUpdate();
            if(rows!=0){
                System.out.println("Фильм удален");
            }else{
                System.out.println("Не удален");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
