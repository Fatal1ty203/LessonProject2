package hw.homework_MYSQL_cinemaHall.OneToMany;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String full = "select brand.name, country, tovar.name, price " +
                "from brand join tovar on tovar.brand = brand.id";

        String deuchland = "select brand.name, country, tovar.name, price " +
                "from brand left join tovar on tovar.brand = brand.id " +
                "where country = 'Deuchland' ";

        String priceAndDeuch = "select brand.name, country, tovar.name, price " +
                "from brand right join tovar on tovar.brand = brand.id " +
                "where price < 1000 and country = 'Deuchland'";

        String delete = "delete from homework_kino.tovar where brand = (select id from brand where country = 'China')";

        boolean isExist = false;
        int action = 0;
        Scanner scanner = new Scanner(System.in);

        //"jdbc:mysql://localhost:3306/homework_kino"
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/homework_kino", "root", "")) {
            Statement stmt = connection.createStatement();
            ResultSet rst = null;
            String standart = null;
            int row = 0;
            while (!isExist) {
                System.out.println("1. Выведите бренд, страну производства, название товара, его цену для всех товаров\n" +
                        "2. Выведите товары только немецкого бренда\n" +
                        "3. Выведите товары только немецкого бренда, чья цена не превышает 1000\n" +
                        "4. Удалите все товары китайского бренда одним запросом\n" +
                        "5. Выход");
                action = scanner.nextInt();
                if (action == 1) {
                    rst = stmt.executeQuery(full);
                } else if (action == 2) {
                    rst = stmt.executeQuery(deuchland);
                } else if (action == 3) {
                    rst = stmt.executeQuery(priceAndDeuch);
                } else if (action == 4) {
                    PreparedStatement ps = connection.prepareStatement("delete from homework_kino.tovar where brand = (select id from brand where country = 'China')");
                    row = ps.executeUpdate();
                } else if (action == 5) {
                    isExist = true;
                }

                if (action>0 && action <4) {
                    while (rst.next()) {
                        standart = rst.getString("brand.name") + " " + rst.getString("country") +
                                " " + rst.getString("tovar.name") + " " + rst.getInt("price");
                        System.out.println(standart);
                    }
                }
                if (action == 4) {
                    if (row > 0) {
                        standart = "Товар удален";
                    } else {
                        standart = "Товар не удален";
                    }
                    System.out.println(standart);
                }

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
