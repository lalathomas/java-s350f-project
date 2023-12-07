/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lala
 */
import ict.bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {
    private Connection connection;

    public AdminDAO(Connection connection) {
        this.connection = connection;
    }

    // Retrieve Admin by ID from the database
    public Admin getAdminById(int adminID) {
        Admin admin = null;
        String query = "SELECT * FROM Admin WHERE AdminID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, adminID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                admin = new Admin();
                admin.setAdminID(resultSet.getInt("AdminID"));
                admin.setUserID(resultSet.getInt("UserID"));
                // Set other attributes here
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }

    // Retrieve all Admins from the database
    public List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<>();
        String query = "SELECT * FROM Admin";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Admin admin = new Admin();
                admin.setAdminID(resultSet.getInt("AdminID"));
                // Set other attributes here
                admins.add(admin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admins;
    }

    // Insert a new Admin into the database
    public boolean insertAdmin(Admin admin) {
        boolean success = false;
        String query = "INSERT INTO Admin (AdminID, UserID) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, admin.getAdminID());
            preparedStatement.setInt(2, admin.getUserID());

            int rowsAffected = preparedStatement.executeUpdate();
            success = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    // Update an existing Admin in the database
    public boolean updateAdmin(Admin admin) {
        boolean success = false;
        String query = "UPDATE Admin SET UserID = ? WHERE AdminID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, admin.getUserID());
            preparedStatement.setInt(2, admin.getAdminID());

            int rowsAffected = preparedStatement.executeUpdate();
            success = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    // Delete an Admin from the database
    public boolean deleteAdmin(int adminID) {
        boolean success = false;
        String query = "DELETE FROM Admin WHERE AdminID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, adminID);

            int rowsAffected = preparedStatement.executeUpdate();
            success = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }
}

