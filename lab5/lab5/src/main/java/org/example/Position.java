package org.example;
import java.sql.*;

public class Position {
    private final Connection connection;

    public Position(Connection connection) {
        this.connection = connection;
    }

    public void insert() throws SQLException {
        String sql = "INSERT IGNORE INTO `Position`(`position_id`, `position_title`, `base_salary`, `schedule_bonus`) VALUES (?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, 6);
        stmt.setString(2, "Тестова посада");
        stmt.setInt(3, 10000);
        stmt.setInt(4, 5);
        System.out.println("Insert Position: " + stmt.executeUpdate());
        stmt.close();
    }

    public void update() throws SQLException {
        String sql = "UPDATE `Position` SET `base_salary` = 55000 WHERE `position_id` = 1";
        Statement stmt = connection.createStatement();
        System.out.println("Update Position: " + stmt.executeUpdate(sql));
        stmt.close();
    }

    public void delete() throws SQLException {
        String sql = "DELETE FROM `Position` WHERE `position_id` = 6";
        Statement stmt = connection.createStatement();
        System.out.println("Delete Position: " + stmt.executeUpdate(sql));
        stmt.close();
    }

    public void read() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM `Position`");
        while (res.next()) {
            System.out.println(res.getInt("position_id") + " " +
                    res.getString("position_title") + " " +
                    res.getInt("base_salary") + " " +
                    res.getInt("schedule_bonus"));
        }
        stmt.close();
        res.close();
    }

    public void search(int salary) throws SQLException {
        String sql = "SELECT * FROM `Position` WHERE `base_salary` > ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, salary);
        ResultSet res = stmt.executeQuery();
        System.out.println("-- SEARCH --");
        while (res.next()) {
            System.out.println(res.getInt("position_id") + " " +
                    res.getString("position_title") + " " +
                    res.getInt("base_salary") + " " +
                    res.getInt("schedule_bonus"));
        }
        stmt.close();
        res.close();
    }
}