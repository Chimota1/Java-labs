package org.example;
import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/Kindrat_Anatolii";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "25102006";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть логін: ");
        String login = scanner.nextLine();

        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            if (connection != null && !connection.isClosed()) {
                String sql = "SELECT * FROM `Users` WHERE users_login = ? AND users_password = SHA2(?, 256)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, login);
                statement.setString(2, password);

                ResultSet userResult = statement.executeQuery();

                if (userResult.next()) {
                    System.out.println("Авторизація успішна! Вітаємо, " + login);
                    Statement stm = connection.createStatement();
                    ResultSet res = stm.executeQuery("SELECT * FROM `Departaments` WHERE departament_id <= 3");
                    while (res.next()) {
                        int id = res.getInt("departament_id");
                        String name = res.getString("departament_name");
                        String type = res.getString("departament_type");
                        int bonus = res.getInt("hazard_bonus");
                        System.out.println(id + " " + name + " " + type + " " + bonus);
                    }
                    stm.close();
                    res.close();
                } else {
                    System.out.println("Невірний логін або пароль!");
                }

                userResult.close();
                statement.close();
            }

        } catch (SQLException e) {
            System.out.println("Щось пішло не так. Помилка: " + e.getMessage());
        }
    }
}