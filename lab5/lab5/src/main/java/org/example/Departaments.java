package org.example;
import java.sql.*;

public class Departaments {
    private final Connection connection;

    public Departaments(Connection connection) {
        this.connection = connection;
    }

    public void insert() throws SQLException {
        String sql = "INSERT IGNORE INTO `Departaments`(`departament_id`, `departament_name`, `departament_type`, `hazard_bonus`) VALUES (?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, 6);
        stmt.setString(2, "Name");
        stmt.setString(3, "type");
        stmt.setInt(4, 0);
        System.out.println("Insert Departaments: " + stmt.executeUpdate());
        stmt.close();
    }

    public void update() throws SQLException {
        String sql = "UPDATE `Departaments` SET `departament_name` = 'Дирекція', `hazard_bonus` = 5 WHERE `departament_id` = 1";
        Statement stmt = connection.createStatement();
        System.out.println("Update Departaments: " + stmt.executeUpdate(sql));
        stmt.close();
    }

    public void delete() throws SQLException {
        String sql = "DELETE FROM `Departaments` WHERE `departament_id` = 6";
        Statement stmt = connection.createStatement();
        System.out.println("Delete Departaments: " + stmt.executeUpdate(sql));
        stmt.close();
    }

    public void read() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM `Departaments`");
        ResultSetMetaData meta = res.getMetaData();
        System.out.println("MetaData:");
        for (int i = 1; i <= meta.getColumnCount(); i++) {
            System.out.println("Column " + i + " Name " + meta.getColumnName(i) + " Type " + meta.getColumnTypeName(i));
        }
        while (res.next()) {
            System.out.println(res.getInt("departament_id") + " " +
                    res.getString("departament_name") + " " +
                    res.getString("departament_type") + " " +
                    res.getInt("hazard_bonus"));
        }
        stmt.close();
        res.close();
    }
}