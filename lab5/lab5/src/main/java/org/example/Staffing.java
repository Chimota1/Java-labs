package org.example;
import java.sql.*;

public class Staffing {
    private final Connection connection;

    public Staffing(Connection connection) {
        this.connection = connection;
    }

    public void insert() throws SQLException {
        String sql = "INSERT IGNORE INTO `Staffing_table`(`staffing_id`, `total_slots`, `vacant_slots`, `departament_id`, `position_id`) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, 6);
        stmt.setInt(2, 3);
        stmt.setInt(3, 1);
        stmt.setInt(4, 1);
        stmt.setInt(5, 1);
        System.out.println("Insert Staffing_table: " + stmt.executeUpdate());
        stmt.close();
    }

    public void update() throws SQLException {
        String sql = "UPDATE `Staffing_table` SET `vacant_slots` = 0 WHERE `staffing_id` = 1";
        Statement stmt = connection.createStatement();
        System.out.println("Update Staffing_table: " + stmt.executeUpdate(sql));
        stmt.close();
    }

    public void delete() throws SQLException {
        String sql = "DELETE FROM `Staffing_table` WHERE `staffing_id` = 6";
        Statement stmt = connection.createStatement();
        System.out.println("Delete Staffing_table: " + stmt.executeUpdate(sql));
        stmt.close();
    }

    public void read() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM `Staffing_table`");
        while (res.next()) {
            System.out.println(res.getInt("staffing_id") + " " +
                    res.getInt("total_slots") + " " +
                    res.getInt("vacant_slots") + " " +
                    res.getInt("departament_id") + " " +
                    res.getInt("position_id"));
        }
        stmt.close();
        res.close();
    }
}