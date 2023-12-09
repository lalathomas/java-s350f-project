/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lala
 */
import java.sql.Connection;
import java.sql.SQLException;
import ict.dao.*;

public class TestDatabaseConnection {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnector.getConnection();
            if (connection != null) {
                System.out.println("Successfully connected to the database.");
                connection.close();
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}