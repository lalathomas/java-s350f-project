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

public class WebUserDAO {
    private Connection connection;

    public WebUserDAO(Connection connection) {
        this.connection = connection;
    }

    // Implement code to retrieve WebUser by ID from the database
    public WebUser getWebUserById(int userID) {
        WebUser webUser = null;
        String sql = "SELECT * FROM webuser WHERE userID = ?";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    webUser = new WebUser();
                    webUser.setUserID(resultSet.getInt("userID"));
                    webUser.setUsername(resultSet.getString("username"));
                    webUser.setPassword(resultSet.getString("password"));
                    webUser.setRole(resultSet.getString("role"));
                    webUser.setFirstName(resultSet.getString("firstName"));
                    webUser.setLastName(resultSet.getString("lastName"));
                    webUser.setEmail(resultSet.getString("email"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling strategy
        }

        return webUser;
    }

    // Implement code to retrieve all WebUsers from the database
    public List<WebUser> getAllWebUsers() {
        List<WebUser> webUsers = new ArrayList<>();
        String sql = "SELECT * FROM webuser";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            while (resultSet.next()) {
                WebUser webUser = new WebUser();
                webUser.setUserID(resultSet.getInt("userID"));
                webUser.setUsername(resultSet.getString("username"));
                webUser.setPassword(resultSet.getString("password"));
                webUser.setRole(resultSet.getString("role"));
                webUser.setFirstName(resultSet.getString("firstName"));
                webUser.setLastName(resultSet.getString("lastName"));
                webUser.setEmail(resultSet.getString("email"));
                webUsers.add(webUser);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling strategy
        }

        return webUsers;
    }

    // Implement code to insert a new WebUser into the database
    public boolean insertWebUser(WebUser webUser) {
        String sql = "INSERT INTO webuser (username, password, role, firstName, lastName, email) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, webUser.getUsername());
            preparedStatement.setString(2, webUser.getPassword());
            preparedStatement.setString(3, webUser.getRole());
            preparedStatement.setString(4, webUser.getFirstName());
            preparedStatement.setString(5, webUser.getLastName());
            preparedStatement.setString(6, webUser.getEmail());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling strategy
            return false;
        }
    }

    // Implement code to update an existing WebUser in the database
    public boolean updateWebUser(WebUser webUser) {
        String sql = "UPDATE webuser SET username = ?, password = ?, role = ?, firstName = ?, lastName = ?, email = ? WHERE userID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, webUser.getUsername());
            preparedStatement.setString(2, webUser.getPassword());
            preparedStatement.setString(3, webUser.getRole());
            preparedStatement.setString(4, webUser.getFirstName());
            preparedStatement.setString(5, webUser.getLastName());
            preparedStatement.setString(6, webUser.getEmail());
            preparedStatement.setInt(7, webUser.getUserID());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling strategy
            return false;
        }
    }

    // Implement code to delete a WebUser from the database
    public boolean deleteWebUser(int userID) {
        String sql = "DELETE FROM webuser WHERE userID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userID);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling strategy
            return false;
        }
    }
  public WebUser validateUser(String userID, String password) {
        WebUser webUser = null;
        String query = "SELECT * FROM webuser WHERE UserID = ? AND Password = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userID);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    webUser = new WebUser();
                    webUser.setUserID(resultSet.getInt("UserID"));
                    webUser.setUsername(resultSet.getString("Username"));
                    webUser.setPassword(resultSet.getString("Password"));
                    webUser.setRole(resultSet.getString("Role"));
                    // Set other attributes here
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return webUser;
    }
}
