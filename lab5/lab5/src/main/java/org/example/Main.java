package org.example;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

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

        try (FileInputStream in = new FileInputStream("D://Java_labs//lab5//lab5//src//main//resources//config.properties")) {
            properties.load(in);
            URL = properties.getProperty("db.URL");
            USERNAME = properties.getProperty("db.USERNAME");
            PASSWORD = properties.getProperty("db.PASSWORD");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            if (connection != null && !connection.isClosed()) {

                // Авторизація
                String sql = "SELECT * FROM `Users` WHERE users_login = ? AND users_password = SHA2(?, 256)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, login);
                statement.setString(2, password);
                ResultSet userResult = statement.executeQuery();

                if (userResult.next()) {
                    System.out.println("Авторизація успішна! Вітаємо, " + login);

                    Departaments departament = new Departaments(connection);
                    System.out.println("\n- DEPARTAMENTS -");
                    departament.insert();
                    departament.update();
                    departament.delete();
                    departament.read();

                    Position position = new Position(connection);
                    System.out.println("\n- POSITION -");
                    position.insert();
                    position.update();
                    position.delete();
                    position.read();
                    position.search(35000);

                    Staffing staffing = new Staffing(connection);
                    System.out.println("\n- STAFFING_TABLE -");
                    staffing.insert();
                    staffing.update();
                    staffing.delete();
                    staffing.read();

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