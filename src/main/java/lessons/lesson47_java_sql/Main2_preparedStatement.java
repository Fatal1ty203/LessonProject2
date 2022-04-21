package lessons.lesson47_java_sql;

import java.sql.*;

public class Main2_preparedStatement {
    public static void main(String[] args) {
        //Извлечь все фильмы определенного режиссера и с рейтингом больше x

        //Вывести всех режиссеров и их фильмы:
        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/homework_film", "root", "")){
            PreparedStatement preparedStatement = connection.prepareStatement("select f.film_name, f.rating, d.name, d.second_name from film f \n" +
                    "join film_and_director fd on f.id = fd.film_id \n" +
                    "join director d on d.id = fd.film_director_id " +
                    "where d.second_name = ? and f.rating > ?");
            preparedStatement.setString(1, "Cameron");
            preparedStatement.setInt(2, 4);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                System.out.println(rs.getString("film_name")
                        +" "+rs.getInt("rating") +" "+ rs.getString("second_name"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
