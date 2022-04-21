package lessons.lesson47_java_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main4_transactions {
    public static void main(String[] args) {
        //Мы хотим сделать в рамках одной транзакции два действия:
        //списать с баланса ивана 10 руб
        //зачислить 10 руб на бланс семена

        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/homework_film", "root", "")){

            connection.setAutoCommit(false); //Отключаем автоматичекие транзакции
            //списываем 10 руб
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "update bank_account set balance = balance-10 where name = ?");
                preparedStatement.setString(1, "ivan");
                preparedStatement.executeUpdate();
                //Зачисляем 10 руб

                preparedStatement = connection.prepareStatement(
                        "update bank_account set balance = balance+10 where name = ?");
                preparedStatement.setString(1, "semen");
                preparedStatement.executeUpdate();
                connection.commit(); //если не было ошибок, сохраняем локальные изменения в транзакции в базу
            }catch (Exception e){
                connection.rollback(); //Отктываем все локальные изменения обратно, если возникла ошибка
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

