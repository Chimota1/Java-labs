package org.example;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

import static com.mysql.cj.conf.PropertyKey.PASSWORD;

public class Main {
    private static final Properties properties = new Properties();
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть логін: ");
        String login = scanner.nextLine();

        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine();

        try (FileInputStream in = new FileInputStream("resources//config.properties")) {
            properties.load(in);
            String URL = properties.getProperty("db.URL");
            String USERNAME = properties.getProperty("db.USERNAME");
            String PASSWORD = properties.getProperty("db.PASSWORD");
        } catch (IOException e){
            e.printStackTrace();
        }

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